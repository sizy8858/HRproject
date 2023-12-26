package com.hr.dto;

import java.time.LocalDateTime;

public class JobHistoryDto {
	private LocalDateTime start_date;
	private int employee_id;
	private int department_id;
	private String job_id;
	private LocalDateTime end_date;
	public JobHistoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JobHistoryDto(LocalDateTime start_date, int employee_id, int department_id, String job_id,
			LocalDateTime end_date) {
		super();
		this.start_date = start_date;
		this.employee_id = employee_id;
		this.department_id = department_id;
		this.job_id = job_id;
		this.end_date = end_date;
	}
	@Override
	public String toString() {
		return "JobHistoryDto [start_date=" + start_date + ", employee_id=" + employee_id + ", department_id="
				+ department_id + ", job_id=" + job_id + ", end_date=" + end_date + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + department_id;
		result = prime * result + employee_id;
		result = prime * result + ((end_date == null) ? 0 : end_date.hashCode());
		result = prime * result + ((job_id == null) ? 0 : job_id.hashCode());
		result = prime * result + ((start_date == null) ? 0 : start_date.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobHistoryDto other = (JobHistoryDto) obj;
		if (department_id != other.department_id)
			return false;
		if (employee_id != other.employee_id)
			return false;
		if (end_date == null) {
			if (other.end_date != null)
				return false;
		} else if (!end_date.equals(other.end_date))
			return false;
		if (job_id == null) {
			if (other.job_id != null)
				return false;
		} else if (!job_id.equals(other.job_id))
			return false;
		if (start_date == null) {
			if (other.start_date != null)
				return false;
		} else if (!start_date.equals(other.start_date))
			return false;
		return true;
	}
	public LocalDateTime getStart_date() {
		return start_date;
	}
	public void setStart_date(LocalDateTime start_date) {
		this.start_date = start_date;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	public LocalDateTime getEnd_date() {
		return end_date;
	}
	public void setEnd_date(LocalDateTime end_date) {
		this.end_date = end_date;
	}
	
	
}
