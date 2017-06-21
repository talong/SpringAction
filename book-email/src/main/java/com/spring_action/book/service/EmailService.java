package com.spring_action.book.service;

import java.util.List;

import com.spring_action.book.domain.Email;

public interface EmailService {

	void saveEmail(Email email);
	Email getEmail(long id);
	List<Email> getEmailes(int count);
}
