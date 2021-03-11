package Model;
import java.util.*;

public final class Student extends Person {
	private ArrayList<Course> enrolledCourses = new ArrayList<Course>() ;
	private ArrayList<GradeItem> grades= new ArrayList<GradeItem>();
	
	public Student(String name){
		super(name);
	}
	
	public void initEmail(){
		String[] name1= new String[2];
		name1=getName().toLowerCase().split(" ");
		setEmail(name1[0]+"."+name1[1]+"@ozu.edu.tr");
	}
	
	public void registerToCourse(Course course){
		if(course.getInstructor()==null)
			System.out.println("Course not available");
		else{
			enrolledCourses.add(course);
			course.addStudent(this);
		}	
	}
	
	public void dropCourse(Course course){
		for(Course c: enrolledCourses){
			for(int i=0; i<c.getStudents().size();i++){
				if(c.getStudents().get(i).getName().equals(this.getName())){
					c.removeStudent(this);
				}
			}
		}
		enrolledCourses.remove(course);
	}

	public void addGrade(GradeItem gradeItem){
		grades.add(gradeItem);
	}
	
	public GradeItem getGradeItem(String courseId, String examId){
		for(GradeItem g: grades){
			if(g.getCourseId().equals(courseId) && g.getExamId().equals(examId)){
				return g;
			}
		}
		return grades.get(0);
	}
	
	public ArrayList<GradeItem> getGrades(){
		return grades;
	}
	
	public void listGrades(){
		boolean control=true;	
		for(int i=0; i<grades.size();i++){
			if(i!=0){
				for(int j=i-1;j<=0;j--){
					if(grades.get(i).getCourseId().equals(grades.get(j).getCourseId())){
						control= false;
						break;
					}
				}
			}	
			if(control){
				System.out.print("\n"+grades.get(i).getCourseId()+" grades of "+this.getName()+": "+grades.get(i));
				for(int k=i+1; k<grades.size();k++){
					if(grades.get(i).getCourseId().equals(grades.get(k).getCourseId()))
						System.out.print(grades.get(k));
				}	
			}
			control=true;
		}	
		System.out.println("");
	}
}
