package com.metroconnect.vmslite.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class UnboundSlots {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private Date startDate;

	@Column
	private Date endDate;

	@Column
	private long vehicleNumber;

	@Column
	private String sourceMetro;

	public UnboundSlots() {
		super();
	}

	public UnboundSlots(Date startDate, Date endDate, long vehicleNumber, String sourceMetro) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.vehicleNumber = vehicleNumber;
		this.sourceMetro = sourceMetro;
	}

	public UnboundSlots(long id, Date startDate, Date endDate, long vehicleNumber, String sourceMetro) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.vehicleNumber = vehicleNumber;
		this.sourceMetro = sourceMetro;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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

	@Override
	public String toString() {
		return "UnboundSlots [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", vehicleNumber="
				+ vehicleNumber + ", sourceMetro=" + sourceMetro + "]";
	}
	
	
}
