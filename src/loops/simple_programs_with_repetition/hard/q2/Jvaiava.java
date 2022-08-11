package loops.simple_programs_with_repetition.hard.q2;
/*
Write a program that will convert a word into "Java Latin", which is done by only keeping the characters at even-numbered
places and adding "ava" at the end of the word. For example, "Sheep" becomes "Sepava". The program should prompt the
user to "Enter a word to be converted:" and then print what the word is in Java Latin. Assume that indexing starts at 0,
which is an even number, and the user enters a string. Ensure that your output matches the example.
Sample Output
    Enter a word to be converted:
    Sheep
    Sheep in Java Latin is Sepava
 */

import java.util.Scanner;

public class Jvaiava {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a word to be converted:");
        String str = input.next();
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 0)
                res += str.charAt(i);
        }
        System.out.println(str + " in Java Latin is " + res + "ava");
    }
}
