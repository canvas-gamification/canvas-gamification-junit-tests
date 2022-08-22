package methods.modular_programs.medium.q7;

/**
 * [J]Write a program with a method called perfectOrNot to accept a number from
 * the user and determine whether it is a "perfect" number. (Hint: A perfect
 * number is one whose factors sum up to equal the given number. Eg. 6 has
 * factors of 1, 2, and 3, whose sum is 6, so it is a perfect number)
 * 
 * Sample Output:
 *    Enter a number: 
 *    6
 *    perfect
 */
import java.util.Scanner;

public class NowThatsPerfect {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter a number: ");
    int n = input.nextInt();
    boolean result = perfectOrNot(n);
    if (result)
      System.out.println("perfect");
    else
      System.out.println("imperfect");
  }

  public static boolean perfectOrNot(int n) {
    int nn = n;
    int result = 0;
    int i = 1;
    while (i < n) {
      if (n % i == 0)
        result += i;
      i++;
    }
    if (result == nn)
      return true;
    else
      return false;
  }
}
