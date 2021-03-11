package GUI;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.Course;
import Model.GradeItem;

public class ListGradesPanel extends JPanel {
	private Course course;
	private JPanel panel1,panel2;
	
	public ListGradesPanel(Course course){
		this.course=course;
		
		this.setLayout(new GridLayout(1,0));
		panel1=new JPanel();
		panel2=new JPanel();
		
		panel1.setLayout(new GridLayout(0,1));
		panel2.setLayout(new GridLayout(0,1));
		
		this.add(panel1);
		this.add(panel2);
		
		panel1.add(new JLabel("<html><font color='red'>ID</font></html>"));
		panel2.add(new JLabel("<html><font color='red'>Name</font></html>"));
		
		for(GradeItem g: course.getStudents().get(0).getGrades()){
			if(g.getCourseId().equals(course.getId())){
				double sum =0;
				int count=0;
				JPanel gradePanel = new JPanel();
				gradePanel.setLayout(new GridLayout(0,1));
				gradePanel.add(new JLabel("<html><font color='red'>"+g.getExamId()+"</font></html>"));
				for(int i=0; i<course.getStudents().size();i++){
					gradePanel.add(new JLabel(Integer.toString(course.getStudents().get(i).getGradeItem(course.getId(),g.getExamId()).getGrade())));
					sum+=course.getStudents().get(i).getGradeItem(course.getId(),g.getExamId()).getGrade();
					count+=1;
				}
				gradePanel.add(new JLabel(Double.toString(sum/count)));
				this.add(gradePanel);
			}
		}
		
		for(int i=0; i<course.getStudents().size();i++){
			panel1.add(new JLabel(course.getStudents().get(i).getId()));
			panel2.add(new JLabel(course.getStudents().get(i).getName()));
		}
		panel1.add(new JLabel("<html><font color='red'>Average</font></html>"));
		panel2.add(new JLabel(""));
	}
}
