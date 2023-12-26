package com.hr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.hr.dto.JobHistoryDto;
import com.hr.util.DBConn;

public class JobHistoryDao {

	public void insert(JobHistoryDto dto) {
		String sql = String.format(
				"insert into job_history values(to_date('%s','YYYY:MM:DD HH24:MI:SS'),%d,%d,'%s',to_date('%s','YYYY:MM:DD HH24:MI:SS'))",
				dto.getStart_date().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),dto.getEmployee_id(), dto.getJob_id(),dto.getDepartment_id(),
				dto.getEnd_date().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		DBConn.statementUpdate(sql);
	}

	// select 작업
	public ArrayList<JobHistoryDto> selectAll() {
		ArrayList<JobHistoryDto> resultDtos = new ArrayList<JobHistoryDto>();
		ResultSet rs = DBConn.statementQuery(String.format("select * from job_history"));
		try {
			while (rs.next()) {
				resultDtos.add(new JobHistoryDto(rs.getTimestamp("start_date").toLocalDateTime(), rs.getInt("employee_id"), rs.getInt("department_id"),
						rs.getString("job_id"),rs.getTimestamp("end_date").toLocalDateTime()));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultDtos;
	}

	// select 작업
	public JobHistoryDto selectId(String job_id) {
		JobHistoryDto resultDtos = new JobHistoryDto();
		ResultSet rs = DBConn.statementQuery(String.format("select * from job_history where job_id='%s'", job_id));
		if (rs != null) {
			try {
				rs.next();
				resultDtos = new JobHistoryDto(rs.getTimestamp("start_date").toLocalDateTime(), rs.getInt("employee_id"), rs.getInt("department_id"),
						rs.getString("job_id"),rs.getTimestamp("end_date").toLocalDateTime());
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return resultDtos;
	}

	// update작업
	public void updatemMax(String employee_id, LocalDateTime end_date) {

		DBConn.statementUpdate(String.format("update job_history set end_date = to_date('%s','YYYY:MM:DD HH24:MI:SS') where employee_id=%d", end_date, employee_id));
	}
	// delete작업
	public void delete(String job_id) {
		DBConn.statementUpdate(String.format("delete job_history where job_id ='%s'", job_id));
	}

	public ArrayList<String> getjob_ids() {
		ArrayList<String> ids = new ArrayList<String>();
		ResultSet rs = DBConn.statementQuery(String.format("select * from job_history"));
		try {
			while (rs.next()) {
				ids.add(rs.getString("job_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ids;
	}

	// job_historyHobby 작업으로 생긴 부분
	public String getMaxjob_id() {
		String maxIdValue = "-1";
		ResultSet rs = DBConn.statementQuery(String.format("select max(job_id)as maxjob_id from job_history"));
		if (rs != null) {
			try {
				rs.next();
				maxIdValue = rs.getString("maxjob_id");
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
