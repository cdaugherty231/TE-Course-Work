package main;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeralConverter {

	private Map<Integer,String> map= new HashMap<Integer,String>();
	
	public RomanNumeralConverter() {
		map.put(new Integer (4), "IV");
		map.put(new Integer(5), "V");
		map.put(new Integer(9), "IX");
		map.put(new Integer(10), "X");
	}
	
	//string ConvertToRomanNumeral(int n)

	public String ConvertToRomanNumeral(int i) {
		String result = "";
		
		while(i>=100) {
			result += "C";
			i -= 100;
		}
		if (i>=90) {
			result += "XC"; 
			i -= 90;
		}
		
		while (i>=50) {
			result += "L";
			i -= 50;
		}
		if (i>=40) {
			result += "XL";
			i-=40;
		}
		
	   while (i>=10) {
			result += "X";
			i -= 10; 	
		}
		
		result = handleOnesPlace(i, result);

			
		//Sarah suggested handling the ones place first, and then the tens place, etc
		return result;
	}

	/**
	 * @param i
	 * @param result
	 * @return
	 */
	private String handleOnesPlace(int i, String result) {
		if (i>=5 && i<9) {
			result += "V";
			i = i-5; 
		}
		
		if (i>0 && i<=3) {
			for (int j=1; j <= i ; j++) {
				result += "I";
			}
		}else if (i==4) {
			result += "IV";
		} else if (i==9) {
			result += "IX";
		}
		return result;
	}
	
	
}
