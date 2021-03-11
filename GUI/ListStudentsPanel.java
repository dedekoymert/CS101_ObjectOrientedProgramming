package GUI;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.Course;

public class ListStudentsPanel extends JPanel{
	private Course course;
	private JPanel panel1,panel2,panel3;
	
	public ListStudentsPanel(Course course){
		this.course=course;
		
		setLayout(new GridLayout(1,3));
		
		panel1= new JPanel();
		panel2= new JPanel();
		panel3= new JPanel();
		
		panel1.setLayout(new GridLayout(0,1));
		panel2.setLayout(new GridLayout(0,1));
		panel3.setLayout(new GridLayout(0,1));
		
		
		panel1.add(new JLabel("<html><font color='red'>ID</font></html>"));
		panel2.add(new JLabel("<html><font color='red'>Name</font></html>"));
		panel3.add(new JLabel("<html><font color='red'>Email</font></html>"));
		
		for(int i=0; i<course.getStudents().size();i++){
			panel1.add(new JLabel(course.getStudents().get(i).getId()));
			panel2.add(new JLabel(course.getStudents().get(i).getName()));
			panel3.add(new JLabel(course.getStudents().get(i).getEmail()));
		}
		
		add(panel1);
		add(panel2);
		add(panel3);
		
		
	}
}
