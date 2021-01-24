package com.eb.model;

import java.time.LocalDate;
import java.time.LocalTime;



public class Event {

	private int eventId;
	private String eventName;
	private String eventType;
	private String eventDescription;
	private LocalDate eventDate;
	private LocalTime startTime;
	private LocalTime endTime;
	private double ticketPrice;
	private String eventImage;
	private Hall hall;
	
	public Event() {}

	public Event(int eventId, String eventName, String eventType, String eventDescription, LocalDate eventDate,
			LocalTime startTime, LocalTime endTime, double ticketPrice, String eventImage) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.eventType = eventType;
		this.eventDescription = eventDescription;
		this.eventDate = eventDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.ticketPrice = ticketPrice;
		this.eventImage = eventImage;
	}
	
	

	public Event(String eventName, String eventType, String eventDescription, LocalDate eventDate, LocalTime startTime,
			LocalTime endTime, double ticketPrice, String eventImage) {
		super();
		this.eventName = eventName;
		this.eventType = eventType;
		this.eventDescription = eventDescription;
		this.eventDate = eventDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.ticketPrice = ticketPrice;
		this.eventImage = eventImage;
	}

	public Event(int eventId, String eventName, String eventType, String eventDescription, LocalDate eventDate,
			LocalTime startTime, LocalTime endTime, double ticketPrice, String eventImage, Hall hall) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.eventType = eventType;
		this.eventDescription = eventDescription;
		this.eventDate = eventDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.ticketPrice = ticketPrice;
		this.eventImage = eventImage;
		this.hall = hall;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public LocalDate getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public String getEventImage() {
		return eventImage;
	}

	public void setEventImage(String eventImage) {
		this.eventImage = eventImage;
	}

	public Hall getHall() {
		return hall;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}

	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", eventName=" + eventName + ", eventType=" + eventType
				+ ", eventDescription=" + eventDescription + ", eventDate=" + eventDate + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", ticketPrice=" + ticketPrice + ", eventImage=" + eventImage + "]";
	}
	

}
