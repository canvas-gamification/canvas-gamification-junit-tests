package conditionals.programs_with_decision_points.medium.q11;

/*
 Write a Java program that prompts the user to select a weather type by entering a number from 1 to 5 
 and then displays the corresponding output.
 If the user enters ‘1’ then print out sunny, if the user enters ‘2’ then print out cloudy, 
 if the user enters ‘3’ then print out rainy, user enters ‘4’ then print out stormy, 
 user enters ‘5’ then print out snowy.
 */

 import java.util.Scanner;

 public class WeatherConditions {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         System.out.println("Enter a weather condition (1-5): ");
         int condition = scanner.nextInt();
 
         switch (condition) {
             case 1:
                 System.out.println("sunny");
                 break;
             case 2:
                 System.out.println("cloudy");
                 break;
             case 3:
                 System.out.println("rainy");
                 break;
             case 4:
                 System.out.println("stormy");
                 break;
             case 5:
                 System.out.println("snowy");
                 break;
             default:
                 System.out.println("Invalid. Please enter a number between 1 and 5.");
         }
 
         scanner.close();
     }
 }
 

