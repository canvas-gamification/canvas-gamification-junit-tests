package arrays.programs_involving_data_sequences.hard.q2;
/*
[J]In the tile-based game "Mahjong", players compete to see who has the best combination in a 10-tile set. With the 10
tiles, smaller combinations called "melds" are used, which are groups of two, three, or four tiles. To be a valid 3-tile
meld, the tiles must have identical numbers such as {2, 2, 2}, or it must be a "run" of successive numbers such as
{2, 3, 4}. Write a program where the main method prompts the user to input a 10 tile set, and then calls a method named
validMeld that takes an array as input and returns true if the array contains a valid 3-tile meld and false otherwise.

In particular, the method expects the array to be integers with three elements in it. The method checks either if a meld
of identical numbers exist or if a meld of consecutive numbers exist. In the latter case, you can assume that the input
array will be sorted in ascending order (from smallest to largest). Be sure to check that the input array verifies that
there are 3 elements in it. Write a program that calls this method and prints out "Valid", if the meld is valid, and
"Not Valid" if the meld is not valid.

Sample Output:
    Please enter the 10 tile set:
    1
    2
    3
    5
    1
    8
    1
    4
    9
    3
    Valid
 */
import java.util.Scanner;

public class MyJong {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the 10 tile set:");
        int[] arr = new int[10];
        for(int i = 0; i < arr.length; i++)
            arr[i] = input.nextInt();
        if (containsValidMeld(arr))
            System.out.println("Valid");
        else
            System.out.println("Not Valid");
    }

    public static boolean containsValidMeld(int[] arr) {
        for(int i = 0; i < arr.length - 2; i ++) {
            if (arr[i] == arr[i + 1] && arr[i + 1] == arr[i + 2])
                return true;
            if (Math.abs(arr[i] - arr[i + 1]) == 1 && Math.abs(arr[i + 1] - arr[i + 2]) == 1)
                return true;
        }
        return false;
    }
}
