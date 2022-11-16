package arrays.multidimensional_arrays.hard.q3;

/*
Write a Java program called CountsOdd. It should have a main method and countsOdd method. The countsOdd method should
have a parameter that accepts a 2D multidimensional array, it should count the number of odd elements in an array and
print the count to the system.  Initialize the following array ({ {1,2,3}, {4,5,6}, {7,8,9} }) in the main method, and
call the countsOdd method using the array as a parameter.

Sample output:
    count of odd numbers in array = 2
 */

public class CountsOdd {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
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
