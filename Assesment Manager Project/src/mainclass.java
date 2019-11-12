import java.util.Scanner;
import java.lang.*;
public class mainclass {

	public static void main(String[] args) {
		
		Teacher combe=new Teacher("Combefis", 115, "YOLO");
		Course pythonCourse=new Course("Python","py",5);
		Course javaCourse=new Course("Java","ja",6);
		
		combe.addCourse(pythonCourse);
		combe.addCourse(javaCourse);
		
		Student Juki=new Student("Kirstein","Julien", 16000);
		Student JuGo=new Student("Gorjon","Julien", 16119);
		Student Yan=new Student("Argyrakis","Yannis", 16001);
		
		combe.addStudToCourse(Juki, "py");
		combe.addStudToCourse(JuGo, "py");
		combe.addStudToCourse(Yan, "py");
		combe.addStudToCourse(Juki, "ja");
		combe.addStudToCourse(JuGo, "ja");
		combe.addStudToCourse(Yan, "ja");
		
		combe.displayCourses();
		
		
		String courseCode="";
		int options = 0;
		int state = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("--- Assessment Manager 2000 ---");
		// GET PROFESSEUR NAME HERE
		Teacher teacher =combe;
		System.out.println("Bonjour professeur !");
		while (true)
		{
			//Course selection
			while(state == 0)
			{
				System.out.println("Sélectionnez le cours qui vous intéresse :");
				teacher.displayCourses();
				String codeInput=sc.nextLine();
				if(!teacher.checkCourseCode(codeInput)) {
					System.out.println("Erreur, veuillez entrez un cours valide !");
				}else{
					state = 1;
					courseCode=codeInput;
				}
			}
			
			while(state == 1)
			{
				System.out.println("Cours sélectionné : " + teacher.getCourseName(courseCode));
				System.out.println("Que souhaitez vous faire ? (0 = Encoder points | 1 = Stats & Affichage | 9 = Retour)");
				
				options = checkIntInput(sc);
				
			  	if( options == 0 || options == 1 || options == 9 ){
			  		if (options == 9){
			  			state = 0;
			  		}else{
						state = 2;
			  		}
				}else{
					System.out.println("Erreur, veuillez entrez une commande valide !");
					/*print ERROR*/  		
				}
			}
			while(state == 2)
			{
				if(options == 0){
					encoder(teacher,courseCode , sc);
					state = 1;
				}
				else if(options == 1){
					state = statistics_display(courseCode,sc);
					// Stats et affichage // at the end -> histogramme or graph
				}
				else { state = 0;} //Retour au menu du cours
			}            
		}
	}
	public static int encoder(Teacher teach, String courseCode , Scanner sc) 
	{
		int year;
		int studID;
		int points;

		System.out.println("--- Code du cours  : " + courseCode + " ---"); // CHERCHE LE STRING DU COURS
		System.out.println("Année académique :");
		year = checkIntInput(sc);
		System.out.println("Matricule de l'étudiant :");
		studID = checkIntInput(sc);
		System.out.println("Points obtenus : /20");
		points = checkIntInput(sc);
		if (points > 20) {
			points = 20;
		}
		// GET OBJECT STUDENT AND SET INFORMATIONS HERE !
		if(teach.encodePoints(courseCode, year, studID, points)==0) {
			System.out.println(studID + " - " + points + "/20 " + " - " + year + " - enregistré avec succès !");
			return 0;
		}else {
			System.out.println("Erreur : L'étudiant "+studID+" ne participe pas à ce cours.");
			return 1;
		}
	}
	
	public static int statistics_display(String courseCode , Scanner sc)
	{
		int option = 0;
		int local_state = 2;
		System.out.println("--- Cours ID : " + courseCode + " ---"); // CHERCHE LE STRING DU COURS
		System.out.println("Affichage (0 = Graphe élèves | 1 = Histogramme des points | 2 = Evolution moyenne par année | 9 = Retour)");
		option = checkIntInput(sc);
		if(option == 0)
		{
			
			System.out.println("*Graphe élève*");
			local_state = 2;
			return local_state;
		}
		else if (option == 1)
		{
			System.out.println("*Histogramme*");
			local_state = 2;
			return local_state;
		}
		else if (option == 2)
		{
			System.out.println("*Evolution Moyenne*");
			local_state = 2;
			return local_state;
		}
		else
		{
			if(option == 9)
			{
				local_state = 1;
				return local_state;
			}
			System.out.println("Veuillez entrez une commande valide !");
			local_state = 2;
			return local_state;
		}
	}
	public static int checkIntInput(Scanner sc){
		int i = 0;
		boolean validated = false;
		while(!validated) {
			try { 
				i = Integer.parseInt(sc.nextLine());
				validated = true;
			}
			catch(Exception e) {
				System.out.println("Erreur, veuillez entrez un nombre !");
			}
		}
		return i;
	}

}