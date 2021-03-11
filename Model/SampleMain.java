package Model;
import java.util.*;

public class SampleMain {
	public static void main(String[] args) {
		System.out.println("-----------------1-------------------");
		Department department = new Department("Computer Science");

		department.addInstructor("Reyyan Yeniterzi");
		department.addInstructor("Reyhan Aydogan");
		department.addInstructor("Murat Sensoy");
		department.listInstructors();

		
		
		System.out.println("-----------------2-------------------");

		department.createCourse("CS102", "Object Oriented Programming");
		department.createCourse("CS201", "Data Structures");
		department.createCourse("CS101", "Introduction to CS");
		department.createCourse("CS404", "Digital Image Processing");

		department.listCourses();

		
		
		System.out.println("----------------3--------------------");

		department.assignInstructorToCourse("Reyyan Yeniterzi", "CS102");
		department.assignInstructorToCourse("Reyhan Aydogan", "CS101");
		department.assignInstructorToCourse("Reyyan Aydogan", "CS102");
		
		department.assignInstructorToCourse("Murat Sensoy", "CS333"); 

		department.listCourses();

		
		
		System.out.println("------------------4------------------");

		for (int i = 0; i < 10; i++)
			department.addStudent(createRandomName());

		department.listStudents();

		System.out.println("------------------5------------------");

		Course oop = department.getCourse("CS102");
		for (int i = 0; i < 5; i++) {
			Student student = department.getStudents().get(i);
			student.registerToCourse(oop);
		}

		oop.listStudents();

		
		
		System.out.println("-----------------6-------------------");

		Course intro = department.getCourse("Introduction to CS");
		for (int i = 0; i < 3; i++) {
			Student student = department.getStudents().get(i);
			student.registerToCourse(intro);
		}

		intro.listStudents();

		
		
		System.out.println("------------------7------------------");

		Student student = department.getStudents().get(2);
		student.dropCourse(oop);
		oop.listStudents();

		
		
		System.out.println("------------------8------------------");

		Course image = department.getCourse("CS404");
		student.registerToCourse(image); // no instructor is assigned to course, print error message

		
		
		System.out.println("-----------------9-------------------");

		Instructor reyyan = department.getInstructorByName("Reyyan Yeniterzi");
		reyyan.registerExamGrades("CS102", "Midterm-1");
		reyyan.registerExamGrades("CS102", "Midterm-2");

		Instructor murat = department.getInstructorByName("Murat Sensoy");
		murat.registerExamGrades("CS102", "Midterm-3"); // instructor murat does not have the course, print error

		Instructor reyhan = department.getInstructorByName("Reyhan Aydogan");
		reyhan.registerExamGrades("CS101", "Midterm-1");

		
		
		System.out.println("---------------------10---------------");

		Student student0 = department.getStudents().get(0);
		student0.listGrades();

		
		
		System.out.println("-------------------11-----------------");

		reyyan.listGradesForExam("CS102", "Midterm-1");

		
		
		System.out.println("------------------12------------------");

		reyyan.printAverageGradeForExam("CS102", "Midterm-1");

	}

	/*
	 * creates a random name
	 */
	private static String createRandomName() {
		String[] firstNames = { "Ali", "Ayse", "Ahmet", "Mehmet", "Mustafa", "Gizem", "Sibel", "Burak", "Bahar" };
		String[] lastNames = { "Yilmaz", "Caliskan", "Korkmaz", "Kaya", "Akar", "Sonmez", "Celikoglu" };

		Random random = new Random();

		String firstName = firstNames[random.nextInt(firstNames.length)];
		String lastName = lastNames[random.nextInt(lastNames.length)];
		String name = firstName + " " + lastName;

		return name;

	}

}



