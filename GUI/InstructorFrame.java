package GUI;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import Model.Instructor;


public class InstructorFrame extends JFrame {

	private Instructor instructor;

	public InstructorFrame(Instructor instructor) {
		this.instructor = instructor;
		init();
	}

	private void init() {
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		
		JTabbedPane tabbedPane = new JTabbedPane();
		for(int i=0; i<instructor.getCourses().size(); i++){
			CoursePanel panel = new CoursePanel(instructor.getCourses().get(i));
			tabbedPane.addTab(instructor.getCourses().get(i).getId(),panel);
		}
		
		this.add(tabbedPane);
		
		this.setVisible(true);

	}

}

