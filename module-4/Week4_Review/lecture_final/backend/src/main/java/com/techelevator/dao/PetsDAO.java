package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Pet;
import com.techelevator.model.User;

public interface PetsDAO {
	public List<Pet> getPetsForUser(User u);
}
