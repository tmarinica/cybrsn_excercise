package com.pokeapi.services.impl;

import java.util.Optional;
import java.util.StringJoiner;

import javax.annotation.PostConstruct;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.pokeapi.entities.Species;
import com.pokeapi.model.NamedAPIResource;
import com.pokeapi.model.SpeciesApiResponse;
import com.pokeapi.repositories.SpeciesRepository;
import com.pokeapi.services.abs.SpeciesService;

@Component
public class SpeciesServiceImpl implements SpeciesService {
	
	private static final String POKEAPI_SPECIES_URL = "https://pokeapi.co/api/v2/pokemon-species";
	private static Logger LOGGER = LoggerFactory.getLogger(BerryServiceImpl.class);


	@Autowired
	private SpeciesRepository speciesRepository;
	
	private Client client;
	
	@PostConstruct
	public void postConstruct() {
		client = ClientBuilder.newClient();
	}
	
	@Override
	public Species getSpecies(String name) {
		
		Species species = speciesRepository.findByName(name);
		
		if(species != null) {
			return species;
		}
			
		LOGGER.info("Species " + name + " is not in cache. Getting from Api...");
		
		SpeciesApiResponse speciesApiResponse = getSpeciesFromApi(name);
		
		species = convertToEntity(speciesApiResponse);
		
		speciesRepository.save(species);
		
		return species;
	}

	@Override
	public Species getSpecies(Integer id) {
		Optional<Species> speciesOptional = speciesRepository.findById(id);
		if(speciesOptional.isPresent()) {
			return speciesOptional.get();
		}
		
		LOGGER.info("Species with id " + id + " is not in cache. Getting from Api...");
		
		SpeciesApiResponse speciesApiResponse = getSpeciesFromApi(id.toString());
		
		Species species = convertToEntity(speciesApiResponse);
		
		speciesRepository.save(species);
		
		return species;
	}
	
	private SpeciesApiResponse getSpeciesFromApi(String idOrName) {
		
		String response = client.target(POKEAPI_SPECIES_URL)
				.path(idOrName)
		        .request(MediaType.APPLICATION_JSON)
		        .get(String.class);

		SpeciesApiResponse species = new Gson().fromJson(response, SpeciesApiResponse.class);
		return species;
	}
	
	private Species convertToEntity(SpeciesApiResponse speciesApiResponse) {
		Species species = new Species();
		species.setId(speciesApiResponse.getId());
		species.setName(speciesApiResponse.getName());
		species.setOrder(speciesApiResponse.getOrder());
		species.setGender_rate(speciesApiResponse.getGender_rate());
		species.setCapture_rate(speciesApiResponse.getCapture_rate());
		species.setBase_happiness(speciesApiResponse.getBase_happiness());
		species.setIs_baby(speciesApiResponse.getIs_baby());
		species.setHatch_counter(speciesApiResponse.getHatch_counter());
		species.setHas_gender_differences(speciesApiResponse.getHas_gender_differences());
		species.setForms_switchable(speciesApiResponse.getForms_switchable());
		
		if(speciesApiResponse.getGrowth_rate() != null) {
			species.setGrowth_rate(speciesApiResponse.getGrowth_rate().getName());
		}
		
		if(speciesApiResponse.getColor() != null) {
			species.setColor(speciesApiResponse.getColor().getName());
		}
		
		if(speciesApiResponse.getEvolves_from_species() != null) {
			species.setEvolves_from_species(speciesApiResponse.getEvolves_from_species().getName());
		}
		
		if(speciesApiResponse.getShape() != null) {
			species.setShape(speciesApiResponse.getShape().getName());
		}
		
		if(speciesApiResponse.getEvolves_from_species() != null) {
			species.setEvolves_from_species(speciesApiResponse.getEvolves_from_species().getName());
		}
		
		if(speciesApiResponse.getHabitat() != null) {
			species.setHabitat(speciesApiResponse.getHabitat().getName());
		}

		if(speciesApiResponse.getGeneration() != null) {
			species.setGeneration(speciesApiResponse.getGeneration().getName());
		}
		
		if(speciesApiResponse.getEgg_groups() != null && !speciesApiResponse.getEgg_groups().isEmpty()) {
			StringJoiner sj = new StringJoiner(", ");
			for(NamedAPIResource nar : speciesApiResponse.getEgg_groups()) {
				sj.add(nar.getName());
			}
			
			species.setEgg_groups(sj.toString());
		}
		
		return species;
	}
	
}
