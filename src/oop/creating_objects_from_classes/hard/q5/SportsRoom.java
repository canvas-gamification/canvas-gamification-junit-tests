package oop.creating_objects_from_classes.hard.q5;

public class SportsRoom {
    public static void main(String[] args) {
        Basketball ball = new Basketball(28.5, "poor");
        ball.inflate();
        Basketball[] newBalls = ball.orderMore(5);
        newBalls[0].playGame();
    }
}
