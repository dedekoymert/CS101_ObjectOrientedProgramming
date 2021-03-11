package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.Course;
import Model.GradeItem;
import Model.Student;

public class RegisterExamGradesHandler implements ActionListener {
	private ArrayList<JTextField> grades;
	private JTextField examId;
	private Course course;

	public RegisterExamGradesHandler(ArrayList<JTextField> grades, JTextField examId, Course course) {
		this.grades = grades;
		this.examId = examId;
		this.course = course;
	}

	public void actionPerformed(ActionEvent e){
		
		
		boolean control =true;
		for(int i=0; i<course.getStudents().size(); i++){
			try{
				if(examId.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Enter a valid exam Id");
					control=false;
					break;
				}
				if(Integer.parseInt(grades.get(i).getText())>100){
					JOptionPane.showMessageDialog(null,"Grade value must be in 0-100 range");
					control = false;
					break;
						
				}
				GradeItem grade = new GradeItem(course.getId(),examId.getText(),Integer.parseInt(grades.get(i).getText()));
				course.getStudents().get(i).addGrade(grade);
			}
			catch(Exception e1){
				JOptionPane.showMessageDialog(null,"Grades must be integer" );
				control=false;
				break;
			}
		}
		for(int j=0;j<course.getStudents().get(0).getGrades().size();j++){
			if(examId.getText().equals(course.getStudents().get(0).getGrades().get(j).getExamId())){
				String[] options ={"Yes","No"};
				JOptionPane.showOptionDialog(null,"An exam with this id is already graded. Do you want to overwrite it?" ,"warning",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null, options, options[0]);
				break;						
			}
		}
		if(control)
			JOptionPane.showMessageDialog(null,"Grades saved");
	}
}
