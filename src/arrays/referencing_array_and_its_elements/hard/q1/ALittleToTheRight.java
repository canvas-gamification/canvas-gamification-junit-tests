package arrays.referencing_array_and_its_elements.hard.q1;

/*
Write a program called ALittleToTheRight, with a method called LilToDaRight, that will take an array of ten integers and
shift the elements of the array forward by one. For example, the element at index 1 will move to index 2, and so on.
Then, the last element of the array will shift to the front of the array. Create a method called lilToDaRight to do
this. It should take an integer array and return the array with all the elements shifted. Finally, print the returned
array in the main method. The method should be general enough to work with an array of any length.
 */

import java.util.Scanner;

public class ALittleToTheRight {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[10];
        System.out.println("Enter 10 numbers:");
        for (int i = 0; i < 10; i++)
            arr[i] = in.nextInt();
        int[] changed = lilToDaRight(arr);
        System.out.println("The shifted array is:");
        for (int i = 0; i < changed.length; i++) {
            System.out.print(changed[i] + " ");
        }
    }

    public static int[] lilToDaRight(int[] argg) {
        int[] ans = argg;
        int last = ans[ans.length - 1];
        for (int i = ans.length - 1; i > 0; i--)
            ans[i] = ans[i - 1];
        ans[0] = last;
        return ans;
    }

}
