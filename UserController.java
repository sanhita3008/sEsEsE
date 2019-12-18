package com.cognizant.stockmarket.controller;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cognizant.stockmarket.entity.Company;
import com.cognizant.stockmarket.entity.User;
import com.cognizant.stockmarket.service.AppUserDetailService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private AppUserDetailService appUserService;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@PostMapping()
	public User signUp(@RequestBody User user) {

		try {
			appUserService.signUp(user);
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Request");
		}
		return user;

	}

	@PutMapping()
	public User updateProfile(@RequestBody User user) {

		try {
			return appUserService.updateProfile(user);
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Request");
		}

	}

	@GetMapping(value = "/confirm/{id}/{pass}")
	public User confirmUser(@PathVariable long id, @PathVariable String pass) {
		try {
			return appUserService.confirmUser(id, pass);
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Request");
		}
	}

	@GetMapping(value = "/{id}")
	public User getUser(@PathVariable long id) {
		try {
			return appUserService.getUser(id);
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Request");
		}
	}

	@PutMapping(value = "/password")
	public User updateUserPassword(@RequestBody User user) {

		try {
			appUserService.updateUserPassword(user);
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Request");
		}
		return user;

	}

	public List<User> getAUser() {
		return Collections.EMPTY_LIST;
	}

}
