package pre_defined_classes.simple_programs_taking_string_user_input.hard.q9;

/*
Make a program that asks the user for a sentence and then searches the sentence to see if it contains the words
"computer" or "science". The program should print true or false for if it contains these words, and the search should
ignore capitalization. Ensure your output matches the sample.

Sample output:
    Please enter a sentence:
    Science rules.
    Does the sentence contain the word computer? false
    Does the sentence contain the word science? true

Distractors:
Scanner input = new Scanner(System.out);
Systems.out.println( "Please enter a sentence:" );
string name = input.next();
{
}
System.in.println( "Does the sentence contain the word computer? " );
containsScience = sentence.endsWith("science");
boolean containsScience, containsComputer;
containsScience = sentence.contains("science");
containsComputer = sentence.contains("computer");
containsComputer = sentence.startsWith("computer");

 */

import java.util.Scanner;

public class SentenceSearch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a sentence: ");
        String sentence = input.nextLine();
        sentence = sentence.toLowerCase();
        boolean containsComputer = sentence.contains("computer");
        boolean containsScience = sentence.contains("science");
        System.out.println("Does the sentence contain the word computer? " + containsComputer);
        System.out.println("Does the sentence contain the word science? " + containsScience);
    }
}
