package Model;
import java.util.*;

public final class Course {
	private String id;
	private String name;
	private Instructor instructor;
	private ArrayList<Student> students = new ArrayList<Student>();
	
	public Course(String id, String name){
		this.id=id;
		this.name=name;
	}
	
	public void addStudent(Student student){
		students.add(student);	
	}
	
	public void removeStudent(Student student){
		students.remove(student);
	}
	
	public String getId(){
		return this.id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public Instructor getInstructor(){
		return this.instructor;
	}
	
	public ArrayList<Student> getStudents(){
		return this.students;
	}
	
	public void setInstructor(Instructor instructor){
		this.instructor=instructor;
		instructor.addCourse(this);
	}
	
	public void listStudents(){
		System.out.println("\nStudents registered in "+this.name+" are: ");
		for(Student s: students){
			System.out.println(s.getName());
		}
	}
	
	public String toString(){
		return id+" "+name;
	}
}
