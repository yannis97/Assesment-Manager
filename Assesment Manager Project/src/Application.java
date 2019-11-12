import java.util.ArrayList;
import java.util.List;

public class Application {

	public static void main(String[] args) {
		
		// Integer list manipulation example 
		List<Integer> myList= new ArrayList<Integer>();
		myList.add(1);
		myList.add(2);
		myList.add(3);
		System.out.println(myList);
		// or rather like this 
		int[] myArray = new int[]{7,2,4};

		for (int number: myList) {
			System.out.println(number);
		}
		
		
		
		// Teacher object
		Teacher Combe=new Teacher("Combefis",14,"PWD");  
		System.out.println(Combe.name);
		// Teacher object list 
		List<Teacher> myTeachers= new ArrayList<Teacher>();
		myTeachers.add(Combe);
		System.out.println(myTeachers.get(0).name);
	

	}

}
