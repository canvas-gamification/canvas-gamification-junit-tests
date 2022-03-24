package pre_defined_classes.mathematical_program.medium.q4;

/*
You are a scorekeeper for your high school basketball team. It’s the end of the season, and you want to analyze your
team’s performance in all of their games. You decide to do this using a Java program. Your job is to get the program to
calculate the total score across all the games, find the highest score, and find the lowest score.
Here are the game statistics:
            Game #1 - Your school scored 36 points
            Game #2 - Your school scored 59 points
            Game #3 - Your school scored 32 points

Sample Output:
		Our team scored 127 points this season!
		The highest score was 59 points
		The lowest score was 32 points
 */

public class BasketballGames {
    public static void main(String[] args) {
        int game1 = 36;
        int game2 = 59;
        int game3 = 32;
        int max = Math.max(Math.max(game1, game2), game3);
        int min = Math.min(Math.min(game1, game2), game3);
        System.out.println("Our team scored " + (game1 + game2 + game3) + " points this season!");
        System.out.println("The highest score was " + max + " points.");
        System.out.println("The lowest score was " + min + " points.");
    }
}
