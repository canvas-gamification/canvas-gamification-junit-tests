package arrays.programs_involving_multidimensional_data.easy.q6;

/*
Write a Java program that defines a 2D integer array of size 2 by 3. Then, uses the % operator to modify each value in
the array to be a value between 0 and 19. Print the resulting array to the console.
 */
public class ValueLock {
    public static void main(String[] args) {
        int[][] arr = {{2, 3, 4}, {16, 20, 32}};
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = arr[i][j] % 20;
                System.out.println(arr[i][j]);
            }
    }
}
