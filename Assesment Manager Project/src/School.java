import java.util.HashMap;
import java.util.Map;

public class School {
	  public static String name;
	  private static String address;	
	  //private static Teacher ListTeacher[];
	  public Map<Integer,Student>studentsDico;
	  public Map<Integer,Teacher>teachersDico;

	  public School(String name, String address)
	  {  
		  this.name = name;
		  this.address = address;
		  this.studentsDico=new HashMap<Integer,Student>();
		  this.teachersDico=new HashMap<Integer,Teacher>();
		  //this.ListTeacher = ListTeacher;			  
	  }
	  
	  public void addTeacher(Teacher teach) {
		  this.teachersDico.put(teach.ID_number,teach);
	  }
	  
	  public void addStudent(Student stud) {
		  this.studentsDico.put(stud.ID_number,stud);
	  }
}
