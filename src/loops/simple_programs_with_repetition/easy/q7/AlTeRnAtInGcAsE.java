package loops.simple_programs_with_repetition.easy.q7;

/*
Write a program that will ask the user for a sentence and 
convert the sentence into an alternating case, 
ex. "Seven" would become "SeVeN". 
The alternating case should start with an uppercase. 
Always assume the input is a sentence. 
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
