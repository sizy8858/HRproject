package com.hr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hr.dto.CountriesDto;
import com.hr.util.DBConn;

public class CountriesDao {

	public void insert(CountriesDto dto) {
		String sql = String.format(
				"insert into jobs values('%s' ,%d,'%s')",
				dto.getCountry_id(), dto.getRegion_id(),
				dto.getCountry_name());
		DBConn.statementUpdate(sql);
	}
	public ArrayList<CountriesDto> selectAll() {
		ArrayList<CountriesDto> resultDtos = new ArrayList<CountriesDto>();
		ResultSet rs = DBConn.statementQuery(String.format("select * from countries"));
		try {
			while (rs.next()) {
				resultDtos.add(new CountriesDto(rs.getString("country_id"), rs.getInt("region_id"),
						rs.getString("country_name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultDtos;
	}
	public CountriesDto selectId(String country_id) {
		CountriesDto resultDtos = new CountriesDto();
		ResultSet rs = DBConn.statementQuery(String.format("select * from countries where country_id='%s'", country_id));
		if (rs != null) {
			try {
				rs.next();
				resultDtos=new CountriesDto(rs.getString("country_id"), rs.getInt("region_id"),rs.getString("country_name"));
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return resultDtos;
	}

	// update작업
	public void update(String country_id, String country_name) {
		DBConn.statementUpdate(String.format("update customer set country_name ='%s' where country_id='%s'",country_name,country_id));
	}
	// delete작업
	public void delete(String country_id) {
		DBConn.statementUpdate(String.format("delete jobs where country_id ='%s'", country_id));
	}

	public ArrayList<String> getCountry_ids() {
		ArrayList<String> ids = new ArrayList<String>();
		ResultSet rs = DBConn.statementQuery(String.format("select * from country_id"));
		try {
			while (rs.next()) {
				ids.add(rs.getString("country_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ids;
	}

	// CustomerHobby 작업으로 생긴 부분
	public String getMaxCountry_id() {
		String maxIdValue = "-1";
		ResultSet rs = DBConn.statementQuery(String.format("select max(Country_id)as max country_id from countries"));
		if (rs != null) {
			try {
				rs.next();
				maxIdValue = rs.getString("MaxCountry_id");
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		return maxIdValue;
	}
	}
