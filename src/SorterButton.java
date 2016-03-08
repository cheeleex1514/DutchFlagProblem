/**
 * SorterButton holds the methods to sort each colored thread
 * into ascending order. I decided that all the implemented
 * methods should be private since no other classes should
 * have access to performing the sort function.
 * 
 * When I initially set up the program, I did a call to the sort()
 * in an entry method and everything flowed nicely. When I 
 * implemented the actionListener on the button to call the sort 
 * method I noticed that the GUI aspect of my program froze until 
 * the actual sorting was complete. After a bit of research I learned 
 * that Swing components wouldn't have been updated until after the 
 * actionPerformed finished its task. From which point I did further 
 * delving into concurrency and multi-threading.
 * 
 * Therefore in order to have my program update in an animated
 * manner, logic within the actionListener runs on its own thread.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class SorterButton extends JButton{
	
	/* CONSTRUCTOR */
	/**
	 * Constructor for sort button.
	 * @param name The desired name to display.
	 * @param panel The desired panel. 
	 */
	public SorterButton(String name, DutchScramblePanel panel) {
		this.setText(name);
		
		//adds an action listener
		addActionListener(new ActionListener()
		{		
			@Override
			public void actionPerformed(ActionEvent e) {
				//creating a new thread called sortThread
				Thread sortThread = new Thread()
				{
					//defining of logic to be performed when run is called
					public void run(){
						System.out.println("New thread started.");
						
						long startTime;
						long endTime;
						
						setEnabled(false);
						
						startTime = System.nanoTime();
						sort(panel);
						endTime = System.nanoTime();
						
						System.out.println();
						System.out.println("Sorting Completed!\nTotal sort time: "+((endTime-startTime)/1000000)+" milliseconds");
						//setEnabled(true);
					}
				};
				sortThread.start(); // starts the thread. 
			}
		});
	}
	
	/* PRIVATE METHODS */
	/**
	 * Sorts the arraylist of threads. This was the algorithm given from
	 * the book. I updated it to be used with an arrayList. Items are sorted
	 * by color value.
	 * 
	 * @param panel The panel containing the threads.
	 */
	private void sort(DutchScramblePanel panel)
	{
		int height = panel.getThreadsArray().size();
		int red = 0;
		int white = height - 1;
		int blue = height - 1;
		
		System.out.println("Sorting started!");
		
		while(red <= white)
		{
			if(red <= white)
			{				
				if(panel.getThreadsArray().get(white).getThreadColor() == "white")
				{
					white--;
					System.out.println("Counter white decremented by 1.");
				}
				else if(panel.getThreadsArray().get(white).getThreadColor() == "red")
				{
					swap(panel, red, white);
					red++;
					System.out.println("Counter red decremented by 1.");
				}
				else //threads[white].getColor() == Color.BLUE
				{
					swap(panel, white, blue);
					white--;
					blue--;
					System.out.println("Counters white and blue decremented by 1.");
				}
			}
		}
	}//end sort
	
	/**
	 * This is the swap method. It swaps elements @ poistion 'up'
	 * with elemts at postion 'down'.
	 * 
	 * @param panel The panel object containing thread objects arrayList.
	 * @param up The integer value for swapping.
	 * @param down The integer value for swapping.
	 */
	private static void swap(DutchScramblePanel panel, int up, int down)
	{
		ColoredThreads temp = panel.getThreadsArray().get(up); // holds temporary Threads object
		panel.getThreadsArray().set(up, panel.getThreadsArray().get(down));
		panel.getThreadsArray().set(down, temp);
		
		System.out.printf("Indexes %d and %d swapped.\n", up, down);
		
		threadSleep(); // causes pause
		
		for(int x = 0; x < panel.getThreadsArray().size(); x++)
		{
			panel.add(panel.getThreadsArray().get(x));
		}
		
		panel.validate(); //tells panel to reposition its components after modification 
	}
	
	/**
	 * Method to perform a slight pause so that the moving of 
	 * threads objects can be followed (User experience)
	 */
	private static void threadSleep()
	{
		try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

