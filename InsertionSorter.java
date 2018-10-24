/** Megha Batra (mb4am) 
 * Extra Credit Assignment 
 * This class actually uses the insertion sorting algorithm to sort an array **/
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JComponent;

public class InsertionSorter {
	
		 private static final int DELAY = 100;
		 
		 // array list to be sorted
		 private int[] a;
		 private Lock sortStateLock;
		 // creates the component that is to be repainted when the animation is paused
		 private JComponent component;

		 // instance variables
		 private int markedPosition = -1;
		 private int alreadySorted = -1;

		 // constructor
		 public InsertionSorter(int[] anArray, JComponent aComponent) {
			 a = anArray;
			 sortStateLock = new ReentrantLock();
			 component = aComponent;
		}
		
		// the actual sorting algorithm 
		public void sort()throws InterruptedException{
			 for (int i = 0; i < a.length; i++) {
				 int key = a[i];
		         int j = i-1;
				 sortStateLock.lock();
				 try{
					 while (j>=0 && a[j] > key)
			            {
			                a[j+1] = a[j];
			                j = j-1;
			            }
					 a[j+1] = key;
					 // For animation
					 alreadySorted = i;
				 }
				 finally{
					 sortStateLock.unlock();
				 	}
				 pause(2);
			 }
		  }
		 
		 // draws the lines for the animation/ keeps track of color based on position
		 public void draw(Graphics2D g2) {
			 sortStateLock.lock();
			 try
			 {
		 int deltaX = component.getWidth() / a.length;
			 for (int i = 0; i < a.length; i++){
				 if (i == markedPosition)
					 g2.setColor(Color.RED);
				 else if (i <= alreadySorted)
					 g2.setColor(Color.BLUE);
				 else
					g2.setColor(Color.BLACK);
				 	g2.draw(new Line2D.Double(i * deltaX, 0,
				 	i * deltaX, a[i]));
			  }
			 }
			 	finally{
			  sortStateLock.unlock();
			  }
		 }
			 
		 // pauses the animation
		 public void pause(int steps) throws InterruptedException
			 {
			 component.repaint();
			 Thread.sleep(steps * DELAY);
			 }
		
}

