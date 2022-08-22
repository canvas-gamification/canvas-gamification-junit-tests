package methods.modular_programs.medium.q5;

/**
 * *Write a Java program with a method called divisionCalc to ask the user for a
 * number and calculate the sum of the following series: 20/1 + 20/2 + 20/3 +
 * 20/4 + 20/5 + 20/6 + … 20/n
 */
import java.util.Scanner;

public class DivSeries {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter a number for the upper bound of the series: ");
    int n = input.nextInt();
    int sum = divisionCalc(n);
    System.out.println("The sum of the series is " + sum);
  }

  public static int divisionCalc(int n) {
    int sum = 0;
    int i = 1;
    while (i <= n) {
      sum += 20 / i;
      i++;
    }
    return sum;
  }
}
