/** Megha Batra (mb4am)
 * Extra Credit Assignment
 * This window allows you to actually see the Insertion Sort algorithm**/

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class InsertionSortViewer {
	public static void main(String[] args){
	 JFrame frame = new JFrame();
	 int[] values = ArrayUtil.randomIntArray(30, 300);
	
	 final int FRAME_WIDTH = 300;
	 final int FRAME_HEIGHT = 400;
	 frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	 final InsertionSortComponent component = new InsertionSortComponent(values);
	 frame.add(component, BorderLayout.CENTER);
	 
	 frame.setVisible(true);
	 component.startAnimation();
	}
}