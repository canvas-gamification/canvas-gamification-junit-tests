package methods.defining_methods.medium.q7;

/*
When ordering a Pizza, you always want the best value for your money spent. Write a program that asks users for the
diameter of two pizzas and write a method called greaterArea that accepts both input values and returns the diameter of
the pizza with the largest area. If either diameter is less than 0, return -1.

Sample output:
    Please enter the diameter of the first pizza:
    5
    Please enter the diameter of the second pizza:
    39.9
    The pizza with the greatest area is the pizza with diameter: 39.9
 */

import java.util.Scanner;

public class PizzaPizza {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the diameter of the first pizza: ");
        double firstPizza = input.nextDouble();
        System.out.println("Please enter the diameter of the second pizza: ");
        double secondPizza = input.nextDouble();
        System.out.println("The pizza with the greatest area is the pizza with diameter: " + greaterArea(firstPizza, secondPizza));
    }

    public static double greaterArea(double a, double b) {
        if (a < 0 || b < 0)
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
