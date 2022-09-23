package test;

public class MethodClause {
    public static void main(String[] args) {
        int z = add(3, 7);
        print("The sum of two numbers is: " + z);
        //areaCalc(4, 5);
    }

    public static void print(String s){
        System.out.println(s);
    }

    public static int add(int x, int y){
        return x + y;
    }

    public static double areaCalc(double x, double y){
        double area = x * y;
        System.out.println("The area is 38.96");
        return area;
    }
}
