package arrays.programs_involving_data_sequences.easy.q1;

/*
Make a program that defines a character array and calls a method named averageChar that takes a character array as input,
considers the ASCII values of each character, computes the "average" character, and returns that "average" character.
Note that the average will have to be an integer, so make sure to round and convert it into a character
when returning it. The program should then print what the average character is.

Sample Output:
    The average character is: a

 */

public class AverageChar {
    public static void main(String[] args) {
        char[] arr = {'a', 'c', 'd', 'z'};
        char avgCh = averageChar(arr);
        System.out.println("The average character is: " + avgCh);
    }

    public static char averageChar(char[] arr) {
        double sum = 0;
        int length = arr.length;
        for (int i = 0; i < arr.length; i++)
            sum = sum + arr[i];
        int avg = (int) Math.round(sum / length);
        return (char) avg;
    }
}
