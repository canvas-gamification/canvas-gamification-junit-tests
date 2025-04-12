package conditionals.nested_statements.q11;
import java.util.Scanner;

/*
 Rearrange the following Java code snippets to correctly implement a nested switch statement that determines 
 an item based on two input Strings, color and taste. The outer switch should handle color, and the inner 
 switch should handle taste within certain cases. The output should be a single string indicating the item.

 */


public class FruitIdentifier {

    public static void main( String [] args ) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter  your investment in $ ");
        double number = input.nextDouble();
        
        switch (number > 5000 ? 1 : 0) {
           case 1: 
              number *= 2; 
              break;
        }
        
        System.out.println("Investment : $" + number);
     }
  
    
}