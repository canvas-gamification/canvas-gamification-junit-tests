package methods.modular_programs.hard.q3;

/*
Write a program with a method called universityYear that asks the user for their undergraduate year level and prints
out their University Status using the following information: 1st year students are "Freshman", 2nd year students are
"Sophomore", 3rd year students are "Junior" and 4th year students are "Senior." Verify the user's input to make sure
it is only these 4 cases, and display an error message “Invalid Input!” in case they enter invalid input.

Sample Output:
  Which year are you in? (1, 2, 3, or 4)
  2
  You're a Sophomore
 */

import java.util.Scanner;

public class UniversityLife {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Which year are you in? (1, 2 ,3, or 4)");
        int year = input.nextInt();
        System.out.println(universityYear(year));
    }

    public static String universityYear(int year) {
        if (year == 1)
            return "You're a Freshman";
        if (year == 2)
            return "You're a Sophomore";
        if (year == 3)
            return "You're a Junior";
        if (year == 4)
            return "You're a Senior";
        else
            return "Invalid Input!";
    }
}
