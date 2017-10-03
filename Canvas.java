/* Name: Sandesh Paudel
 * Assignment: Project 3
 * Lab Section: Wednesday, 2:00 pm-3:15 pm
 * TA'S Name: Colin Porovost
 * I affirm that I have not given or received any unauthorized help on this assignment, and that this code is my own.*/


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

import java.awt.FlowLayout;


public class Canvas extends JPanel{
	public static boolean draw=false;
	public static double time;
	public Random rand = new Random();
	public int color;
	public static boolean dualstream=false;
	public static boolean lines=false;
	public static boolean linearflower=false;
	public static boolean triovals=false;
	public static boolean dynamiccircle=false;
	public static boolean animation = true;
	public static boolean update = false;
	
	
	public Canvas(){
		setBackground(Color.BLACK);
	}

	@Override
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		g.setColor(GUI.colorchoice);
		
		
		//calculation of coordinates
		for(int time = 0; time<=4+GUI.explosiontime; time++){
			int x =  (int) (GUI.velocity0*Math.cos(Math.toRadians(GUI.angle0))*time);
			int y =  ((int) ((GUI.velocity0*Math.sin(Math.toRadians(GUI.angle0))*time) - (0.5*9.81*time*time)));
			int x1 = (getWidth()/2) +(getWidth()*x/392);
			int y1 = (getHeight()*y/1000);
			
			//starting position
			g.fillOval((getWidth()/2), (int) (getHeight()/1.05), getWidth()/40, getHeight()/60);
			
			//drawing the trajectory of launch
			if (y>0){
				g.fillOval(x1, (int)((getHeight()/1.05)-(3*y1)), getWidth()/40, getHeight()/60);}		
		}
		
//-----------------------------------------------------------------------------------------------EXPLOSION TYPES------------------------------------
		
		//Dual Streams
		if(dualstream==true){
			for (int i=0; i<GUI.arc_num; i++){
				int timen=(4+GUI.explosiontime);
				int x =  (int) (GUI.velocity0*Math.cos(Math.toRadians(GUI.angle0))*timen);
				int y =  ((int) ((GUI.velocity0*Math.sin(Math.toRadians(GUI.angle0))*timen) - (0.5*9.81*timen*timen)));
				int x1= (getWidth()/2) +(getWidth()*x/392);
				int y1= (getHeight()*y/900);
				int width = ((100+rand.nextInt(100))*getWidth())/392;
				int height = ((100+rand.nextInt(100))*getHeight())/800;
				int startAngle = rand.nextInt(20);
				int arcAngle = 90+rand.nextInt(20);
				
				g.drawArc(x1, (int)((getHeight()/1.05)-(3*y1)), width, height, startAngle, arcAngle);
				
				int startAnglei = 180-startAngle;
				int arcAnglei = -arcAngle;
				
				g.drawArc(x1-width, (int)((getHeight()/1.05)-(3*y1)), width, height, startAnglei, arcAnglei);
			}
		}
		else 
		
		
			
		if (lines==true){
		
		//Lines
			for (int i=0; i<=1; i++){
				int timen=(4+GUI.explosiontime);
				int x =  (int) (GUI.velocity0*Math.cos(Math.toRadians(GUI.angle0))*timen);
				int y =  ((int) ((GUI.velocity0*Math.sin(Math.toRadians(GUI.angle0))*timen) - (0.5*9.81*timen*timen)));
				int x1= (getWidth()/2) +(getWidth()*x/392);
				int y1= (getHeight()*y/900);
				
				int y2 = (int)((getHeight()/1.05)-(3*y1));
				
				g.drawLine((x1-rand.nextInt(30)), (y2), (x1+rand.nextInt(200)), (y2 - rand.nextInt(200)));
				g.drawLine((x1-rand.nextInt(30)), (y2 - rand.nextInt(50)), (x1+rand.nextInt(200)), (y2 + rand.nextInt(100)));
			}
		}
		else
			
			
		
		if(linearflower==true){
		
		//Linear Flower
			for (int i=0; i<=10; i++){
				int timen=(4+GUI.explosiontime);
				int x =  (int) (GUI.velocity0*Math.cos(Math.toRadians(GUI.angle0))*timen);
				int y =  ((int) ((GUI.velocity0*Math.sin(Math.toRadians(GUI.angle0))*timen) - (0.5*9.81*timen*timen)));
				int x1= (getWidth()/2) +(getWidth()*x/392);
				int y1= (getHeight()*y/900);
				
				int y2 = (int)((getHeight()/1.05)-(3*y1));
				
				g.drawLine(x1, y2, (x1+(rand.nextInt(200))*getWidth()/392), (y2 - (rand.nextInt(200)*getHeight()/800)));
				g.drawLine(x1, y2, (x1-(rand.nextInt(200))*getWidth()/392), (y2 - (rand.nextInt(100)*getHeight()/800)));
			}
	
		}
		else
			
			
			
			
		if(triovals==true){
		//TriOvals
			for (int i=0; i<GUI.arc_num; i++){
				int timen=(4+GUI.explosiontime);
				int x =  (int) (GUI.velocity0*Math.cos(Math.toRadians(GUI.angle0))*timen);
				int y =  ((int) ((GUI.velocity0*Math.sin(Math.toRadians(GUI.angle0))*timen) - (0.5*9.81*timen*timen)));
				int x1= (getWidth()/2) +(getWidth()*x/392);
				int y1= (getHeight()*y/900);
				int y2 = (int)((getHeight()/1.05)-(3*y1));
				int width = ((100+rand.nextInt(50))*getWidth())/392;
				int height = ((50+rand.nextInt(50))*getHeight())/800;
				
				g.drawOval(x1, y2, width, height);
				g.drawOval(x1-(height/2), y2-height, height, width);
				g.drawOval(x1-width, y2, width, height);
			}
		}
		else
			
			
			
		if(dynamiccircle==true){
		//Dynamic Circle
			for(int i = 0; i < 360; i+=20+ rand.nextInt(10)){
				int timen=(4+GUI.explosiontime);
				int x =  (int) (GUI.velocity0*Math.cos(Math.toRadians(GUI.angle0))*timen);
				int y =  ((int) ((GUI.velocity0*Math.sin(Math.toRadians(GUI.angle0))*timen) - (0.5*9.81*timen*timen)));
				int x1= (getWidth()/2) +(getWidth()*x/392);
				int y1= (getHeight()*y/900);
				int y2 = (int)((getHeight()/1.05)-(3*y1));
				
				
				
				int x3 = x1 + (int) (100*Math.cos(i*Math.PI/180)*getWidth()/392);
				int y3 = y2 + (int) (100*Math.sin(i*Math.PI/180)*getHeight()/800);
				g.fillOval(x3-10, y3-10,(20*getWidth()/392),(20*getHeight()/800));
				
				g.drawLine(x1, y2, x3, y3);
			
			}
		}
		
//-----------------------------------------------------------------------------------------------EXPLOSION TYPES------------------------------------
		
		repaint();
		

	
	}

	
}
	

