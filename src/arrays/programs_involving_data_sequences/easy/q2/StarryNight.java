package arrays.programs_involving_data_sequences.easy.q2;

/*
Make a program that calls a method named printArrayPattern that will take an integer array and then print "*" x times on
each line, where x corresponds to each array element. If an array element is less than 0, print a newline. For example,
given [1, 3, 5, 7], the method prints the following pattern:

*
***
*****
*******

 */
public class StarryNight {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
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
