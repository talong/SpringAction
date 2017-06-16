package com.spring_action.book.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmailController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String email() {
		return "email";
	}
}
