package com.spring_action.book.data;

import java.util.List;

import com.spring_action.book.domain.Email;

public interface EmailRepository {

	List<Email> findEmailes(long max, int count);
}
