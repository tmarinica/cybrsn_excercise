package com.pokeapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pokeapi.entities.Berry;

@Repository
public interface BerryRepository extends JpaRepository<Berry, Integer>{

	public abstract Berry findByName(@Param("name") String name);
	
}
