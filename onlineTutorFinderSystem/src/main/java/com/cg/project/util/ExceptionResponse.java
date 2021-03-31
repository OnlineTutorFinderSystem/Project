package com.cg.project.util;

import java.util.Date;

/**
 * @author NITIN
 *
 */
public class ExceptionResponse {

	private Date timestamp;

	private String message;

	private String details;

	private String httpCodeMessage;

	public ExceptionResponse(Date timestamp, String message, String details, String httpCodeMessage) {
		super();

		this.timestamp = timestamp;

		this.message = message;

		this.details = details;

		this.httpCodeMessage = httpCodeMessage;

	}

	public String getHttpCodeMessage() {

		return httpCodeMessage;

	}

	public Date getTimestamp() {

		return timestamp;

	}

	public String getMensaje() {

		return message;

	}

	public String getDetalles() {

		return details;

	}

}
