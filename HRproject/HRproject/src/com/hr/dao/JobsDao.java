package com.hr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hr.dto.JobsDto;
import com.hr.util.DBConn;

public class JobsDao {

	public void insert(JobsDto dto) {
		String sql = String.format(
				"insert into jobs values('%s' ,'%s', %d, %d)",
				dto.getJob_id(), dto.getJob_title(),
				dto.getMin_salary(), dto.getMax_salary());
		DBConn.statementUpdate(sql);
	}

	// select 작업
	public ArrayList<JobsDto> selectAll() {
		ArrayList<JobsDto> resultDtos = new ArrayList<JobsDto>();
		ResultSet rs = DBConn.statementQuery(String.format("select * from jobs order by job_id"));
		try {
			while (rs.next()) {
				resultDtos.add(new JobsDto(rs.getString("job_id"), rs.getString("job_title"), rs.getInt("min_salary"),
						rs.getInt("max_salary")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultDtos;
	}

	// select 작업
	public JobsDto selectId(String job_id) {
		JobsDto resultDtos = new JobsDto();
		ResultSet rs = DBConn.statementQuery(String.format("select * from jobs where job_id='%s'", job_id));
		if (rs != null) {
			try {
				rs.next();
				resultDtos = new JobsDto(rs.getString("job_id"), rs.getString("job_title"), rs.getInt("min_salary"),
						rs.getInt("max_salary"));
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return resultDtos;
	}

	// update작업
	public void update(String job_id, int min_salary) {

		DBConn.statementUpdate(String.format("update jobs set min_salary =%d where job_id='%s'",min_salary, job_id));
	}
	// delete작업
	public void delete(String job_title) {
		DBConn.statementUpdate(String.format("delete jobs where job_title ='%s'", job_title));
	}

	public ArrayList<String> getjob_ids() {
		ArrayList<String> ids = new ArrayList<String>();
		ResultSet rs = DBConn.statementQuery(String.format("select * from jobs"));
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

	// CustomerHobby 작업으로 생긴 부분
	public String getMaxjob_id() {
		String maxIdValue = "-1";
		ResultSet rs = DBConn.statementQuery(String.format("select max(job_id)as maxjob_id from jobs"));
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

	public void update(String job_id, String job_title) {
		DBConn.statementUpdate(String.format("update jobs set job_title='%s' where job_id='%s'", job_id, job_title));

	}

}
