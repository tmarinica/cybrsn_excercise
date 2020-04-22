package com.pokeapi.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pokeapi.entities.Berry;
import com.pokeapi.enums.SortOrder;
import com.pokeapi.services.abs.BerryService;

@SpringBootTest
public class BerryServiceUnitTests {

	@Autowired
	private BerryService berryService;

	private Berry getRandomBerry(){
		Random r = new Random();
		return new Berry(r.nextInt(), RandomStringUtils.random(10), r.nextInt(), r.nextInt(), r.nextInt(), r.nextInt(), r.nextInt(), r.nextInt());
	}
	
	@Test
	public void testSortBerriesByIdAsc() {
		
		List<Berry> berries = new ArrayList<>();
		
		Berry first = getRandomBerry();
		first.setId(0);
		
		Berry second = getRandomBerry();
		second.setId(1);
		
		berries.add(second);
		berries.add(first);
		
		berryService.sortBerries(berries, "id", SortOrder.ASC);
		
		assertEquals(berries.get(0), first);
		assertEquals(berries.get(1), second);
	}
	
	@Test
	public void testSortBerriesByIdDesc() {
		
		List<Berry> berries = new ArrayList<>();
		
		Berry first = getRandomBerry();
		first.setId(0);
		
		Berry second = getRandomBerry();
		second.setId(1);
		
		berries.add(first);
		berries.add(second);
		
		berryService.sortBerries(berries, "id", SortOrder.DESC);
		
		assertEquals(berries.get(0), second);
		assertEquals(berries.get(1), first);
	}
	
	@Test
	public void testSortBerriesByNameAsc() {
		
		List<Berry> berries = new ArrayList<>();
		
		Berry first = getRandomBerry();
		first.setName("a");
		
		Berry second = getRandomBerry();
		second.setName("b");
		
		berries.add(second);
		berries.add(first);
		
		berryService.sortBerries(berries, "name", SortOrder.ASC);
		
		assertEquals(berries.get(0), first);
		assertEquals(berries.get(1), second);
	}
	
	@Test
	public void testSortBerriesByNameDesc() {
		
		List<Berry> berries = new ArrayList<>();
		
		Berry first = getRandomBerry();
		first.setName("a");
		
		Berry second = getRandomBerry();
		second.setName("b");
		
		
		berries.add(first);
		berries.add(second);
		
		berryService.sortBerries(berries, "name", SortOrder.DESC);
		
		assertEquals(berries.get(0), second);
		assertEquals(berries.get(1), first);
	}
	
	@Test
	public void testSortBerriesByGrowthTimeAsc() {
		
		List<Berry> berries = new ArrayList<>();
		
		Berry first = getRandomBerry();
		first.setGrowth_time(0);
		
		Berry second = getRandomBerry();
		second.setGrowth_time(1);
		
		berries.add(second);
		berries.add(first);
		
		berryService.sortBerries(berries, "growth_time", SortOrder.ASC);
		
		assertEquals(berries.get(0), first);
		assertEquals(berries.get(1), second);
	}
	
	@Test
	public void testSortBerriesByGrowthTimeDesc() {
		
		List<Berry> berries = new ArrayList<>();
		
		Berry first = getRandomBerry();
		first.setGrowth_time(0);
		
		Berry second = getRandomBerry();
		second.setGrowth_time(1);
		
		berries.add(first);
		berries.add(second);
		
		berryService.sortBerries(berries, "growth_time", SortOrder.DESC);
		
		assertEquals(berries.get(0), second);
		assertEquals(berries.get(1), first);
	}
	
	@Test
	public void testSortBerriesExceptionIsThrownWhenIfBerriesListIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> berryService.sortBerries(null, "test", SortOrder.ASC));
	}
	
	@Test
	public void testSortBerriesExceptionIsThrownIfSortFieldIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> berryService.sortBerries(new ArrayList<>(), null, SortOrder.ASC));
	}
	
	@Test
	public void testSortBerriesExceptionIsThrownIfSortOrderIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> berryService.sortBerries(new ArrayList<>(), "test", null));
	}
	
}
