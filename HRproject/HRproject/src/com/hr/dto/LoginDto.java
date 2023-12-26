package com.hr.dto;

public class LoginDto {
	private Integer employee_id;
	private String employee_pw;
	private String first_name;
	private String last_name;
	private String isAdmin;
	
	public LoginDto() {}

	public LoginDto(Integer employee_id, String employee_pw, String first_name, String last_name, String isAdmin) {
		super();
		this.employee_id = employee_id;
		this.employee_pw = employee_pw;
		this.first_name = first_name;
		this.last_name = last_name;
		this.isAdmin = isAdmin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + ((employee_id == null) ? 0 : employee_id.hashCode());
		result = prime * result + ((employee_pw == null) ? 0 : employee_pw.hashCode());
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + ((isAdmin == null) ? 0 : isAdmin.hashCode());
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
		LoginDto other = (LoginDto) obj;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		if (employee_id == null) {
			if (other.employee_id != null)
				return false;
		} else if (!employee_id.equals(other.employee_id))
			return false;
		if (employee_pw == null) {
			if (other.employee_pw != null)
				return false;
		} else if (!employee_pw.equals(other.employee_pw))
			return false;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (isAdmin == null) {
			if (other.isAdmin != null)
				return false;
		} else if (!isAdmin.equals(other.isAdmin))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LoginDto [employee_id=" + employee_id + ", employee_pw=" + employee_pw + ", first_name=" + first_name
				+ ", last_name=" + last_name + ", isAdmin=" + isAdmin + "]";
	}

	public Integer getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_pw() {
		return employee_pw;
	}

	public void setEmployee_pw(String employee_pw) {
		this.employee_pw = employee_pw;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	
}
