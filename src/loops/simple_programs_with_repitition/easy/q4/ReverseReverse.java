package loops.simple_programs_with_repitition.easy.q4;

/*
Write a program to reverse a number.
Example: 1234 -> 4321
*/

import java.util.Scanner;

public class ReverseReverse {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.println("Enter a number : ");
      int n = input.nextInt();
      int reverse = 0;
      while (n > 0) {
         reverse = (reverse * 10) + (n % 10);
         n = n / 10;
      }
      System.out.println("Reversed Number: " + reverse);
   }
}
