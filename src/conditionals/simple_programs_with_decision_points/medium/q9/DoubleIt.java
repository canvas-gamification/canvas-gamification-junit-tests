package conditionals.simple_programs_with_decision_points.medium.q9;
import java.util.Scanner;

/*
 Rearrange the following Java code snippets in the correct order to run a program that will ask the user for their 
 {investment} and double it if it is above ${5000}

Sample Output:
    Enter your investment in $ 
    6000
    Investment : $12000.0

    Enter your investment in $ 
    4500
    Investment : $4500.0
 */


public class DoubleIt {

    public static void main( String [] args ) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your investment in $ ");
        double number = input.nextDouble();
        
        switch (number > 5000 ? 1 : 0) {
           case 1: 
              number *= 2; 
              break;
        }
        
        System.out.println("Investment : $" + number);
     }
  
    
}
