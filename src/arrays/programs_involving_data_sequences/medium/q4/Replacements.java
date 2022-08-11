package arrays.programs_involving_data_sequences.medium.q4;

/*
Write a java program with a method named add this one, which takes an array and an integer and replaces one of the
elements in the array with the integer. The method should compute an index by summing the values in the array and taking
the modulus of the sum by the array length (sum % length). Then, it replaces the item at this index with the integer and
returns the array. Print the array with the new element in the main method. If the method receives an empty array,
return the empty array.

Sample Output:
    The array is now: 98 3 5 7 9

Distractors:
    int size = arr.length - 1;
    double size = arr.length;
    arr[ num ] = index;
    public static int addThisOne( int [] arr, int num )
    return index;
    {
    }
    return num;
    int replacement = addThisOne(arr, 98);
    System.out.print(arr[i] + " ");
 */

public class Replacements {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        int[] replacement = addThisOne(arr, 98);
        System.out.print("The array is now: ");
        for (int i = 0; i < replacement.length; i++) {
            System.out.print(replacement[i] + " ");
        }
    }

    public static int[] addThisOne(int[] arr, int num) {
        int size = arr.length;
        if (size == 0)
            return arr;
        int sum = 0;
        for (int i = 0; i < size; i++)
            sum += arr[i];
        int index = sum % size;
        arr[index] = num;
        return arr;
    }
}
