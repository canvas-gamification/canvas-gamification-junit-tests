package methods.modular_programs.hard.q2;
/*
Write a program that will accept a string from the user that doesn't have any spaces and send it to a method called
addSpace that accepts a string as a parameter and will add spaces between the words. The method should store this in a
new string and return it. Your program should print the spaced string in the main method ("The string with spaces is: x.").
Assume that the first letter of every word is a capital letter. If an empty string is passed to your method, it should
return an empty string. Note that your string should not have any extra spaces at the beginning or end
(example: "Today Is A New Day"). Ensure that your output matches the sample.

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
