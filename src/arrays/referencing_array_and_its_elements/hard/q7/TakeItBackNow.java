package arrays.referencing_array_and_its_elements.hard.q7;
/*
Write a java program that takes an array of ten integers as input and reverses it. For example, the array {1, 2, 3, 4}
would become {4, 3, 2, 1}. To do this, create a method called rev that takes an array and reverses it by placing the
elements in a new array in reverse order. Then, return this array and print it in the main method.

Sample Output:
    Enter an array of 10 integers to reverse:
    1 2 3 4 5 6 7 8 9 10
    The reverse of the array is:
    10 9 8 7 6 5 4 3 2 1
 */

import java.util.Scanner;

public class TakeItBackNow {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an array of 10 integers to reverse:");
        for (int i = 0; i < 10; i++)
            arr[i] = in.nextInt();
        System.out.println("The reverse of the array is:");
        System.out.println(Rev(arr));

    }

    public static String Rev(int[] arr) {
        String ans = "";
        int[] reverse = new int[arr.length];
        for (int i = 0, j = arr.length - 1; i < arr.length; i++, j--) {
            reverse[i] = arr[j];
        }
        for (int i = 0; i < reverse.length; i++)
            ans += reverse[i] + " ";

        return ans.trim();
    }
}
