package com.metroconnect.vmslite.dto;

import java.util.Date;

import com.metroconnect.vmslite.utils.BookingStatus;

public class BookingDto {
	
	private long id;
	
	private String source;
	
	private String destination;
	
	private Date transitDate;
	
	private Date deliveryDate;
	
	private String customerEmail;
	
	private long vehicleNumber;
	
	private int cost;
	
	private int weight;

	private BookingStatus bookingStatus;
	
	public BookingDto() {
		super();
	}
	
	public BookingDto(String source, String destination, Date transitDate, Date deliveryDate,
			String customerEmail, long vehicleNumber, int cost, int weight, BookingStatus bookingStatus) {
		super();
		this.source = source;
		this.destination = destination;
		this.transitDate = transitDate;
		this.deliveryDate = deliveryDate;
		this.customerEmail = customerEmail;
		this.vehicleNumber = vehicleNumber;
		this.cost = cost;
		this.weight = weight;
		this.bookingStatus = bookingStatus;
	}


	

	public BookingDto(long id, String source, String destination, Date transitDate, Date deliveryDate,
			String customerEmail, long vehicleNumber, int cost, int weight, BookingStatus bookingStatus) {
		super();
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.transitDate = transitDate;
		this.deliveryDate = deliveryDate;
		this.customerEmail = customerEmail;
		this.vehicleNumber = vehicleNumber;
		this.cost = cost;
		this.weight = weight;
		this.bookingStatus = bookingStatus;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getTransitDate() {
		return transitDate;
	}

	public void setTransitDate(Date transitDate) {
		this.transitDate = transitDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public long getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(long vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
}
