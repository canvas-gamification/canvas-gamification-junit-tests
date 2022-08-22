package methods.method_overloading.hard.q9;

/**
 * [J] Write a Java Program that passes in a user's first name and age and
 * returns their username as their first name.age. For example, john.34. Use
 * method overloading to accept user's input in either order for example, (name,
 * age) or (age, name).
 * 
 * Input Sets:
 *    - Set1: Joe, 21
 *    - Set2: 19, Madi
 * 
 * Sample Output:
 *  The username for Joe with the age of 21 is: Joe.21
 *  The username for Madi with the age of 19 is: Madi.19
 */
public class Overload9 {
  public static void main(String[] args) {
    System.out.println("The username for Joe with the age of 21 is: " + userName("Joe", 21));
    System.out.println("The username for Madi with the age of 19 is: " + userName(19, "Madi"));
  }

  public static String userName(int age, String name) {
    String username = name + "." + age;
    return username;

  }

  public static String userName(String name, int age) {
    String username = name + "." + age;
    return username;
  }

}
