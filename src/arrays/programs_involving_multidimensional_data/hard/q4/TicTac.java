package arrays.programs_involving_multidimensional_data.hard.q4;

/*
In the game of Tic-Tac-Toe is played on a board of size 3 by 3 between two players. Each player has a shape that can be
used (either a circle 'O' or a cross 'X'), and the player has to get three of the same shapes in a row, column, or a
diagonal to win. Write a Java program that uses a 2D character array to represent the board and randomly assigns one of
the shapes to each square. For that, write a method called generateTicTac that
takes an integer and returns a multidimensional char array which represent the generated random board.
Next, the program prints out the shapes on the game board in the main method.

Sample Output:
    The generated board is:
    OOX
    XOO
    OXX
 */

public class TicTac {
    public static void main(String[] args) {
        char[][] ans = generateTicTac(3);
        System.out.println("The generated board is:");
        for(int i = 0; i < ans.length; i ++){
            for(int j = 0; j < ans[i].length; j ++)
                System.out.print(ans[i][j]);
            System.out.println();
        }
    }

    public static char[][] generateTicTac(int n){
        char[][] arr = new char[n][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int val = (int) (Math.random() * 2);
                if(val == 0)
                    arr[i][j] = 'X';
                else
                    arr[i][j] = 'O';
            }
        }
        return arr;
    }
}
