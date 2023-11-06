package task9;

import static java.lang.System.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.*;

public class Main {
	public static void main(String[] args) {
		String txtfile = "data/data.txt";
		try {
		GameApp app = new GameApp(txtfile);
		app.game();
		} catch(IOException ioe) {
		out.printf("Perhaps missing text file: %s/%s? \n\n",
		new Main().getClass().getPackage().getName(), txtfile);
		}
	}//End of main method
	
	public static class GameApp {
		private List<Country> countryList;
		
		public GameApp(String filename) throws IOException {
			countryList = new LinkedList<>();
			readData(filename);
		}
		
		public void readData(String filename) throws IOException {
			Path path = new File(filename).toPath();
			List<String> content = Files.readAllLines(path);
			//Iterates through the data.txt file and converts its contents to an arraylist
			for (String line : content) {
				String[] items = line.split(",");
				String name = items[0];
				String cap = items[1];
				int pop = Integer.valueOf(items[2]);
				Country country = new Country(name, cap, pop);
				countryList.add(country);
			}
		}
		public void game() {
			try (Scanner input = new Scanner(in)) {
				boolean play = true;
				//While loop for allowing the user to play multiple games
				while(play) {
					int count = 0;
					int num = ThreadLocalRandom.current().nextInt(0, 6);
					//While loop allowing for 3 guesses
					while (count < 3) {
						Country country = countryList.get(num);
						out.println("What's the capital of " + country.getName() + "?");
						String answer = input.nextLine();
						if (answer.equalsIgnoreCase(country.getCapital())) {
							out.println("Well done!");
							out.println(country.getCapital() + " is a country with a population of " + country.getPopulation() + " million.");
							count = 3;
						} else {
							count++;
							if (count < 3) {
								out.println("Incorrect. You have made " + count + " out of 3 attempts.");
							} else {
								out.println("Incorrect. It’s " + country.getCapital() + ".");
							}
						}
					}
					
					out.println("Would you like to play again? (Y/N)");
					boolean l = true;
					//While loop for validating the users input of Y/N
					while (l) {
						String continueGame = input.nextLine();
						if (continueGame.equalsIgnoreCase("Y")) {
							out.println("Stating new game...");
							l = false;
						} else if (continueGame.equalsIgnoreCase("N")) {
							out.println("Thanks for playing!");
							l = false;
							play = false;
						} else {
							out.println("Please enter Y if you would like to play again or N if you would like to stop playing.");
						}
					}				
				}
			}
		}
	}//End of class GameApp
	
	public static class Country {
		private String name;
		private String capital;
		private int population;
		
		public Country (String name, String capital, int population) {
			this.name = name;
			this.capital = capital;
			this.population = population;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public String getCapital() {
			return capital;
		}
		
		public void setCapital(String capital) {
			this.capital = capital;
		}
		
		public int getPopulation() {
			return population;
		}
		
		public void setPopulation(int population) {
			this.population = population;
		}
		
	}//End of class Country
}//End of class Main

