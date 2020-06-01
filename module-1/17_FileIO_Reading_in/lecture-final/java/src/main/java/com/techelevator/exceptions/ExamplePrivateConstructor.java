package com.techelevator.exceptions;

public class ExamplePrivateConstructor {
	private ExamplePrivateConstructor() {} //DONT DO THIS
	
	public void someMethod() {
		ExamplePrivateConstructor exp = new ExamplePrivateConstructor();
	}

}
