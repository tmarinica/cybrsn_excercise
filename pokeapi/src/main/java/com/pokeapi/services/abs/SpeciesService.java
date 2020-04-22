package com.pokeapi.services.abs;

import com.pokeapi.entities.Species;

public interface SpeciesService {

	public abstract Species getSpecies(String name);

	public abstract Species getSpecies(Integer id);

}
