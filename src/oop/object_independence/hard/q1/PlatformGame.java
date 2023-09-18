package oop.object_independence.hard.q1;

public class PlatformGame {
    private int numLevels;
    private String difficulty;

    public PlatformGame(int num, String diff) {
        numLevels = num;
        difficulty = diff;
    }

    public int getNumLevels() {
        return numLevels;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setNumLevels(int num) {
        numLevels = num;
    }

    public void setDifficulty(String diff) {
        difficulty = diff;
    }

    public String toString() {
        return "This game has " + numLevels + " levels and is rated to be " + difficulty + " difficulty.";
    }
}
