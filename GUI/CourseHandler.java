package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Model.Course;

public class CourseHandler implements ActionListener {
	private Course course;
	private JPanel centerPanel;
	
	
	public CourseHandler(Course course,JPanel centerPanel){
		this.course=course;
		this.centerPanel=centerPanel;
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() instanceof JButton ){
			JButton button=((JButton)e.getSource());
			if(button.getText().equals("List Students")){
				ListStudentsPanel listStudents = new ListStudentsPanel(course);
				centerPanel.removeAll();
				centerPanel.repaint();
				centerPanel.add(listStudents);
				centerPanel.revalidate();
			}
			else if(button.getText().equals("Register Exam Grades")){
				RegisterExamGradesPanel registerExamGrades = new RegisterExamGradesPanel(course);
				centerPanel.removeAll();
				centerPanel.repaint();
				centerPanel.add(registerExamGrades);
				centerPanel.revalidate();
			}
			else if(button.getText().equals("List Grades")){
				ListGradesPanel listGrades = new ListGradesPanel(course);
				centerPanel.removeAll();
				centerPanel.repaint();
				centerPanel.add(listGrades);
				centerPanel.revalidate();
			}
		}
	}
}
//frame.revalidate(); // frame.pack() if you want to resize.