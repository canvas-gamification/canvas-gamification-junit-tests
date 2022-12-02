package methods.modular_programs.hard.q5;

/*
Write a Java Program with a method called fineCalculator(String speed, char schoolZone) that determines the fine of a
person caught speeding by asking. You need to take the speed as a string to handle invalid cases.
the user how much above the speed limit is the driver, and if they were in a school zone. If a person is driving under
or equal to speed limit their fine is $0. If a person is driving 0 - 10 km/h above the speed limit, their fine is $50.
If a person is driving 11 - 30 km/h above the speed limit, their fine is $75. If a person is driving 31 - 50 km/h above
the speed limit, their fine is $100. If a person is driving 51 km/h above the speed limit, their fine is $150. If a
person is in a school zone, then their fine is doubled. The method should catch invalid input and prints
"Invalid Input!" as error message.

Sample Output:
    How fast were you above the speed limit?
    20
    Were you in a school zone? (Enter T/F)
    T
    Your fine is 150 dollars!
 */

import java.util.Scanner;

public class DrivingFines {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("How fast were you above the speed limit?");
    String speed = input.next();
    System.out.println("Were you in a school zone? (Enter T/F)");
    String temp = input.next();
    char zone = temp.charAt(0);
    fineCalculator(speed, zone);
  }

  public static void fineCalculator(String speedSt, char zone) {
    int speed;
    try {
      speed = Integer.parseInt(speedSt);
    } catch (Exception e) {
      System.out.println("Invalid Input!");
      return;
    }
    if ((zone != 'T' && zone != 'F')) {
      System.out.println("Invalid Input!");
    } else if (speed > 50) {
      if (zone == 'T')
        System.out.println("Your fine is 300 dollars!");
      else
        System.out.println("Your fine is 150 dollars!");
    } else if (speed > 30 && speed <= 50) {
      if (zone == 'T')
        System.out.println("Your fine is 200 dollars!");
      else
        System.out.println("Your fine is 100 dollars!");
    } else if (speed > 10 && speed <= 30) {
      if (zone == 'T')
        System.out.println("Your fine is 150 dollars!");
      else
        System.out.println("Your fine is 75 dollars!");
    } else if (speed > 0 && speed <= 10) {
      if (zone == 'T')
        System.out.println("Your fine is 100 dollars!");
      else
        System.out.println("Your fine is 50 dollars!");
    } else if (speed <= 0)
      System.out.println("Your fine is 0 dollars!");
  }
}

