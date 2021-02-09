package com.metroconnect.vmslite.dto;

public class MetroConnectionDto {

	private long id;

	private String sourceCity;

	private String destinationCity;

	private int cost;

	private int travelDays;

	public MetroConnectionDto() {
		super();
	}

	public MetroConnectionDto(long id, String sourceCity, String destinationCity, int cost, int travelDays) {
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
		return "MetroConnectionDto [id=" + id + ", sourceCity=" + sourceCity + ", destinationCity=" + destinationCity
				+ ", cost=" + cost + ", travelDays=" + travelDays + "]";
	}

}
