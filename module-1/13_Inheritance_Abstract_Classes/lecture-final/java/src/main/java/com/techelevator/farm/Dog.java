package com.techelevator.farm;

public class Dog extends FarmAnimal {
	
	private boolean isTailWagging;

	public Dog() {
		super("dog", "woof");
		isTailWagging = false;
		//name = "pup"; name is not visible here since it's PRIVATE in the parent/superclass FarmAnimal
	}
	
	public Dog(String dogNoise, boolean isTailWagging) {
		super("dog", dogNoise);
		this.isTailWagging = isTailWagging;
	}
	
	public boolean isTailWagging() {
		return isTailWagging;
	}
	
	public Cow makeDogACow() {
		return new Cow(); 
	}

	@Override
	public String getName() {
		return "pooch";		
	}

	@Override
	public String eat() {
		return "scorf";
	}
	
	

}
