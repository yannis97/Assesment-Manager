import java.util.Scanner;
import java.lang.*;
public class mainclass {

	public static void main(String[] args) {
		
		int cours = 0;
		int options = 0;
		int state = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("--- Assessment Manager 2000 ---");
		// GET PROFESSEUR NAME HERE
		System.out.println("Bonjour professeur !");
		while (true)
		{
			// GET LIST OF COURS HERE
			//ID du cours qui nous intéresse Ex : " id_python = 0 "
			while(state == 0)
			{
				System.out.println("Sélectionnez le cours qui vous intéresse : (0 = Python | 1 = Java)");
				cours = checkIntInput(sc);
			  	if( cours != 0 ) //if cours is not in range of cours_id 
			  	{
					state = 0;
					System.out.println("Erreur, veuillez entrez un cours valide !");
					/*print ERROR*/
				}
				else 
				{
					state = 1;
				}
			}
			
			while(state == 1)
			{
				System.out.println("Cours sélectionné : " + cours); // Chercher le string du cours
				System.out.println("Que souhaitez vous faire ? (0 = Encoder points | 1 = Stats & Affichage | 9 = Retour)");
				
				options = checkIntInput(sc);
				
			  	if( options == 0 || options == 1 || options == 9 ){
			  		if (options == 9){
			  			state = 0;
			  		}else{
						state = 2;
			  		}
				}
			  	else{
					System.out.println("Erreur, veuillez entrez une commande valide !");
					state = 1;	
					/*print ERROR*/  		
				}
			}
			while(state == 2)
			{
				if(options == 0){
					encoder(cours , sc);
					state = 1;
				}
				else if(options == 1){
					state = statistics(cours,sc);
					// Stats et affichage // at the end -> histogramme or graph
				}
				else { state = 0;} //Retour au menu du cours
			}            
		}
	}
	private static void encoder(int cours , Scanner sc) 
	{
		int year;
		String name;
		String firstname;
		int point;

		System.out.println("--- Cours ID : " + cours + "---"); // CHERCHE LE STRING DU COURS
		System.out.println("Année académique :");
		year = checkIntInput(sc);
		System.out.println("Nom de l'étudiant :");
		name = sc.nextLine();
		System.out.println("Prénom de l'étudiant :");
		firstname = sc.nextLine();
		System.out.println("Points obtenus : /20");
		point = checkIntInput(sc);
		// CREATE OBJECT STUDENT AND SET POINT HERE !
		System.out.println("Points enregistrés avec succès !");
		System.out.println("");
	}
	private static int statistics(int cours , Scanner sc)
	{
		int option = 0;
		int local_state = 2;
		System.out.println("--- Cours ID : " + cours + " ---"); // CHERCHE LE STRING DU COURS
		System.out.println("Affichage (0 = Graphe élèves | 1 = Histogramme des points | 2 = Evolution moyenne par année | 9 = Retour)");
		option = checkIntInput(sc);
		if(option == 0)
		{
			
			System.out.println("*Graphe élève*");
			System.out.println("");
			local_state = 2;
			return local_state;
		}
		else if (option == 1)
		{
			System.out.println("*Histogramme*");
			System.out.println("");
			local_state = 2;
			return local_state;
		}
		else if (option == 2)
		{
			System.out.println("*Evolution Moyenne*");
			System.out.println("");
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
	private static int checkIntInput(Scanner sc){
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