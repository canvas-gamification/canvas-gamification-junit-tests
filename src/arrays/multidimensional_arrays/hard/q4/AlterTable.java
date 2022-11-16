package arrays.multidimensional_arrays.hard.q4;

/*
Make a program that defines a 2D array and goes through each element in it by traversing each row's elements one at a
time. While going through each of these elements, the program prints out alternating elements starting from the first
element. For example, if you have the following 2D array {{1,2,3}, {4, 5 ,6}, {7,8,9} }, the program will
print 1, 3, 5, 7, 9.
 */

public class AlterTable {
    public static void main(String[] args) {
        int[][] nums = {{4, 5, 6}, {66, 54, 21}, {609, 998, 543}, {1111, 2342, 4583}};
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (count % 2 == 0)
                    System.out.print(nums[i][j] + " ");
                count++;
            }
        }
    }
}
