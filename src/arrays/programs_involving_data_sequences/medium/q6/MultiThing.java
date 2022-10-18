package arrays.programs_involving_data_sequences.medium.q6;

/*
Make a Java program that calls a method that takes an array of numbers as input. Then, for each element in the array,
determine if the number is even or odd. If the number is odd, multiply it by 2 and store it back in the array, and if
the number is even, divide it by 2 and store it back in the array. Lastly, the method returns the array as output which
is then printed in the main method.

return input[i];
return;
public void multiplier(int[] input)
public static int[] multiplier(int[])
public static void multiplier(int[] input)
input[i] = input[i] - 2;
input[i] = input[i] + 2;
input = input * 2;
input = input / 2;
{
}
 */

public class MultiThing
{
    public static void main( String [] args )
    {
        int [] arr = {1,3,5,7,9, 44, 88, 24};
        for(int num:multiplier(arr)){
            System.out.println(num);
        }
    }
    public static int[] multiplier(int [] input)
    {
        for (int i = 0; i < input.length; i++)
        {
            if (input[i]%2 == 0)
                input[i] = input[i] / 2;
            else
                input[i] = input[i]*2;
        }
        return input;
    }
}
