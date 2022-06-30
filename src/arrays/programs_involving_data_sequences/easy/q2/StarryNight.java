package arrays.programs_involving_data_sequences.easy.q2;
/*
Make a program that calls a method named printArrayPattern that will take an integer array and then print a number of
"*" on a line corresponding to each individual array element. For example, given [1, 3, 5, 7], the method prints the
following pattern:
*
***
*****
*******

 */
public class StarryNight {
    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 1};
        printArrayPattern(arr);
    }

    public static void printArrayPattern(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++)
                System.out.print("*");
            System.out.println();
        }
    }
}
