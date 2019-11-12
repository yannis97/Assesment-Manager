import java.util.ArrayList;
import java.util.List;
//import java.util.Dictionary;
//import java.util.Hashtable;
import java.util.HashMap;
import java.util.Map;


public class Course {
	public String name;
	public String code;
	public int creditNumber;
	public List<Student> studentList;
	Map<Integer,Student> studentDico;
	//Dictionary<Integer, Dictionary> years_points_dico = new Hashtable<Integer, Dictionary>();
	//Dictionary<Integer, Float> points2019_dico = new Hashtable<Integer, Float>();
	Map<Integer,HashMap<Integer,Float>>pointsDico;

	
	public Course(String courseName,String courseCode,int creditNumber) {
		this.name=courseName;
		this.code=courseCode;
		this.creditNumber= creditNumber;
		studentList=new ArrayList<Student>();
		studentDico=new HashMap<Integer,Student>();
		pointsDico=new HashMap<Integer,HashMap<Integer,Float>>();
		
		//points2019_dico.put(16119,(float)15.0);
		//points2019_dico.put(16150,(float)16.0);
		//years_points_dico.put(2019, points2019_dico);
	}
	
	public void addStudent(Student stud) {
		this.studentDico.put(stud.ID_number, stud);
		studentList.add(stud);
	}
	
	public boolean hasStudent(int ID) {
		return this.studentDico.containsKey(ID);
	}
	
	public void addPoints(int year, int id, float points) {
		if(!pointsDico.containsKey(year)) {
			pointsDico.put(2019, new HashMap<Integer,Float>());
		}
		pointsDico.get(year).put(id, points);
	}
	
}
