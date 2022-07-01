package arrays.programs_involving_data_sequences.medium.q1;
/*
Make a program that calls a method called intoStrings that takes an integer array as input and returns a String that
results from concatenating all the integers together. For example, the input of [1,2,3,4,5,6] will result in an output
of "123456". The program should print this new String in the main method.

Distractors:
    s += nums[1];
    for( int i = 1; i <= nums.length; i++ )
    String s;
    return nums;
    return;
    public void String intoStrings( int [] nums )
    public static void intoStrings( int [] nums )
    public static String intoStrings( int nums )
    public static int[] intoStrings( int [] nums )

 */
public class Stringify {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 0, 1};
        String str = intoString(arr);
        System.out.println(str);
    }

    public static String intoString(int[] nums) {
        String s = "";
        for (int i = 0; i < nums.length; i++)
            s = s + nums[i];
        return s;
    }
}

