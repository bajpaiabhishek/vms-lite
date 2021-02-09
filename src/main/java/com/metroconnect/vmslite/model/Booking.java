package com.metroconnect.vmslite.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.metroconnect.vmslite.utils.BookingStatus;

@Entity
@Table
public class Booking {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String source;

	@Column
	private String destination;

	@Column
	private Date transitDate;

	@Column
	private Date deliveryDate;

	@Column
	private String customerEmail;

	@Column
	private long vehicleNumber;

	@Column
	private int cost;

	@Column
	private int weight;

	@Column
	private BookingStatus bookingStatus;
	
	public Booking() {
		super();
	}

	public Booking(long id, String source, String destination, Date transitDate, Date deliveryDate,
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

	@Override
	public String toString() {
		return "Booking [id=" + id + ", source=" + source + ", destination=" + destination + ", transitDate="
				+ transitDate + ", deliveryDate=" + deliveryDate + ", customerEmail=" + customerEmail
				+ ", vehicleNumber=" + vehicleNumber + ", cost=" + cost + ", weight=" + weight + ", bookingStatus="
				+ bookingStatus + "]";
	}
}
