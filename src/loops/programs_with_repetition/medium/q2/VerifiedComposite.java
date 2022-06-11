package loops.programs_with_repetition.medium.q2;
/*
Write a program that will ask the user for a number 'n' greater than 1 and list all composite numbers between 2 and 'n'
(inclusive). Composite Numbers are those that have more than 2 factors, i.e. the opposite of prime numbers. Make sure
that the program will keep asking for input until it receives valid input from the user, i.e. a number greater than 0,
and that your output matches the sample.
Sample Output:
	Enter an integer:
    -1
    Enter an integer:
    0
    Enter an integer:
    10
    4
    6
    8
    9
    10
 */
import java.util.Scanner;

public class VerifiedComposite {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        while (true) {
            System.out.println("Enter an integer:");
            n = input.nextInt();
            if (n > 1)
                break;
        }
        for (int i = 2; i <= n; i++) {
            int c = 0;
            for (int j = 1; j <= i; j++)
                if (i % j == 0)
                    c++;
            if (c > 2) {
                System.out.println(i);
            }
        }
    }
}
