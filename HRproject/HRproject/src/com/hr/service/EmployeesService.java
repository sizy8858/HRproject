package com.hr.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EmployeesDao;
import com.hr.dto.EmployeesDto;

public class EmployeesService {
	public static EmployeesDao employeesDao=new EmployeesDao();
	
	public static void insertDB(HttpServletRequest request, HttpServletResponse response) {
		EmployeesDto dto=new EmployeesDto(Integer.parseInt(request.getParameter("employee_id")), 
										  request.getParameter("first_name"),
										  request.getParameter("last_name"),
										  request.getParameter("email"),
										  request.getParameter("phone_number"),
										  LocalDateTime.parse(request.getParameter("hire_date")),
										  request.getParameter("job_id"),
										  Double.parseDouble(request.getParameter("salary")),
                                          Double.parseDouble(request.getParameter("commission_pct")),
                                          Integer.parseInt(request.getParameter("manager_id")),
                                          Integer.parseInt(request.getParameter("department_id")));
		System.out.println(dto);
		employeesDao.insert(dto);
	}
	
	public static void selectAll(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<EmployeesDto> dtos=employeesDao.selectAll();
		request.setAttribute("dtos", dtos);
	}
	
	public static void selectId(HttpServletRequest request, HttpServletResponse response) {
		EmployeesDto dto=employeesDao.selectId(Integer.parseInt(request.getParameter("employee_id")));
		request.setAttribute("dto", dto);
	}
	
	public static void selectName(HttpServletRequest request, HttpServletResponse response) {
		EmployeesDto dto=employeesDao.selectName(request.getParameter("last_name"));
		request.setAttribute("dto", dto);
	}
	
	public static void updateEmail(HttpServletRequest request, HttpServletResponse response) {
		employeesDao.updateEmail(Integer.parseInt(request.getParameter("employee_id")), request.getParameter("email"));
	}
	public static void updatePhone(HttpServletRequest request, HttpServletResponse response) {
		employeesDao.updateEmail(Integer.parseInt(request.getParameter("employee_id")), request.getParameter("phone_number"));
	}
	public static void updateSal(HttpServletRequest request, HttpServletResponse response) {
		employeesDao.updateSal(Integer.parseInt(request.getParameter("employee_id")), Integer.parseInt(request.getParameter("salary")));
	}
	public static void updateComm(HttpServletRequest request, HttpServletResponse response) {
		employeesDao.updateSal(Integer.parseInt(request.getParameter("employee_id")), Integer.parseInt(request.getParameter("commission_pct")));
	}
	public static void updateManager(HttpServletRequest request, HttpServletResponse response) {
		employeesDao.updateSal(Integer.parseInt(request.getParameter("employee_id")), Integer.parseInt(request.getParameter("manager_id")));
	}
	public static void updateDept(HttpServletRequest request, HttpServletResponse response) {
		employeesDao.updateSal(Integer.parseInt(request.getParameter("employee_id")), Integer.parseInt(request.getParameter("department_id")));
	}
	
	public static void updateFirstName(HttpServletRequest request, HttpServletResponse response) {
		employeesDao.updateFirstName(Integer.parseInt(request.getParameter("employee_id")), request.getParameter("first_name"));
	}
	
	public static void delete(HttpServletRequest request, HttpServletResponse response) {
		employeesDao.delete(Integer.parseInt(request.getParameter("employee_id")));
	}
	
	
}
