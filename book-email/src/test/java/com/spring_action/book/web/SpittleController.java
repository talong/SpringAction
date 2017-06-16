package com.spring_action.book.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring_action.book.data.EmailRepository;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

	private EmailRepository emailRepository;
	@Autowired
	public SpittleController(EmailRepository emailRepository) {
		this.emailRepository = emailRepository;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String spittles(Model model) {
		model.addAllAttributes(emailRepository.findEmailes(Long.MAX_VALUE, 20));
		return "spittles";
	}
	
}
