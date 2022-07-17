package loops.while_loops.hard.q8;

/*
Write a program that asks the user for a sentence and then counts the number of characters in the sentence using a while loop.
For this program, Space/' ' is not considered a character.
 */

import java.util.Scanner;
public class CounterChar
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner( System.in );
        System.out.println( "Enter a sentence: " );
        String sentence = input.nextLine();
        int count = 0;
        int i = 0;
        while( i < sentence.length() )
        {
            if(sentence.charAt(i) != ' ')
                count++;
            i++;
        }
        System.out.println( "Total number of Characters in the sentence: " +  count);
    }
}

