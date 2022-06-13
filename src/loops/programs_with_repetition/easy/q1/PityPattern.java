package loops.programs_with_repetition.easy.q1;
/*
Write a program to print out the following pattern using nested loops with n = 5, where n is the number of rows:
1
22
333
4444
…
nnn…nnn
 */

public class PityPattern {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            for (int k = 1; k <= i; k++)
                System.out.print(i);
            System.out.println();
        }
    }
}
