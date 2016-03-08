/**
 * Class extends JPanel.
 * Creates a JPanel object with added components
 * from an arraylist containing threads objects.
 */
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DutchScramblePanel extends JPanel{
	
	/* DATA FIELDS */
	private ArrayList<ColoredThreads> threadsArray; // immutable
	
	/* CONSTRUCTOR */
	public DutchScramblePanel() {
		this.threadsArray = populateRandomizedArray(); // initializes array
		setLayout(new GridLayout(this.threadsArray.size(), 0)); // set layout
		populatePanel(threadsArray);// populates array with thread objects and randomizes order
	}
	
	/* ACCESSOR METHODS */
	/**
	 * Getter for threadsArray
	 * 
	 * @return threadsArray
	 */
	public ArrayList<ColoredThreads> getThreadsArray() {
		return threadsArray;
	}

	/* PRIVATE METHODS */
	/**
	 * Method for populating a temp array and randomizes elements
	 * within the temp array.
	 * 
	 * @return A temporary array containing randomized thread objects
	 */
	private ArrayList<ColoredThreads> populateRandomizedArray()
	{
		ArrayList<ColoredThreads> tempArray = new ArrayList<ColoredThreads>();
		
		
		//populates array
		for(int x = 0; x < 65; x++) // populates array with 195 elements, 65 * 3
		{
			tempArray.add(new ColoredThreads("white"));
			tempArray.add(new ColoredThreads("red"));
			tempArray.add(new ColoredThreads("blue"));
		}
		
		randomizeArray(tempArray); // randomizes array
		
		return tempArray;
	}
	
	/**
	 * Randomizes the temp array by grabbing a random index within the bounds
	 * of the size of the array.
	 * 
	 * @param list The array to be randomized.
	 */
	private void randomizeArray(ArrayList<ColoredThreads> list)
	{
		Random rand = new Random();
		int counter = 10000000; // the amount of times an element is moved within the array
		
		while(counter > 0)
		{
			ColoredThreads tempThread = list.remove(rand.nextInt(list.size()));
			list.add(tempThread);
			counter --;
		}
	}
	
	/**
	 * Method for populating panel with thread objects.
	 * 
	 * @param list The desired arraylist to populate panel
	 */
	private void populatePanel(ArrayList<ColoredThreads> list)
	{
		for(int x = 0; x < list.size(); x++)
		{
			add(threadsArray.get(x));
		}
	}
}
