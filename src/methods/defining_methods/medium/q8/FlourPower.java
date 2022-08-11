package methods.defining_methods.medium.q8;

/*
Write a Java Program that determines the cost per kg for flour. The program will ask the user for the weight of the flour,
and then the cost of the flour. Then, using a method called costPerCalc, return the cost per kg of the flour.
If either weight or cost is less than 0, return -1.
Sample output:
Please enter the weight of the flour:
4.4
Please enter the cost:
8
The cost per kg of the flour is: 1.8181818181818181

 */

import java.util.Scanner;
public class FlourPower
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner (System.in);
        System.out.println("Please enter the weight of the flour: ");
        double weightFlour = input.nextDouble();
        System.out.println("Please enter the cost: ");
        double costFlour = input.nextDouble();
        System.out.println("The cost per kg of the flour is: " + costPerCalc(weightFlour, costFlour));
    }
    public static double costPerCalc(double weight, double cost)
    {
        if(weight < 0||cost < 0)
            return -1;
        else
            return cost/weight;
    }
}

