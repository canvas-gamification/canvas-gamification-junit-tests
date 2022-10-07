package test.random;

import java.util.Random;

public class MethodRandom {
    public static void main(String[] args){
        System.out.println(randomInt(5, 11));
    }

    public static int randomInt(int lower, int upper){
        Random random = new Random();
        int range = upper - lower;
        return random.nextInt(range) + lower;
    }
}
