package arrays.programs_involving_multidimensional_data.medium.q1;

/*
Write a Java program that initializes and prints two integer arrays, both of size 5 by 5, with values within both arrays
randomly being generated from 1-5 (inclusive of both values). Then, check to see if each of their elements in the
respective positions are the same. If any pair of elements are not the same, print "different", otherwise do nothing.

Sample output:
    1 5 5 3 3
    2 2 2 4 4
    2 2 4 4 4
    4 2 5 3 3
    4 3 0 5 2

    1 5 5 3 1
    2 2 2 4 4
    2 0 4 0 1
    4 2 5 3 3
    4 3 0 0 1

    different
    different
    different
    different
    different
    different

Distractors:
a[i][j] = ( int ) (Math.random() * 4) + 1;
b[i][j] = (Math.random() * 4) + 1;
b[i][j] = ( int ) (Math.random() * 4) + 1;
if ( a[i][j] == b[i][j] )
if( a[i] == b[i] )
int[][] a = new int[][];
int[][] b = new int[][];
int[] a = new int[5];
int[] b = new int[5];
public static void main (String args)
int[][] b = new int[5][5]
 */

public class Identical
{
    public static void main (String[] args)
    {
        int[][] a = new int[5][5];
        int[][] b = new int[5][5];
        for( int i = 0; i < a.length; i++ )
            for( int j = 0; j < a[i].length; j++ )
            {
                a[i][j] = ( int ) (Math.random() * (5+1));
                b[i][j] = ( int ) (Math.random() * (5+1));
            }
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[i].length; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for(int i = 0; i < b.length; i++){
            for(int j = 0; j < b[i].length; j++){
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for( int i = 0; i < a.length; i++ )
            for( int j = 0; j < a[i].length; j++ )
                if( a[i][j] != b[i][j] )
                    System.out.println("different");

    }
}
