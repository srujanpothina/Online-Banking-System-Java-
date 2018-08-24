package DAO;

import java.io.Serializable;
import java.sql.Date;


public class Customer implements Serializable {
	
	String fullName,username,password,emailId,ssn,address,gender;
	Date dob;
	long phone;
	int branch;
	double balance;
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Customer() {
		
	}
	

	public Customer(String fullName, String username, String password, String emailId, String ssn, String address,
			String gender, Date dob, long phone, int branch, double balance) {
		super();
		this.fullName = fullName;
		this.username = username;
		this.password = password;
		this.emailId = emailId;
		this.ssn = ssn;
		this.address = address;
		this.gender = gender;
		this.dob = dob;
		this.phone = phone;
		this.branch = branch;
		this.balance = balance;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public int getBranch() {
		return branch;
	}
	public void setBranch(int branch) {
		this.branch = branch;
	}
	
	

}
