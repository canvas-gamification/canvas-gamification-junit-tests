package methods.method_overloading.hard.q8;

/*
Write a Java Program with an overloaded method called printType which can take either an integer or a double. In the
given main method, printType is passed the integer 14 and on a new line the double 61.34. You must write the overloaded methods and
pass back a string containing the associated data type to be printed.

Sample Output:
The data type associated with 14 is: int
	The data type associated with 61.34 is: double
 */

public class FindDataType
{
   public static void main( String[] args )
      {
         System.out.println("The data type associated with 14 is: " + printType( 14 ));
         System.out.println("The data type associated with 61.34 is: " + printType( 61.34 ));
      }
   public static String printType( int x)
      {
         return "int";
      }
   public static String printType ( double x)
      {
         return "double";
      }

}
