package test;


import java.util.Scanner;

public class MethodCode {

    public static void main(String[] args) {
        System.out.println("This is the main method");
        printSomething();
        printThis();
        double z = max(5, 0);
    }

    public static void printSomething(){
        System.out.println("Print something");
    }

    public static void printThis(){
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        System.out.println(s);
    }

    public static double max(int x, int y){
        return Math.max(x, y);
    }

    public static int sum(int [] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }

}
