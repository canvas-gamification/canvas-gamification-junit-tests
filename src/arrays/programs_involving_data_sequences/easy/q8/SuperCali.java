package arrays.programs_involving_data_sequences.easy.q8;

/*
Make a Java program that passes an array of string to a method called lengthFinder. The method should print out the
length of each word in the array parameter, and then find the longest word and replace it with
"Supercalifragilisticexpialidocious".

Sample Output:
    4
    4
    2
    10
 */

public class SuperCali
{
    public static void main( String [] args )
    {
        String[] arr = {"bite", "life", "it", "birthright"};
        lengthFinder(arr);
    }
    public static void lengthFinder( String[] input )
    {
        int longest = -1;
        int pos = -1;
        for (int i = 0;i <input.length;i++)
        {
            String word = input[i];
            if (word.length() > longest) {
                longest = word.length();
                pos = i;
            }
            System.out.println(word.length());
        }
        input[pos] = "Supercalifragilisticexpialidocious";
    }
}
