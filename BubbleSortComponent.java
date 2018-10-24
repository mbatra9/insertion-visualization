/** Megha Batra (mb4am) 
 * Extra Credit Assignment 
 * This class is the animation component**/

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class BubbleSortComponent extends JComponent{
	private BubbleSorter sorter;
	 int[] values = ArrayUtil.randomIntArray(30, 300);
	 
	// gets the random array that needs to be sorted
	 public BubbleSortComponent(int[] arr) {
		 sorter = new BubbleSorter(values, this);
	 }
	 
	 // paints the lines in the bubble sorting method
	 public void paintComponent(Graphics g)
	  {
		 Graphics2D g2 = (Graphics2D)g;
		 sorter.draw(g2);
	  }
	 
	 // animates the algorithm
	 public void startAnimation(){
		 class AnimationRunnable implements Runnable{
			 	public void run() {
			 		try{
			 			sorter.sort();
			 			repaint();
			 		}
			 		catch (InterruptedException exception){
			 		}
	  }
			 	}
		 Runnable r = new AnimationRunnable();
		 Thread t = new Thread(r);
		 t.start();
} 
}

