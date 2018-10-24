/** Megha Batra (mb4am)
 * Extra Credit Assignment
 * This class actually sorts an array using the Bubble sort method of sorting **/
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.JComponent;

public class BubbleSorter {
	
	private static final int DELAY = 100;

		 // array list to be sorted
		 private int[] a;
		 //created a lock
		 private Lock sortStateLock;
		 // the component is repainted when the animation is paused
		 private JComponent component;
		 // helps with drawing
		 private int markedPosition = -1;
		 private int alreadySorted = -1;

	// constructor for Bubble Sort
	public BubbleSorter(int[] anArray, JComponent aComponent){
		 a = anArray;
		 sortStateLock = new ReentrantLock();
		 component = aComponent;
		}
	
	// method that actually sorts the array
	public void sort()throws InterruptedException{
		// loops through the  array 
		for (int i = 0; i < a.length-1; i++) {
			 for (int j = 0; j < a.length-i-1; j++) {
				 sortStateLock.lock();
				 try{
					 if (a[j] > a[j+1])
			           {
						  int temp = a[j];
		                   a[j] = a[j+1];
		                   a[j+1] = temp;  
		               
			            }
					   
	                    // to keep track of animation
						 alreadySorted = i;
				 }
				 finally{
					 sortStateLock.unlock();
				 	}
				 pause(2);
			 }
			 }
		  }
		
	// actually draws the lines
	public void draw(Graphics2D g2) {
			 sortStateLock.lock();
			 try {
				 int pos = component.getWidth() / a.length;
				 for (int i = 0; i < a.length; i++){
					 // tracks the position
					 if (i == markedPosition)
						 g2.setColor(Color.RED);
					 // already sorted lines
					 else if (i <= alreadySorted)
						g2.setColor(Color.CYAN);
					 else
						g2.setColor(Color.BLACK);
				 		g2.draw(new Line2D.Double(i * pos, 0, i * pos, a[i]));
			  }
			 }
			 finally{
				 sortStateLock.unlock();
			  }
		 }
			 
	// pauses to repaint the animation		
	public void pause(int steps) throws InterruptedException{
		component.repaint();
		Thread.sleep(steps * DELAY);
	 }
}

