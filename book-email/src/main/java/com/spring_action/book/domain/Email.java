package com.spring_action.book.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Email {

	private final Long id;
	private final String message;
	private final Date time;
	
	public Email(String message, Date time) {
		this.id = null;
		this.message = message;
		this.time = time;
	}

	public Long getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public Date getTime() {
		return time;
	}
	
	@Override
	public boolean equals(Object that) {
		return EqualsBuilder.reflectionEquals(this, that, "id", "time");
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, "id", "time");
	}
}
