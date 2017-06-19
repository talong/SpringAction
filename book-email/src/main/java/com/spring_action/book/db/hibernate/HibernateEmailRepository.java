package com.spring_action.book.db.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring_action.book.db.HibernateRepository;
import com.spring_action.book.domain.Email;

@Repository
public class HibernateEmailRepository implements HibernateRepository {

	public SessionFactory sessionFactory;
	
	@Autowired   //由于需要引入额外的jar包，所以就用@Autowired替代了@Inject
	public HibernateEmailRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;		 
	}
	
	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public long count() {
		return findAll().size();
	}

	@Override
	public Email save(Email email) {
		Serializable id = currentSession().save(email);
		return new Email((Long) id,
				email.getMessage(),
				email.getTime());
	}

	@Override
	public Email findOne(long id) {
		return (Email) currentSession().get(Email.class, id);
	}

	@Override
	public List<Email> findAll() {
		return (List<Email>) currentSession()
				.createCriteria(Email.class).list();
	}
	
	public Email findByMessage(String message) {
		return (Email)currentSession()
				.createCriteria(Email.class)
				.add(Restrictions.eq("message", message))
				.list().get(0);
	}

}
