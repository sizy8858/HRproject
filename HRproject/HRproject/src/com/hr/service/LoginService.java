package com.hr.service;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.LoginDao;
import com.hr.dto.LoginDto;

public class LoginService {
	public static LoginDao loginDao=new LoginDao();
	
	public static void insertDB(HttpServletRequest request, HttpServletResponse response) {
		LoginDto dto=new LoginDto(Integer.parseInt(request.getParameter("employee_id")),
								  request.getParameter("employee_pw"), request.getParameter("first_name"),
								  request.getParameter("last_name"), request.getParameter("isAdmin"));
		System.out.println(dto);
		loginDao.insert(dto);
	}
	
	public static void delete(HttpServletRequest request, HttpServletResponse response) {
		loginDao.delete(Integer.parseInt(request.getParameter("employee_id")));
	}
	
	public static void updatePw(HttpServletRequest request, HttpServletResponse response) {
		loginDao.updatePw(Integer.parseInt(request.getParameter("employee_id")), request.getParameter("employee_pw"));
	}
	
	public static void updateAdmin(HttpServletRequest request, HttpServletResponse response) {
		loginDao.updateAdmin(Integer.parseInt(request.getParameter("employee_id")), request.getParameter("isAdmin"));
	}
	
	public static void selectAll(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<LoginDto> dtos=loginDao.selectAll();
		request.setAttribute("dtos", dtos);
	}
	
	public static void selectId(HttpServletRequest request, HttpServletResponse response) {
		LoginDto dto=loginDao.selectId(Integer.parseInt(request.getParameter("employee_id")));
		request.setAttribute("dto", dto);
	}

    public static boolean checkLogin(String employee_id, String employee_pw) {
        ArrayList<LoginDto> dtos = loginDao.selectAll();
        for (LoginDto dto : dtos) {
            if (dto.getEmployee_id().equals(employee_id) && dto.getEmployee_pw().equals(employee_pw)) {
                return true; // 사용자가 입력한 ID와 PW가 데이터베이스에 있는 정보와 일치하는 경우
            }
        }
        return false; // 사용자가 입력한 ID와 PW가 일치하는 로그인 정보를 찾을 수 없는 경우
    }
    
    public static String getAdminStatus(String employee_id) {
    	return loginDao.getAdminStatus(employee_id);
	}
    
    public static String getLastName(String employee_id) {
    	return loginDao.getLastName(employee_id);
    }
   
}
