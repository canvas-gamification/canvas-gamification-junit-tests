package loops.programs_with_repetition.easy.q3;
/*
Write a program to print the following pattern using nested loops for n = 5, where n is the number of lines long the
pattern is.
Sample Output (for n = 5):
 *****
  ****
   ...
    **
     *

 */
public class Pattern {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int k = 0; k <= i; k++)
                System.out.print(" ");
            for (int k = 1; k <= 5 - i; k++)
                System.out.print("*");
            System.out.println();
        }
    }
}
