package com.hr.dao;

import java.sql.ResultSet;
import java.util.ArrayList;


import com.hr.dto.EmpMgrDeptDto;
import com.hr.util.DBConn;



public class EmpMgrDeptDao {
	public ArrayList<EmpMgrDeptDto> selectAllEmployeeAndDepartments() {
		ArrayList<EmpMgrDeptDto> resultDtos = new ArrayList<EmpMgrDeptDto>();
		ResultSet rs = DBConn.statementQuery(String.format("select e.employee_id, e.first_name, e.last_name, e.email, e.phone_number, e.hire_date, e.job_id, e.salary, e.commission_pct, e.manager_id, e.department_id, d.department_name from employees e join departments d on e.department_id = d.department_id order by employee_id"));	
		try {
			while(rs.next()) {
				resultDtos.add(new EmpMgrDeptDto(
						rs.getInt("employee_id"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("email"),
						rs.getString("phone_number"),
						rs.getTimestamp("hire_date").toLocalDateTime(),
						rs.getString("job_id"),
						rs.getDouble("salary"),
						rs.getDouble("commission_pct"),
						rs.getInt("manager_id"),
						rs.getInt("department_id"),
						rs.getString("department_name")
						
						)
				);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return resultDtos;
	}
	
	public EmpMgrDeptDto selectOneEmployeesAndDepartments(String department_name, String first_name) {
		EmpMgrDeptDto resultDto = null;
		// id가 있을때
		// select customer.*, hobby.hobby from customer, hobby where customer.id=hobby.id(+)
		// and customer.id=31 and hobby.hobby is null;
		
		// id가 없을때
		// select customer.*, hobby.hobby from customer, hobby where customer.id = hobby.id(+)
		// and customer.id=101 and hobby.hobby = '1';
		String sql = "";
		if(department_name.equals("")) {
			sql = "select case when department_name = '' then null else department_name end as" + 
					"department_name, first_name from departments D left join employees E on D.manager_id = E.employee_id;";
		} else {
			sql = "select department_name, first_name from "
					+ "departments D left join employees E on D.manager_id = E.employee_id "
					+ "where D.department_name is not null;";	
		}
		System.out.println(sql);
		ResultSet rs = DBConn.statementQuery(String.format(sql));
		
		try {
			while(rs.next()) {
				resultDto = new EmpMgrDeptDto(
						rs.getInt("employee_id"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("email"),
						rs.getString("phone_number"),
						rs.getTimestamp("hire_date").toLocalDateTime(),
						rs.getString("job_id"),
						rs.getInt("salary"),
						rs.getInt("commission_pct"),
						rs.getInt("manager_id"),
						rs.getInt("department_id"),
						rs.getString("department_name")
						);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultDto;
	}

}


