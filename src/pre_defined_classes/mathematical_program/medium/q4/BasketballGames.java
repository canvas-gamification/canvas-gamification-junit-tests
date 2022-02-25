package pre_defined_classes.mathematical_program.medium.q4;

/*
You are a scorekeeper for your high school basketball team. It’s the end of the season and you have to calculate your
team’s participation in all of the tournaments. You decide to do this using a Java program. Your job is to get the
program to calculate the total score across all the games, find the highest score, and find the lowest score. Here is
the game statistics:
            Game #1 - Your school lost (Your coach recorded the score as -36)
            Game #2 - Your school won (Your coach recorded the scored as 59)
            Game #3 - Your school won (Your coach recorded the scored as 32)
As you can see, whenever a game was lost, the score was recorded as a negative number. So the actual score for Game #1
is 36 points. Your program will need to take this into consideration.
 */

public class BasketballGames {
    public static void main(String[] args) {
        int game1 = -36;
        int game2 = 59;
        int game3 = 32;
        game1 = Math.abs(game1);
        int max = Math.max(Math.max(game1, game2), game3);
        int min = Math.min(Math.min(game1, game2), game3);
        System.out.println("Our team scored " + (game1 + game2 + game3) + " points in the season!");
        System.out.println("The highest score was " + max + " points.");
        System.out.println("The lowest score was " + min + " points.");
    }
}