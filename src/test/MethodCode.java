package test;


import java.util.Scanner;

public class MethodCode {

    public static void main(String[] args) {
        System.out.println("Hello there");
        printSomething();
        printThis();
    }

    public static void printSomething(){
        System.out.println("Print something");
    }

    public static void printThis(){
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        System.out.println(s);
    }
}
