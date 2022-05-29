package conditionals.programs_with_decision_points.hard.q2;
/*
Write a program that acts like a simple calculator. It should take input for two operands ( such as '2' and '3' ) and
asks the user to enter either +, - , *, or /, and performs the specified operation on the operands. Then, the program
should print out the result of this operation.

Sample Output:
Enter operand 1:
2
Enter operand 2:
3
Enter operator ( +, -, *, / ):
+
2.0 + 3.0 = 5.0

Distractors:
    System.out.println("Enter operator ( +, -, *, / ,%,^):  ");
    char op = input.next().char(0);
    double op1 = input.next();
    double op2 = input.next();
    if( op == '^' )
    if( op == '%' )

 */

import java.util.Scanner;
public class Calculator
{
    public static void main( String [] args )
    {
        Scanner input = new Scanner( System.in );
        System.out.println("Enter operand 1:");
        double op1 = input.nextDouble();
        System.out.println("Enter operand 2:");
        double op2 = input.nextDouble();
        System.out.println("Enter operator ( +, -, *, / ):");
        char op = input.next().charAt(0);
        if( op == '+' )
            System.out.println(op1 + " + " + op2 + " = " + ( op1 + op2 ) );
        else if( op == '-' )
            System.out.println(op1 + " - " + op2 + " = " + ( op1 - op2 ) );
        else if( op == '*' )
            System.out.println(op1 + " * " + op2 + " = " + ( op1 * op2 ) );
        else if( op == '/' )
            System.out.println(op1 + " / " + op2 + " = " + ( op1 / op2 ) );
        else
            System.out.println("Invalid operator!");
    }
}
