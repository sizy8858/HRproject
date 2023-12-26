package com.hr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hr.dto.LoginDto;
import com.hr.util.DBConn;

public class LoginDao {
	 public static LoginDao loginDao = new LoginDao();
	//insert
	public void insert(LoginDto dto) {
		String sql=String.format("insert into login values(%d, '%s', '%s','%s','%s')", 
								dto.getEmployee_id(), dto.getEmployee_pw(), dto.getFirst_name(),
								dto.getLast_name(), dto.getIsAdmin());
		DBConn.statementUpdate(sql);
	}
	//delete
	public void delete(Integer employee_id) {
		DBConn.statementUpdate(String.format("delete login where employee_id=%d", employee_id));
	}
	//update
	public void updatePw(Integer employee_id, String employee_pw) {
		DBConn.statementUpdate(String.format("update login set employee_pw='%s' where employee_id=%d", employee_pw, employee_id));
	}
	
	public void updateAdmin(Integer employee_id, String isAdmin) {
		DBConn.statementUpdate(String.format("update login set isAdmin='%s' where employee_id=%d", isAdmin, employee_id));
	}
	//select (비번 제외하고 아이디만)
	public ArrayList<LoginDto> selectAll() {
		ArrayList<LoginDto> resultDtos=new ArrayList<LoginDto>();
		ResultSet rs=DBConn.statementQuery(String.format("select employee_id,employee_pw from login order by employee_id"));
		
		try {
			while(rs.next()) {
				resultDtos.add(new LoginDto(rs.getInt("employee_id"), rs.getString("employee_pw"),
											rs.getString("first_name"), rs.getString("last_name"),
											rs.getString("isAdmin")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return resultDtos;
	}
	public LoginDto selectId(Integer employee_id) {
		LoginDto resultDtos=new LoginDto();
		ResultSet rs=DBConn.statementQuery(String.format("select employee_id,employee_pw from Login where employee_id=%d", employee_id));
		
		if(rs!=null) {
			try {
				rs.next();
				resultDtos=new LoginDto(rs.getInt("employee_id"), rs.getString("employee_pw"),
										rs.getString("first_name"), rs.getString("last_name"), rs.getString("isAdmin"));
			}catch(SQLException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return resultDtos;
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
	 
	 public String getAdminStatus(String employee_id) {
		 String isAdmin="";
		 DBConn.statementUpdate(String.format("select isAdmin from login where employee_id=%d", employee_id));
		 return isAdmin;
	 }
	 
	 public String getLastName(String employee_id) {
		 String last_name = "";
	     DBConn.statementUpdate(String.format("SELECT last_name FROM login WHERE employee_id=%d", employee_id));
	     return last_name;
	 }
}
