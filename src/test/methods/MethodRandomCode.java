package test.methods;

import java.util.Random;

public class MethodRandomCode {
    public static void main(String[] args) {
        System.out.println(randomInt(20));
    }

    public static int randomInt(int i){
        Random r = new Random();
        return r.nextInt(i);
    }

    public static double randomDouble(double i){
        Random r = new Random();
        return r.nextDouble() * i;
    }

    public static char randomChar(char c){
        Random r = new Random();
        int bound = c - 96;
        return (char) (r.nextInt(bound) + 97);
    }

    public static int[] randomIntArray(int size){
        Random r = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++){
            arr[i] = r.nextInt(size);
        }
        return arr;
    }

    public static double[] randomDoubleArray(double randomNumberBound, int size){
        Random r = new Random();
        double[] arr = new double[size];
        for (int i = 0; i < size; i++){
            arr[i] = r.nextDouble() * randomNumberBound;
        }
        return arr;
    }

    public static char[] randomCharArray(char randomCharBound, int size){
        Random r = new Random();
        char[] arr = new char[size];
        for (int i = 0; i < size; i++)
            arr[i] = (char) (r.nextInt(randomCharBound) + 97);
        return arr;
    }

}
