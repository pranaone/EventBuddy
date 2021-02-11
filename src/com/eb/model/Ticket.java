package com.eb.model;

import java.time.LocalDate;

public class Ticket {

private int ticketId;
private String seatNno;
private double commission;
private LocalDate paymentDate;
private double paymentAmount;
private String paymentStatus;
private Customer customer;
private Event event;

public Ticket() {}

public Ticket(String seatNno, double commission, LocalDate paymentDate, double paymentAmount, String paymentStatus,
		Customer customer, Event event) {
	super();
	this.seatNno = seatNno;
	this.commission = commission;
	this.paymentDate = paymentDate;
	this.paymentAmount = paymentAmount;
	this.paymentStatus = paymentStatus;
	this.customer = customer;
	this.event = event;
}

public Ticket(int ticketId, String seatNno, double commission, LocalDate paymentDate, double paymentAmount,
		String paymentStatus) {
	super();
	this.ticketId = ticketId;
	this.seatNno = seatNno;
	this.commission = commission;
	this.paymentDate = paymentDate;
	this.paymentAmount = paymentAmount;
	this.paymentStatus = paymentStatus;
}

public Ticket(int ticketId, String seatNno, double commission, LocalDate paymentDate, double paymentAmount,
		String paymentStatus, Customer customer, Event event) {
	super();
	this.ticketId = ticketId;
	this.seatNno = seatNno;
	this.commission = commission;
	this.paymentDate = paymentDate;
	this.paymentAmount = paymentAmount;
	this.paymentStatus = paymentStatus;
	this.customer = customer;
	this.event = event;
}

public int getTicketId() {
	return ticketId;
}

public void setTicketId(int ticketId) {
	this.ticketId = ticketId;
}

public String getSeatNno() {
	return seatNno;
}

public void setSeatNno(String seatNno) {
	this.seatNno = seatNno;
}

public double getCommission() {
	return commission;
}

public void setCommission(double commission) {
	this.commission = commission;
}

public LocalDate getPaymentDate() {
	return paymentDate;
}

public void setPaymentDate(LocalDate paymentDate) {
	this.paymentDate = paymentDate;
}

public double getPaymentAmount() {
	return paymentAmount;
}

public void setPaymentAmount(double paymentAmount) {
	this.paymentAmount = paymentAmount;
}

public String getPaymentStatus() {
	return paymentStatus;
}

public void setPaymentStatus(String paymentStatus) {
	this.paymentStatus = paymentStatus;
}

public Customer getCustomer() {
	return customer;
}

public void setCustomer(Customer customer) {
	this.customer = customer;
}

public Event getEvent() {
	return event;
}

public void setEvent(Event event) {
	this.event = event;
}




}

