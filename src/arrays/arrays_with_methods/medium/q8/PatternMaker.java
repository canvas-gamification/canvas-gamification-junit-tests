package arrays.arrays_with_methods.medium.q8;

/*
Make a method that takes an integer variable n as input, where n specifies the number of lines of the pattern displayed
(shown below), and then returns a 2D array of characters which contains all the characters needed for displaying all n
lines of the pattern. An example pattern for n=3 is:
    #      (line 1)
   ##      (line 2)
  ###      (line 3)
The corresponding 2D array is this:
{
   { ' ',  ' ',  '#' },
   { ' ',  '#',  '#' },
   { '#',  '#',  '#' },
}
Note that the pattern always prints a prespecified character, where the first line has leading spaces with one such
character, the second line has one fewer leading spaces followed by the character, and so on, with the n'th line having
no leading spaces and only a series of n such characters.
 */

public class PatternMaker {
    public static char[][] mapThePattern( int n, char ch )
    {
        char [][] patt = new char[n][n];
        for( int i = 0; i < n; i ++ )
        {
            int innerCount = 0;
            for( int j = 1; j < ( n - i );  j++ )
            {
                patt[i][innerCount] = ' ';
                innerCount++;
            }
            for( int k = 0; k <= i;  k++ )
            {
                patt[i][innerCount] = ch;
                innerCount++;
            }
        }
        return patt;
    }
}
