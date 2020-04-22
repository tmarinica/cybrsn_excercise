package com.pokeapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pokeapi.entities.Species;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, Integer>{

	public abstract Species findByName(@Param("name") String name);
	
}
