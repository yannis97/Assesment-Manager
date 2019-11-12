import java.io.Serializable;

public class Address implements Serializable {
	public static int PostalCode;
	  private static String Street;	
	  private static int Number;

	  public Address(int PostalCode, String Street, int Number)
	  {  
		  this.PostalCode = PostalCode;
		  this.Street = Street;
		  this.Number = Number;			  
	  }
}
