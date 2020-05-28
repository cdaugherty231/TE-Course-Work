package com.techelevator.farm;

//added abstract keyword so no one can say = new FarmAnimal("","")
public abstract class FarmAnimal implements Singable {
	private String name;
	private String sound;
	private boolean isAsleep; 

	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
	}
	
	public String getName( ) {
		return name;
	}
	
	//adding final because i don't want subclasses to be allowed to override
	public final String getSound( ) {
		if (isAsleep) {
			return "zzzzzz";
		}
		return sound;
	}
	
	public boolean isAsleep() {
		return isAsleep;
	}
	
	//add methods goToSleep and wakeUp
	public void goToSleep() {
		isAsleep = true;
	}
	
	public void wakeUp() {
		isAsleep = false;
	}
	
	//force all of my subclasses to have an eat() method
	/*
	 *  Abstract methods are methods with no logic that must be implemented by concrete subclasses
		If a class has an abstract method, it must be an abstract class
		If a class does not override an abstract method from its parent, it must also be an abstract class
	*/
	 
	public abstract String eat(); 
}