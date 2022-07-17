package loops.while_loops.hard.q5;
/*
Write a program that will ask the user to input a number n, and print tall the terms in the fibonacci sequence up to
the nth term (inclusive) using a while loop. The ith term in the fibonacci series is obtained by adding the previous two
terms together. Assume the sequence starts with 0 and 1, so the next term would be 1, the term after that would be 2,
then 3, then 5, and so on. The pattern goes like 0, 1, 1, 2, 3, 5, 8 ...etc). Assume the user enters a valid
non-negative integer.
Sample Output:
    Enter a number:
    5
    Fibonacci Sequence: 0, 1, 1, 2, 3, 5,
 */
import java.util.Scanner;

public class FiboWhat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = input.nextInt();
        int n1 = 0, n2 = 1;
        System.out.print("Fibonacci Sequence: 0, ");
        int i = 0;
        while (i < n) {
            System.out.print(n2 + ", ");
            int temp = n1;
            n1 = n2;
            n2 = temp + n2;
            i++;
        }
    }
}
