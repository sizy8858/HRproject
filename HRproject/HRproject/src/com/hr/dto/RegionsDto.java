package com.hr.dto;


public class RegionsDto {
	private int region_id;
	private String region_name;
	public RegionsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RegionsDto(int region_id, String region_name) {
		super();
		this.region_id = region_id;
		this.region_name = region_name;
	}
	@Override
	public String toString() {
		return "RegionsDto [region_id=" + region_id + ", region_name=" + region_name + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + region_id;
		result = prime * result + ((region_name == null) ? 0 : region_name.hashCode());
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
		RegionsDto other = (RegionsDto) obj;
		if (region_id != other.region_id)
			return false;
		if (region_name == null) {
			if (other.region_name != null)
				return false;
		} else if (!region_name.equals(other.region_name))
			return false;
		return true;
	}
	public int getRegion_id() {
		return region_id;
	}
	public void setRegion_id(int region_id) {
		this.region_id = region_id;
	}
	public String getRegion_name() {
		return region_name;
	}
	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}
	
	
}
