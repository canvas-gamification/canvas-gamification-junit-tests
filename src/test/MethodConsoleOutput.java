package test;

import java.util.Locale;

public class MethodConsoleOutput {
    public static void main(String[] args) {
        printMessage("Hello Seth");
        System.out.println(stringToUpper("this was lowercase"));
    }

    public static void printMessage(String message){
        System.out.println(message);
    }

    public static String stringToUpper(String message){
        return message.toUpperCase();
    }
}
