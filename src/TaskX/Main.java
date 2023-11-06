package TaskX;

import static java.lang.System.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.*;

public class Main {
	public static void main(String[] args) {
		String txtfile = "data/data2.txt";
		try {
		AudioBookApp app = new AudioBookApp(txtfile);
		AudioBook shortest = app.getShortestBook();
		if (shortest != null) {
		out.println("Shortest book:");
		shortest.displayInfo();
		}
		out.printf("\nBooks published btw 2010-2020: %d\n", app.countBooks());
		app.randomBookList();
		} catch(IOException ioe) {
		out.printf("Perhaps missing text file: %s/%s? \n\n",
		new Main().getClass().getPackage().getName(), txtfile);
		}
	}//End of main method
	public static class AudioBookApp {
		private List<AudioBook> bookList;
		public List<AudioBook> getBookList() {
		return bookList;
		}
		
		public AudioBookApp(String filename) throws IOException {
			bookList = new LinkedList<>();
			readData(filename);
		}
		public void readData(String filename) throws IOException {
			Path path = new File(filename).toPath();
			List<String> content = Files.readAllLines(path);
			
			for (String line : content) {
				String[] items = line.split(",");
				String title = items[0];
				int year = Integer.valueOf(items[1]);
				double hours = Double.valueOf(items[2]);
				AudioBook audiobook = new AudioBook(title, year, hours);
				bookList.add(audiobook);
			}
		}
		public AudioBook getShortestBook() {
			AudioBook shortestBook = null;
			//Iterates through bookList to get the shortest book length
			for (AudioBook i : bookList) {
				if (shortestBook == null || i.getLength() < shortestBook.getLength()) {
					shortestBook = i;
				}
			}
			return shortestBook;
		}
		public int countBooks() {
			int count = 0;
			//Counts the number of books between 2010 - 2020 by iterating through bookList
			for (AudioBook i : bookList) {
				int range = i.getYear();
				if (range >= 2010 && range <= 2020) {
					count++;
				}
			}
			return count;
		}
		public void randomBookList() {
			List<AudioBook> randomList1 = new ArrayList<>();
			List<AudioBook> randomList2 = new ArrayList<>();
			List<AudioBook> randomList3 = new ArrayList<>();
			
			int num = 0;
			for (AudioBook e : bookList) {
				
				num = ThreadLocalRandom.current().nextInt(1, 4);//1-10
				
				//Assigns each audio book to a random list
				if (num == 1) {
					randomList1.add(e);
				} else if(num == 2) {
					randomList2.add(e);
				} else {
					randomList3.add(e);
				}
			}
			
			//Outputs the audio books with their randomly selected lists
			out.println("\n" + randomList1.size() + " books in list #1:");
			for (AudioBook e : randomList1) {
				out.println(e);
			}
			out.println("\n" + randomList2.size() + " books in list #2:");
			for (AudioBook e : randomList2) {
				out.println(e);
			}
			out.println("\n" + randomList3.size() + " books in list #3:");
			for (AudioBook e : randomList3) {
				out.println(e);
			}
		}
	}//End of class App
	
	public static class Book{
		private String title;
		private int year;
		
		public Book (String title, int year) {
			this.title = title;
			this.year = year;
		}
		
		public String getTitle() {
			return title;
		}
		
		public void setTitle(String title) {
			this.title = title;
		}
		
		public int getYear() {
			return year;
		}
		
		public void setYear(int year) {
			this.year = year;
		}
		
		
	}//End of class Book
	
	public static class AudioBook extends Book {
		private double length;
		
		public AudioBook (String title, int year, double length) {
			super(title, year);
			this.length = length;
		}
		
		public double getLength() {
			return length;
		}
		
		public void setLength(double length) {
			this.length = length;
		}
		
		public void displayInfo() {
			out.println("Book title: " + getTitle() + ". Publish year: " + getYear() + ". Length: " + getLength() + " hours.");
		}
		
		//Fixes a problem in which the contents of lists would display as raw information
		@Override public String toString() {
			return "Book title: " + getTitle() + ". Publish year: " + getYear() + ". Length: " + getLength() + " hours.";
		}
		
	}//End of class AudioBook
}//End of class Main
