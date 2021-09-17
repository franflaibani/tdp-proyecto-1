package launcher;
import entities.*;
import gui.*;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Student student = new Student(115134, "Flaibani", "Francisco Luis", "fraaaan007@gmail.com", "https://github.com/franflaibani", "images/estudiante.jpg");
            	new SimplePresentationScreen(student);
            }
        });
    }
}