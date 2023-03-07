package arrays.multidimensional_arrays.hard.q3;

/*
Write a Java program that randomly initialize a 3 by 3 multidimensional array, with integers between 1 and 100
(inclusive of both ends) in the main method and prints it. Then write a countsOdd method that accept a multidimensional
array of integers and print the number of odd integers in it.
Note that the last line in the sample output should be printed in the method.

Sample output:
    Generated array:
    42 84 85
    45 50 63
    14 7 17
    count of odd numbers in array = 5
 */

public class CountsOdd {
    public static void main(String[] args) {
        System.out.println("Generated array:");
        int[][] arr = new int[3][3];
        for(int i = 0; i < arr.length; i ++){
            for(int j = 0; j < arr[i].length; j ++) {
                arr[i][j] = (int) (Math.random() * 100);
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        countsOdd(arr);
    }

    public static void countsOdd(int[][] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++)
            for (int j = 0; j < nums[i].length; j++)
                if (nums[i][j] % 2 != 0)
                    count++;
        System.out.println("count of odd numbers in array = " + count);
    }
}
