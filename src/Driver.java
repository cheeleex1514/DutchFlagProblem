/**
 * @author Chee M. Lee
 * 
 * This is the driver class for testing the application.
 * Console also outputs what is happening behind the GUI.
 * 
 * Operation:
 * Press the sort button at the bottom of the application
 * to visually see the scrambled colored threads become 
 * sorted into the Dutch National flag. 
 * 
 * The colored threads are randomized at run time. 
 * The application can only be run once. The sort
 * button will be disabled upon clicking of sort button.
 * 
 * To end the run of the application just simply close 
 * the window.
 *
 */
public class Driver {

	/* ENTRY METHOD */
	public static void main(String[] args)
	{
		Canvas program = new Canvas();
		program.setVisible(true);
	}
}
