package loops.programs_with_repetition.medium.q1;

/*
Write a program to print the following pattern using nested loops :
    *
   **
  ***
 ****
*****
 ****
  ***
   **
    *
 */
public class DiamondCantBreak {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            for (int j = 5 - i; j >= 1; j--)
                System.out.print(" ");
            for (int k = 1; k <= i; k++)
                System.out.print("*");
            System.out.println();
        }
        for (int i = 1; i <= 4; i++) {
            for (int k = 1; k <= i; k++)
                System.out.print(" ");
            for (int j = 5 - i; j >= 1; j--)
                System.out.print("*");
            System.out.println();
        }
    }
}
