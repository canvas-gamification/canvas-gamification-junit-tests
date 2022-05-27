package pre_defined_classes.simple_programs_taking_string_user_input.hard.q4;
/*
Plagiarism detection software is used to compare whether two essays or programming assignments are similar enough to
each other that one could have been a direct copy of the other. We consider a trivial case of plagiarism detection in
this question. Make a program that takes in two different paragraphs entered by the user and answers true or false to
the question of if two paragraphs are identical.

Sample Output:
	Enter the first paragraph:
    This is a paragraph about nothing. Thank you taking the time to read this.
    Enter the second paragraph:
    This is a paragraph about nothing. Thank you taking the time to read this.
    Are the two paragraphs identical? true

Distractors:
    String str1 = input.nextLine();
    String str1 = input.nextLine();
    String str1 = input.next();
    String str2 = input.next();
    boolean comparison = str1.equals( str1 );
    boolean comparison = equals( str1, str2 );
    boolean comparison = str2.equals( str2 );
    boolean comparison = str2.equals( str1 )

 */

import java.util.Scanner;

public class CompareStrings {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str1, str2;
        System.out.println("Enter the first paragraph:");
        str1 = input.nextLine();
        System.out.println("Enter the second paragraph:");
        str2 = input.nextLine();
        boolean comparison = str1.equals(str2);
        System.out.println("Are the two paragraphs identical? " + comparison);
    }
}
