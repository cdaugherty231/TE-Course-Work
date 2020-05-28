package com.techelevator.farm;

// so i can't create a new Pest, but I can create a class Coyote extends Pest then coyote would have to implement eat()
public abstract class Pest extends FarmAnimal {

	public Pest(String name, String sound) {
		super(name, sound);
		
	}

}
