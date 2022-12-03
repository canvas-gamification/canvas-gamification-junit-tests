package methods.method_overloading.medium.q3;

/*
Overload a Java method so that it can take two strings or can take three strings and concatenate them (combines all the
strings to one large string). The main method should print two calls to the method, one with two inputs and one with three.

Sample Output:
  Hello I am
  Hello I am bob

 */
public class ThreeStrings {
    public static void main(String[] args) {
        String a = "Hello";
        String b = " I am ";
        String c = "bob";
        System.out.println(concatenate(a, b));
        System.out.println(concatenate(a, b, c));
    }

    public static String concatenate(String a, String b) {
        return a + b;
    }

    public static String concatenate(String a, String b, String c) {
        return a + b + c;
    }
}
