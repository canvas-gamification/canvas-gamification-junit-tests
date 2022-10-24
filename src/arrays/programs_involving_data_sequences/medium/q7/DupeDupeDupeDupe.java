package arrays.programs_involving_data_sequences.medium.q7;

/*
Make a Java program that calls a method that takes an array of words as input. Go through all the words and find the
longest word in the array. Take the longest word and duplicate it as many times as the length of the word. For example,
suppose the longest word is "cars" that is 4 characters long. Then the newly constructed word would be duplicate "cars"
4 times to get "carscarscarscars". This newly constructed word is then returned as output.

Distractors:
    return longestWord;
    public void static stringRepeater(String[] arr)
    public String static stringRepeater(String[] arr)
    public static String stringRepeater(String[])
    return;
    for (int j = 0; j < len; j++)
    for (int i = 0; i < len; i++)
    newWord = longestWord;
    newWord = longestWord*len;
 */

public class DupeDupeDupeDupe
{
    public static void main( String [] args )
    {
        String[] arr = {"left","right","ending","homecoming", "longing"};
        stringRepeater(arr);
    }
    public static String stringRepeater(String [] words)
    {
        int greatestLength = 0;
        String longestWord = "";
        String newWord = "";
        for (int i = 0; i < words.length; i++)
        {
            int len = words[i].length();
            if ( len > greatestLength)
            {
                greatestLength = len;
                longestWord = words[i];
            }
        }
        for (int j = 0; j < longestWord.length(); j++)
            newWord = newWord + longestWord;
        return newWord;
    }
}
