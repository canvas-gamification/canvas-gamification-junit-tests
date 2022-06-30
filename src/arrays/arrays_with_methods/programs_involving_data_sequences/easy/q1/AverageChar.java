package arrays.arrays_with_methods.programs_involving_data_sequences.easy.q1;

public class AverageChar {
    public static void main(String[] args) {
        char[] arr = {'a', 'c', 'd', 'z'};
        char avgCh = averageChar(arr);
        System.out.println("The average character is: " + avgCh);
    }

    public static char averageChar(char[] arr) {
        int sum = 0;
        double length = arr.length;
        for (int i = 0; i < arr.length; i++)
            sum = sum + arr[i];
        int avg = (int) Math.round(sum / length);
        return (char) avg;
    }
}
