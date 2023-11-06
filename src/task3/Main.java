package task3;

import static java.lang.System.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
	public static void main (String[] args) {
		task3();
	}
	
	static Scanner input = new Scanner(in);
	static DecimalFormat df = new DecimalFormat("0.00");
	
	public static void task3() {
		//Read users input for their score
		int l = 1;
		while (l == 1) {
			try {
				getInput();
				l = 0;
			}
			catch (Exception err) {
				out.println("Please input a number.");
			}
		}
	}
	
	public static void getInput() {
		boolean check = true; 
		while (check) {
			//Request user input (score)
			out.print("Enter a score:\n");
			double score  = Double.parseDouble(input.nextLine());
			if (score < 0 || score > 100) {
				//Outputs something so the user knows they have entered something irrelevant to the console
				out.println("Invalid score.");
			}
			else {
				//Scores printed to console
				if (score < 50) {
					out.println("Score " + df.format(score) + " will receive grade D.");
				}
				else if (score >= 50 && score < 70) {
					out.println("Score " + df.format(score) + " will receive grade C.");
				}
				else if (score >= 70 && score < 80) {
					out.println("Score " + df.format(score) + " will receive grade B.");
				}
				else {
					out.println("Score " + df.format(score) + " will receive grade A.");
				}					
				check = false;
			}
		}
	}
}