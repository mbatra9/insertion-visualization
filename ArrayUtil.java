/** Megha Batra (mb4am) 
 * Extra Credit Assignment 
 * This class creates a random array of integers that need to be sorted**/
import java.util.Random;

public class ArrayUtil {
	public static Random randomints = new Random();
	
	public static int[] randomIntArray(int length, int n){
		int[] a = new int[length];
		
		for(int i=0; i<a.length; i++)
			a[i] = randomints.nextInt(n);
		
		return a;
	}

	
/**Sources used for help on all parts of the assignment:
* help with animation & threads: http://www.dmc.fmph.uniba.sk/public_html/doc/Java/ch10.htm and the Big Java Textbook
* help with visualizing and understanding each algorithm: https://www.toptal.com/developers/sorting-algorithms
* help with making the lines: https://docs.oracle.com/javase/7/docs/api/java/awt/geom/Line2D.html
* / **/
}
