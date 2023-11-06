package task8;

import static java.lang.System.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		//creates a list of Bag instances		
		List<Bag> bags = new LinkedList<>();
		bags.add(new Bag("white", 5.30));
		bags.add(new Bag("grey", 5.30));
		bags.add(new Bag("black", 2.30));
		BagApp bgapp = new BagApp();
		double totalCapacity = bgapp.calcTotalCapacity(bags);
		out.printf("Total capacity: %.2f\n", totalCapacity);
		out.printf("Total number of bags: %d\n", bags.size());
	}
	
	public static class BagApp {
		public double calcTotalCapacity(List<Bag> bagList) {
		//This calculates and returns the total capacity of all instances in “bagList”.
			if (bagList != null && bagList.size() > 0) {
				//Case
				Bag count = bagList.get(0);
				double capacity = count.getCapacity();
				//Call
				List<Bag> subList = bagList.subList(1, bagList.size());
		        return capacity + calcTotalCapacity(subList);
		        } else {
		        	return 0; //Base
			    }
			}
		}//End of class BagApp

	public static class Bag {
		private String colour;
		private double capacity;

		public Bag (String colour, double capacity) {
			this.colour = colour;
			this.capacity = capacity;
		}		

		public String getColour() {
			return colour;
		}
		
		public void setColour(String colour) {
			this.colour = colour;
		}
		
		public double getCapacity() {
			return capacity;
		}
		
		public void setCapacity(double capacity) {
			this.capacity = capacity;
		}
	}//End of class Bag
}//End of class Main