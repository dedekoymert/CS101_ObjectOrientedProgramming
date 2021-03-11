package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.Course;

public class RegisterExamGradesPanel extends JPanel{
	private Course course;
	private JPanel topPanel,centerPanel,botPanel,panel1,panel2,panel3;
	private JTextField examId;
	private ArrayList<JTextField> grades;
	private JButton button;
	
	public RegisterExamGradesPanel(Course course){
		this.course=course;
		
		this.setLayout(new BorderLayout());
		
		topPanel=new JPanel();
		topPanel.setLayout(new GridLayout(1,3));
		topPanel.add(new JLabel("Enter Exam ID:"));
		topPanel.add(new JLabel(""));
		examId= new JTextField();
		topPanel.add(examId);
		
		panel1=new JPanel();
		panel2=new JPanel();
		panel3=new JPanel();
		panel1.setLayout(new GridLayout(0,1));
		panel2.setLayout(new GridLayout(0,1));
		panel3.setLayout(new GridLayout(0,1));
		
		centerPanel=new JPanel();
		centerPanel.setLayout(new GridLayout(0,3));
		centerPanel.add(panel1);
		centerPanel.add(panel2);
		centerPanel.add(panel3);
		
		panel1.add(new JLabel("<html><font color='red'>ID</font></html>"));
		panel2.add(new JLabel("<html><font color='red'>Name</font></html>"));
		panel3.add(new JLabel("<html><font color='red'>Grade</font></html>"));
		
		grades= new ArrayList<JTextField>();
		for(int i=0; i<course.getStudents().size(); i++){
			panel1.add(new JLabel(course.getStudents().get(i).getId()));
			panel2.add(new JLabel(course.getStudents().get(i).getName()));
			JTextField currentGrade = new JTextField();
			panel3.add(currentGrade);
			grades.add(currentGrade);
		}
		
		botPanel= new JPanel();
		button= new JButton("Save");
		botPanel.setLayout(new BorderLayout());
		botPanel.add(button,BorderLayout.EAST);
		
		button.addActionListener(new RegisterExamGradesHandler(grades,examId,course));
		
		this.add(topPanel,BorderLayout.NORTH);
		this.add(centerPanel,BorderLayout.CENTER);
		this.add(botPanel,BorderLayout.SOUTH);
	}
}
