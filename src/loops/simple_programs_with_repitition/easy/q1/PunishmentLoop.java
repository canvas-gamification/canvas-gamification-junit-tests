package loops.simple_programs_with_repitition.easy.q1;

/*
Write a program that will ask the user to input a sentence, and then ask them for a "n", that represents how many times the program should repeat the sentence.
Then print the entered sentence "n" times.
 Sample Output:
 Enter a sentence: Hello World
 Enter the number of times to repeat the sentence: 3
 Hello World
 Hello World
 Hello World
*/

import java.util.Scanner;
public class PunishmentLoop
{
   public static void main( String[] args )
   {
      Scanner input = new Scanner( System.in );
      System.out.println( "Enter a sentence: " );
      String sentence = input.nextLine(); 
      System.out.println( "Enter the number of times to repeat the sentence: " );
      int n = input.nextInt();
      for(int i = 0; i < n; i++) 
      {
         System.out.println( sentence );
      }
   }
}

