package arrays.programs_involving_data_sequences.medium.q5;

/*
Make a program that calls a method that takes as input an array of numbers and another target number. The method tries
to find the target number in the array. If found, the value in the array is set to 0 and the method stores the index
where that value was found. Note that there could be multiple numbers in the array matching the target. In that case,
the method returns the index of the last match. If none of the numbers in the array match the target number, then the
method returns -1 instead. The main method should then print out the array.

Distractors:
    return = num;
    double delete = -1;
    public static void deletThis( int [] arr, int num )
    return - 1;
    break;
    arr[i++] = 0;
    {
    }
    if( arr[i] == delete )
    int delete = 0;
 */

import java.util.Scanner;
// 1, 3, 5, 7, 9, 7
public class DoTheDelete {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the desired array length: ");
        int length = input.nextInt();
        if (length >= 0) {
            int[] arr = new int[length];
            System.out.println("Enter numbers for array: ");
            for(int i = 0; i < arr.length; i++){
                arr[i] = input.nextInt();
            }
            System.out.println("Enter the number to be replaced: ");
            int replace = input.nextInt();
            deleteThis(arr, replace);
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        } else {
            System.out.println("Invalid array length");
        }
    }

    public static int deleteThis(int[] arr, int num) {
        int delete = -1;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == num) {
                arr[i] = 0;
                delete = i;
            }
        return delete;
    }
}
