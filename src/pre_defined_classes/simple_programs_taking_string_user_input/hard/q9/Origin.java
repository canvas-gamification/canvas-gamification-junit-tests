package pre_defined_classes.simple_programs_taking_string_user_input.hard.q9;

/*
Make a program that asks the user for a sentence, and then searches the sentence to see if it contains the words
"computer" or "science". The program should print true or false for if it contains these words.

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
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a sentence:");
        String sentence = input.nextLine();
        sentence = sentence.toLowerCase();
        boolean containsComputer = sentence.contains("computer");
        boolean containsScience = sentence.contains("science");
        System.out.println("Does the sentence contain the word computer? " + containsComputer);
        System.out.println("Does the sentence contain the word science? " + containsScience);
    }
}
