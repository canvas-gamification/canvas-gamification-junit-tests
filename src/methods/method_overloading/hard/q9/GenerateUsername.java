package methods.method_overloading.hard.q9;

/*
Write a Java Program that receives two first names and ages from the user and passes that information to an
overloaded method called userName. The method should take the String and int in either order, (name, age) or (age, name),
and return their username as first_name.age. For example, if the first name is john and the age 34, the username is john.34.

Write a Java program that calls an overloaded method named userName which generates a username from the user's age and
name. The method should be overloaded so that it accepts a string for the username and an integer for the age in either
order.

Sample Output:
  Enter two names:
  Joe Madi
  Enter corresponding ages:
  21 19
  The username for Joe with the age of 21 is: Joe.21
  The username for  Madi with the age of 19 is:  Madi.19
 */

public class GenerateUsername {
    public static void main(String[] args) {
        String n1 = "Steve";
        String n2 = "Madi";
        int a1 = 17;
        int a2 = 49;
        System.out.println("The username for " + n1 + " with the age of " + a1 + " is: " + userName(n1, a1));
        System.out.println("The username for " + n2 + " with the age of " + a2 + " is: " + userName(a2, n2));
    }

    public static String userName(int age, String name) {
        return name + "." + age;

    }

    public static String userName(String name, int age) {
        return name + "." + age;
    }
}
