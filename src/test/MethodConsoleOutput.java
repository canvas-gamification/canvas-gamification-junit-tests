package test;

public class MethodConsoleOutput {
    public static void main(String[] args) {
        printMessage("Hello Seth");
        System.out.println(stringToUpper("this was lowercase"));
        sum(1, 3);
    }

    public static void printMessage(String message){
        System.out.println(message);
    }

    public static String stringToUpper(String message){
        return message.toUpperCase();
    }

    public static int sum (int x, int y){
        int z = x + y;
        System.out.printf("The sum of %d and %d is %d\n", x, y, 5);
        return 5;
    }
}
