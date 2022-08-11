package arrays.programs_involving_data_sequences.medium.q5;

/*
Make a program that calls a method named deleteThis that takes an array of integers and another target integer as
parameters. The method tries to find and replace the target number in the array with 0. Note that there could be
multiple numbers in the array matching the target. In that case, the method should replace all with 0. Also, the method
should return the index of the number it replaces, and if it replaces multiple, it should return the last index. Then,
the program should print out the returned index and the array with the replaced values.

Sample Output:
    The number at index 5 was replaced.
    The array is now: 1 3 5 0 9 0

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

public class DoTheDeletion {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 7};
        int index = deleteThis(arr, 7);
        System.out.println("The number at index " + index + " was replaced.");
        System.out.print("The array is now: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
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
