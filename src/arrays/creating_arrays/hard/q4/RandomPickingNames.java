package arrays.creating_arrays.hard.q4;

/*
Write a program that asks the user for 5 names of students, and stores those values into an array and randomly picks an index and
prints the index and associated name from the array. The selected student will be chosen to answer questions in class.
Sample output:
Enter 5 names:
Anne
Will
Alba
Titus
Emilio
At index 1: Will
 */

import java.util.Scanner;

public class RandomPickingNames {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 5 names: ");
        String[] sent = new String[5];
        for (int i = 0; i < sent.length; i++) {
            sent[i] = input.nextLine();
        }
        int randInt = (int) (Math.random() * 5);
        System.out.println("At index " + randInt + ": " + sent[randInt]);
    }
}
