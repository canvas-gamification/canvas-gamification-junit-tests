package oop.object_independence.medium.q5;

public class Team {
    private String name;
    private int totalWins;

    public Team(String n, int w) {
        name = n;
        totalWins = w;
    }

    public void setTotalWins(int w) {
        totalWins = w;
    }

    public int getTotalWins() {
        return totalWins;
    }

    public String toString() {
        return "Team " + name + " has won " + totalWins + " games";
    }
}

