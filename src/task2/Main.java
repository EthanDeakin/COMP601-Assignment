package task2;

import static java.lang.System.*;
import java.util.*;
import java.text.DecimalFormat;

public class Main {
	
	public static void main (String[] args) {
		task2();
	}
	
	static Scanner input = new Scanner(in);
	static DecimalFormat df = new DecimalFormat("0.00");
	static DecimalFormat df2 = new DecimalFormat("0");

	public static void task2() {
		//Read users input for circle radius
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
		out.print("Enter circle radius:\n");
		double radius  = Double.parseDouble(input.nextLine());
		String fmt1 = "";
		double area = radius * radius * Math.PI;
		double diametre = radius * 2;
		double perimetre = diametre * Math.PI;
		//Unique formating for larger numbers
		if (radius >= 10000000) {
			String s = "" + df.format(radius) + df.format(perimetre) + df.format(area);
			int sLen = s.length();
			String n1 = df2.format((0.5*sLen)/1.5);
			String n2 = df2.format((0.625*sLen)/1.5);
			fmt1 = "%-"+n1+"s%-"+n2+"s%s\n";
			out.printf(fmt1, "Radius", "Perimetre", "Area");
			out.println("-".repeat(42+sLen));
		}
		else {
			fmt1 = "%-15s%-20s%s\n";
			out.printf(fmt1, "Radius", "Perimetre", "Area");
			out.println("-".repeat(40));
		}
		out.printf(fmt1, df.format(radius), df.format(perimetre), df.format(area));
	}
}
