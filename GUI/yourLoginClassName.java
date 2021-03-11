package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Model.Department;

public class yourLoginClassName extends JFrame {
	private JTextField textField;
	private JButton button;
	private JLabel label;
	private JPanel mainPanel;

	public yourLoginClassName(Department department){
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(750,450);
		
		mainPanel= new JPanel();
		add(mainPanel);
		
		label= new JLabel("Email: ");
		textField= new JTextField("",20);
		button= new JButton("Login");
		
		mainPanel.add(label);
		mainPanel.add(textField);
		mainPanel.add(button);
		
		button.addActionListener(new LoginHandler(textField,department));
		
		setVisible(true);
	}
}
