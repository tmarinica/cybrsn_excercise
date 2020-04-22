package com.pokeapi.endpoints;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pokeapi.entities.Berry;
import com.pokeapi.enums.SortOrder;
import com.pokeapi.exceptions.InvalidFieldNameException;
import com.pokeapi.services.abs.BerryService;

@RestController
public class BerryEndpoint {

	private static Logger LOGGER = LoggerFactory.getLogger(BerryEndpoint.class);
	
	@Autowired
	private BerryService berryService;
	
	@CrossOrigin
	@GetMapping("/berry")
	public List<Berry> getSortedBerries(@RequestParam("sortField") String sortField, @RequestParam("sortOrder") SortOrder sortOrder) {
		return berryService.getSortedBerries(sortField, sortOrder);
	}
	
	@ExceptionHandler({ InvalidFieldNameException.class})
    public ResponseEntity<String> handleException(InvalidFieldNameException e) {
		LOGGER.error(e.getMessage(), e);
        return ResponseEntity.badRequest().body("Invalid sort by field name!");
    }
	
	@ExceptionHandler({ Exception.class})
    public ResponseEntity<String> handleException(Exception e) {
		LOGGER.error(e.getMessage(), e);
        return ResponseEntity.badRequest().body("An unknown error has occured");
    }
	
}
