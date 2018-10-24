/** Megha Batra (mb4am)
 * Extra Credit Assignment 
 * This class is the animation component for the Selection Sort algorithm**/
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class SelectionSortComponent extends JComponent{
	 private SelectionSorter sorter;
	 int[] values = ArrayUtil.randomIntArray(30, 300);
	 
	 //constructor that also takes in the random array that needs to be sorted
	 public SelectionSortComponent(int[] arr) {
		 sorter = new SelectionSorter(values, this);
	 }
	 
	 // paints the algorithm
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