/** Megha Batra (mb4am)
 * Extra Credit Assignment
 * This class actually sorts an array using the Selection Sort algorithm **/

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.JComponent;

public class SelectionSorter {
	private static final int DELAY = 100;

	private int[] a;
	private Lock sortStateLock;
	// The component is repainted when the animation is paused
	private JComponent component;

	// These instance variables are needed for drawing
	private int markedPosition = -1;
	private int alreadySorted = -1;

	// constructor for Selection Sort
	public SelectionSorter(int[] anArray, JComponent aComponent) {
		a = anArray;
		sortStateLock = new ReentrantLock();
		component = aComponent;
	}

	// actually sorts the array using Selection Sort
	public void sort()throws InterruptedException{
		for (int i = 0; i < a.length - 1; i++) {
			int minPos = minPosition(i);
			sortStateLock.lock();
			try{
				swap(minPos, i);
				// For animation
				alreadySorted = i;
			}
			finally{
				sortStateLock.unlock();
		 		}
			pause(2);
	 }
  }
 
	// finds the smallest integer in the array
	private int minPosition(int from) throws InterruptedException{
		int minPos = from;
		for (int i = from + 1; i < a.length; i++){
			sortStateLock.lock();
			try{
				if (a[i] < a[minPos]) minPos = i;
			  // For animation
			  markedPosition = i;
		  }
			finally
		  {
				sortStateLock.unlock();
		  }
		 pause(2);
	  }
	  return minPos;
  }
 
	// switches two integers from the array
 	private void swap(int i, int j){
 		int temp = a[i];
 		a[i] = a[j];
 		a[j] = temp;
  }
 
 	// actually draws the animation
 	public void draw(Graphics2D g2) {
 		sortStateLock.lock();
 		try{
 			int pos = component.getWidth() / a.length;
 			for (int i = 0; i < a.length; i++){
 				if (i == markedPosition)
 					g2.setColor(Color.RED);
 				else if (i <= alreadySorted)
 					g2.setColor(Color.CYAN);
 				else
 					g2.setColor(Color.BLACK);
 					g2.draw(new Line2D.Double(i * pos, 0,i * pos, a[i]));
	  }
	 }
	 	finally{
	 		sortStateLock.unlock();
	  }
 }
	 
	// pauses the animation 
 	public void pause(int steps) throws InterruptedException {
 		component.repaint();
 		Thread.sleep(steps * DELAY);
	 }
}
