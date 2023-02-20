package arrays.creating_arrays.hard.q4;

/*
Write a program that asks the user for 50 names of students, stores those values in an array, and asks the user for
an index. Print the index and associated name from the array.
Sample output:
    Enter 50 names:
    Anne
    Will
    Abla Rey
    Titus
    Emilio
    Enter an index:
    3
    At index 3: Titus
 */

import java.util.Scanner;

public class RandomPickingNames {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 50 names: ");
        String[] sent = new String[50];
        for (int i = 0; i < sent.length; i++) {
            sent[i] = input.nextLine();
        }
        System.out.println("Enter an index: ");
        int index = input.nextInt();
        System.out.println("At index " + index + ": " + sent[index]);
    }
}
