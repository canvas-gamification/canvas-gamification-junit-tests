package arrays.programs_involving_data_sequences.hard.q1;

/*
Write a program that prompts the user to enter an array of positive numbers in the range of 0 and 100  with length 14.
This program will also have a method called countThisPlease() that takes the array and integer as input and counts the
number of items in it which are below the pivot, equal to the pivot, and above the pivot. Assume for this question the pivot
is equal to 45, but your method should be generalized to handle all cases. The values calculate in the method should be
returned as a new array of length 3, in the order numbers below, numbers equal to, and then numbers above the pivot.
Finally, the main method should print out this array, with one element on each line. Ensure your output matches the sample.

Sample Output:
    Please enter n numbers:
    1
    11
    49
    ...
    n
    The number of numbers below 45 is x
    The number of numbers equal to 45 is y
    The number of numbers above 45 is z

 */
import java.util.Scanner;

public class CountArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int [] arr = new int[14];
        System.out.println("Please enter 14 numbers:");
        for(int i = 0; i < 14; i++)
            arr[i] = input.nextInt();
        int[] arrCount = countThisPlease(arr, 45);
        System.out.printf("The number of numbers below %d is: %d\n", 45, arrCount[0]);
        System.out.printf("The number of numbers equal to %d is: %d\n", 45, arrCount[1]);
        System.out.printf("The number of numbers above %d is: %d\n", 45, arrCount[2]);
    }

    public static int[] countThisPlease(int[] nums, int pivot) {
        int above = 0;
        int equal = 0;
        int below = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < pivot)
                below++;
            else if(nums[i] == pivot)
                equal++;
            else
                above++;
        }
        return new int[]{below, equal, above};
    }
}
