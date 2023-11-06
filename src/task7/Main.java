package task7;

import static java.lang.System.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		List<Shape> shapes = new LinkedList<>();
		shapes.add(new Shape("white"));
		shapes.add(new Rectangle("red", 10, 6));
		shapes.add(new Rectangle("black", 20, 9));
		shapes.add(new Shape("orange"));
		showShapeNames(shapes);//produces output part 1
		Rectangle[] rectangleArray1 = {
			new Rectangle("white", 4, 3),
			new Rectangle("red", 9, 5),
			new Rectangle("purple", 3, 6),
			new Rectangle("orange", 15, 10),
			new Rectangle("black", 4, 14),
		};
		Rectangle[] rectangleArray2 = {
			new Rectangle("pink", 3, 4),
			new Rectangle("red", 10, 2),
			new Rectangle("white", 8, 5),
			new Rectangle("blue", 14, 4),
			new Rectangle("bindle", 10, 15),
		};
		
		//produces output part 2
		countOverlapRectangles(rectangleArray1, rectangleArray2);
	}//end of main() method
	
	public static void showShapeNames(List<Shape> shapes){
	//Iterates through the elements of shape and outputs their shap type
		for (Shape i : shapes) {
			out.println(i.getShapeType());
		}
	}
	
	public static void countOverlapRectangles(Rectangle[] group1, Rectangle[]
	group2){
		//Iterates through each rectangle in group 1 and then group 2 to output any overlapping colours or perimetres between them
		int count1 = 0;
		int count2 = 0;
		for (Rectangle i : group1) {
			for (Rectangle j : group2) {
				if (i.getColour() == j.getColour()) {
					count1++;
				}
				if (i.getPerimetre() == j.getPerimetre()) {
					count2++;
				}
			}
		}
		out.println("There are " + count1 + " Rectangle objects with overlapping colour between the two arrays");
		out.println("There are " + count2 + " Rectangle objects with overlapping perimetre between the two arrays");
	}
	
	public static class Shape {
		private String colour; //Shape colour

		public Shape (String colour) {
			this.colour = colour;
		}		

		public String getColour() {
			return colour;
		}
		
		public void setColour(String colour) {
			this.colour = colour;
		}
		
		public String getShapeType() {
			String message = "I'm a Shape";
			return message;
		}
	}
	
	public static class Rectangle extends Shape {
		private double height; //Rectangle height
		private double width; //Rectangle width (used for perimetre)
			
		public double getHeight() {
			return height;
		}
		
		public void setHeight(double height) {
			this.height = height;
		}

		public double getWidth() {
			return width;
		}
		
		public void setWidth(double width) {
			this.width = width;
		}
		
		public Rectangle (String colour, double height, double width) {
			super(colour);
			this.height = height;
			this.width = width;
		}
		
		@Override public String getShapeType() {
			String message = "I'm a Rectangle";
			return message;	
		}
		
		public double getPerimetre() {
			double perimetre = (height + width) * 2; //Formula for the perimetre
			return perimetre;
		}
	}
}//end of Main class
