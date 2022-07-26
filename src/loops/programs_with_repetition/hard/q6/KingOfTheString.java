package loops.programs_with_repetition.hard.q6;

/*
Write a program named KingOfTheString that will ask the user for a sentence and then display the most common character in the given sentence.
Ignore the case of the characters in the sentence. When you print the most common character print it in lower case.

Sample Output:
Enter a sentence:
Hello Tallulah like the lovely weather?
l 8
 */

import java.util.Scanner;
public class KingOfTheString
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner( System.in );
        System.out.println( "Enter a sentence: " );
        String sent = input.nextLine();
        sent = sent.toLowerCase();
        char maxc = ' ';
        int maxn = 0;
        for(int i = 0; i < sent.length(); i++)
        {
            int count = 0;
            for(int j = 0; j < sent.length(); j++)
                if( sent.charAt(j) == sent.charAt(i) )
                    count++;
            if( count > maxn )
            {
                maxn = count;
                maxc = sent.charAt(i);
            }
        }
        System.out.println( maxc + " " + maxn);
    }
}
