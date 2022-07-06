package arrays.programs_involving_data_sequences.medium.q5;

/*
Make a program that asks the user to input an array length, and then the numbers for that array. If the entered length
is less than one, the program should print "Invalid array length!". After getting the array, the program should ask the
user for a number in the array to be replaced, and then the program should call a method named deleteThis that takes as
input the array and number to be replaced. The method tries to find the number in the array, and if found, the value in
the array is set to 0 and the method stores the index where that value was found. Note that there could be multiple
numbers in the array matching the target. In that case, the method returns the index of the last match. If none of the
numbers in the array match the target number, then the method returns -1 instead. The main method should then print out
the array.

Sample Output:
    Enter the desired array length:
    3
    Enter the numbers for the array:
    1
    2
    1
    Enter the number to be replaced:
    1
    0 2 0

Distractors:
    return = num;
    double delete = -1;
    public static void deleteThis( int [] arr, int num )
    return - 1;
    break;
    int[] arr = new int[3];
    arr[i++] = 0;
    {
    }
    if(arr[i] == delete)
    if(length >= 0)
    int delete = 0;
    return arr;
 */

import java.util.Scanner;

public class DoTheDeletion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the desired array length: ");
        int length = input.nextInt();
        if (length > 0) {
            int[] arr = new int[length];
            System.out.println("Enter the numbers for the array: ");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = input.nextInt();
            }
            System.out.println("Enter the number to be replaced: ");
            int replace = input.nextInt();
            int index = deleteThis(arr, replace);
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        } else {
            System.out.println("Invalid array length!");
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
