package pre_defined_classes.programs_with_changing_behaviour.medium.q5;
/*
Make a program that will randomly display a weather report out of four possible choices: "Sunny", "Rainy", "Clear", and
"Overcast.". Write a Java program that generates a random number between 1 and 50000 (inclusive of both values), then
obtain the remainder of the value after dividing the random number by 4. Finally, print out the predicted weather
(the remainder), where Sunny = 0, Rainy = 1, Clear = 2, and Overcast = 3.

Sample Output:
    The weather predicted is: 1

 */

import java.util.Random;

public class WeatherWizard {
    public static void main(String[] args) {
        Random gen = new Random();
        int weather = gen.nextInt(50000) + 1;
        int remainderVal = weather % 4;
        System.out.println("The weather predicted is: " + remainderVal);
    }
}
