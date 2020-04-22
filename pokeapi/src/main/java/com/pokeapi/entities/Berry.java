package com.pokeapi.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "berries")
public class Berry implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column
	private Integer id;

	@Column
	private String name;

	@Column
	private Integer growth_time;

	@Column
	private Integer max_harvest;

	@Column
	private Integer natural_gift_power;

	@Column
	private Integer size;

	@Column
	private Integer smoothness;

	@Column
	private Integer soil_dryness;

	public Berry() {
		super();
	}

	public Berry(Integer id, String name, Integer growth_time, Integer max_harvest, Integer natural_gift_power,
			Integer size, Integer smoothness, Integer soil_dryness) {
		super();
		this.id = id;
		this.name = name;
		this.growth_time = growth_time;
		this.max_harvest = max_harvest;
		this.natural_gift_power = natural_gift_power;
		this.size = size;
		this.smoothness = smoothness;
		this.soil_dryness = soil_dryness;
	}

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

	public Integer getGrowth_time() {
		return growth_time;
	}

	public void setGrowth_time(Integer growth_time) {
		this.growth_time = growth_time;
	}

	public Integer getMax_harvest() {
		return max_harvest;
	}

	public void setMax_harvest(Integer max_harvest) {
		this.max_harvest = max_harvest;
	}

	public Integer getNatural_gift_power() {
		return natural_gift_power;
	}

	public void setNatural_gift_power(Integer natural_gift_power) {
		this.natural_gift_power = natural_gift_power;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getSmoothness() {
		return smoothness;
	}

	public void setSmoothness(Integer smoothness) {
		this.smoothness = smoothness;
	}

	public Integer getSoil_dryness() {
		return soil_dryness;
	}

	public void setSoil_dryness(Integer soil_dryness) {
		this.soil_dryness = soil_dryness;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((growth_time == null) ? 0 : growth_time.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((max_harvest == null) ? 0 : max_harvest.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((natural_gift_power == null) ? 0 : natural_gift_power.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + ((smoothness == null) ? 0 : smoothness.hashCode());
		result = prime * result + ((soil_dryness == null) ? 0 : soil_dryness.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Berry other = (Berry) obj;
		if (growth_time == null) {
			if (other.growth_time != null)
				return false;
		} else if (!growth_time.equals(other.growth_time))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (max_harvest == null) {
			if (other.max_harvest != null)
				return false;
		} else if (!max_harvest.equals(other.max_harvest))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (natural_gift_power == null) {
			if (other.natural_gift_power != null)
				return false;
		} else if (!natural_gift_power.equals(other.natural_gift_power))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		if (smoothness == null) {
			if (other.smoothness != null)
				return false;
		} else if (!smoothness.equals(other.smoothness))
			return false;
		if (soil_dryness == null) {
			if (other.soil_dryness != null)
				return false;
		} else if (!soil_dryness.equals(other.soil_dryness))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Berry [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", growth_time=");
		builder.append(growth_time);
		builder.append(", max_harvest=");
		builder.append(max_harvest);
		builder.append(", natural_gift_power=");
		builder.append(natural_gift_power);
		builder.append(", size=");
		builder.append(size);
		builder.append(", smoothness=");
		builder.append(smoothness);
		builder.append(", soil_dryness=");
		builder.append(soil_dryness);
		builder.append("]");
		return builder.toString();
	}

}
