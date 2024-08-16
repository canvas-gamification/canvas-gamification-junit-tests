package oop.programs_with_interesting_classes.hard.q2;

public class LeaderBoard {
    private Player[] players;
    private int numPlayers;

    public LeaderBoard(Player[] list) {
        numPlayers = 0;
        players = new Player[100];
        if (list.length <= players.length)
            for (int i = 0; i < list.length; i++)
                addPlayer(list[i]);
    }

    public boolean addPlayer(Player p) {
        if (numPlayers < players.length) {
            players[numPlayers] = p;
            numPlayers++;
            return true;
        } else
            return false;
    }

    public String getTop2() {
        int top1 = -1;
        int top2 = -1;
        String winner = "empty";
        String runnerUp = "empty";
        for (int i = 0; i < numPlayers; i++) {
            int score = players[i].getScore();
            if (score > top2 && score > top1) {
                top2 = top1;
                top1 = score;
                runnerUp = winner;
                winner = players[i].getName();
            } else if (score > top2) {
                top2 = score;
                runnerUp = players[i].getName();
            }
        }
        return "Winner: " + winner + " with " + top1 + " points\n" + "Runner-up: " + runnerUp + " with " + top2 + " points\n";
    }
}
