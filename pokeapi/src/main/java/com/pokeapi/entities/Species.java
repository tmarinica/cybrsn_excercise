package com.pokeapi.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "species")
public class Species implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column
	private Integer id;
	
	@Column
	private String name;
	
	@Column(name = "order_nr")
	private Integer order;
	
	@Column
	private Integer gender_rate;
	
	@Column
	private Integer capture_rate;
	
	@Column
	private Integer base_happiness;
	
	@Column
	private Boolean is_baby;
	
	@Column
	private Integer hatch_counter;
	
	@Column
	private Boolean has_gender_differences;
	
	@Column
	private Boolean forms_switchable;
	
	@Column
	private String growth_rate;
	
	@Column
	private String egg_groups;
	
	@Column
	private String color;
	
	@Column
	private String shape;
	
	@Column
	private String evolves_from_species;
	
	@Column
	private String habitat;
	
	@Column
	private String generation;
	
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

	public String getGrowth_rate() {
		return growth_rate;
	}

	public void setGrowth_rate(String growth_rate) {
		this.growth_rate = growth_rate;
	}

	public String getEgg_groups() {
		return egg_groups;
	}

	public void setEgg_groups(String egg_groups) {
		this.egg_groups = egg_groups;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public String getEvolves_from_species() {
		return evolves_from_species;
	}

	public void setEvolves_from_species(String evolves_from_species) {
		this.evolves_from_species = evolves_from_species;
	}

	public String getHabitat() {
		return habitat;
	}

	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}

	public String getGeneration() {
		return generation;
	}

	public void setGeneration(String generation) {
		this.generation = generation;
	}

	
	
	
}
