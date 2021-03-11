package GUI;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import Model.Course;

public class CoursePanel extends JPanel{
	private Course course;
	private JButton listStudents,registerExamGrades,listGrades;
	private JPanel topPanel;
	private JPanel centerPanel;
	
	public CoursePanel(Course course){
		this.course=course;
		this.setLayout(new BorderLayout());
		
		listStudents= new JButton("List Students");
		registerExamGrades=new JButton("Register Exam Grades");
		listGrades= new JButton("List Grades");
		topPanel= new JPanel();
		centerPanel= new JPanel();
		this.add(topPanel,BorderLayout.NORTH);
		
		listStudents.addActionListener(new CourseHandler(course,centerPanel));
		registerExamGrades.addActionListener(new CourseHandler(course,centerPanel));
		listGrades.addActionListener(new CourseHandler(course,centerPanel));
		this.add(centerPanel,BorderLayout.CENTER);
		
		topPanel.add(listStudents);
		topPanel.add(registerExamGrades);
		topPanel.add(listGrades);
		
		this.setVisible(true);
	}
}
