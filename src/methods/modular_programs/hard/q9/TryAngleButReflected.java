package methods.modular_programs.hard.q9;

/**
 * [J]Write a program with a method called printPattern that takes in an integer
 * n, and print the following pattern using nested loops based on their input:
 * 1 2 3 4 5 … n
 * …
 * 1 2 3 4 5
 * 1 2 3 4
 * 1 2 3
 * 1 2
 * 1
 * 
 * Write a main method that asks the user for the number of lines, and then
 * calls the printPattern method.
 * 
 * Sample output:
 * Enter number of lines: 5
 * 1 2 3 4 5
 * 1 2 3 4
 * 1 2 3
 * 1 2
 * 1
 * 
 * Note: If the user enters a negative number, the program should print an error
 * message instead as seen in the sample
 * output below.
 * Sample output:
 * Enter number of lines: -3
 * Number must be positive
 * 
 */
import java.util.Scanner;

public class TryAngleButReflected {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter number of lines: ");
    int n = input.nextInt();
    printPattern(n);
  }

  public static void printPattern(int n) {
    if (n <= 0) {
      System.out.println("Number must be positive");
    }
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= (n - i + 1); j++)
        System.out.print(j + " ");
      System.out.println();
    }
  }
}
