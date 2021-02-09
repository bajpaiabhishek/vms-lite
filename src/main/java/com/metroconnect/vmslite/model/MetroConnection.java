package com.metroconnect.vmslite.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class MetroConnection {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String sourceCity;
	
	@Column
	private String destinationCity;
	
	@Column
	private int cost;
	
	@Column
	private int travelDays;

	public MetroConnection() {
		super();
	}

	public MetroConnection(long id, String sourceCity, String destinationCity, int cost, int travelDays) {
		super();
		this.id = id;
		this.sourceCity = sourceCity;
		this.destinationCity = destinationCity;
		this.cost = cost;
		this.travelDays = travelDays;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSourceCity() {
		return sourceCity;
	}

	public void setSourceCity(String sourceCity) {
		this.sourceCity = sourceCity;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getTravelDays() {
		return travelDays;
	}

	public void setTravelDays(int travelDays) {
		this.travelDays = travelDays;
	}

	@Override
	public String toString() {
		return "MetroConnection [id=" + id + ", sourceCity=" + sourceCity + ", destinationCity=" + destinationCity
				+ ", cost=" + cost + ", travelDays=" + travelDays + "]";
	}
	
}
