/* Name: Sandesh Paudel
 * Assignment: Project 3
 * Lab Section: Wednesday, 2:00 pm-3:15 pm
 * TA'S Name: Colin Porovost
 * I affirm that I have not given or received any unauthorized help on this assignment, and that this code is my own.*/

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JFrame;
import javax.swing.JLabel;


import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import javax.swing.JComboBox;

public class GUI extends JPanel implements ActionListener, ChangeListener {

	public static int angle0=90;
	public static int velocity0=60;
	public static int explosiontime = 0;
	public static Color colorchoice=Color.WHITE;
	public static Object exptype;
	//spider variables
	public static int x;
	public static int y;
	public static int length;
	public static int width;
	public static int arc_num;
	public static int start_angle;
	public static int end_angle;
	JLabel para;
	JLabel color;
	JLabel launchangle;
	JLabel launchspeed;
	JLabel explosion;
	JSlider angle;
	JTextField speed;
	JComboBox colour;
	JComboBox explosiontype;
	JButton launch;
	
	
	
	
	public GUI(){
		setLayout(new GridLayout(9,0, 6, 6));
		
		color = new JLabel("Color:");
		add(color);
		
		
		colour = new JComboBox();
		colour.addItem("Red");
		colour.addItem("Blue");
		colour.addItem("Green");
		colour.addItem("Gray");
		colour.addActionListener(this);
		add(colour);
		
		launchangle = new JLabel("Launch Angle: (degrees)");
		add(launchangle);
		
		angle = new JSlider(JSlider.HORIZONTAL, 0, 180, 90);
		//ticks
		angle.setMajorTickSpacing(45);
		angle.setMinorTickSpacing(1);
		angle.setPaintTicks(true);
		angle.setPaintLabels(true);
		angle.addChangeListener(this);
		add(angle);
		
		launchspeed = new JLabel("Launch Speed: (m/s)");
		add(launchspeed);
		
		speed = new JTextField("60");
		speed.addActionListener(this);
		add(speed);
		
		explosion = new JLabel("Explosion Type:");
		add(explosion);
		
		explosiontype = new JComboBox();
		explosiontype.addItem("Dual Stream");
		explosiontype.addItem("Linear Flower");
		explosiontype.addItem("Lines");
		explosiontype.addItem("TriOvals");
		explosiontype.addItem("Dynamic Circle");
		explosiontype.addActionListener(this);
		add(explosiontype);
		
		
		launch = new JButton("Launch!");
		launch.addActionListener(this);
		add(launch);
		}

	
			@Override
			public void stateChanged(ChangeEvent e) {
				angle0=(angle.getValue());
				
			}


			@Override
			public void actionPerformed(ActionEvent f) {
		
			if(f.getSource()==launch){
			velocity0=Integer.valueOf(speed.getText());
			exptype=explosiontype.getSelectedItem();
	
		
			//Color Choice Setter
			if (colour.getSelectedItem()=="Red"){
			colorchoice=Color.RED;
			}
			else
				if (colour.getSelectedItem()=="Blue"){
					colorchoice=Color.BLUE;
					}
				else 
					if (colour.getSelectedItem()=="Green"){
						colorchoice=Color.GREEN;
						}
					else 
						if (colour.getSelectedItem()=="Gray"){
							colorchoice=Color.LIGHT_GRAY;
							}
			
			
			
			
			//explosion type setter
			if(explosiontype.getSelectedIndex()==0){
				Canvas.dualstream=true;
				Canvas.lines=false;
				Canvas.linearflower=false;
				Canvas.triovals=false;
				Canvas.dynamiccircle=false;
			}
			else
				if(explosiontype.getSelectedIndex()==1){
					Canvas.lines=false;
					Canvas.dualstream=false;
					Canvas.linearflower=true;
					Canvas.triovals=false;
					Canvas.dynamiccircle=false;
				}
				else
					if(explosiontype.getSelectedIndex()==2){
						Canvas.linearflower=false;
						Canvas.dualstream=false;
						Canvas.lines=true;
						Canvas.triovals=false;
						Canvas.dynamiccircle=false;
					}
					else
						if(explosiontype.getSelectedIndex()==3){
							Canvas.triovals=true;
							Canvas.dualstream=false;
							Canvas.lines=false;
							Canvas.linearflower=false;
							Canvas.dynamiccircle=false;
						}
						else
							if(explosiontype.getSelectedIndex()==4){
								Canvas.dynamiccircle=true;
								Canvas.dualstream=false;
								Canvas.lines=false;
								Canvas.linearflower=false;
								Canvas.triovals=false;
							}
						
			
					
					//explosion time setter
					Random rand = new Random();
					explosiontime=rand.nextInt(5);
					
					//spider arcs
					arc_num=5+rand.nextInt(5);
					
		

		}
	
	}
}
