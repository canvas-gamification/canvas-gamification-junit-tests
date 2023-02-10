package arrays.referencing_array_and_its_elements.medium.q10;

/*
Write a Java program that asks the user for 30 names and stores them in an array of Strings. Then, count how many of the
names start with the letter "B" and display the value, and the name in order that they appear.

Sample Output:
    Enter 30 given names:
    Billy Bob Jacob ...  Anthony Bartholomew Angus
    These are the 3 names that start with the letter B:
    Billy Bob Bartholomew
 */

import java.util.Scanner;

public class VowelNames {
    public static void main(String[] args) {
        int n = 30;
        Scanner in = new Scanner(System.in);
        String[] arr = new String[n];
        System.out.println("Enter " + n + " given names:");
        for (int i = 0; i < n; i++)
            arr[i] = in.next();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].charAt(0) == 'B')
                count++;
        }
        System.out.println("These are the " + count + " names that start with the letter B:");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].charAt(0) == 'B')
                System.out.print(arr[i] + " ");
        }
    }
}
