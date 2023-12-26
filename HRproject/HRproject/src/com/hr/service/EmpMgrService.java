package com.hr.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dto.EmpMgrDto;
import com.hr.dao.EmpMgrDao;

public class EmpMgrService {
	public static EmpMgrDao dao= new EmpMgrDao();
	
	public static void selectEmpMgr(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<EmpMgrDto> dtos = dao.selectEmpMgr();
		request.setAttribute("dtos", dtos);
	}
	
}
