import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Scanner;
import java.util.Random;
import java.io.*;

class testmainclass {
	
	@Test
	void testIntInput(){
		Random rand = new Random();
		// Obtain a number between [0 - 99].
		int i = rand.nextInt(100);
		String to_check = Integer.toString(i);
		Scanner in = new Scanner(to_check);
		assertEquals(mainclass.checkIntInput(in), i);
		
	}
	
	@Test
	void testEncoder()
	{
		Teacher combe=new Teacher("Combefis", 115, "YOLO");
		Course csharpCourse=new Course("Csharp","c#",5);
		combe.addCourse(csharpCourse);
		
		Student Yan=new Student("Argyrakis","Yannis", 16133);
		combe.addStudToCourse(Yan, "c#");
		
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream is = loader.getResourceAsStream("encoder_data.txt");
		Scanner in = new Scanner(is);
		
		assertEquals(mainclass.encoder(combe,"c#",in),0);
		
	}
	
	@Test
	void testStatisticsDisplay(){
		Teacher combe=new Teacher("Combefis", 115, "YOLO");
		Course csharpCourse=new Course("Csharp","C#",5);
		

		
		combe.addCourse(csharpCourse);
		
		Student JuKi=new Student("Kirstein","Julien", 16000);
		Student JuGo=new Student("Gorjon","Julien", 16119);
		Student Yan=new Student("Argyrakis","Yannis", 16001);
		
		csharpCourse.addPoints(2019, 16119, 16);
		csharpCourse.addPoints(2019, 16001, 15);
		csharpCourse.addPoints(2019, 16000, 10);
		
		
		combe.addStudToCourse(JuKi, "C#");
		combe.addStudToCourse(JuGo, "C#");
		combe.addStudToCourse(Yan, "C#");
		
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream is = loader.getResourceAsStream("data_stats.txt");
		Scanner in = new Scanner(is);
		assertEquals(mainclass.statistics_display(combe,"C#", in),2);

	}

}