package conditionals.programs_with_decision_points.hard.q9;

/*
 * Write a Java Program that determines the fine of a person caught speeding by asking the user how much above the
 * speed limit is the driver, and if they were in a school zone. If a person is driving 1 - 10 km/h above the speed
 * limit, their fine is $50. If a person is driving 11 - 30 km/h above the speed limit, their fine is $75. If a person
 * is driving 31 - 50 km/h above the speed limit, their fine is $100. If a person is driving 51 km/h or more above the
 * speed limit, their fine is $150. If a person is in a school zone, then their fine is doubled. When asking if the
 * person was speeding at school zone, enter whether "true" or "false". Make sure to print “Invalid Input!” if the
 * input is invalid.
 * 
 * Sample Output:
 *    How fast were you above the speed limit?
 *    10
 *    Were you in a school zone? (Enter true or false)
 *    true
 *    Your fine is $100!
 * 
 * Distractors:
 *    boolean speed = input.nextInt();
 *    int char = isInSchoolZone.charAt(0);
 *    if ( speed > 51 )
 *    else if( speed>31 && speed < 50){
 *    else if( speed>11 && speed < 30){
 *    else if( speed>1 && speed < 10){
 *
 */

import java.util.Scanner;

public class DrivingFines {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("How fast were you above the speed limit?");
    int speed = input.nextInt();
    System.out.println("Were you in a school zone? (Enter true or false)");
    boolean isInSchoolZone = input.nextBoolean();
    if (speed > 50) {
      if (isInSchoolZone)
        System.out.println("Your fine is $300!");
      else
        System.out.println("Your fine is $150!");
    } else if (speed > 30 && speed <= 50) {
      if (isInSchoolZone)
        System.out.println("Your fine is $200!");
      else
        System.out.println("Your fine is $100!");
    } else if (speed > 10 && speed <= 30) {
      if (isInSchoolZone)
        System.out.println("Your fine is $150!");
      else
        System.out.println("Your fine is $75!");
    } else if (speed > 0 && speed <= 10) {
      if (isInSchoolZone)
        System.out.println("Your fine is $100!");
      else
        System.out.println("Your fine is $50!");
    } else
      System.out.println("Invalid Input!");
  }
}
