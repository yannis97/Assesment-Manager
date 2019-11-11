import java.util.ArrayList;
import java.util.List;
//import java.util.Dictionary;
//import java.util.Hashtable;
import java.util.HashMap;
import java.util.Map;


public class Course {
	public String name;
	public String code;
	public int currentYear=2019;
	public int creditNumber;
	public List<Student> studentList;
	//Dictionary<Integer, Dictionary> years_points_dico = new Hashtable<Integer, Dictionary>();
	//Dictionary<Integer, Float> points2019_dico = new Hashtable<Integer, Float>();
	Map<Integer,HashMap<Integer,Float>>pointsDico;

	
	public Course(String courseName,String courseCode,int creditNumber) {
		this.name=courseName;
		this.code=courseCode;
		this.creditNumber= creditNumber;
		studentList=new ArrayList<Student>();
		pointsDico=new HashMap<Integer,HashMap<Integer,Float>>();
		
		//points2019_dico.put(16119,(float)15.0);
		//points2019_dico.put(16150,(float)16.0);
		//years_points_dico.put(2019, points2019_dico);
	}
	
	public void addStudent(Student stud) {
		studentList.add(stud);
	}
	
	public void addPoints(int id, float points) {
		pointsDico.get(currentYear).put(id, points);
		//pointsDico.put(2019,new HashMap(<Integer,Float> ){{put((int)16119,(float)16);}});
	}
	
}
