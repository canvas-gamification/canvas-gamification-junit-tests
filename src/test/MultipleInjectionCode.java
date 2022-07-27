package test;

import java.util.Scanner;

public class MultipleInjectionCode {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = input.nextLine();
        System.out.print("Enter a number: ");
        int numRepeats = input.nextInt();

        for(int i = 0; i < numRepeats; i++) {
            System.out.println(sentence);
        }
    }
}
