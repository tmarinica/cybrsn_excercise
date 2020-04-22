package com.pokeapi.model;

import java.io.Serializable;
import java.util.List;

public class SpeciesApiResponse implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String name;
	
	private Integer order;
	
	private Integer gender_rate;
	
	private Integer capture_rate;
	
	private Integer base_happiness;
	
	private Boolean is_baby;
	
	private Integer hatch_counter;
	
	private Boolean has_gender_differences;
	
	private Boolean forms_switchable;
	
	private NamedAPIResource growth_rate;
	
	private NamedAPIResource color;
	
	private NamedAPIResource shape;
	
	private NamedAPIResource evolves_from_species;
	
	private NamedAPIResource habitat;

	private NamedAPIResource generation;
	
	private List<NamedAPIResource> egg_groups;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Integer getGender_rate() {
		return gender_rate;
	}

	public void setGender_rate(Integer gender_rate) {
		this.gender_rate = gender_rate;
	}

	public Integer getCapture_rate() {
		return capture_rate;
	}

	public void setCapture_rate(Integer capture_rate) {
		this.capture_rate = capture_rate;
	}

	public Integer getBase_happiness() {
		return base_happiness;
	}

	public void setBase_happiness(Integer base_happiness) {
		this.base_happiness = base_happiness;
	}

	public Boolean getIs_baby() {
		return is_baby;
	}

	public void setIs_baby(Boolean is_baby) {
		this.is_baby = is_baby;
	}

	public Integer getHatch_counter() {
		return hatch_counter;
	}

	public void setHatch_counter(Integer hatch_counter) {
		this.hatch_counter = hatch_counter;
	}

	public Boolean getHas_gender_differences() {
		return has_gender_differences;
	}

	public void setHas_gender_differences(Boolean has_gender_differences) {
		this.has_gender_differences = has_gender_differences;
	}

	public Boolean getForms_switchable() {
		return forms_switchable;
	}

	public void setForms_switchable(Boolean forms_switchable) {
		this.forms_switchable = forms_switchable;
	}

	public NamedAPIResource getGrowth_rate() {
		return growth_rate;
	}

	public void setGrowth_rate(NamedAPIResource growth_rate) {
		this.growth_rate = growth_rate;
	}

	public NamedAPIResource getColor() {
		return color;
	}

	public void setColor(NamedAPIResource color) {
		this.color = color;
	}

	public NamedAPIResource getShape() {
		return shape;
	}

	public void setShape(NamedAPIResource shape) {
		this.shape = shape;
	}

	public NamedAPIResource getEvolves_from_species() {
		return evolves_from_species;
	}

	public void setEvolves_from_species(NamedAPIResource evolves_from_species) {
		this.evolves_from_species = evolves_from_species;
	}

	public NamedAPIResource getHabitat() {
		return habitat;
	}

	public void setHabitat(NamedAPIResource habitat) {
		this.habitat = habitat;
	}

	public NamedAPIResource getGeneration() {
		return generation;
	}

	public void setGeneration(NamedAPIResource generation) {
		this.generation = generation;
	}

	public List<NamedAPIResource> getEgg_groups() {
		return egg_groups;
	}

	public void setEgg_groups(List<NamedAPIResource> egg_groups) {
		this.egg_groups = egg_groups;
	}

}
