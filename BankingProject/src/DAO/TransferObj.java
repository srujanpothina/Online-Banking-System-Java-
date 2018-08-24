package DAO;

import java.io.Serializable;
import java.util.Date;

public class TransferObj implements Serializable {

	int sender,receiver; 
	Double amount;
	Date date;
	String fullname,emailid;
	double balance;

	public TransferObj(String fullname, String emailid, double balance) {
		super();
		this.fullname = fullname;
		this.emailid = emailid;
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public TransferObj(String fullname, String emailid) {
		super();
		this.fullname = fullname;
		this.emailid = emailid;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getSender() {
		return sender;
	}
	public void setSender(int sender) {
		this.sender = sender;
	}
	public int getReceiver() {
		return receiver;
	}
	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public TransferObj(int sender, int receiver, Double amount, Date date) {
		super();
		this.sender = sender;
		this.receiver = receiver;
		this.amount = amount;
		this.date = date;
	}
	public TransferObj() {

	}

}
