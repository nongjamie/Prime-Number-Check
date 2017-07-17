package PrimeNumberCheck;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

/**
 * Graphic User Interface.
 * @author Jamie Sathira Kittisukmongkol
 * 			Software Engineering Student
 * 			Kasetsart University Bangkaen Campus
 */
public class GUI {

	private Console console;
	private JFrame frame;
	private CheckButtonListener checkButtonListener; 
	
	// Top section
	private JPanel topPanel;
	private JLabel labelInputNumber;
	private JTextField inputNumberField;
	private JLabel labelResult;
	private JTextField resultField;
	
	// Buttom section
	private JPanel buttomPanel;
	private JButton checkButton;
	private JButton resetButton;
	private JButton quitButton;
	
	/**
	 * This is the Graphic User Interface constructor.
	 * @param console , Prime Number Checking logic.
	 */
	public GUI( Console console ) {
		this.console = console;
		frame = new JFrame( "Prime Number Checking by Jamie SK" );
		checkButtonListener = new CheckButtonListener();
		initComponent();
		addAllComponent();
	}
	
	/**
	 * Manage all components.
	 */
	public void initComponent() {
		
		// Top Panel
		topPanel = new JPanel();
		
		labelInputNumber = new JLabel();
		labelInputNumber.setText( "Input Number --> " );
		
		inputNumberField = new JTextField();
		inputNumberField.setPreferredSize( new Dimension( 100 , 20 ) );
		inputNumberField.addKeyListener( checkButtonListener );
		
		labelResult = new JLabel();
		labelResult.setText( "Result --> " );
		
		resultField = new JTextField();
		resultField.disable();
		resultField.setPreferredSize( new Dimension( 250 , 20 ) );
		
		// Buttom Panel
		buttomPanel = new JPanel();
		
		checkButton = new JButton("Check!");
		checkButton.addActionListener( checkButtonListener );
		
		resetButton = new JButton("Reset");
		resetButton.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				inputNumberField.setText("");
				resultField.setText("");
				console.resetAll();
			}
			
		} );
		
		quitButton = new JButton("Quit");
		quitButton.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit( 0 );
			}
			
		} );
		
	}
	
	/**
	 * Add all components into appropriate panels.
	 * Add all components into the frame.
	 */
	public void addAllComponent() {
		
		// Add components into Top panel.
		topPanel.add( labelInputNumber );
		topPanel.add( inputNumberField );
		topPanel.add( labelResult );
		topPanel.add( resultField );
		
		// Add components into Buttom panel.
		buttomPanel.add( checkButton );
		buttomPanel.add( resetButton );
		buttomPanel.add( quitButton );
		
		// Add all panels into the frame.
		frame.add( topPanel , BorderLayout.NORTH );
		frame.add( buttomPanel , BorderLayout.SOUTH );
		
	}
	
	/**
	 * Run the frame on the display.
	 */
	public void run() {
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setVisible( true );
		frame.setMaximumSize( new Dimension( 600 , 90 ) );
		frame.setMinimumSize( new Dimension( 600 , 90 ) );
	}
	
	/**
	 * Action to check the prime number.
	 */
	class CheckButtonListener implements ActionListener , KeyListener {
		
		@Override
		public void keyTyped(KeyEvent e) {
			/* Do nothing */
		}
		
		/**
		 * When Enter on keyboard is pressed.
		 */
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if( key == KeyEvent.VK_ENTER ) {
				String input = inputNumberField.getText();
				console.checkingPrimeNumber( input.trim() );
				resultField.setText( console.getResult() );
			}
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			/* Do nothing */
		}
		
		/**
		 * When Check button in the program is pressed.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			String input = inputNumberField.getText();
			console.checkingPrimeNumber( input.trim() );
			resultField.setText( console.getResult() );
		}
		
	}
	
	
}

