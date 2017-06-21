package com.spring_action.book.db;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import com.spring_action.book.domain.Email;

public interface HibernateRepository {

	long count();
	
	@CachePut(value="emailCache", key="#result.id")
	Email save(Email email);
	
	@Cacheable(value="emailCache", unless=
			"#result.message.contains('NoCache')",
			condition="#id >= 10")//不缓存message中包含NoCache的结果,并且只缓存id>=10的结果
	Email findOne(long id);
	
	List<Email> findAll();
	
	@CacheEvict("emailCache")  //从缓存移除
	void remove(long emailId);
}
