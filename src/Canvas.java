/**
 * Canvas extends JFrame and combines panel and buttons to form the GUI of the application.
 * JButton and JPanel parted out for organizational purposes. Was getting annoying scrolling
 * and searching for issues. 
 * 
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Canvas extends JFrame{
	
	public Canvas() {
		DutchScramblePanel panel = new DutchScramblePanel();
		SorterButton button = new SorterButton("Sort", panel);
		
		setTitle("Dutch National Flag");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(new Dimension(300, 250));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(panel, BorderLayout.CENTER); // add panel to JFrame
		add(button, BorderLayout.SOUTH); // add button to JFrame
	}
}
