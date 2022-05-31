package pre_defined_classes.programs_with_changing_behaviour.medium.q2;
/*
In a live action role-playing game such as dungeons and dragons, players roll a 20-sided die to determine the level of
success their current action will have. Specifically, the following describes the possible outcomes corresponding to the
value of the die:
    1 - 5 : Action failed
    6 - 10: Action barely worked
    11 - 15: Action partially worked
    16 - 20: Action worked perfectly
Make a program that generates a random integer between 1 and 20 (inclusive of both values) to emulate the rolling of a
20-sided die and display what the value rolled is so that you can check the effectiveness of your action.

Sample Output:
    For this action, you rolled: 1
 */

import java.util.Random;

public class DnDRandom {
    public static void main(String[] args) {
        Random gen = new Random();
        int d20 = gen.nextInt(20) + 1;
        System.out.println("For this action, you rolled: " + d20);
    }
}
