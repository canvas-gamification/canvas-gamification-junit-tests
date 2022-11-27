package methods.method_overloading.hard.q6;

/*
Write a Java Program with an overloaded method called studentCheck to check whether a student has a valid username and
student number. One method takes the first name, the last name, and the username and returns a boolean. The other name
takes the student number and returns a boolean. To determine this, ask the user for their name, username, and student
number. The following conditions should be met to determine their validity:
Their username must be their first name and last name back-to-back with a dot in the middle for example: john.doe
Their student number must at least be 8 digits long

Sample Output:
  Please enter a student's name:
  Jack Swift
  Please enter a username:
  Jack.Swift
  Please enter a student number:
  38471
  Jack.Swift is a valid username: true
  38471 is a valid student number: false
 */
import java.util.Scanner;

public class AttendingStudent {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Please enter a student's name: ");
    String firstName = input.next();
    String lastName = input.next();
    input.nextLine();
    System.out.println("Please enter a username: ");
    String validName = input.nextLine();
    System.out.println("Please enter a student number: ");
    int validNum = input.nextInt();
    System.out.println(validName + " is a valid username: " + studentCheck(firstName, lastName, validName));
    System.out.println(validNum + " is a valid student number: " + studentCheck(validNum));
  }

  public static boolean studentCheck(int studentID) {
    int len = String.valueOf(studentID).length();
    boolean check;
    if (len < 8)
      check = false;
    else
      check = true;
    return check;
  }

  public static boolean studentCheck(String fname, String lname, String username) {
    String correctUsername = fname + "." + lname;
    boolean check;
    if (username.equals(correctUsername))
      check = true;
    else
      check = false;
    return check;
  }
}
