package loops.programs_with_repetition.hard.q3;
/*
Write a Java program to accept a 3-digit number from the user and print out all possible combinations of unique
three-digit numbers that can be made using the digits of that number. For simplicity, assume that the user inputs a
three-digit positive number and will not input a digit with duplicate values, i.e. the digits will be unique. Make sure your
program matches the sample. (Hint: Use 3 nested for loops).
Sample Output:
    Enter a 3-digit number:
    369
    369
    396
    639
    693
    936
    963
 */
import java.util.Scanner;

public class PermutateThis {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a 3-digit number: ");
        String n = input.next();
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                for (int k = 0; k < 3; k++)
                    if (i != j && j != k && i != k)
                        System.out.println("" + n.charAt(i) + n.charAt(j) + n.charAt(k));
    }
}
