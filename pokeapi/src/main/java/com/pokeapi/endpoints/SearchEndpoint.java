package com.pokeapi.endpoints;

import javax.ws.rs.NotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pokeapi.entities.Species;
import com.pokeapi.services.abs.SpeciesService;

@RestController
public class SearchEndpoint {

	private static Logger LOGGER = LoggerFactory.getLogger(BerryEndpoint.class);

	@Autowired
	private SpeciesService speciesService;
	
	@CrossOrigin
	@GetMapping("/species/{idOrName}")
	public Species getSpecies(@PathVariable String idOrName) {
		
		String name = idOrName;
		Integer id = null;
		try {
			id = Integer.parseInt(idOrName);
			name = null;
		} catch (Exception e) {
			
		}
		
		if(name != null && !name.isEmpty()) {
			return speciesService.getSpecies(name);
		}
		
		if(id != null) {
			return speciesService.getSpecies(id);
		}
		
		return null;
	}
	
	
	@ExceptionHandler({ NotFoundException.class})
    public ResponseEntity<String> handleException(NotFoundException e) {
		LOGGER.error(e.getMessage(), e);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found!");
    }
	
}
