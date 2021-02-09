package com.metroconnect.vmslite.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Vehicle {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long vehicleNumber;

	@NotBlank
	@Column
	private String sourceMetro;
	
	@NotNull
	private Date availability;

	public Vehicle() {
		super();
	}

	public Vehicle(long vehicleNumber, @NotBlank String sourceMetro, @NotNull Date availability) {
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
		return "Vehicle [vehicleNumber=" + vehicleNumber + ", sourceMetro=" + sourceMetro + ", availability="
				+ availability + "]";
	}
}
