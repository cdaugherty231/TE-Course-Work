package com.techelevator.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.PetsDAO;
import com.techelevator.dao.UserDAO;
import com.techelevator.model.Pet;
import com.techelevator.model.User;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class PetsController {
	
	private UserDAO userDao;
	private PetsDAO petsDao;
	
	public PetsController(UserDAO userDao, PetsDAO petsDao) {
		this.userDao = userDao;
		this.petsDao = petsDao;
	}
	
	@GetMapping("/pets")
	public List<Pet> getAllPets(Principal principal) {	
		User currentUser = userDao.findByUsername(principal.getName());
		return petsDao.getPetsForUser(currentUser);
	}

}
