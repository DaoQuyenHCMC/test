package com.laptrinh.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.laptrinh.dto.User;
import com.laptrinh.service.IUserService;

public class AdminAPI {
	@Autowired
	private IUserService userService;
	


	@PostMapping("/api/user")
	public User createNew(@RequestBody User user) {
		return userService.save(user);
	}

	@PutMapping("/api/user")
	public User updateNew(@RequestBody User updateNew) {
		return userService.save(updateNew);
	}

	@DeleteMapping("/api/user")
	public void deleteNew(@RequestBody long[] ids) {
		userService.delete(ids);
	}
}
