import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 
 * Allows users to enter text, analyze it, and display the analysis results.
 *
 * @author Tej
 *
 */
public class TextAnalysisGUI implements ActionListener {
	
	private JTextArea inputField;
	private JTextArea display;
	private JButton clear, analyze;
	private TextAnalyzer textAnalyze;
	
	/**
	 * Constructs a TextAnalysisGUI object with the specified title.
	 * @param title the title of the GUI window
	 */
	public TextAnalysisGUI(String title) {
		JFrame jfrm = new JFrame(title);
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(800, 400);  
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.setResizable(false);
		JLabel prompt = new JLabel("Start typing or copy and paste your text below.");
		jfrm.add(prompt);
		
		this.inputField = new JTextArea(0, 0); // Will adjust dynamically when needed
        JScrollPane inputScrollPane = new JScrollPane(inputField); // Add scrolling functionality
        inputScrollPane.setPreferredSize(new Dimension(750, 250)); // Set preferred size
        inputField.setLineWrap(true); // Prevent horizontal dynamic adjusting
        inputField.setWrapStyleWord(true); // Enable word wrap
        jfrm.add(inputScrollPane);


		
		this.display = new JTextArea (2 ,75);
		jfrm.add(display);
		
		analyze = new JButton("analyze");
		analyze.addActionListener(this);
		jfrm.add(analyze);

		clear = new JButton("clear");
		clear.addActionListener(this);
		jfrm.add(clear);
		
		jfrm.setVisible(true);	
		
		
	}
	
	/**
	 * Invoked when an action occurs.
	 * 
	 * @param e the ActionEvent object representing the event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub		
		if (e.getSource() == analyze) {
			textAnalyze = new TextAnalyzer(inputField.getText());
			display.append(textAnalyze.toString());
		}
		
		else if(e.getSource() == clear) {
			display.setText("");
			inputField.setText("");
		}
	}


	public static void main(String[] args) {
		//Starting the GUI application
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new TextAnalysisGUI("Text Analyzer");
			}
		});		

	}
	

}
