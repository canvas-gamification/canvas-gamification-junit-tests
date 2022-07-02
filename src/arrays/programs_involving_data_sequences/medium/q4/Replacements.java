package arrays.programs_involving_data_sequences.medium.q4;
/*
Make a program that calls a method that takes an integer array and a number as input. The idea is to replace one of the
elements in the array with this number. To find out which element gets replaced, the method takes the sum of all the
values in the array, and then takes the modulus of the sum by the array size (index = sum % size). The method should
then return the index, which is printed out in the main method.

Distractors:
    int size = arr.length - 1;
    double size = arr.length;
    arr[ num ] = index;
    public static int[] addThisOne( int [] arr, int num )
    return arr;
    {
    }
    return num;
    int n = addThisOne(arr, 98);

 */
public class Replacements {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        int index = addThisOne(arr, 98);
        System.out.println("The index the number was added at is: " + index);
    }

    public static int addThisOne(int[] arr, int num) {
        int size = arr.length;
        int sum = 0;
        for (int i = 0; i < size; i++)
            sum += arr[i];
        int index = sum % size;
        arr[index] = num;
        return index;
    }
}

