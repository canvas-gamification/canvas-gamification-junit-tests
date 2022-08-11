package methods.defining_methods.medium.q7;

import java.util.Scanner;
public class PizzaPizza
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner (System.in);
        System.out.println("Please enter the size of the first Pizza");
        double firstPizza = input.nextDouble();
        System.out.println("Please enter the size of the second Pizza");
        double secondPizza = input.nextDouble();
        System.out.println("The pizza with the greatest area is the pizza with length: " + greaterSize(firstPizza, secondPizza));
    }
    public static double greaterSize(double a, double b)
    {
        double firstArea = (a/2)*(a/2)*Math.PI;
        double secondArea = (b/2)*(b/2)*Math.PI;
        if (firstArea>secondArea)
            return a;
        else
            return b;
    }
}

