import java.util.ArrayList;
import java.util.List;

public class Teacher{
	public String name;
	public int ID_number;
	private String passwd;
	public List<Course> courseList;
	
	// list of students that follow the course
	
	public Teacher(String name,int ID,String passwd) {
		this.name= name;
		this.ID_number= ID;
		this.passwd= passwd;
		courseList=new ArrayList<Course>();
		
	}
	
	public void addCourse(Course course) {
		courseList.add(course);
	}
	
	public List<Course> getCourseList(){
		return this.courseList;
	}
	
	
	public boolean checkPasswd(String passwd) {
		return (this.passwd==passwd);
	}
}
