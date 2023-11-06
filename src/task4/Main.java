package task4;

import static java.lang.System.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main (String[] args) {
		task4();
	}
	
	static Scanner input = new Scanner(in);
	
	public static void task4() {
		//Read users input for circle radius
		int l = 1;
		while (l == 1) {
			try {
				getInput();
				l = 0;
			}
			//Error checking
			catch (Exception err) {
				out.println("Please input a list of colours.\nExample: 'red,blue,green,purple,black'.");
			}
		}
	}
	
	public static void getInput() {
		out.println("Enter first line of colours:");
		
		//Scans two user inputs and then converts those inputs to arrays.
		String coloursInput  = (input.nextLine());
		String[] colours1 = coloursInput.split(",");
		out.println("Enter second line of colours:");
		coloursInput = (input.nextLine());
		String[] colours2 = coloursInput.split(",");
		
		//Outputs the length of the two arrays
		out.println("You entered " + colours1.length + " colours in the first list.");
		out.println("You entered " + colours2.length + " colours in the second list.");
		
		ArrayList<String> listColours1 = new ArrayList<>(Arrays.asList(colours1));
		ArrayList<String> listColours2 = new ArrayList<>(Arrays.asList(colours2));
		ArrayList<String> innerjoinColours = new ArrayList<>();
		//Iterates through a list and adds new colours to the list if they share an element.
		for (String i : listColours1) {
			if (listColours2.contains(i)) {
				innerjoinColours.add(i);
			}
		}
		//Outputs the each overlapping colour to the console
		out.println("Number of overlapping colours: " + innerjoinColours.size());
		out.println("Overlapping colours are as follows: ");
		for (String i : innerjoinColours) {
			out.println(i);
		}
		
	}
}