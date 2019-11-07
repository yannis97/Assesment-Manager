
public class Course {
	public String name;
	public String code;
	public int creditNumber;
	// list of students that follow the course
	
	public Course(String courseName,String courseCode,int creditNumber) {
		this.name=courseName;
		this.code=courseCode;
		this.creditNumber= creditNumber;
	}
}
