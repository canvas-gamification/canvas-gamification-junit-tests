package loops.programs_with_repetition.medium.q4;

/*
 * Write a program to print the following pattern using nested loops : 
 * 
 * Sample output:
 *    * * * * *
 *     * * * *
 *      * * *
 *       * *
 *        *
 *       * *
 *      * * *
 *     * * * *
 *    * * * * *
 */

public class OurGlass {
  public static void main(String[] args) {
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < i; j++)
        System.out.print(" ");
      for (int k = 0; k < 5 - i; k++)
        System.out.print("* ");
      System.out.println();
    }
    for (int i = 1; i < 5; i++) {
      for (int j = 4 - i; j > 0; j--)
        System.out.print(" ");
      for (int k = 0; k <= i; k++)
        System.out.print("* ");
      System.out.println();
    }
  }
}
