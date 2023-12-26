package com.hr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hr.dto.LocationDto;
import com.hr.util.DBConn;

public class LocationDao {
	public void insert(LocationDto dto) {
		String sql = String.format("insert into location values(%d, '%s','%s','%s','%s','%s')", dto.getLocation_id(), dto.getCountry_id(), dto.getStreet_address(), dto.getPostal_code(), dto.getCity(), dto.getState_province());
		DBConn.statementUpdate(sql);
	}
	
	public ArrayList<LocationDto> selectAll() {
		ArrayList<LocationDto> resultDtos = new ArrayList<LocationDto>();
		ResultSet rs = DBConn.statementQuery(String.format("select * from location order by location_id"));
		try {
			while(rs.next()) {
				resultDtos.add(new LocationDto(rs.getInt("location_id"), rs.getString("country_id"), rs.getString("street_address"), rs.getString("postal_code"), rs.getString("city"), rs.getString("state_province")));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return resultDtos;
	}
	
	public LocationDto selectOne(int location_id, String city) {
		LocationDto resultDto = new LocationDto();
		// ArrayList<LocationDto> resultDtos = new ArrayList<LocationDto>();
		ResultSet rs = DBConn.statementQuery(String.format("select * from Location where id=%d and Location='%s'", location_id, city));
		if(rs!=null) {
			try {
				rs.next();
				resultDto = new LocationDto(rs.getInt("location_id"), rs.getString("country_id"), rs.getString("street_address"), rs.getString("postal_code"), rs.getString("city"), rs.getString("state_province"));
			} catch(SQLException e) {
				e.printStackTrace();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return resultDto;
	}
	
	public void update(int location_id, String city, String newCity) {
		DBConn.statementUpdate(String.format("update location set city='%s' where location_id=%d and city='%s'", newCity, location_id,city));	
	}
		
	public void delete(int location_id) {
		DBConn.statementUpdate(String.format("delete location where location_id=%d", location_id));
	}
	
	public ArrayList<LocationDto> selectId(Integer location_id) {
		ArrayList<LocationDto> resultDtos = new ArrayList<LocationDto>();
		ResultSet rs = DBConn.statementQuery(String.format("select * from Location where location_id=%d order by location_id", location_id));
		
		try {
			while(rs.next()) {
				resultDtos.add(new LocationDto(rs.getInt("location_id"), rs.getString("country_id"), rs.getString("street_address"), rs.getString("postal_code"), rs.getString("city"), rs.getString("state_province")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultDtos;
	}
}


