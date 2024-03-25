package oop.programs_with_interesting_classes.hard.q1;

import java.util.Random;

public class WordSearch {
    private char[][] grid;

    public WordSearch(String[] words) {
        int longest = 0;
        for (int i = 0; i < words.length; i++)
            if (words[i].length() > longest)
                longest = words[i].length();
        grid = new char[longest][longest];
        for (int i = 0; i < words.length; i++) {
            insertHorizontally(words[i], i);
        }
        randomFill();
    }

    private void insertHorizontally(String word, int row) {
        for (int i = 0; i < word.length(); i++)
            grid[row][i] = word.charAt(i);
    }

    private void randomFill() {
        Random gen = new Random();
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++)
                if (grid[i][j] < 65 || grid[i][j] > 90)
                    grid[i][j] = (char) (gen.nextInt(90 - 65) + 65);
    }

    public String toString() {
        String puzzle = "";
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++)
                puzzle += grid[i][j] + " ";
            puzzle += "\n";
        }
        return puzzle;
    }
}
