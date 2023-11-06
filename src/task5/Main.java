package task5;

import static java.lang.System.*;
import java.util.*;

public class Main {
	public static void main(String[] args){
		List<Note> notes = new LinkedList<>();
		notes.add(new Note("D", 19));
		notes.add(new Note("C", 20));
		notes.add(new Note("F", 31));
		notes.add(new Note("B", 45));
		notes.add(new Note("C", 73));
		notes.add(new Note("F", 13));
		notes.add(new Note("B", 34));
		notes.add(new Note("C", 53));
		
		processNotes(notes);
	
	}//end of main method
	
	public static void processNotes(List<Note> notes){
		int total = 0;
		//Iterates through the arraylist notes
		//Calls the playNote method to output sentences based on the context of the list
		//Calculates the total duration of all notes
		for (Note n : notes) {
			n.playNote();
			total += n.getDuration();
		}
		out.println("Total duration: " + total + " seconds");
	}
	
	public static class Note {
		private String pitch;
		private int duration;
		
		public Note (String pitch, int duration) {
			this.pitch = pitch;
	        this.duration = duration;
		}		

		public String getPitch() {
			return pitch;
		}
		
		public void setPitch(String pitch) {
			this.pitch = pitch;
		}

		public int getDuration() {
			return duration;
		}
		
		public void setDuration(int duration) {
			this.duration = duration;
		}
		
		public void playNote() {
			out.println("The note " + pitch + " is played for " + duration + " seconds");
		}
		
	}
}//end of class Main
