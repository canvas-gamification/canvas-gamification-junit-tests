package loops.simple_programs_with_repitition.medium.q8;

/*
Write a program to convert a given binary number to a decimal.
*/

import java.util.Scanner;
public class OutTheBin
{
  public static void main( String[] args )
  {
     Scanner input = new Scanner( System.in );
     System.out.println( "Enter a binary number : " );
     int n = input.nextInt();
     int i = 0;
     int d;
     int result = 0;
     while( n > 0 ) 
     {
        d = n % 10;
        result += d * Math.pow( 2, i ); 
        i++;  
        n = n / 10;
     }
     System.out.println( "Decimal Number: " + result );
  }
}
