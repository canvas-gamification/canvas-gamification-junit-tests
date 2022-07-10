package pre_defined_classes.simple_programs_taking_string_user_input.hard.q9;

/*
People all around the world use last names to identify their origins. Common last names include:"Silva" from Portugal
and "Johnson" meaning the son of John. Make a program that checks to see if a given name starts
with "Sil" or ends with "son" and prints true or false to both questions about the name's origin.

Sample output:
Please enter your last name:
Silvester
Is the person from Portugal? true
 "Does the person's name contain his/her parent's name? false

Distractors:
Scanner input = new Scanner(System.out);
Systems.out.println( "Please enter your last name" );
string name = input.nextLine();
{
}
System.in.println( "You are from Portugal." );
isPortugese = name.contains( "sil" );
boolean isPortugese, isSon;
isSon = name.endsWith( "son" );
isPortugese = name.startsWith( "sil" );
isSon = name.contains( "son" );

 */

import java.util.Scanner;

public class Origin {
    public static void main( String[] args )
    {
        Scanner input = new Scanner( System.in );
        System.out.println( "Please enter your last name:" );
        String name = input.nextLine();
        name = name.toLowerCase();
        boolean isPortugese = name.startsWith( "sil" );
        boolean isSon = name.endsWith( "son" );
        System.out.println( "Is the person from Portugal? " + isPortugese );
        System.out.println( "Does the person's name contain his/her parent's name? " + isSon );
    }
}
