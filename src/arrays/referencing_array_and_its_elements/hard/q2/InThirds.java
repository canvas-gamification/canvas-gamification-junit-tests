package arrays.referencing_array_and_its_elements.hard.q2;

/*
Write a program called InThirds that defines an array of integers, in this case {3, 4, 6, 21, 48, 42, 89, 2, 0}, and
splits the array into three separate subarrays, using a method called splitter that takes and array, split it into
three equal subarray and return the second subarray.
For example, if there are 6 elements in the array, then the first two elements go into the first subarray, the middle
elements go into the second subarray, and the last two elements go into the third subarray. Assume that the number of
elements in the array is always a multiple of 3. Display all the elements in the second subarray in one line.

 */
public class InThirds {
    public static void main(String[] args) {
        int[] arr = {3, 4, 6, 21, 48, 42, 89, 2, 0};
        int[] split = splitter(arr);
        for (int i = 0; i < split.length; i++) {
            System.out.print(split[i] + " ");
        }
    }

    public static int[] splitter(int[] argg) {
        int size = argg.length;
        int[] ans = new int[size / 3];
        int[] first = new int[size / 3];
        int[] second = new int[size / 3];
        int[] third = new int[size / 3];
        for (int i = 0; i < size; i++) {
            if (i < (size / 3))
                first[i] = argg[i];
            else if (size / 3 <= i && i < (2 * size / 3))
                second[i - (size / 3)] = argg[i];
            else
                third[i - (2 * size / 3)] = argg[i];
        }
        for (int i = 0; i < second.length; i++)
            ans[i] = second[i];

        return ans;
    }
}