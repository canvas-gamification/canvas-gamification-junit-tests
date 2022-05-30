package conditionals.programs_with_decision_points.medium.q4;
/*
Write a program that will take in the number of strokes taken by the user to complete the current hole in their golf
game, as well as the number of strokes needed for "par" (the expected number of strokes to be considered average). Use
this information to display the scoring term for the current hole based on the following: "Eagle" when the number of
strokes is 2 under par, "Birdie" when the number of strokes is 1 under par, "Par" when the number of
strokes is equal to par, "Bogey" when the number of strokes is 1 above par, "Double Bogey" when the number of
strokes is 2 above par, and “No Scoring Term” for any other score differences from par. Assume the user provides valid
input.

Sample Output;
	Enter the number of strokes you took for this course:
	4
	Enter the number of strokes you need for par:
	4
	Par
 */

import java.util.Scanner;

public class ForeGolf {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of strokes you took for this course: ");
        int strokes = input.nextInt();
        System.out.println("Enter the number of strokes you need for par: ");
        int par = input.nextInt();
        int diff = strokes - par;
        if (diff == 0)
            System.out.println("Par");
        else if (diff == -1)
            System.out.println("Birdie");
        else if (diff == -2)
            System.out.println("Eagle");
        else if (diff == 1)
            System.out.println("Bogey");
        else if (diff == 2)
            System.out.println("Double Bogey");
        else
            System.out.println("No Scoring Term");
    }
}
