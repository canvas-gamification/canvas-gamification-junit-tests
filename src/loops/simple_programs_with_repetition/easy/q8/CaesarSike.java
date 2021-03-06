package loops.simple_programs_with_repetition.easy.q8;

/*
Write a program that will ask the user for a sentence and encrypt 
the sentence by adding a set number, that the user enters, to each character. 
( Hint: "ABC" offset by 2 becomes "CDE" ). 
The offset will not take negative numbers due to negative values of the ASCII table. 
Always assume the input is a sentence.
*/

import java.util.Scanner;
public class CaesarSike
{
   public static void main( String[] args )
   {
      Scanner input = new Scanner( System.in );
      System.out.println( "Enter a sentence: " );
      String sent = input.nextLine();
      System.out.println( "Enter a number to offset by: " );
      int off = input.nextInt();
      int i = 0; 
      String result = "";
      while( i < sent.length() )
      {
         result += (char)( sent.charAt(i) + off ) ;
         i++;
      }
      System.out.println("Your Encrypted Sentence is: " + result ); 
   }
}

