/** Megha Batra (mb4am)
 * Extra Credit Assignment
 * This class animates the insertion sorting algorithm**/

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class InsertionSortComponent extends JComponent{
	private InsertionSorter sorter;
	int[] values = ArrayUtil.randomIntArray(30, 300);
	
 	 // constructor for insertion sort that takes in the random array list that needs to be sorted
	 public InsertionSortComponent(int[] arr) {
		 sorter = new InsertionSorter(values, this);
	 }
	 
	 // draws the algorithm
	 public void paintComponent(Graphics g)
	  {
		 Graphics2D g2 = (Graphics2D)g;
		 sorter.draw(g2);
	  }
	 
	 // starts the animation for the algorithm
	 public void startAnimation(){
		 class AnimationRunnable implements Runnable{
			 	public void run() {
			 		try{
			 			sorter.sort();
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

