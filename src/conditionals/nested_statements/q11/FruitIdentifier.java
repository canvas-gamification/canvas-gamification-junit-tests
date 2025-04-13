package conditionals.nested_statements.q11;
import java.util.Scanner;

/*
 Rearrange the following Java code snippets to correctly implement a nested switch statement that determines 
 an item based on two input Strings, color and taste. The outer switch should handle color, and the inner 
 switch should handle taste within certain cases. The output should be a single string indicating the item.

 Sample output:
 Chili
 */


public class FruitIdentifier {
   public static void main(String[] args) {
       String color = "Red";
       String taste = "Spicy";

       switch (color) {
           case "Red":
               switch (taste) {
                   case "Sweet":
                       System.out.print("Apple");
                       break;
                   case "Spicy":
                       System.out.print("Chili");
                       break;
                   default:
                       System.out.print("Not found");
                       break;
               }
               break;
           case "Yellow":
               switch (taste) {
                   case "Sweet":
                       System.out.print("Banana");
                       break;
                   default:
                       break;
               }
               break;
       }
   }
}
