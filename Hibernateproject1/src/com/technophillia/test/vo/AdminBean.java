package com.technophillia.test.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class AdminBean 
{
	//============ Variables =========================

	@Id @GeneratedValue
	@Column(name="sl_no")
	private int sl_no;

	@Column(name="username")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	//=============== CONSTRUCTORS ======================
	
	public AdminBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminBean(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	//========= start Getters and Setters==========================
	public int getSl_no() {
		return sl_no;
	}

	public void setSl_no(int sl_no) {
		this.sl_no = sl_no;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//================== end Getters and Setters==========================
	
	//======================= start hashcode equals and toString ===============================
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + sl_no;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		AdminBean other = (AdminBean) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (sl_no != other.sl_no)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AdminBean [sl_nol=" + sl_no + ", userName=" + userName + ", password=" + password + "]";
	}
	
	//======================= end hashcode equals and toString ===============================
	
	

}
