package oop.programs_with_interesting_classes.hard.q2;

public class CandyCrush {
    public static void main(String[] args) {
        Player p1 = new Player("Ming");
        Player p2 = new Player("Megan");
        Player p3 = new Player("Millie");
        Player[] playerList = {p1, p2, p3};
        LeaderBoard gameBoard = new LeaderBoard(playerList);
        p1.setScore(5);
        p2.setScore(10);
        p3.setScore(8);
        Player p4 = new Player("Madison");
        gameBoard.addPlayer(p4);
        p4.setScore(12);
        System.out.println(gameBoard.getTop2());
    }
}
