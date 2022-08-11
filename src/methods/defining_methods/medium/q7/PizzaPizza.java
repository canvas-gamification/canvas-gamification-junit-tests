package methods.defining_methods.medium.q7;

/*
When ordering a Pizza, you always want the greatest value for your money spent. Write a program that asks users for
two sizes of Pizza (e.g. the user can input a 12 inch. Pizza as 12, and a 14 inch pizza as 14), and then write a method
that accepts both input values, and returns the length with the greatest area. If either size is less than 0, return -1.
Sample output:
Please enter the size of the first Pizza:
5
Please enter the size of the second Pizza:
2
The pizza with the greatest area is the pizza with length: 5.0
 */

import java.util.Scanner;
public class PizzaPizza
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner (System.in);
        System.out.println("Please enter the size of the first Pizza: ");
        double firstPizza = input.nextDouble();
        System.out.println("Please enter the size of the second Pizza: ");
        double secondPizza = input.nextDouble();
        System.out.println("The pizza with the greatest area is the pizza with length: " + greaterSize(firstPizza, secondPizza));
    }
    public static double greaterSize(double a, double b)
    {
        if(a < 0 || b < 0)
            return -1;
        else {
            double firstArea = (a / 2) * (a / 2) * Math.PI;
            double secondArea = (b / 2) * (b / 2) * Math.PI;
            if (firstArea > secondArea)
                return a;
            else
                return b;
        }
    }
}

