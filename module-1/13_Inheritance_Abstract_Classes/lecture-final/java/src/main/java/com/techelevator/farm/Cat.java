package com.techelevator.farm;

// TabbyCat extends Cat is no longer allowed since we have the final keyword on class
public final class Cat extends FarmAnimal {

	public Cat() {
		super("Cat", "meow");		
	}

	@Override
	public String eat() {
		return "mmm";
	}
	
	/* not allowed because Cat extends FarmAnimal and the getSound method has the final keyword in FarmAnimal
	@Override
	public String getSound() {
		return "MEOW!";
	}

   */
}
