import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Tej
 *
 */
public class TextAnalysisGUI implements ActionListener {
	
	private JTextArea inputField;
	private JTextArea display;
	private JButton clear, analysis;
	private TextAnalyzer textAnalyze;
	
	public TextAnalysisGUI(String title) {
		JFrame jfrm = new JFrame(title);
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(800, 400);  
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.setResizable(false);
		JLabel prompt = new JLabel("Start typing or copy and paste your text below.");
		jfrm.add(prompt);
		
		this.inputField = new JTextArea(0, 0);
        JScrollPane inputScrollPane = new JScrollPane(inputField);
        inputScrollPane.setPreferredSize(new Dimension(750, 250)); // Set preferred size
        inputField.setLineWrap(true); // Enable line wrap
        inputField.setWrapStyleWord(true); // Enable word wrap
        jfrm.add(inputScrollPane);
//		this.inputField.addActionListener(this); 

		
		this.display = new JTextArea (2 ,75);
		jfrm.add(display);
		
		analysis = new JButton("analysis");
		analysis.addActionListener(this);
		jfrm.add(analysis);

		clear = new JButton("clear");
		clear.addActionListener(this);
		jfrm.add(clear);
		
		jfrm.setVisible(true);	
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		textAnalyze = new TextAnalyzer(inputField.getText());
		if (e.getSource() == analysis) {
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
