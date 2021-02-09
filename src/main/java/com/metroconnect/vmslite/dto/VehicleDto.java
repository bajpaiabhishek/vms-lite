package com.metroconnect.vmslite.dto;

import java.util.Date;

public class VehicleDto {
	
	private long vehicleNumber;

	private String sourceMetro;
	
	private Date availability;

	public VehicleDto() {
		super();
	}

	public VehicleDto(long vehicleNumber, String sourceMetro, Date availability) {
		super();
		this.vehicleNumber = vehicleNumber;
		this.sourceMetro = sourceMetro;
		this.availability = availability;
	}

	public long getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(long vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getSourceMetro() {
		return sourceMetro;
	}

	public void setSourceMetro(String sourceMetro) {
		this.sourceMetro = sourceMetro;
	}

	public Date getAvailability() {
		return availability;
	}

	public void setAvailability(Date availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "VehicleDto [vehicleNumber=" + vehicleNumber + ", sourceMetro=" + sourceMetro + ", availability="
				+ availability + "]";
	}

}
