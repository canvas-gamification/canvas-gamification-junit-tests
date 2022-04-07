package loops.simple_programs_with_repitition.easy.q5;

/*
Write a program that will ask the user for a sentence and then prints out the number of words 
in the user's sentence. (Hint:  Assume that the number of words = number of spaces + 1 ). 
Always assume the input is a sentence.
*/

import java.util.Scanner;
public class WordCount
{
   public static void main( String[] args )
   {
      Scanner input = new Scanner( System.in );
      System.out.println( "Enter a sentence: " );
      String sent = input.nextLine(); 
      sent.toLowerCase();
      int count = 0; 
      for(int i = 0; i < sent.length(); i++) 
         if( sent.charAt(i) == ' ' )
            count++;
      System.out.println("The number of words in the sentence is " + ( count + 1 ) + " words.");
   }
}
