package com.eb.model;

public class Hall {

	private int hallId;
	private String hallName;
	private String hallType;
	private String hallLocation;
	private String hallContact;
	private int noOfSeats;
	private Owner owner;
	
	public Hall() {}
	

	public Hall(String hallName, String hallType, String hallLocation, String hallContact, int noOfSeats) {
		super();
		this.hallName = hallName;
		this.hallType = hallType;
		this.hallLocation = hallLocation;
		this.hallContact = hallContact;
		this.noOfSeats = noOfSeats;
	}

	public Hall(int hallId, String hallName, String hallType, String hallLocation, String hallContact, int noOfSeats) {
		super();
		this.hallId = hallId;
		this.hallName = hallName;
		this.hallType = hallType;
		this.hallLocation = hallLocation;
		this.hallContact = hallContact;
		this.noOfSeats = noOfSeats;
	}

	public Hall(int hallId, String hallName, String hallType, String hallLocation, String hallContact, int noOfSeats,
			Owner owner) {
		super();
		this.hallId = hallId;
		this.hallName = hallName;
		this.hallType = hallType;
		this.hallLocation = hallLocation;
		this.hallContact = hallContact;
		this.noOfSeats = noOfSeats;
		this.owner = owner;
	}

	public int getHallId() {
		return hallId;
	}

	public void setHallId(int hallId) {
		this.hallId = hallId;
	}

	public String getHallName() {
		return hallName;
	}

	public void setHallName(String hallName) {
		this.hallName = hallName;
	}

	public String getHallType() {
		return hallType;
	}

	public void setHallType(String hallType) {
		this.hallType = hallType;
	}

	public String getHallLocation() {
		return hallLocation;
	}

	public void setHallLocation(String hallLocation) {
		this.hallLocation = hallLocation;
	}

	public String getHallContact() {
		return hallContact;
	}

	public void setHallContact(String hallContact) {
		this.hallContact = hallContact;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	

}
