package com.techelevator.farm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.techelevator.store.Sellable;

public class OldMacdonald {
	
	public static void main(String[] args) {

		
		//FarmAnimal[] farmAnimals = new FarmAnimal[] { new Cow(), new Chicken(), new Dog(), new Dog("bark!",true), new Shark(),new Tractor() };
		Cow c = new Cow();
		c.goToSleep();
		Cat cat = new Cat();
		cat.goToSleep();
		Singable[] farmItems = new Singable[] {c, new Chicken(), new Dog(), new Dog("bark!",true), new Shark(), new Tractor(),new Cat()}; 
		( (FarmAnimal)farmItems[4]).goToSleep(); // a little riskey and brittle
		
		// to prevent this, since it doesn't make sense, we're going to make FarmAnimal abstract
		//FarmAnimal fa = new FarmAnimal("generic","meh");
		
		//some of the farm animals are sellable but not all of them
		//sell my chicken and cow, but i don't want to sell my dog. i don't want to sell my tractor
		//ISellable something = new ISellable(); CANNOT INSTANTIATE AN INTERFACE
		
		//List is the interface, ArrayList is a class that implements that interface
		List<Sellable> myList = new ArrayList<Sellable>();
		myList.add(new Cow());
		myList.add(new Chicken());
		
		//myList.add(new Dog()); I CANNOT add a dog to the list of ISellable because a DOG IS NOT an ISellable
		
		//when i have my datatype something generic, i can only do the generic things
		Sellable chicken = new Chicken();
		((Chicken) chicken).layEgg();
		((FarmAnimal) chicken).getName();
		((Singable) chicken).getName();
		
		Sellable cow = new Cow();
		//((Chicken) cow).layEgg(); Run time error
		
		
		//List<FarmAnimal> farmAnimals2 = new ArrayList<FarmAnimal>();
		
		/*
		FarmAnimal[] farmAnimals = new FarmAnimal[3];
		Cow c = new Cow();
		Cow c2 = new Cow();
		Chicken chicken1 = new Chicken();
		farmAnimals[0] = c;
		farmAnimals[1] = c2;
		farmAnimals[2] = chicken1;
		*/
					
		
		for(Singable item : farmItems) {
			String name = item.getName();
			String sound = item.getSound();
			
			/* instance of is not polymorphic code
			 * if the dog's tail is wagging it makes sound happy. don't do it here. override getSound in dog instead
			if ( animal instanceof Dog) {
				if (((Dog) animal).isTailWagging()) {			
					sound = "happy";
				}
			}
			*/
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a "+name+", ee, ay, ee, ay, oh!");
			System.out.println("With a "+sound+" "+sound+" here");
			System.out.println("And a "+sound+" "+sound+" there");
			System.out.println("Here a "+sound+" there a "+sound+" everywhere a "+sound+" "+sound);
			System.out.println();
		}
		
		
		//For the homework
		Random rand = new Random();
		
		//generate and print 5 random ints
		for (int i=0; i<5; i++) {
			int randomInt = rand.nextInt();
			System.out.println(randomInt);
		}
		
		//generate and print 5 random double
		for (int i=0; i<5; i++) {
			double randomInt = rand.nextDouble();
			System.out.println(randomInt);
		}
		
		//format nicely a list of ISellable items
		// class name 10 spaces price
		System.out.printf("%-50s %s\n", "Item Class", "Item Price" );
		for (Sellable item : myList) {
		
			System.out.printf("%-50s %.2f\n", item.getClass(),item.getPrice() );
		}
		
		/* Abstract classes can still have implemented methods. Interfaces can have no implemented methods.
          *A class can only inherit from one other class, but can implement as many interfaces as you want it to.
          *Inheriting from a super class is kind of like making a more specialized version of that class. 
              Inheriting just means that you can be used in the context the interface is for. 
              There is a difference in being a kind of Book versus being Sellable or Readable
         */
		
	}
}