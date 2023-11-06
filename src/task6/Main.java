package task6;

import static java.lang.System.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
	static DecimalFormat df = new DecimalFormat("0.0");
	
	public static void main(String[] args){
		List<LeafyGreen> veges = new LinkedList<>();
		veges.add(new LeafyGreen(10, 3.5, "Cabbage"));
		veges.add(new LeafyGreen(5, 2.94, "Lettuce"));
		veges.add(new LeafyGreen(20, 5.45, "Broccoli"));
		veges.add(new LeafyGreen(7, 1.94, "Lettuce"));
		veges.add(new LeafyGreen(15, 2.8, "Lettuce"));
		veges.add(new LeafyGreen(30, 2.5, "Cabbage"));
		veges.add(new LeafyGreen(28, 4.4, "Broccoli"));
		veges.add(new LeafyGreen(20, 5.5, "Cabbage"));
		veges.add(new LeafyGreen(16, 3.9, "Broccoli"));
		veges.add(new LeafyGreen(26, 4.8, "Broccoli"));
		calculateStats(veges);
	}//end of main
	
	public static void calculateStats(List<LeafyGreen> veges){
		double totalVegPrice = 0;
		double totalCabWeight = 0;
		double totalBroWeight = 0;
		double totalLetWeight = 0;		
		
		for (LeafyGreen i : veges) {
			//Calculates the price for the total vege costs
			totalVegPrice += i.getWeight()*i.getPrice();
			
			//If a leafygreen product is the same type, add their weight together
			if (i.getType() == "Cabbage") {
				totalCabWeight += i.getWeight();
			} else if (i.getType() == "Broccoli") {
				totalBroWeight += i.getWeight();
			} else {
				totalLetWeight += i.getWeight();
			}			
		}
		//Outputs the the total cost of each leafygreen and their individual weights for each produce (type) 
		out.println("Total vegetable cost: $" + df.format(totalVegPrice));
		out.println("Total Cabbage weight: " + df.format(totalCabWeight) + " kg");
		out.println("Total Broccoli weight: " + df.format(totalBroWeight) + " kg");
		out.println("Total Lettuce weight: " + df.format(totalLetWeight) + " kg");
		}
	
	public static class Vegetable {
		private double weight; //kg
		private double price; //$NZ per kg
		
		public Vegetable (double weight, double price) {
			this.weight = weight;
	        this.price = price;
		}		

		public double getWeight() {
			return weight;
		}
		
		public void setWeight(double weight) {
			this.weight = weight;
		}

		public double getPrice() {
			return price;
		}
		
		public void setPrice(double price) {
			this.price = price;
		}
	}
		
	public static class LeafyGreen extends Vegetable{
		private String type; //eg. Cabbage, Lettuce, Broccoli
		
		public LeafyGreen(double weight, double price, String type) {
	        super(weight, price);
			this.type = type;
		}		

		public String getType() {
			return type;
		}
		
		public void setType(String type) {
			this.type = type;
		}
	}
}
