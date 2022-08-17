package methods.method_overloading.hard.q6;

/**
 * [J] Write a Java Program with an overloaded method to check whether a student
 * has a valid username or student number. To determine this, ask the user for
 * either their first/last name or student number. The following conditions
 * should be met to determine their validity:
 *    - Their username must be their first name and last name back-to-back with a dot
 * in the middle for example: john.doe
 *    - Their student number must at least be 8 digits long
 * 
 *    Input Sets:
 *      # Set1: First name: John, Last name: Smith, Username: John.Smith
 *      # Set2: Student ID: 519277312
 *      # Set3: First name: Jack, Last name: Swift, Username: jackSwift151
 *      # Set4: Student ID: 47519
 * 
 *    Sample Output:
 *      The following student has a valid username: true
 *      The following student has a valid student number: true
 *      The following student does not have a valid username: false
 *      The following student does not have a valid student number: false
 */
public class Overload6 {
  public static void main(String[] args) {
    System.out.println("The following student has a valid username: " + studentCheck("John", "Smith", "John.Smith"));
    System.out.println("The following student has a valid student number: " + studentCheck(519277312));
    System.out.println("The following student does not have a valid username: " + studentCheck("Jack", "Swift", "jackSwift151"));
    System.out.println("The following student does not have a valid student number: " + studentCheck(47519));
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
