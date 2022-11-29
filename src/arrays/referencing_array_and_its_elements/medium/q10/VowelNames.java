package arrays.referencing_array_and_its_elements.medium.q10;

/*
Write a Java program that asks the user for 6 names and stores them in an array of Strings. Then, count how many of the
names start with the letter "B" and display the value.

Sample Output:
    Enter 6 given names:
    Billy Bob Jacob Anthony Bartholomew Angus
    There are 3 names that start with the letter B

 */

import java.util.Scanner;

public class VowelNames {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] arr = new String[6];
        System.out.println("Enter 6 given names:");
        for (int i = 0; i < 6; i++)
            arr[i] = in.next();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].charAt(0) == 'B')
                count++;
        }
        System.out.println("There are " + count + " names that start with the letter B");
    }
}
