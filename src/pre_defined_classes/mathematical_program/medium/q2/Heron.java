package pre_defined_classes.mathematical_program.medium.q2;

/*
Consider a triangle with sides <tt>a, b, c</tt>. To calculate its area, it is very common to use Heron's formula,
where <tt>s</tt> is defined as half the perimeter of the triangle <tt>s = ( a + b + c ) / 2</tt>. Then, the area is
found by this equation:s(s-a)(s-b)(s-c). Make a program that calculates the area of a triangle using this formula.
 */

public class Heron {
    public static void main(String[] args) {
        double a = 3.4;
        double b = 5.0;
        double c = 6.6;
        double s = (a + b + c) / 2;
        double area = s * (s - a) * (s - b) * (s - c);
        area = Math.sqrt(area);
        System.out.println("The area of the triangle is: " + area + " units squared.");
    }
}
