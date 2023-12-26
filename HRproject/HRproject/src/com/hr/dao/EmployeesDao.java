package com.hr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.hr.dto.EmployeesDto;
import com.hr.util.DBConn;

public class EmployeesDao {
	//삽입

	public void insert(EmployeesDto dto) {
		String sql=String.format("insert into employees values(%d, '%s', '%s', '%s', '%s', to_date('%s', 'YYYY-MM-DD HH24:MI:SS'), '%s', %.1f, %.1f, %d, %d)",

								dto.getEmployee_id(), dto.getFirst_name(), dto.getLast_name(), dto.getEmail(),
								dto.getPhone_number(), dto.getHire_date().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), dto.getJob_id(), dto.getSalary(),
								dto.getCommission_pct(), dto.getManager_id(), dto.getDepartment_id());
		DBConn.statementUpdate(sql);
	}
	//삭제는 job_history 퇴사 날짜 기입으로 대체
	//갱신(이메일, 연락처, 급여, 커미션, 상사, 부서)
	public void updateEmail(Integer employee_id, String updEmail) {
		DBConn.statementUpdate(String.format("update employees set email='%s' where employee_id=%d", updEmail, employee_id));
	}
	public void updatePhone(Integer employee_id, String updPhone) {
		DBConn.statementUpdate(String.format("update employees set phone_number='%s' where employee_id=%d", updPhone, employee_id));
	}
	public void updateSal(Integer employee_id, int updSalary) {
		DBConn.statementUpdate(String.format("update employees set salary=%.1f where employee_id=%d", updSalary, employee_id));
	}
	public void updateComm(Integer employee_id, int updComm) {
		DBConn.statementUpdate(String.format("update employees set commission_pct=%.1f where employee_id=%d", updComm, employee_id));
	}
	public void updateManager(Integer employee_id, Integer updManager) {
		DBConn.statementUpdate(String.format("update employees set manager_id=%d where employee_id=%d", updManager, employee_id));
	}
	public void updateDept(Integer employee_id, Integer updDept) {
		DBConn.statementUpdate(String.format("update employees set department_id=%d where employee_id=%d", updDept, employee_id));
	}
	
	public void updateFirstName(Integer employee_id, String first_name) {
		String sql = String.format("update employees set first_name='%s' where employee_id=%d", first_name, employee_id);
		System.out.println(sql);
		DBConn.statementUpdate(sql);
		
	
	}
	// 삭제
	public void delete(Integer employee_id) {
		String sql = String.format("delete employees where employee_id=%d", employee_id);
		System.out.println(sql);
		DBConn.statementUpdate(sql);
	}
	//조회
	public ArrayList<EmployeesDto> selectAll() {
		ArrayList<EmployeesDto> resultDtos=new ArrayList<EmployeesDto>();
		ResultSet rs=DBConn.statementQuery(String.format("select * from employees order by employee_id"));
		
		try {
			while(rs.next()) {
				resultDtos.add(new EmployeesDto(rs.getInt("employee_id"),
												rs.getString("first_name"),
												rs.getString("last_name"),
												rs.getString("email"),
												rs.getString("phone_number"),
												rs.getTimestamp("hire_date").toLocalDateTime(),
												rs.getString("job_id"),
												rs.getDouble("salary"),
												rs.getDouble("commission_pct"),
												rs.getInt("manager_id"),
												rs.getInt("department_id")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return resultDtos;
	}
	public EmployeesDto selectId(Integer employee_id) {
		EmployeesDto resultDtos=new EmployeesDto();
		ResultSet rs=DBConn.statementQuery(String.format("select * from employees where employee_id=%d", employee_id));
		
		if(rs!=null) {
			try {
				rs.next();
				resultDtos=new EmployeesDto(rs.getInt("employee_id"),
											rs.getString("first_name"),
											rs.getString("last_name"),
											rs.getString("email"),
											rs.getString("phone_number"),
											rs.getTimestamp("hire_date").toLocalDateTime(),
											rs.getString("job_id"),
											rs.getDouble("salary"),
											rs.getDouble("commission_pct"),
											rs.getInt("manager_id"),
											rs.getInt("department_id"));
			}catch(SQLException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return resultDtos;
	}
	public EmployeesDto selectName(String last_name) {
		EmployeesDto resultDtos=new EmployeesDto();
		ResultSet rs=DBConn.statementQuery(String.format("select * from employees where last_name='%s'", last_name));
		
		if(rs!=null) {
			try {
				rs.next();
				resultDtos=new EmployeesDto(rs.getInt("employee_id"),
											rs.getString("first_name"),
											rs.getString("last_name"),
											rs.getString("email"),
											rs.getString("phone_number"),
											rs.getTimestamp("hire_date").toLocalDateTime(),
											rs.getString("job_id"),
											rs.getDouble("salary"),
											rs.getDouble("commission_pct"),
											rs.getInt("manager_id"),
											rs.getInt("department_id"));
			}catch(SQLException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return resultDtos;
	}
}
