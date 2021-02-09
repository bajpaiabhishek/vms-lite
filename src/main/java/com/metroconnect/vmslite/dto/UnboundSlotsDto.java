package com.metroconnect.vmslite.dto;

import java.util.Date;

public class UnboundSlotsDto {

	private long id;

	private Date startDate;

	private Date endDate;

	private long vehicleNumber;

	private String sourceMetro;

	public UnboundSlotsDto() {
		super();
	}

	public UnboundSlotsDto(Date startDate, Date endDate, long vehicleNumber, String sourceMetro) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.vehicleNumber = vehicleNumber;
		this.sourceMetro = sourceMetro;
	}

	public UnboundSlotsDto(long id, Date startDate, Date endDate, long vehicleNumber, String sourceMetro) {
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
		return "UnboundSlotsDto [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", vehicleNumber="
				+ vehicleNumber + ", sourceMetro=" + sourceMetro + "]";
	}

}
