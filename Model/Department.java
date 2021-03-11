package Model;
import java.util.*;

public final class Department {
	private String name;
	private ArrayList<Course> courses=new ArrayList<Course>();;
	private ArrayList<Instructor> instructors= new ArrayList<Instructor>();
	private ArrayList<Student> students= new ArrayList<Student>();; 
	
	public Department(String name){
		this.name=name;
	}
	
	public void addInstructor(String instructorName){
		instructors.add(new Instructor(instructorName));
	}
	
	public void addStudent(String studentName){
		students.add(new Student(studentName));
	}
	
	public void assignInstructorToCourse(String instructorName, String courseId){
	    boolean controlInstructor;
	    boolean controlId = false;
		for(Course c : courses){
			controlInstructor=false;
			if(c.getId().equals(courseId)){
				controlId=true;
				for(Instructor i: instructors){
					if(i.getName().equals(instructorName)){
						c.setInstructor(i);
						controlInstructor=true;
					}
				}
				if(controlInstructor==false)
					System.out.println("Instructor not found "+instructorName);
			}
		}
		if(controlId==false)
			System.out.println("Course not found "+courseId);	
	}
	
	public void createCourse(String courseId, String courseName){
		courses.add(new Course(courseId,courseName));
	}
	
	public ArrayList<Instructor> getInstructors(){
		return this.instructors;
	}
	
	public Course getCourse(String st){
		for(Course c: courses){
			if(c.getId().equals(st)||c.getName().equals(st)){
				return c;
			}
		}
		System.out.println("There is no "+st+" course");
		return null;
	}
	
	public ArrayList<Student> getStudents(){
		return this.students;
	}
	
	public Instructor getInstructorByName(String name){
		for(Instructor i: instructors){
			if(i.getName().equals(name))
				return i;
		}
		System.out.println("Instructor "+name+" is not on the list");
		return null;
	}

	public void listInstructors(){
		System.out.println("\nInstructors registered in this department are: ");
		for(Instructor i: instructors){
			System.out.println(i);
		}
	}
	
	public void listCourses(){
		System.out.println("\nCourses given by this department are: ");
		for(Course c: courses){
			if(c.getInstructor()==null)
				System.out.println(c);
			else 
				System.out.println(c+" by "+c.getInstructor().getName());
		}
	}
	
	public void listStudents(){
		System.out.println();
		for(Student s: students){
			System.out.println(s);
		}
	}
}
