package pre_defined_classes.simple_programs_taking_numeric_user_input.medium.q6;
/*
A computer science teacher would like to ask the students about the intelligence of computers versus humans.
Make a program that asks the user if the user thinks that computers are smarter than humans.
Generates a random percentage representing how right they are and display the percentage to the users
assuming users always give a valid input (valid inputs: 0 for no, 1 for yes).

Sample output:
Do you think computers are smarted than humans (0 for no, 1 for yes)?
0
0 is 69% correct.

 */
import java.util.Scanner;
import java.util.Random;

public class Intelligence {
    public static void main(String[] args){
        System.out.println("Do you think computers are smarted than humans (0 for no, 1 for yes)?");
        Scanner input = new Scanner(System.in);
        int answer = input.nextInt();
        Random gen = new Random();
        int correct = gen.nextInt(101);
        System.out.println(answer + " is " + correct + "% correct.");
    }
}
