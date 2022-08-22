package methods.modular_programs.medium.q6;

/**
 * [J] Write a program with a method called addUp to display a "single-digit
 * reduction" of a number taken from the user by adding up its digits until a
 * single-digit number is obtained. Eg. 567 becomes 5 + 6 + 7 = 18 = 1 + 8 => 9)
 */
import java.util.Scanner;

public class Reduceros {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter a number: ");
    int n = input.nextInt();
    int result = addUp(n);
    System.out.println(n + "'s single number reduction is " + result);
  }

  public static int addUp(int n) {
    int result = 0;
    while (true) {
      result += n % 10;
      n = n / 10;
      if (n <= 0) {
        if (result >= 10) {
          n = result;
          result = 0;
          continue;
        }
        break;
      }
    }
    return result;
  }
}
