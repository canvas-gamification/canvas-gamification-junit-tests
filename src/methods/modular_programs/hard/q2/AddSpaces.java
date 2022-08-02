package methods.modular_programs.hard.q2;
/*
Write a program that will accept a string from the user that doesn't have spaces and send it to a method called "addSpace"
that accepts a string as a parameter and will add spaces between the words and store it in a separate string. The method
should return that string, which will then be printed in the main method. Assume that the first letter of every word is
a capital letter. If an empty string is passed your method, it should return an empty string. Note that your string
should not have any extra spaces at the beginning or end of the string (Example: "Today Is A New Day").

Sample Output:
    Enter a sentence:
    TodayIsANewDay
    The string with spaces is: Today Is A New Day.
 */

import java.util.Scanner;

public class AddSpaces {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String sentence = input.next();
        System.out.println("The string with spaces is: " + addSpace(sentence) + ".");
    }

    public static String addSpace(String sentence) {
        if (sentence.length() == 0)
            return sentence;
        String result = sentence.charAt(0) + "";
        for (int i = 1; i < sentence.length(); i++) {
            if (Character.isUpperCase(sentence.charAt(i)))
                result += " ";
            result += sentence.charAt(i);
        }
        return result;
    }
}
