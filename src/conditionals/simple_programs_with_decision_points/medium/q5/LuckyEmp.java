package conditionals.simple_programs_with_decision_points.medium.q5;

import java.util.Scanner;
public class LuckyEmp
{
    public static void main( String [] args )
    {
        Scanner input = new Scanner( System.in );
        System.out.println("What is your annual salary in $?");
        double salary = input.nextDouble();
        if( salary < 12000)
        {
            salary = salary + ( 0.15 * salary );
            System.out.println("Congratulations!, you received a bonus of 15%!");
        }
        System.out.println("Annual Salary: $" + salary);
    }
}
