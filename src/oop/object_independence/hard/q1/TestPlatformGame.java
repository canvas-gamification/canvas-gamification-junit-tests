package oop.object_independence.hard.q1;

public class TestPlatformGame {
    public static void main(String[] args) {
        PlatformGame game1 = new PlatformGame(3, "easy");
        PlatformGame game2 = new PlatformGame(10, "hard");
        System.out.println(game1.toString());
        System.out.println(game2.toString());
        game1.setNumLevels(5);
        System.out.println(game1.toString());
        System.out.println(game2.toString());
    }
}
