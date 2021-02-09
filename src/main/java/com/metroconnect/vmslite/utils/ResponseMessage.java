package com.metroconnect.vmslite.utils;

import org.springframework.http.HttpStatus;

public class ResponseMessage {

	private HttpStatus status;
	private String message;
	private Object payload;

	public ResponseMessage() {
		super();
	}

	public ResponseMessage(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public ResponseMessage(HttpStatus status, String message, Object payload) {
		super();
		this.status = status;
		this.message = message;
		this.payload = payload;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getPayload() {
		return payload;
	}

	public void setPayload(Object payload) {
		this.payload = payload;
	}
}
