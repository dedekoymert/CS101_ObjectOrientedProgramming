package Model;

public final class GradeItem {
	private String courseId;
	private String examId;
	private int grade;
	
	public GradeItem(String courseId, String examId, int grade){
		this.courseId=courseId;
		this.examId=examId;
		this.grade=grade;
	}
	
	public String getCourseId(){
		return this.courseId;
	}
	
	public String getExamId(){
		return this.examId;
	}
	
	public int getGrade(){
		return this.grade;
	}
	
	public String toString(){
		return "["+examId+" "+grade+"]";
	}
}
