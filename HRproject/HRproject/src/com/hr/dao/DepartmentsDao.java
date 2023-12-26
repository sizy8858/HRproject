package com.hr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hr.dto.DepartmentsDto;
import com.hr.util.DBConn;

public class DepartmentsDao {
	// insert
	public void insert(DepartmentsDto dto) {
		String sql = String.format("insert into departments values (%d, '%s', %d, %d)",
			    dto.getDepartment_id(),dto.getDepartment_name(), 
			    dto.getManager_id(),dto.getLocation_id());
			    

		DBConn.statementQuery(sql);
	}
	
	// update
	public void update(int department_id, int manager_id) {
		String sql = String.format("update departments set manager_id=%d where department_id=%d", 
				manager_id, department_id);
		DBConn.statementQuery(sql);
	}
	
	// delete
	public void delete(Integer department_id) {
		DBConn.statementQuery(String.format("delete departments where department_id = %d"));
	}
	
	// select
	public ArrayList<DepartmentsDto> selectAll(){
		ArrayList<DepartmentsDto> resultDtos = new ArrayList<DepartmentsDto>();
		ResultSet rs = DBConn.statementQuery(
				String.format("select * from departments order by department_id"));
		try {
			while(rs.next()) {
				resultDtos.add(new DepartmentsDto(
						rs.getInt("department_id"), rs.getString("department_name"),
						rs.getInt("manager_id"), rs.getInt("location_id")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return resultDtos;
	}
	
	public DepartmentsDto selectId(int department_id) {
		DepartmentsDto resultDtos = new DepartmentsDto();
		ResultSet rs = DBConn.statementQuery(String.format("select * from departments where department_id = %d", department_id));
		if(rs != null) {
			try {
				rs.next();
				resultDtos = new DepartmentsDto(
						rs.getInt("department_id"), rs.getString("department_name"),
						rs.getInt("manager_id"), rs.getInt("location_id"));
			}catch(SQLException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return resultDtos;
	}
}
