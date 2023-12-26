package com.hr.dto;

public class CountriesDto {
	private String country_id;
	private int region_id;
	private String country_name;
	public CountriesDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CountriesDto(String country_id, int region_id, String country_name) {
		super();
		this.country_id = country_id;
		this.region_id = region_id;
		this.country_name = country_name;
	}
	@Override
	public String toString() {
		return "CountriesDto [country_id=" + country_id + ", region_id=" + region_id + ", country_name=" + country_name
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country_id == null) ? 0 : country_id.hashCode());
		result = prime * result + ((country_name == null) ? 0 : country_name.hashCode());
		result = prime * result + region_id;
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
		CountriesDto other = (CountriesDto) obj;
		if (country_id == null) {
			if (other.country_id != null)
				return false;
		} else if (!country_id.equals(other.country_id))
			return false;
		if (country_name == null) {
			if (other.country_name != null)
				return false;
		} else if (!country_name.equals(other.country_name))
			return false;
		if (region_id != other.region_id)
			return false;
		return true;
	}
	public String getCountry_id() {
		return country_id;
	}
	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}
	public int getRegion_id() {
		return region_id;
	}
	public void setRegion_id(int region_id) {
		this.region_id = region_id;
	}
	public String getCountry_name() {
		return country_name;
	}
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	
	
}
