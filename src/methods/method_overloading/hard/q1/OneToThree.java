package methods.method_overloading.hard.q1;

/*
Create a Java class with a static method called "stringLength" that returns an integer. Overload this method twice so
that it can take either one string, two strings, or three strings. Return the length of the string when there is just
one input, and the length of all the input strings added together otherwise. You do not need a main method.
 */
public class OneToThree {
    public static int stringLength(String a) {
        return a.length();
    }

    public static int stringLength(String a, String b) {
        String x = a + b;
        return x.length();
    }

    public static int stringLength(String a, String b, String c) {
        String x = a + b + c;
        return x.length();
    }
}
