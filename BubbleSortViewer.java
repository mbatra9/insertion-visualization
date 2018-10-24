/** Megha Batra (mb4am) 
 * Extra Credit Assignment 
 * This class visualizes the sorting of the algorithm**/

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class BubbleSortViewer {
	public static void main(String[] args){
	 // creates the frame	
	 JFrame frame = new JFrame();
	 int[] values = ArrayUtil.randomIntArray(30, 300);
	 // sets the size of the frames
	 final int FRAME_WIDTH = 300;
	 final int FRAME_HEIGHT = 400;
	 frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	 // creating a bubble component
	 final BubbleSortComponent component = new BubbleSortComponent(values);
	 frame.add(component, BorderLayout.CENTER);
	 
	 // setting the frame to be seen and starting the animation
	 frame.setVisible(true);
	 component.startAnimation();
	}
}