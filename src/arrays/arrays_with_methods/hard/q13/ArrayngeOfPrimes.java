package arrays.arrays_with_methods.hard.q13;

/*
Write a program that asks the user to enter an array of 10 integers. Then, the program passes the array to a method
called getPrimes which identifies all the primes in the given array as an integer n and returns them in a new array of
size n. The main method should then print the array of primes. Note that prime numbers start from 2 since they must be
divisible only by 1 and themselves. Your getPrimes method should be generalized to work with an array of any size.

Sample output:
    Enter an array of 10 integers:
    1 2 3 4 5 6 7 8 9 10
    2
    3
    5
    7
 */

import java.util.Scanner;

public class ArrayngeOfPrimes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an array of 10 integers: ");
        int[] arr = new int[10];
        for(int x = 0; x < 10; x++){
            arr[x] = input.nextInt();
        }
        int[] primes = getPrimes(arr);
        for (int i = 0; i < primes.length; i++) {
            System.out.println(primes[i]);
        }
    }

    public static int[] getPrimes(int[] arr) {
        int[] hold = new int[arr.length];
        int primeCount = 0;
        int count = 0;
        for (int x = 0; x < arr.length; x++) {
            int n = arr[x];
            int c = 0;
            for (int i = 1; i <= n; i++)
                if (n % i == 0)
                    c++;
            if (c == 2){
                primeCount++;
                hold[count++] = n;
            }
        }

        int[] primes = new int[primeCount];
        System.arraycopy(hold, 0, primes, 0, primeCount);
        return primes;
    }
}
