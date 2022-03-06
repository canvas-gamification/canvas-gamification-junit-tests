package temp;

import java.util.Random;
import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        Random gen = new Random();
        Scanner input = new Scanner(System.in);
        int val = gen.nextInt(10);
        System.out.println("This is a random test with retrieval.");
        System.out.println(val);
        System.out.println(input.nextLine());
    }
}
