package com.javainuse.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
public class HelloWorldController {

	@RequestMapping({ "/" })
	public String firstPage() {
		return "hello authenticated user";
	}
	@RequestMapping({ "/shay" })
	public String shayPage() {
		return "hello authenticated shay user";
	}
}