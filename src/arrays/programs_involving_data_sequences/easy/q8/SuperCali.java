package arrays.programs_involving_data_sequences.easy.q8;

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
            if( word.length() > longest )
            {
                longest = word.length();
                pos = i;
            }
            System.out.println(word.length());
        }
        input[pos] = "Supercalifragilisticexpialidocious";
    }
}
