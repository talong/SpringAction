package com.spring_action.book.config.test;

import org.springframework.stereotype.Component;

@Component
public class SgtPeppers implements CompactDisc {

	@Override
	public void play() {
		System.out.println("Playing");
	}

}
