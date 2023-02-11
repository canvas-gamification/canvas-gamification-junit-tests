package methods.method_overloading.hard.q9;

/*
* Provide the main method to the student fot his question *
Write a Java program that calls an overloaded method named userName that generates a username from a user's age and
name. The method should accept a string for the user's name and an integer for their age and return a string for the
username with the format firstName.age. For example, if the method receives "Joe" and 80, the username returned should
be "Joe.80". Overload the userName method so the string and integer can be passed in either order. Use the provided
main method to call and print the output from the methods.

Sample Output:
  The username for Joe with the age of 80 is: Joe.80
  The username for Madi with the age of 19 is:  Madi.19
 */

public class GenerateUsername {
    public static void main(String[] args) {
        String n1 = "Joe";
        String n2 = "Madi";
        int a1 = 80;
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
