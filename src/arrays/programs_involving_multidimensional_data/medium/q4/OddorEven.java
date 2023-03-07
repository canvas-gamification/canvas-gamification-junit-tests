package arrays.programs_involving_multidimensional_data.medium.q4;

/*
Write a Java program that initializes a 2D array of random integers of size 5 by 5, with numbers in the range of 1 to 10
(inclusive of both values), and print each row in a line. Then use a method named count that creates a 1D array
with two elements, and count the number of even and odd numbers in the 2D array. Use the index 0 for even numbers and
index 1 for the odd numbers. Then, print out the resulting 1D array.

Sample Output:
    10 2 2 7 10
    7 6 1 3 6
    4 1 3 10 3
    9 5 8 5 4
    3 4 1 6 5
    12
    13
Distractors:
    oddEve[0]--;
    oddEve[1]--;
    for( int i=0; i < arr.length(); i++ )
    for( int j=0; j<arr.length; j++ )
    for( int j=0; j<arr.length; j++ )
    for( int i=0; i < arr.length(); i++ )
     if( arr[i][j] % 2 != 0 )
    int [] oddEve = new int[5];
    int[] oddEv = new int[ arr.length ];
    System.out.println( oddEve );
 */

public class OddorEven {
    public static void main(String[] args) {
        int[][] arr = new int[5][5];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) (Math.random() * 10 + 1);
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        count(arr);
    }

    public static void count(int[][] arr) {
        int[] oddEve = new int[2];
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                oddEve[arr[i][j] % 2]++;
        for (int i = 0; i < oddEve.length; i++)
            System.out.println(oddEve[i]);
    }

}
