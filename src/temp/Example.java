package temp;

import java.util.Random;

public class Example {
    public static void main(String[] args) {
        Random gen = new Random();
        int val = gen.nextInt(10);
        System.out.println("This is a random test with retrieval.");
        if(val >= 5) {
            System.out.println(val);
        }
    }
}
