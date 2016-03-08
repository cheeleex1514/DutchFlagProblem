/**
 * This is the threads class. Each created thread will be either red, white, or blue.
 */

import java.awt.Color;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ColoredThreads extends JPanel{

	/* DATA FIELDS */
	private String threadColor;
	private int comparableThreadNumber;
	
	/* CONSTRUCTOR */
	/**
	 * All new object must be created with a valid argument of "red", "white", or "blue".
	 * 
	 * @param color The desired string of red, white, or blue.
	 */
	public ColoredThreads(String color) {
		if(validateColor(color))
		{
			this.threadColor = color.toLowerCase(); // to insure all names are in lowerCase for sorting
			this.comparableThreadNumber = generateComparableThreadNumber(color);
			this.defineThreadColor(color);
			
		}//end if
	}//end constructor
	
	/* PRIVATE METHODS */
	/**
	 * Method for validating whether created object is only given a valid string of white, red, or blue.
	 * Throws and IllegalArgumentException if object is created with something other the valid options.
	 * @param color
	 * @return
	 */
	private boolean validateColor(String color)
	{
		if(!(color.toLowerCase().equals("white") || color.toLowerCase().equals("red") || color.toLowerCase().equals("blue")))
		{
			throw new IllegalArgumentException("Color selection is invalid.");
		}
		else
		
		return true;
	}
	
	/**
	 * Generates a pre-defined integer value for threads object.
	 * 
	 * Note: The numbers aren't actually used in the sorting function but left in place
	 * 		 for future studies of other sorting algorithms.
	 * 
	 * @Throws IllegalArgumentException Thrown if the color does not match that in the switch 
	 * @param color The color defined in the constructor.
	 * @return
	 */
	private int generateComparableThreadNumber(String color)
	{
		switch(color.toLowerCase())
		{
			case "red":
				return 0;
			case "white":
				return 1;
			case "blue":
				return 2;
			default:
				throw new IllegalArgumentException("Color selection is invalid.");		
		}
	}
	
	/* MUTATOR & ACCESSOR */
	public String getThreadColor()
	{
		return this.threadColor;
	}
		
	public int getComparableThreadNumber()
	{
		return this.comparableThreadNumber;
	}
	
	/* PRIVATE METHODS*/
	/**
	 * Method that sets the objects background color according to given String
	 * 
	 * @param color The color defined in object instantiation.
	 */
	private void defineThreadColor(String color)
	{
		switch(color.toLowerCase())
		{
			case "red":
				this.setBackground(Color.RED);
				break;
				
			case "white":
				this.setBackground(Color.WHITE);
				break;
				
			case "blue":
				this.setBackground(Color.BLUE);
				break;
				
			default:
				throw new IllegalArgumentException("Color selection is invalid.");		
		}//end switch
	}
}
