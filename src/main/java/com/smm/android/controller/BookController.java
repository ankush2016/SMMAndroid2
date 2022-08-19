package com.smm.android.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smm.android.enitites.User;

@RestController
public class BookController {

	@GetMapping("/books")
	public User getBooks() {
		User user = new User();
		user.setId(1);
		user.setName("Ankush Kapoor");
		user.setCity("Lucknow");
		//user.setStatus("Android Developer");
		return user;
	}
}
