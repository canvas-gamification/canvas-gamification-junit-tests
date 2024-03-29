package methods.method_overloading.medium.q8;

/*
Overload a Java Method so that it can take either two characters or three integers and returns the greatest value from
the inputs. Note: it is possible to numerically compare characters.
 */
public class OverloadChar {
    public static char greatest(char a, char b) {
        if (a > b)
            return a;
        else
            return b;
    }

    public static int greatest(int a, int b, int c) {
        if (a > b && a > c)
            return a;
        else if (b > c)
            return b;
        else
            return c;
    }
}
