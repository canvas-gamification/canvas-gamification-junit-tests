package oop.programs_with_interesting_classes.hard.q2;

public class Player {
    private String name;
    private int score;

    public Player(String n) {
        name = n;
        score = 0;
    }

    public String toString() {
        return name + ": " + score + " points";
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public void setScore(int newScore) {
        score = newScore;
    }
}
