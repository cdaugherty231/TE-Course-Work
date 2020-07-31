package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.techelevator.model.Pet;
import com.techelevator.model.User;

@Service
public class PetsMockDAO implements PetsDAO {

	@Override
	public List<Pet> getPetsForUser(User u) {
		List<Pet> result = new ArrayList<>();
		
		if (u.getId() == 1) {
			result.add(new Pet("Max", "fish"));
			result.add(new Pet("Erma", "fish"));
		} else if (u.getId() == 2) {
			result.add(new Pet("Spot", "dog"));
		} else if (u.getId() == 3) {
			result.add(new Pet("Poppy", "cat"));
			result.add(new Pet("Lady Stardust", "cat"));
			result.add(new Pet("Oat", "cat"));

		} else {
			result.add(new Pet("George", "chicken"));
			result.add(new Pet("Fido", "dog"));
		}
		
		
		
		return result;
	}

}
