package pre_defined_classes.simple_programs_taking_string_user_input.medium.q2;
/*
Make a program that asks the user for a city name, then replace all the vowels (a, e, i, o u) with the letter y and
display that changed name to see if the user can guess what the city name actually is.

Sample Output:
	Enter a city name:
	Kelowna
	What is the name of the city that is spelt like Kylywny?

 */

import java.util.Scanner;

public class GuessCityName {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a city name: ");
        String city = input.nextLine();
        String city2 = city;
        city2 = city2.replace('a', 'y');
        city2 = city2.replace('e', 'y');
        city2 = city2.replace('i', 'y');
        city2 = city2.replace('o', 'y');
        city2 = city2.replace('u', 'y');
        System.out.println("What is the name of the city that is spelt like " + city2 + "?");
    }
}

