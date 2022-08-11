package arrays.programs_involving_data_sequences.medium.q3;
/*
Make a program that takes up to 10 integers from the user. All of these numbers will get stored in an
array and then printed. If the user wishes to enter fewer than 10 numbers, the user can enter -1 to exit the program.
The program should only print the numbers the user entered for the array.

Sample Output:
    Enter a value to insert into the array ( -1 to exit ):
    1
    Enter a value to insert into the array ( -1 to exit ):
    2
    Enter a value to insert into the array ( -1 to exit ):
    3
    Enter a value to insert into the array ( -1 to exit ):
    4
    Enter a value to insert into the array ( -1 to exit ):
    5
    Enter a value to insert into the array ( -1 to exit ):
    6
    Enter a value to insert into the array ( -1 to exit ):
    -1
    1 2 3 4 5 6

Distractors:
    if( userValue >= - 1 )
    int[] arr = new int[];
    ind > 9 && ind >= 0
    arr[userValue] = ind;
    while ( userValue != -1 )
    userValue = input.next();
    i = input.next();

 */

import java.util.Scanner;

public class BuildAnArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr = new int[10];
        int userValue = 0;
        int i;
        for (i = 0; i < 10; i++) {
            System.out.println("Enter a value to insert into the array ( -1 to exit ): ");
            userValue = input.nextInt();
            if (userValue == -1)
                break;
            else
                arr[i] = userValue;
        }
        for (int j = 0; j < i; j++)
            System.out.print(arr[j] + " ");
    }
}
