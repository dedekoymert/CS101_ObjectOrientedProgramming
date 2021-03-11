package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.Department;

public class LoginHandler implements ActionListener {
	private JTextField textField;
	private Department department;
	
	public LoginHandler(JTextField textField, Department department){
		this.textField=textField;
		this.department=department;
	}
	
	public void actionPerformed(ActionEvent e){
		boolean control = false;
		for(int i=0; i<department.getInstructors().size(); i++){
			if(department.getInstructors().get(i).getEmail().equals(textField.getText())){
				InstructorFrame instructorFrame= new InstructorFrame(department.getInstructors().get(i));
				control=true;
			}
		}
		if(control==false)
			JOptionPane.showMessageDialog(null,"User does not exist");
	}
}
