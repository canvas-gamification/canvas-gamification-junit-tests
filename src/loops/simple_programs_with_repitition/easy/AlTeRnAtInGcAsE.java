package loops.simple_programs_with_repitition.easy;

/*
Write a program that will ask the user for a sentence and 
convert the sentence into an alternating case, ex. "Seven" would become "SeVeN".

*/

import java.util.Scanner;

public class AlTeRnAtInGcAsE {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String sent = input.nextLine();
        int i = 0;
        String result = "";
        while (i < sent.length()) {
            if (i % 2 == 0)
                result += Character.toUpperCase(sent.charAt(i));
            else
                result += Character.toLowerCase(sent.charAt(i));
            i++;
        }
        System.out.println("YoUr SeNtEnCe In AlTeRnAtInG cAsE iS: " + result);
    }
}
