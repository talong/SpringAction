package com.spring_action.book.db;

import java.util.List;

import com.spring_action.book.domain.Email;

public interface HibernateRepository {

	long count();
	Email save(Email email);
	Email findOne(long id);
	List<Email> findAll();
}
