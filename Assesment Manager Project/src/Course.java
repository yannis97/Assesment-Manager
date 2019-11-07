import java.util.ArrayList;
import java.util.List;
import java.util.Dictionary;
import java.util.Hashtable;


public class Course {
	public String name;
	public String code;
	public int creditNumber;
	public List<Student> studentList;
	Dictionary<Integer, Dictionary> years_points_list = new Hashtable<Integer, Dictionary>();
	Dictionary<Integer, Integer> points_list2019 = new Hashtable<Integer, Integer>();


	
	public Course(String courseName,String courseCode,int creditNumber) {
		this.name=courseName;
		this.code=courseCode;
		this.creditNumber= creditNumber;
		studentList=new ArrayList<Student>();
		
		points_list2019.put(16119,15);
		points_list2019.put(16150,16);
		years_points_list.put(2019, points_list2019);
	}
}
