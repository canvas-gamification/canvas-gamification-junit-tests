package arrays.arrays_with_methods.hard.q13;

/*
Write a program that asks the user to enter a number that we will call "n". Then, the program initializes an integer
array with the first n prime numbers then prints that array. Note that prime numbers start from 2.
When generating prime numbers, you can simply loop through integers one by one while checking to see if that integer
is prime or not. To do this, make sure you write a method called isPrime that takes an integer as input and returns true
if that number is a prime number but false otherwise.
Sample output:
Enter the size of the array:
5
2
3
5
7
11
 */

import java.util.Scanner;

public class ArrayngeOfPrimes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = input.nextInt();
        int[] arr = new int[n];
        int primeCount = 0;
        int elem = 2;
        while (primeCount < n) {
            if (isPrime(elem)) {
                arr[primeCount] = elem;
                primeCount++;
            }
            elem++;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }

    public static boolean isPrime(int n) {
        int c = 0;
        for (int i = 1; i <= n; i++)
            if (n % i == 0)
                c++;
        return (c == 2);
    }
}
