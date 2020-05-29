package com.techelevator.examples;

import java.util.Random;

public class ShowExamples {
	
	private int intVar;
	private boolean isClassFun; 
	
	public static void main(String [] args) {
		Random rand = new Random();
		int randomInt = rand.nextInt(); 
	}

	public int getIntVar() {
		return intVar;
	}

	public void setIntVar(int intVar) {
		this.intVar = intVar;
	}

	/**
	 * @return the isClassFun
	 */
	public boolean isClassFun() {
		return isClassFun;
	}

	/**
	 * @param isClassFun the isClassFun to set
	 */
	public void setClassFun(boolean isClassFun) {
		this.isClassFun = isClassFun;
	}

}
