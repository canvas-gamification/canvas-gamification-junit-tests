package loops.programs_with_repetition.hard.q1;
/*
Write a program to print the following pattern using nested loops with n = 5, where n is the starting number and the
number of lines. Make sure your output matches the sample.
Sample Output (n = 5):
    55555
    54444
    54333
    54322
    54321
 */
public class CascadingPattern {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 0; i < 5; i++) {
            for (int j = 5; j >= 5 - i; j--)
                System.out.print(j);
            for (int k = 1; k < 5 - i; k++)
                System.out.print(n);
            System.out.println();
            n--;
        }
    }
}
