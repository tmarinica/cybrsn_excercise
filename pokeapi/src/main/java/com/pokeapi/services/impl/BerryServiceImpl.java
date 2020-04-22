package com.pokeapi.services.impl;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.pokeapi.entities.Berry;
import com.pokeapi.enums.SortOrder;
import com.pokeapi.exceptions.InvalidFieldNameException;
import com.pokeapi.model.BerriesNamesWithUrlsResponse;
import com.pokeapi.model.BerryNameWithUrl;
import com.pokeapi.repositories.BerryRepository;
import com.pokeapi.services.abs.BerryService;

@Component
public class BerryServiceImpl implements BerryService {

	private static final String POKEAPI_BERRY_URL = "https://pokeapi.co/api/v2/berry?offset=0";
	
	private static final Integer CHUNK_SIZE = 100;

	private static Logger LOGGER = LoggerFactory.getLogger(BerryServiceImpl.class);

	@Autowired
	private BerryRepository berryRepository;
	
	private Client client;
	
	@PostConstruct
	public void postConstruct() {
		client = ClientBuilder.newClient();
	}
	
	@Override
	public List<Berry> getSortedBerries(String sortField, SortOrder sortOrder) {
		
		sortField = sanitizeSortField(sortField);
		
		validateFieldName(sortField);
		
		List<Berry> berries = new ArrayList<>();
		try {
			
			BerriesNamesWithUrlsResponse br = getAllBerriesNamesWithUrlsFromApi(POKEAPI_BERRY_URL + "&limit=" + CHUNK_SIZE);
			Boolean hasNext = false;
			do {
				
				for(BerryNameWithUrl bnwu : br.getResults()) {
					
					Berry berry = berryRepository.findByName(bnwu.getName()); 
					if(berry == null) {
						LOGGER.info("Berry " + bnwu.getName()+" not in cache! Getting from API...");
						
						berry = getBerryFromApi(bnwu.getUrl());
						
						if(berry != null) {
							berryRepository.save(berry);
						}
					}
					
					berries.add(berry);
				}
				
				if(br.getNext() != null && !br.getNext().isEmpty()) {
					hasNext = true;
					br = getAllBerriesNamesWithUrlsFromApi(br.getNext());
				}else {
					hasNext = false;
				}
				
			}while(hasNext);
			
		} catch (Exception e) {
			LOGGER.error("Exception while getting berries. " + e.getMessage(), e);
			LOGGER.info("Returning berries from cache...");
			berries = berryRepository.findAll();
		}
		
		sortBerries(berries, sortField, sortOrder);
		
		return berries;
	}

	@Override
	public void sortBerries(List<Berry> berries, String sortField, SortOrder sortOrder) {
		
		if(berries == null) {
			throw new IllegalArgumentException("berries is null!");
		}
		
		if(sortField == null || sortField.isEmpty()) {
			throw new IllegalArgumentException("sortField is null!");
		}
		
		if(sortOrder == null) {
			throw new IllegalArgumentException("sortOrder is null!");
		}
		
		Comparator comparator = getComparator(sortField);

		if(sortOrder == SortOrder.DESC) {
			comparator = comparator.reversed();
		}
		
		berries.sort(comparator);
	}
	
	private BerriesNamesWithUrlsResponse getAllBerriesNamesWithUrlsFromApi(String url) {
		
		String response = client.target(url)
		        .request(MediaType.APPLICATION_JSON)
		        .get(String.class);

		BerriesNamesWithUrlsResponse br = new Gson().fromJson(response, BerriesNamesWithUrlsResponse.class);
		return br;
	}
	
	private Berry getBerryFromApi(String berryUrl) {
		
		String response = client.target(berryUrl)
		        .request(MediaType.APPLICATION_JSON)
		        .get(String.class);

		Berry berry = new Gson().fromJson(response, Berry.class);
		return berry;
	}
	
	private String sanitizeSortField(String sortField) {
		return sortField.toLowerCase().replace(" ", "_");
	}
	
	private void validateFieldName(String sortField) {
		boolean hasMethod = false;
		Method[] methods = Berry.class.getMethods();

		String getMethodName = "get" + sortField.substring(0, 1).toUpperCase() + sortField.substring(1);

		for (Method m : methods) {
			if (m.getName().equals(getMethodName)) {
				hasMethod = true;
				break;
			}
		}
		
		if(!hasMethod) {
			throw new InvalidFieldNameException("Field name " + sortField + " is invalid!");
		}
	}

	private Comparator getComparator(String fieldName) {
		Comparator comparator = Comparator.comparing(obj -> {
	        try {
	        	
	        	String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
	        	
	        	return (Comparable) obj.getClass().getMethod(getMethodName, null).invoke(obj, null);

	        } catch (Exception e) {
	        	throw new InvalidFieldNameException("Field name " + fieldName + " is invalid!");
	        }
	    });
		
		return comparator;
	}
	
}
