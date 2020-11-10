package com.killvung.githubactionsspringboot.controller;

import com.killvung.githubactionsspringboot.dto.model.greeting.GreetingDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public GreetingDto greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new GreetingDto()
				.setId(counter.incrementAndGet())
				.setName(String.format(template, name));
	}
}
