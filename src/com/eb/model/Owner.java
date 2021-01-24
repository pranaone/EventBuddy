package com.eb.model;

public class Owner {
	private int ownerId;
	private String firstName;
	private String lastName;
	private String email;
	private String mobile;
	private String brNo;
	private User user;
	
	public Owner() {}
	
	public Owner(int ownerId, String firstName, String lastName, String email, String mobile, String brNo) {
		super();
		this.ownerId = ownerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.brNo = brNo;
	}
	
	public Owner(int ownerId, String firstName, String lastName, String email, String mobile, String brNo, User user) {
		super();
		this.ownerId = ownerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.brNo = brNo;
		this.user = user;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getBrNo() {
		return brNo;
	}

	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

	

	

	
}
