package com.pokeapi.services.abs;

import java.util.List;

import com.pokeapi.entities.Berry;
import com.pokeapi.enums.SortOrder;

public interface BerryService {

	public abstract List<Berry> getSortedBerries(String sortField, SortOrder sortOrder);

	public abstract void sortBerries(List<Berry> berries, String sortField, SortOrder sortOrder);

}
