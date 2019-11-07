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
		
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream is = loader.getResourceAsStream("encoder_data.txt");
		Scanner in = new Scanner(is);
		assertEquals(mainclass.encoder(0, in),0);
		
	}
	
	@Test
	void testStatisticsDisplay(){
		String graph = "0";
		String histogram = "1";
		String average = "2";
		String retour = "9";
		String[] options = new String[5];
		
		options[0] = graph;
		options[1] = histogram;
		options[2] = average;
		options[3] = retour;
		options[4] = "99";
		
		for (int i=0;i<options.length;i++){
			Scanner in = new Scanner(options[i]);
			if (options[i] == "9"){
				assertEquals(mainclass.statistics_display(0, in),1);
			}
			else {
				assertEquals(mainclass.statistics_display(0, in),2);
			}	
		}
	}

}
