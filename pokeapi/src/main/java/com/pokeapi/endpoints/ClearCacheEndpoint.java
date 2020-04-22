package com.pokeapi.endpoints;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClearCacheEndpoint implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private List<JpaRepository> repositories;
	
	@GetMapping("/clearCache")
	public void clearCache() {
		for(JpaRepository repository : repositories) {
			repository.deleteAll();
		}
	}
	
}
