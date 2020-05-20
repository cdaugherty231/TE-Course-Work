package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Lecture {

	public static void main(String[] args) {
		
		//StringBuilder - this really just makes strings mutable. use this if you are appending/updating a string many times
		StringBuilder sb = new StringBuilder();
		sb.append("abc");
		sb.append("defg");
		
		

		System.out.println("####################");
		System.out.println("       MAPS");
		System.out.println("####################");
		System.out.println();

		/* Map is an interface and HashMap is a class that implements Map */
		//key is an Integer, my value is a string
		Map<Integer,String> ssnToName = new HashMap<Integer,String>();
		
		//look up the list of quiz scores by class
		Map<String,List<Double>> quizScoresByClass = new HashMap<String,List<Double>>();
		
		List<Double> javaQuizScores = new ArrayList<Double>();
		javaQuizScores.add(100.0);
		javaQuizScores.add(85.5);
		
		quizScoresByClass.put("java",javaQuizScores);
		
		//check and see if .net is there yet
		boolean keyExists = quizScoresByClass.containsKey(".net");
		System.out.println("does .net exist in the map? "+keyExists);
		
		keyExists = quizScoresByClass.containsKey("java");
		System.out.println("does java exist in the map? "+keyExists);
		
		keyExists = quizScoresByClass.containsKey("JAVA");
		System.out.println("does JAVA exist in the map? "+keyExists);
		
		//get teh list of scores back and add 44.4 as another score
		quizScoresByClass.get("java").add(44.4);

		/* The "put" method is used to add elements to a Map */
		ssnToName.put(111111111, "Josh");
		ssnToName.put(121111111, "Cameron");
		ssnToName.put(112111111, "Greyson");
		ssnToName.put(111121111, "Rory");
		

		/* The "get" method is used to retrieve elements from a Map */
		String found = ssnToName.get(121111111);
		System.out.println("Key: 121111111 Found value: "+found);
		
		//if i put a key that already exists, then it overwrites the value
		ssnToName.put(121111111, "Abel");
		found = ssnToName.get(121111111);
		System.out.println("Key: 121111111 Found value: "+found);
		
		//search for a key that doesn't exist
		found = ssnToName.get(555555555);
		System.out.println("Key: 555555555 Found value: "+found);
	
		/* keySet returns a Set of all of the keys in the Map */
		//the type returned is what type the keys are whenyou created your map
		Set<Integer> allTheKeys = ssnToName.keySet();
		for(Integer key : allTheKeys) {
			System.out.println(key + " value: "+ ssnToName.get(key));
		}
		
		
		
		/* If the key already exists, put will overwrite the existing value with the new value */


		System.out.println("####################");
		System.out.println("       SETS");
		System.out.println("####################");
		System.out.println();
		
		//can't guarantee order, elements are unique
		Set<Integer> students = new HashSet<Integer>();
		System.out.println("Adding : "+students.add(11111111)); 
		System.out.println("Adding again: "+students.add(11111111)); 
		
		boolean contains = students.contains(11111111);
		System.out.println("Does students contain 1111111? "+contains);

		contains = students.contains(55555);
		System.out.println("Does students contain 55555? "+contains);

		
		System.out.println("####################");
		System.out.println("Sets cannot contain duplicates");
		System.out.println("####################");
		System.out.println();


		System.out.println("####################");
		System.out.println("Sets do not guarantee ordering");
		System.out.println("####################");
		System.out.println();
		
		//Big O notation - performance
		
		//let's look for something in a list
		//loop through the list until i find it
		List<Integer> myList = new ArrayList<Integer>();
		//add some stuff to myList
		
		for(int i=0;i<myList.size();i++)
		{
			//check if myList.get(i) matches what we're looking for
		}
		
		//worst case scenario - we don't find it or we find it last
		//PERFORMANCE - O(n)

		int[] ar = {1,2,3,5,99,7,8,4,5,6,7};
		int []ar2 = {1,2,3,4};
		int [] worstCase = {1,2,3,4,5,6,7,8,9,10,10};
		//does this array have duplicates?
		boolean hasDups = false;
		for (int i=0;i<ar.length;i++) {
			for (int j=0;j<ar.length;j++) {
				if (ar[i]==ar[j] && i!=j) {
					hasDups = true;
				}
			}			
		}
		//PERFORMANCE - O(n^2)
		
		//search for a key in map
		Map<Integer,String> myMap = new HashMap<Integer,String>();
		
		myMap.get(1);
		
		//the size doesn't matter - O(1)
		
		//does array have dups? O(n)
		boolean hasDupsWithSet = false;
		Set<Integer> mySet = new HashSet<Integer> ();
		for (Integer i : ar) {
			if (mySet.contains(i)) {
				hasDupsWithSet = true;		
				break;
			}
			else {
				mySet.add(i);
			}
		}
		
		Integer[] wrapper = Arrays.stream(ar).boxed().toArray(Integer[]::new);
		Set<Integer> set = new HashSet<Integer>(Arrays.asList(wrapper));
		boolean hasDupsFastest = set.size()!=ar.length; // if there were dups in the array, then the set size will be smaller
		//O(1)


	}

}
