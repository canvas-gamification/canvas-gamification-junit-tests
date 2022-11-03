package arrays.programs_involving_multidimensional_data.easy.q2;

/*
A 2D array is used to keep track of the order of the people who appeared in line-ups. In particular, each row represents
the names of those who lined up for a certain musical event. Make a program that checks if the same name appears in the
last spot of each line (i.e., each row), and prints "Match" each time a match is found.
 */

public class LineUps
{
    public static void main (String[] args)
    {
        String[][] arr = {{"May","Joe","Sam"}, {"Neo","Sal","Joe"}, {"Dan","Ray","Joe"}, {"El", "Ally", "Sam"}};
        String[] lastOnes = new String[ arr.length ];
        for( int i = 0; i < arr.length; i++ )
        {
            int lastIndex = arr[i].length;
            String lastPerson = arr[i][lastIndex-1];
            lastOnes[i] = lastPerson;
        }
        for( int i=0; i < lastOnes.length; i++ )
        {
            String name = lastOnes[i];
            for( int j = (i+1); j<lastOnes.length; j++ )
                if( name == lastOnes[ j ] )
                    System.out.println( "Match" );
        }
    }
}
