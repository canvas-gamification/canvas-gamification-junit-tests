package arrays.referencing_array_and_its_elements.medium.q11;

/*
Write a Java program that asks the user for 30 names and stores them in an array of Strings. Then, count how many of the
names end with the letter "B" and display the value.

Sample Output:
    Enter 30 given names:
    Billy Bob Jacob Anthony ... Bartholomew Angus
    These 2 names end with the letter b:
    Bob Jacob
 */

import java.util.Scanner;

public class VowelNames {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] arr = new String[30];
        System.out.println("Enter 30 given names:");
        for (int i = 0; i < 30; i++)
            arr[i] = in.next();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].charAt(arr[i].length() - 1) == 'b')
                count++;
        }
        System.out.println("These " + count + " names end with the letter b:");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].charAt(arr[i].length() - 1) == 'b')
                System.out.print(arr[i] + " ");
        }
    }
}
