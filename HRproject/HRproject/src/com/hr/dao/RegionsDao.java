package com.hr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hr.dto.RegionsDto;
import com.hr.util.DBConn;

public class RegionsDao {

	public void insert(RegionsDto dto) {
		String sql = String.format(
				"insert into regions values( %d ,'%s')",
				dto.getRegion_id(), dto.getRegion_name());
		DBConn.statementUpdate(sql);
	}

	// select 작업
	public ArrayList<RegionsDto> selectAll() {
		ArrayList<RegionsDto> resultDtos = new ArrayList<RegionsDto>();
		ResultSet rs = DBConn.statementQuery(String.format("select * from regions"));
		try {
			while (rs.next()) {
				resultDtos.add(new RegionsDto(rs.getInt("region_id"), rs.getString("region_name")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultDtos;
	}

	// select 작업
	public RegionsDto selectId(int region_id) {
		RegionsDto resultDtos = new RegionsDto();
		ResultSet rs = DBConn.statementQuery(String.format("select * from regions where region_id=%d", region_id));
		if (rs != null) {
			try {
				rs.next();
				resultDtos = new RegionsDto(rs.getInt("region_id"), rs.getString("region_name"));
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return resultDtos;
	}

	// update작업
	public void updatem(int region_id, String region_name) {

		DBConn.statementUpdate(String.format("update regions set region_name ='%s' where region_id=%d",region_name,region_id));
	}
	// delete작업
	public void delete(int region_id) {
		DBConn.statementUpdate(String.format("delete regions where region_id =%d", region_id));
	}

	public ArrayList<Integer> getregion_ids() {
		ArrayList<Integer> ids = new ArrayList<Integer>();
		ResultSet rs = DBConn.statementQuery(String.format("select * from regions"));
		try {
			while (rs.next()) {
				ids.add(rs.getInt("region_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ids;
	}

	// CustomerHobby 작업으로 생긴 부분
	public Integer getMaxregion_id() {
		Integer maxIdValue = -1;
		ResultSet rs = DBConn.statementQuery(String.format("select max(region_id)as maxregion_id from regions"));
		if (rs != null) {
			try {
				rs.next();
				maxIdValue = rs.getInt("maxregion_id");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		return maxIdValue;
	}

	

}
