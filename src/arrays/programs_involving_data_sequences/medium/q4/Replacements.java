package arrays.programs_involving_data_sequences.medium.q4;
/*
Make a program that calls a method that takes an integer array and a number as input. The idea is to replace one of the
elements in the array with this number. To find out which element gets replaced, the method takes the sum of all the
values in the array, and then takes the modulus of the sum by the array size (index = sum % size). The method should
then return the array, which is printed out in the main method. If an empty array is passed to the method, the method
should return the empty array.

Distractors:
    int size = arr.length - 1;
    double size = arr.length;
    arr[ num ] = index;
    public static int addThisOne( int [] arr, int num )
    return index;
    {
    }
    return num;
    int n = addThisOne(arr, 98);
    System.out.print("The item at index " + n + "was replaced.")
 */
public class Replacements {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        int[] replacement = addThisOne(arr, 98);
        System.out.print("The array is now: ");
        for(int i = 0; i < replacement.length; i++){
            System.out.print(replacement[i] + " ");
        }
    }

    public static int[] addThisOne(int[] arr, int num) {
        int size = arr.length;
        if(size == 0)
            return arr;
        int sum = 0;
        for (int i = 0; i < size; i++)
            sum += arr[i];
        int index = sum % size;
        arr[index] = num;
        return arr;
    }
}
