package com.spring_action.book.Exceptions;

public class EmailNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 7519326656060749551L;

	private long emailId;
	
	public EmailNotFoundException(long emailId) {
		this.emailId = emailId;
	}
	
	public long getEmailId() {
		return emailId;
	}
}
