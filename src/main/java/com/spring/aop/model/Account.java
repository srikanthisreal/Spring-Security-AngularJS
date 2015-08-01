package com.spring.aop.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Account model.
 * 
 * @author srikanth_p
 *
 */
@XmlRootElement(name = "account")
@XmlAccessorType(XmlAccessType.FIELD)
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	@XmlAttribute
	private String accountNumber;
	@XmlAttribute
	private String customerName;
	@XmlAttribute
	private String balance;
	@XmlAttribute
	private String passwordOne;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getPasswordOne() {
		return passwordOne;
	}

	public void setPasswordOne(String passwordOne) {
		this.passwordOne = passwordOne;
	}

}
