package com.spring_action.book.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.spring_action.book.Exceptions.EmailNotFoundException;
import com.spring_action.book.data.EmailRepository;
import com.spring_action.book.domain.Email;
import com.spring_action.book.model.MyError;

@Controller
@RequestMapping("/spittles")
public class EmailRestfulController {

	private static final String MAX_LONG_AS_STRING 
	     = "9223372036854775807";
	private EmailRepository emailRepository;
	
	@Autowired
	public EmailRestfulController(EmailRepository emailRepository) {
		this.emailRepository = emailRepository;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Email> emailes(
			@RequestParam(value="max",
			  defaultValue=MAX_LONG_AS_STRING) long max,
			  @RequestParam(value="count",
			  defaultValue="20") int count) {
		return emailRepository.findEmailes(max, count);
	}
	
	/**
	 * @ResponseBody注解会告知Spring,我们要将返回的对象作为资源
	 * 发送给客户端，并将其装还为客户端可接受的表述形式。更具体地将，DispatcherServlet
	 * 将会考虑到请求中的Accept头部信息，并查找能够为客户端提供所需表述形式
	 * 的消息转换器
	 * @param max
	 * @param count
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET,
			 produces="application/json")
	public @ResponseBody List<Email> emailesREST(
			@RequestParam(value="max",
			  defaultValue=MAX_LONG_AS_STRING) long max,
			  @RequestParam(value="count",
			  defaultValue="20") int count) {
		return emailRepository.findEmailes(max, count);
	}
	
	/**
	 * @RequestBody会根据Content-Type头部信息，例如"application/json",
	 * DispatcherServlet就会查找能够将JSON转换为Java的消息转化器。
	 * @param email
	 * @return
	 */
	@RequestMapping(
			method=RequestMethod.POST,
			consumes="application/json")
	public @ResponseBody 
	    Email saveEmail(@RequestBody Email email) {
		return emailRepository.save(email);
	}
	
	
   /*更改为其下面的写法
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody Email emailById(@PathVariable long id) {
		return emailRepository.findOne(id);
	}
	*/
	
	/**
	 * ResponseEntity允许我们制定响应的状态码
	 * ResponseEntity包含了@ResponseBody的语义
	 * @param id
	 * @return 
	 * @return
	/*@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Email> emailById(@PathVariable long id) {
		Email email = emailRepository.findOne(id);
		HttpStatus status = email != null ?
				HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<Email>(email, status);
	}
	更进一步，改写为下面的方法*/
	
	
/*	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> emailById(@PathVariable long id) {
		Email email = emailRepository.findOne(id);
		if (email == null) {
			MyError error = new MyError(4, "Email[" + id + "] not found");
			return new ResponseEntity<MyError>(error, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Email>(email, HttpStatus.OK);
	}
	使用错误处理器来进一步提炼重构为以下两个方法*/
	
	
	@ExceptionHandler(EmailNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody MyError emailNotFound(
			EmailNotFoundException e) {
		long emailId = e.getEmailId();
		return new MyError(4, "Email[" + emailId + "] not found");
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody Email emailById(@PathVariable long id) {
		Email email = emailRepository.findOne(id);
		if (email == null) {
          throw new EmailNotFoundException(id);
		}
		return email;
	}
	
}
