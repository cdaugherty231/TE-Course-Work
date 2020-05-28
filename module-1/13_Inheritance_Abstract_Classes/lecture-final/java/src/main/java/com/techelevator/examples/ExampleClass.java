package com.techelevator.examples;

import java.util.ArrayList;
import java.util.List;

import com.techelevator.farm.Singable;

public class ExampleClass implements ExampleInterface, Singable {

	@Override
	public void methodName(String a, int num) {
	   //Do something
		List<Double> listOfDoubles = new ArrayList<Double>();
		
	}

	@Override
	public String getName() {
		return "example";
	}

	@Override
	public String getSound() {
		return "IDK!";
	}

}
