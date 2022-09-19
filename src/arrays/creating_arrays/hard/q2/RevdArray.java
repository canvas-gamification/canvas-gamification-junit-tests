package arrays.creating_arrays.hard.q2;

/*
Write a program that will ask the user for 5 numbers and initialize an integer array with the reverse of each number.
For example, if the user enters 432 as the 5th number, then the 5th array element will be 234. Assume only positive
numbers will be input.
To simplify your code, make sure you create a method called reverse() that takes a single integer as input and returns
an integer in a reversed format as output.
Sample output:
Enter a number to add to the array:
34
Enter a number to add to the array:
678
Enter a number to add to the array:
1
Enter a number to add to the array:
23
Enter a number to add to the array:
18525
43
876
1
32
52581
 */

import java.util.Scanner;

public class RevdArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter a number to add to the array: ");
            arr[i] = reverse(input.nextInt());
        }
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }

    public static int reverse(int n) {
        int reversed = 0;
        while (n > 0) {
            reversed = (reversed * 10) + n % 10;
            n = n / 10;
        }
        return reversed;
    }
}
