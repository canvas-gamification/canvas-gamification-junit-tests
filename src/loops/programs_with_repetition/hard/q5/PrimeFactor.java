package loops.programs_with_repetition.hard.q5;
/*
Write a java program that asks the user for a number and prints out the factors of that number that are also primes.
Sample Output:
    Enter a number:
    36
    Factors of 36 that are prime numbers are:
    2 3
 */
import java.util.Scanner;
public class PrimeFactor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number:");
        int n = input.nextInt();
        System.out.println("Factors of " + n + " that are prime numbers are:");
        for (int i = 1; i <= n; i++)
            if (n % i == 0) {
                int factorCount = 0;
                for (int j = 1; j <= i; j++)
                    if (i % j == 0)
                        factorCount++;
                if (factorCount == 2)
                    System.out.print(i + " ");
            }
    }
}
