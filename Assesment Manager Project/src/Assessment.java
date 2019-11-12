import java.io.Serializable;

public class Assessment implements Serializable {
	public static float Result;
  private static String AcademicYear;

  public Assessment(float Result, String AcademicYear)
  {  
	  this.Result = Result;
	  this.AcademicYear = AcademicYear;  
  }
}
