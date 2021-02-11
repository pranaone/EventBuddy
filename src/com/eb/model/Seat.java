package com.eb.model;

public class Seat {

	private int seatId;
	private String seatNo;
	private boolean seatStatus;
	private Event event;
	
	public Seat() {}

	public Seat(int seatId, String seatNo, boolean seatStatus) {
		super();
		this.seatId = seatId;
		this.seatNo = seatNo;
		this.seatStatus = seatStatus;
	}

	public Seat(int seatId, String seatNo, boolean seatStatus, Event event) {
		super();
		this.seatId = seatId;
		this.seatNo = seatNo;
		this.seatStatus = seatStatus;
		this.event = event;
	}

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	public boolean isSeatStatus() {
		return seatStatus;
	}

	public void setSeatStatus(boolean seatStatus) {
		this.seatStatus = seatStatus;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
	
	
}
