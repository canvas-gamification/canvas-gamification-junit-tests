package conditionals.simple_programs_with_decision_points.hard.q8;
/*
Write a program that asks the user for two numbers, x and y then state if the sum of the two numbers is less or more than 50.
Sample Output:
Enter x  
1  
Enter y  
10  
Sum is less than 50.

 */
import java.util.Scanner;

public class SumToFifty {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter x: ");
        int x = input.nextInt();
        System.out.println("Enter y: ");
        int y = input.nextInt();

        int sum = x + y; 

        switch (Integer.compare(sum, 50)) {
            case -1:
                System.out.println("Sum is less than 50");
                break;
            case 1:
                System.out.println("Sum is more than 50");
                break;
            default:
                System.out.println("Sum is exactly 50");
        }
    }
}

