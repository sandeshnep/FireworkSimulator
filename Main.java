/* Name: Sandesh Paudel
 * Assignment: Project 3
 * Lab Section: Wednesday, 2:00 pm-3:15 pm
 * TA'S Name: Colin Porovost
 * I affirm that I have not given or received any unauthorized help on this assignment, and that this code is my own.*/

import javax.swing.JFrame;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;



public class Main extends JFrame{
	public static boolean update=false;
	
	public Main(){
	int height = 800;
	int width = 600;
	
	Canvas canvas = new Canvas();
	add(canvas);
	
	GUI gui = new GUI();
	add(gui);
	
	setTitle("FireWorks Simulator");
	setSize(height, width);
	setLayout(new GridLayout(0,2));
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main (String[] args){
		new Main().setVisible(true);	
	}
}
