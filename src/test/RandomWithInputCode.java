package test;

import java.util.Random;
import java.util.Scanner;

public class RandomWithInputCode {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("This is a test with retrieval.");
        System.out.println(input.nextLine());

        Random gen = new Random();
        int val = gen.nextInt(10);
        System.out.println(val + input.nextInt());
        System.out.println(val);
    }
}
