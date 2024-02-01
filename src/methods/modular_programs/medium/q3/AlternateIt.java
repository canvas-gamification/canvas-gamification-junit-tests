package methods.modular_programs.medium.q3;

/**
 * *Write a Java program called AlternateIt with a method called sumCalc to ask the user for a
 * number and calculate the sum of the following series: 1 - 2 + 3 - 4 + 5 - 6 + .. + n. The method should take an
 * integer n as input and return the sum of aforementioned series. In your main method take the number n in the
 * following format and print the answer.
 *
 * Sample Output:
 *    Enter a number for the upper bound of the series: 
 *    12
 *    The sum of the series is: -6
 */
import java.util.Scanner;

public class AlternateIt {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter a number for the upper bound of the series: ");
    int n = input.nextInt();
    int ans = sumCalc(n);
    System.out.println("The sum of the series is: " + ans);
  }

  public static int sumCalc(int n) {
    int sum = 0;
    for (int i = 0; i < n; i++)
      sum += Math.pow(-1, i) * (i + 1);
    return sum;
  }
}
