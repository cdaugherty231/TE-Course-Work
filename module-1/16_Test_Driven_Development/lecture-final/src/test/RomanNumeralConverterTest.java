package test;

import org.junit.Test;

import junit.framework.Assert;
import main.RomanNumeralConverter;

public class RomanNumeralConverterTest {
	
	private RomanNumeralConverter rnc = new RomanNumeralConverter();
	
		
	//let's try making sure that 1 returns I
	@SuppressWarnings("deprecation")
	@Test
	public void test_1_returns_I() {
		Assert.assertEquals("I", rnc.ConvertToRomanNumeral(1));
	}
	@Test
	public void test_2_returns_II() {
		Assert.assertEquals("II", rnc.ConvertToRomanNumeral(2));
	}

	@Test
	public void test_3_returns_III() {
		Assert.assertEquals("III", rnc.ConvertToRomanNumeral(3));
	}

	@Test
	public void test_4_returns_IV() {
		Assert.assertEquals("IV", rnc.ConvertToRomanNumeral(4));
	}

	
	@Test
	public void test_5_returns_V() {
		Assert.assertEquals("V", rnc.ConvertToRomanNumeral(5));
	}
	
	@Test
	public void test_6_Thru_8_returns_correct() {
		Assert.assertEquals("VI", rnc.ConvertToRomanNumeral(6));
		Assert.assertEquals("VII", rnc.ConvertToRomanNumeral(7));
		Assert.assertEquals("VIII", rnc.ConvertToRomanNumeral(8));
	}


	@Test
	public void test_9_returns_IX() {
		Assert.assertEquals("IX", rnc.ConvertToRomanNumeral(9));
	}
	
	@Test
	public void test_10_returns_X() {
		Assert.assertEquals("X", rnc.ConvertToRomanNumeral(10));
	}
	@Test
	public void test_11_returns_XI() {
		Assert.assertEquals("XI", rnc.ConvertToRomanNumeral(11));
	}
	@Test
	public void test_12_thru_19_returns_XI() {
		Assert.assertEquals("XII", rnc.ConvertToRomanNumeral(12));
		Assert.assertEquals("XIII", rnc.ConvertToRomanNumeral(13));
		Assert.assertEquals("XIV", rnc.ConvertToRomanNumeral(14));
		Assert.assertEquals("XV", rnc.ConvertToRomanNumeral(15));
		Assert.assertEquals("XVI", rnc.ConvertToRomanNumeral(16));
		Assert.assertEquals("XVII", rnc.ConvertToRomanNumeral(17));
		Assert.assertEquals("XVIII", rnc.ConvertToRomanNumeral(18));
		Assert.assertEquals("XIX", rnc.ConvertToRomanNumeral(19));

	}
	
	@Test
	public void test_20_returns_XX() {
		Assert.assertEquals("XX", rnc.ConvertToRomanNumeral(20));
	}
	
	@Test
	public void test_21_thru_39_returns_correct() {
		Assert.assertEquals("XXI", rnc.ConvertToRomanNumeral(21));
		Assert.assertEquals("XXIX", rnc.ConvertToRomanNumeral(29));
		Assert.assertEquals("XXXIII", rnc.ConvertToRomanNumeral(33));
		Assert.assertEquals("XXXIV", rnc.ConvertToRomanNumeral(34));
		Assert.assertEquals("XXXVII", rnc.ConvertToRomanNumeral(37));
		Assert.assertEquals("XXXIX", rnc.ConvertToRomanNumeral(39));
	}
	
	
	@Test
	public void test_40_returns_XL() {
		Assert.assertEquals("XL", rnc.ConvertToRomanNumeral(40));
	}
	
	@Test
	public void test_50_returns_L() {
		Assert.assertEquals("L", rnc.ConvertToRomanNumeral(50));
	}
	
	@Test
	public void test_51_thru_89_returns_correctly() {
		Assert.assertEquals("LI", rnc.ConvertToRomanNumeral(51));
		Assert.assertEquals("LIV", rnc.ConvertToRomanNumeral(54));
		Assert.assertEquals("LIX", rnc.ConvertToRomanNumeral(59));
		Assert.assertEquals("LXIII", rnc.ConvertToRomanNumeral(63));
		Assert.assertEquals("LXVIII", rnc.ConvertToRomanNumeral(68));
		Assert.assertEquals("LXXVII", rnc.ConvertToRomanNumeral(77));
		Assert.assertEquals("LXXX", rnc.ConvertToRomanNumeral(80));
		Assert.assertEquals("LXXXIX", rnc.ConvertToRomanNumeral(89));
	}
	@Test
	public void test_90_returns_XC() {
		Assert.assertEquals("XC", rnc.ConvertToRomanNumeral(90));
	}
}
