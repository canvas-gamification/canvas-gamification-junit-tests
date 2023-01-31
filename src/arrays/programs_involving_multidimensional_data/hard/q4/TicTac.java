package arrays.programs_involving_multidimensional_data.hard.q4;

/*
In the game of Tic-Tac-Toe is played on a board of size 3 by 3 between two players. Each player has a shape that can be
used (either a circle '0' or a cross '1'), and the player has to get three of the same shapes in a row, column, or a
diagonal to win. Write a Java program that uses a 2D character array to represent the board and randomly assigns one of
the shapes to each square. Next, the program prints out the shapes on the game board.

Sample Output:
    1 0 0
    1 0 1
    0 1 0
 */

public class TicTac {
    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int val = (int) (Math.random() * 2);
                arr[i][j] = val;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
