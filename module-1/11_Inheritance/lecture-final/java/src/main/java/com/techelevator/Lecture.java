package com.techelevator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Lecture {

	public static void main(String[] args) {
		Auction a = new Auction("pen");
		
		List<Bid> allBids = a.getAllBids(); //encapsulation, we got a COPY of the list of bids, not the actual list
		
		/* example of how allBids is a copy and modifying doesn't modify the list in the aucton
		allBids.add(new Bid("katie",1)); 
		for (Bid b : allBids)
		{
		    System.out.println(b.getBidder() + " $"+b.getBidAmount());
		}
		allBids = a.getAllBids();
		System.out.println("AUCTION BIDS");
		for (Bid b : allBids)
		{
		    System.out.println(b.getBidder() + " $"+b.getBidAmount());
		}
		*/
		a.placeBid(new Bid("katie",1));
		System.out.println("Highest Bid: "+a.getHighBid());
		a.placeBid(new Bid("andie",5));
		a.placeBid(new Bid("abel",6));
		a.placeBid(new Bid("tien",10));
		a.placeBid(new Bid("jacob",100));
		a.placeBid(new Bid("conner",2));
		
		System.out.println("Highest Bid: "+a.getHighBid());
		
		ReserveAuction ra = new ReserveAuction(20);
		System.out.println(ra.getItemForSale()); //look in reserve auction FIRST, then start looking in parent, then grandparent, etc

		//ra.isOver compile error - not visible
		ra.placeBid(new Bid("Katie",10)); //we want ra to throw this bid away since the reserve is 20
		ra.placeBid(new Bid("andie",5));
		ra.placeBid(new Bid("abel",68));
		ra.placeBid(new Bid("tien",10));
		ra.placeBid(new Bid("jacob",100));
		ra.placeBid(new Bid("conner",20));
		
		ra.methodOnlyInReserve();
		
		System.out.println("All the bids for the reserve auction");
		List<Bid> bids = ra.getAllBids();
		for (Bid b : bids) {
			System.out.println(b);
		}
		System.out.println("High Bid for the reserve auction");
		System.out.println(ra.getHighBid());
		
		/* Overloading - two or more methods in the same class have the same name but different parameters. Compiler 
		 * looks at the parameter list to decide which one to call
		 * 
		 * Overriding - same name and same parameter list in a child class and a parent class. Compiler looks at what class
		 * an object is to decide which one to call
		 */
		
		BuyoutAuction ba = new BuyoutAuction("coffee",154);
		System.out.println(ba.getItemForSale()); //look in buyout auction FIRST, then start looking in parent, then grandparent, etc

		ba.placeBid(new Bid("Katie",10));
		ba.placeBid(new Bid("andie",190));
		ba.placeBid(new Bid("abel",50000));
		
		System.out.println("All the bids for the buyout auction");
		List<Bid> babids = ba.getAllBids();
		for (Bid b : babids) {
			System.out.println(b);
		}
		System.out.println("High Bid for the buyout auction");
		System.out.println(ba.getHighBid());
		
		//POLYMORPHISM
		List<Auction> allTheAuctions = new ArrayList<Auction>();
		allTheAuctions.add(a);
		allTheAuctions.add(ba);
		allTheAuctions.add(ra);
		
		//rory wants to bid 50 in all the auctions
		for (Auction loopAuction : allTheAuctions) {
			loopAuction.placeBid(new Bid("Rory",50));
			//loopAuction.methodOnlyInReserve();
			
		}
		
		
		/* BIG DECIMAL EXAMPLE */
		BigDecimal cost = new BigDecimal("1.50"); //constructor is OVERLOADED to take pretty much whatever 
		//as the parameter as long as it can get back to a nubmer
		BigDecimal b = BigDecimal.valueOf(1.50);
		
		//i want to multiply cost by 3
		BigDecimal newCost = cost.multiply(new BigDecimal(3)); //NOT MODIFYING COST
		
		//-1, 0, or 1 as this BigDecimal is numericallyless than, equal to, or greater than val.
		 cost.compareTo(newCost);
				
	}

}
