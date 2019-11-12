import java.util.ArrayList;
//import java.util.Dictionary;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.io.Serializable;

public class Teacher implements Serializable {
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
	
	public void addStudToCourse(Student stud,String courseCode) {
		coursesDico.get(courseCode).addStudent(stud);
	}
	
	public List<Course> getCourseList(){
		ArrayList<Course> coursesList = new ArrayList<>(coursesDico.values());
		return coursesList;
	}
	
	public boolean checkCourseCode(String code){//Scanner sc) {
		return coursesDico.containsKey(code); //sc.nextLine());
	}
	
	public void displayCourses() {
		for (Map.Entry<String,Course> e : coursesDico.entrySet()){
		    System.out.print(e.getKey()+" = "+e.getValue().name + " | ");
		}
	}
	
	public boolean checkPasswd(String passwd) {
		return (this.passwd==passwd);
	}
	
	public int encodePoints(String courseCode,int year, int id, float points) {
		Course thisCourse=coursesDico.get(courseCode);
		if(thisCourse.hasStudent(id)){
			thisCourse.addPoints(year,id,points);
		}else {
			return 1;
		}
		return 0;
	}
	
	public String getCourseName(String code) {
		return this.coursesDico.get(code).name;
	}
}
