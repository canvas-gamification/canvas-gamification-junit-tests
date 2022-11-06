package arrays.referencing_array_and_its_elements.hard.q1;

/*
write a program called ALittleToTheRight, with a method called LilToDaRight, that will take a 10 integer array and shift
the elements of the integer array forward by one, using a method called lilToDaRight that takes an array and returns the
shifted array. For example, the element at index 4 will move to index 5, and so on. Then, the last element of the array
will be pushed to the front of the array. At the end, print the array in one line.
 */

import java.util.Scanner;
public class ALittleToTheRight {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[10];
        System.out.println("Enter 10 numbers:");
        for(int i = 0; i < 10; i ++)
            arr[i] = in.nextInt();
        int[] changed = lilToDaRight(arr);
        System.out.println("The shifted array is:");
        for(int i = 0; i < changed.length; i++) {
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
