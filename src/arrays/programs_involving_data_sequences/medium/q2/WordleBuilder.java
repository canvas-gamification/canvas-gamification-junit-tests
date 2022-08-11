package arrays.programs_involving_data_sequences.medium.q2;

/*
In a game of alternative word builder, a group of people take turns adding one letter each to the end of a word, and
then looking at the word they end up making. Make a program that calls a method called charzIIStrings that takes a
string consisting of a word and an array of letters as input and returns the resulting word in the game. Print the
result to the console.

Distractors:
    s +== letters[i];
    for( int i = 1; i <= letters.length; i++ )
    String s;
    String s = "";
    return letters;
    public void String charzIIString( char [] letters, String word )
    public static void charzIIString( String word, char [] letters )
    public static String charzIIString( char letters, String word )
    public static char[] charzIIString( char [] letters )

 */
public class WordleBuilder {
    public static void main(String[] args) {
        char[] arr = {'b', 'u', 'i', 'l', 'd'};
        String str = charzIIString("String", arr);
        System.out.println(str);
    }

    public static String charzIIString(String word, char[] letters) {
        String s = word;
        for (int i = 0; i < letters.length; i++)
            s = s + letters[i];
        return s;
    }
}
