package arrays.programs_involving_multidimensional_data.easy.q8;

/*
Make a Java program that generates a 5 by 5 2D array of random integers ranging from 1-1000 (inclusive on both ends),
and print it. Then, multiply all the elements of the array by 5 if the element is even and by 3 if the element is odd.
Lastly, print out the array at the end of the program with each row of numbers on a separate line.

Sample Output:
    490 534 197 730 540
    705 266 774 632 21
    725 623 354 446 169
    285 396 67 65 315
    57 244 194 244 489
    2450 2670 591 3650 2700
    2115 1330 3870 3160 63
    2175 1869 1770 2230 507
    855 1980 201 195 945
    171 1220 970 1220 1467
 */

public class EvenOrOdd {
    public static void main(String[] args) {
        int[][] arr = new int[5][5];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) (Math.random() * 1000) + 1;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] % 2 == 0)
                    arr[i][j] = arr[i][j] * 5;
                else
                    arr[i][j] = arr[i][j] * 3;
            }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }
}
