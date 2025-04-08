package conditionals.simple_programs_with_decision_points.medium.q10;

import java.util.Scanner;

/*

Rearrange the following Java code snippets in the correct order to run a program to ask the user for their age 
and check whether they are of legal age to {vote} in a country, which happens to be {19}. 

Sample Output:
    What is your age?
    25
    Congrats, you can vote!

    What is your age?
    13
    You are not allowed to vote yet
 */

public class VirtualBouncer {
    public static void main( String [] args ) {
        Scanner input = new Scanner(System.in);
        System.out.println("What is your age?");
        int age = input.nextInt();       
        switch ((age >= 19) ? 1 : 0) {
           case 1:
              System.out.println("Congrats, you can vote!");
              break;
           default:
              System.out.println("You are not allowed to vote yet");
        }
     }
  
}
