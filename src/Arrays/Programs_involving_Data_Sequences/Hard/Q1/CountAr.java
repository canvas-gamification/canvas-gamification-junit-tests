package Arrays.Programs_involving_Data_Sequences.Hard.Q1;

/*
Write a program that defines (in the main method) an array of positive numbers in the range of 0 and 9 with the following values :
[ 1, 3, 4, 5, 4, 9, 4, 9, 9, 7, 7, 3 ].
This program will also have a method called countThisPlease() that counts the frequency of each number in that array.
With the input array you've defined, the method would count that there are no 0's, one 1's, no 2's, two 3's, three 4's, etc.,
and store those counts into a new array [ 0, 1, 0, 2, 3, 1, 0, 2, 0, 3] for each possible value between 0 to 9.
That new array of counts will be returned as the method's output, which the main method should print out,
with one element on each line.
 */

public class CountAr {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 4, 9, 4, 9, 9, 7, 7, 3};
        int[] arrCounts = countThisPlease(arr);
        for (int j = 0; j < arrCounts.length; j++)
            System.out.println(arrCounts[j]);
    }

    public static int[] countThisPlease(int[] nums) {
        int[] counts = new int[10];
        for (int i = 0; i < nums.length; i++)
            counts[nums[i]]++;
        return counts;
    }

}
