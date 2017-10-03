This is a Firework Simulator. Here I document my efforts in detail. 

The Program consists of three classes: GUI, Canvas and Main. The following describes what each of the classes contain:
GUI- the elements of GUI, all the buttons, JSliders, JLabels and JCombobox. 
Canvas- The actual drawing elements of the fireworks. 
Main- setting of the window.

Much effort was given to randomizing the attributes of the firework:
1) The height to which the firework launches is random. Every time the firework is launched, a random function generates a random height. This implies a  random time delay between and explosion. 
2) The height, width, and the angles of arcs, as well as the number of arcs used in the explosion are random. 
3) The height, width, and the angles of lines, as well as the number of lines formed in the explosion also utilize the random function (also the coordinates are bound within a random function). 
4) The effect of random functions can be seen as the repaint() method sets it into motion due to infinite loop. 
5) The height, width and the number of ovals formed are random. 
6) The number of points in the dynamic circle is also randomized. 


Also, the program is updated to work when it is resized. 

I hope you like the program.
-Sandesh