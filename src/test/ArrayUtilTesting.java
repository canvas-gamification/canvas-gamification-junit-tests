package test;

import java.util.Scanner;

public class ArrayUtilTesting {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 10 integers: ");
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++)
            arr[i] = input.nextInt();
        System.out.println("The sum of your array is: " + sum(arr));
    }

    public static int sum(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];
        return sum;
    }

    public static int[] half(int[] arr){
        int[] half = new int[arr.length / 2];
        for (int i = 0; i < half.length; i++)
            half[i] = arr[i];
        return half;
    }
}
