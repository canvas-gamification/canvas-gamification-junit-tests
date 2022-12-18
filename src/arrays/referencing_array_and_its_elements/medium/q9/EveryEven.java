package arrays.referencing_array_and_its_elements.medium.q9;

/*
Make a Java program that initializes an integer array with 10 elements, whose values are randomly generated between 1
and 1000 (inclusive of both ends), and print it. Then, create a second array of half of the size that copies the values
from every even index element in the first array, and only finally print out the values of the second array to
the console.

Sample Output:
    The random generated array:
    315 197 258 756 982 424 235 201 624 446
    The elements on even indices are:
    315 258 982 235 624
 */

public class EveryEven {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++)
            arr[i] = (int) (Math.random() * 1000) + 1;
        System.out.println("The random generated array:");
        for(int i = 0; i < 10; i ++)
            System.out.print(arr[i] + " ");
        System.out.println();
        int len = arr.length;
        int[] arr2 = new int[len / 2];
        int arr2index = 0;
        for (int i = 0; i < len - 1; i += 2) {
            arr2[arr2index] = arr[i];
            arr2index++;
        }
        System.out.println("The elements on even indices are:");
        for (int i = 0; i < arr2.length; i++)
            System.out.print(arr2[i] + " ");
    }

}
