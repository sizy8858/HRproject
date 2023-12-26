package com.hr.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.DepartmentsDao;
import com.hr.dao.EmpMgrDeptDao;
import com.hr.dao.EmployeesDao;
import com.hr.dto.EmpMgrDeptDto;

public class EmpMgrDeptService {
	public static EmployeesDao employeesDao = new EmployeesDao();
	public static DepartmentsDao departmentsDao = new DepartmentsDao();
	public static EmpMgrDeptDao empMgrDeptDao = new EmpMgrDeptDao();
	
//	public static void insertDB(HttpServletRequest request, HttpServletResponse response) {
//		EmployeesDto employeesDto = new EmployeesDto(Integer.parseInt(request.getParameter("employee_id")), 
//				request.getParameter("first_name"), request.getParameter("last_name")
//				, request.getParameter("email"), request.getParameter("phone_number"),
//				LocalDateTime.parse(request.getParameter("hire_date")), request.getParameter("job_id"),
//				Integer.parseInt(request.getParameter("salary")), 
//				Integer.parseInt(request.getParameter("commission_pct")), 
//				Integer.parseInt(request.getParameter("manager_id")), 
//				Integer.parseInt(request.getParameter("department_id")));
//		employeesDao.insert(employeesDto);
//		


	
	public static void selectAll(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<EmpMgrDeptDto> dtos = new ArrayList<EmpMgrDeptDto>();
		dtos = empMgrDeptDao.selectAllEmployeeAndDepartments();
		request.setAttribute("dtos", dtos);
	}
	
	public static void selectOne(HttpServletRequest request, HttpServletResponse response) {
		EmpMgrDeptDto dto = empMgrDeptDao.selectOneEmployeesAndDepartments(request.getParameter("department_name"), request.getParameter("first_name"));
		System.out.println(dto);
		request.setAttribute("dto", dto);
	}
	
//	public static void deleteHobby(HttpServletRequest request, HttpServletResponse response) {
//		hobbyDao.delete(Integer.parseInt(request.getParameter("id"))
//				, request.getParameter("hobby"));
//	}
//	
//	public static void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
//		hobbyDao.delete(Integer.parseInt(request.getParameter("id")));
//		customerDao.delete(Integer.parseInt(request.getParameter("id")));
//	}
//	
//	public static void update(HttpServletRequest request, HttpServletResponse response) {
//		customerDao.update(Integer.parseInt(request.getParameter("id")), Double.parseDouble(request.getParameter("newHeight")));
//		hobbyDao.update(Integer.parseInt(request.getParameter("id")), request.getParameter("hobby"), request.getParameter("newHobby"));
//		
//	}
}

	
