import java.util.ArrayList;
import java.util.List;
//import java.util.Dictionary;
//import java.util.Hashtable;
import java.util.HashMap;
import java.util.Map;
import java.io.Serializable;

public class Course implements Serializable {

	public String name;
	public String code;
	public int creditNumber;
	public Map<Integer,Student> studentDico;
	public Map<Integer,HashMap<Integer,Integer>>pointsDico;

	
	public Course(String courseName,String courseCode,int creditNumber) {
		this.name=courseName;
		this.code=courseCode;
		this.creditNumber= creditNumber;
		studentDico=new HashMap<Integer,Student>();
		pointsDico=new HashMap<Integer,HashMap<Integer,Integer>>();
	}
	
	public void addStudent(Student stud) {
		this.studentDico.put(stud.ID_number, stud);
	}
	
	public boolean hasStudent(int ID) {
		return this.studentDico.containsKey(ID);
	}
	
	public void addPoints(int year, int id, int points) {
		if(!pointsDico.containsKey(year)) {
			pointsDico.put(year, new HashMap<Integer,Integer>());
		}
		pointsDico.get(year).put(id, points);
	}
	
	public int displayGraph(int year) {
		if(pointsDico.containsKey(year)) {
			for (Map.Entry<Integer,Integer> e : pointsDico.get(year).entrySet()){
			    System.out.print("Stud "+e.getKey()+" : ");
			    printNtimes(e.getValue(),"-");
			    System.out.println(e.getValue());

			}
			return 2; 
		}else {
			System.out.println("Aucun points n'ont été encodé pour cette année.");
			return 1;
		}
	}
	
	public int displayHistogram(int year) {
		if(pointsDico.containsKey(year)) {
			int[] frequencies=new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
			for (Map.Entry<Integer,Integer> e : pointsDico.get(year).entrySet()){
			    frequencies[e.getValue()-1]++;

			}
			System.out.println("Résultat  \\  Fréquence");

			int score=0;
			for(int freq:frequencies) {
				if(score<10)System.out.print(' ');  // align with two digit numbers
				System.out.print(score);
				printNtimes(freq,"-");
				System.out.println(' ');
				score++;
			}
			
			return 2; 
		}else {
			System.out.println("Aucun points n'ont été encodés pour cette année.");
			return 1;
		}
	}
	
	public void printNtimes(int n,String charact) {
		for(int i=0; i<n; i++) {
			System.out.print(charact);
		}
	}
}
