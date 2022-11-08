package arrays.referencing_array_and_its_elements.hard.q7;
/*
Write a java program that takes an array of 10 integers as an input and reverse it. Write a method called Rev that takes
an array and reverse it and then returns a string of the elements of array with a space between them, then print that
string in your main method (No extra spaces).

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
