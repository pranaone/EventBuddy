package com.eb.model;

import java.util.Date;

public class Ticket {

private int ticket_id;
private String seat_no;
private double commission;
private Date payment_date;
private double payment_amount;
private String payment_status;
private Customer customer;
private Event event;

public Ticket() {}

public Ticket(int ticket_id, String seat_no, double commission, Date payment_date, double payment_amount,
		String payment_status) {
	super();
	this.ticket_id = ticket_id;
	this.seat_no = seat_no;
	this.commission = commission;
	this.payment_date = payment_date;
	this.payment_amount = payment_amount;
	this.payment_status = payment_status;
}

public Ticket(int ticket_id, String seat_no, double commission, Date payment_date, double payment_amount,
		String payment_status, Customer customer, Event event) {
	super();
	this.ticket_id = ticket_id;
	this.seat_no = seat_no;
	this.commission = commission;
	this.payment_date = payment_date;
	this.payment_amount = payment_amount;
	this.payment_status = payment_status;
	this.customer = customer;
	this.event = event;
}

public int getTicket_id() {
	return ticket_id;
}

public void setTicket_id(int ticket_id) {
	this.ticket_id = ticket_id;
}

public String getSeat_no() {
	return seat_no;
}

public void setSeat_no(String seat_no) {
	this.seat_no = seat_no;
}

public double getCommission() {
	return commission;
}

public void setCommission(double commission) {
	this.commission = commission;
}

public Date getPayment_date() {
	return payment_date;
}

public void setPayment_date(Date payment_date) {
	this.payment_date = payment_date;
}

public double getPayment_amount() {
	return payment_amount;
}

public void setPayment_amount(double payment_amount) {
	this.payment_amount = payment_amount;
}

public String getPayment_status() {
	return payment_status;
}

public void setPayment_status(String payment_status) {
	this.payment_status = payment_status;
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
