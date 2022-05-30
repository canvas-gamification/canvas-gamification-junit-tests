package conditionals.programs_with_decision_points.hard.q5;
/*
Write a program that asks the user some questions about the weather and time, and prints out what the user should do
next based on the following information: If it is sunny and it is past noon, Wear sunglasses and sunscreen before going
out. If it is not sunny and it is past noon, wear a jacket before going out. If it is sunny and before noon, then wear
your normal clothes. In any other case, stay inside. Assume the user provides numeric input.

Sample Output:
	Is it sunny outside? ( Enter 1 for yes and 0 for no )
    0
    Is it past noon? ( Enter 1 for yes and 0 for no )
    1
    Wear a jacket before leaving!

Distractors:
    if( ( sunny == 0 || sunny == 1 ) || ( pastNoon == 0 || pastNoon == 1 ) )
    if( ( sunny == 0 && sunny == 1 ) && ( pastNoon == 0 && pastNoon == 1 ) )
    if( ( sunny == 0 && sunny == 1 ) || ( pastNoon == 0 && pastNoon == 1 ) )
    if( sunny == 1 || pastNoon == 1 )
    else if( sunny == 0 || pastNoon == 1 )
    else if( sunny == 1 || pastNoon == 0 )

 */
import java.util.Scanner;

public class WeatherIGo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Is it sunny outside? ( Enter 1 for yes and 0 for no )");
        int sunny = input.nextInt();
        System.out.println("Is it past noon? ( Enter 1 for yes and 0 for no )");
        int pastNoon = input.nextInt();
        if ((sunny == 0 || sunny == 1) && (pastNoon == 0 || pastNoon == 1)) {
            if (sunny == 1 && pastNoon == 1)
                System.out.println("Wear some sunscreen and a pair of sunglasses before leaving!");
            else if (sunny == 0 && pastNoon == 1)
                System.out.println("Wear a jacket before leaving!");
            else if (sunny == 1 && pastNoon == 0)
                System.out.println("Wear your normal clothes!");
            else
                System.out.println("Stay Inside!");
        } else
            System.out.println("Invalid input!");
    }
}
