package com.techelevator.store;

import java.math.BigDecimal;

/*Define what something can do or how it can be used, but not how it does it.*/
public interface Sellable { //contract that you have a get price method
	BigDecimal getPrice();

}
