package Model;
import java.util.*;

public final class Instructor extends Person {
	private ArrayList<Course> courses= new ArrayList<Course>();
	
	public Instructor(String name){
		super(name);
	}
	
	public void addCourse(Course course){
		courses.add(course);
	}
	
	public void initEmail(){
		String[] name1=new String[2];
		name1= this.getName().toLowerCase().split(" ");
		this.setEmail(name1[0]+"."+name1[1]+"@ozyegin.edu.tr");
	}
	
	public void registerExamGrades(String courseId, String examId){
		Random rand = new Random();
		boolean courseControl = false;
		for(Course c: courses){
			if(c.getId().equals(courseId)){	
				courseControl=true;
				for(int i=0; i<c.getStudents().size(); i++){
					int g = rand.nextInt(101);
					GradeItem grade = new GradeItem(courseId,examId,g);
					c.getStudents().get(i).addGrade(grade);
					}	
				}	
		}
		if(courseControl==false)
			System.out.println("Instructor "+this.getName()+" cannot grade the course "+courseId);
	}
	
	public void listGradesForExam(String courseId, String examId){
		System.out.println(courseId+" "+examId+" grades are:");
		for(Course c: courses){
			if(c.getId().equals(courseId)){
				for(int i=0; i<c.getStudents().size(); i++){
					System.out.println(c.getStudents().get(i).getName()+": "+c.getStudents().get(i).getGradeItem(courseId, examId));
				}
			}
		}
	}
	
	public void printAverageGradeForExam(String courseId, String examId){
		double sum=0;
		int count=0;
		
		
		for(Course c: courses){
			if(c.getId().equals(courseId)){
				for(int i=0; i<c.getStudents().size();i++){
					if(c.getStudents().get(i).getGradeItem(courseId, examId).getExamId().equals(examId)){
						sum+=c.getStudents().get(i).getGradeItem(courseId, examId).getGrade();
						count+=1;
					}
				}
			}
		}
		if(count==0)
			System.out.println("There is no student in the course");
		else
			System.out.println(courseId+" "+examId+" average grade is: "+sum/count);
	}
	
	public ArrayList<Course> getCourses(){
		return courses;
	}
}
