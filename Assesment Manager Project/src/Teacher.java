import java.util.ArrayList;
//import java.util.Dictionary;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Teacher{
	public String name;
	public int ID_number;
	private String passwd;
	//public List<Course> courseList;
	Map<String,Course>coursesDico; 
	

	
	public Teacher(String name,int ID,String passwd) {
		this.name= name;
		this.ID_number= ID;
		this.passwd= passwd;
		coursesDico=new HashMap<String,Course>();
		//courseList=new ArrayList<Course>();
		
	}
	
	public void addCourse(Course course) {

		coursesDico.put(course.code,course);
		//courseList.add(course);
	}
	
	public List<Course> getCourseList(){
		ArrayList<Course> coursesList = new ArrayList<>(coursesDico.values());
		return coursesList;
	}
	
	
	public boolean checkPasswd(String passwd) {
		return (this.passwd==passwd);
	}
	
	public void encodePoints(String courseCode, int id, float points) {
		coursesDico.get(courseCode).addPoints(id,points);
	}
}
