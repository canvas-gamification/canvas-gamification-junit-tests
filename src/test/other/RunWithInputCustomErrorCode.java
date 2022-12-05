package test.other;

import java.util.Random;
import java.util.Scanner;

public class RunWithInputCustomErrorCode {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("This is a test with retrieval.");
        System.out.println(input.nextLine());
    }
}
