package com.hr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hr.dto.EmpMgrDto;
import com.hr.util.DBConn;

public class EmpMgrDao {
	// 삽입
	public ArrayList<EmpMgrDto> selectEmpMgr(){
		ArrayList<EmpMgrDto> resultDtos = new ArrayList<EmpMgrDto>();
		ResultSet rs = DBConn.statementQuery(String.format(
				"select e1.first_name employee, e2.first_name manager "
				+ "from empoyees e1, employees e2 where e1.manager_id = e2.employee_id"));
		try {
			while(rs.next()) {
				resultDtos.add(new EmpMgrDto(rs.getString("employee"),
						rs.getString("manager")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return resultDtos;
	}
}
