package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AuctionTest {
	
	//what should i test?
	//placing a bid
	//what does gethighbid do if there aren't any bids
	//constructor sets all data correctly
	//add high bid first and then a bunch of lower
	//add high bid in middle
	//add high bid last
	//if dup high bid, first bidder wins
	
	
	private Auction a;
	
	@Before
	public void setup() {
		a = new Auction("my item");
	}
	
	@Test
	public void constructor_sets_all_data_correctly() {
		//arrange and act
		//Auction a = new Auction("my item"); we moved this to the setup
		
		//assert
		Assert.assertEquals("my item",a.getItemForSale());
	}
	

	@Test
	public void place_bid_tests() {
		
		//arrange
		Bid [] placeBids = new Bid [] { new Bid("Katie",1),new Bid("Abel",10)};

		//act
		for (Bid b : placeBids) {
			a.placeBid(b);
		}
		
		//assert
		Assert.assertArrayEquals(placeBids, a.getAllBids().toArray());
		
	}
	
	@Test
	public void get_high_bid_with_no_bids_has_bid_amount_zero_and_bidder_empty_string() {
		//a is a brand new auction becuase we called new in setup
		Bid highBid = a.getHighBid();
		Assert.assertEquals("", highBid.getBidder());
		Assert.assertEquals(0,highBid.getBidAmount());
	}

}
