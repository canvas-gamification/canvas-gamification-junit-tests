package test;

import global.utils.ArrayUtil;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class ArrayUtilTesting {
    public static void main(String[] args) {
        int[] intTest = ArrayUtil.generateRandomIntArray(5, 100, 500);
        System.out.println(ArrayUtil.intArrayToInput(intTest));
        double[] doubleTest = ArrayUtil.generateRandomDoubleArray(1.56, 2.04, 30);
        System.out.println(ArrayUtil.doubleArrayToInput(doubleTest));
        System.out.println(ArrayUtil.sum(new int[]{1, 2, 3, 4, 5}));
        System.out.println(ArrayUtil.sum(new double[]{1.0, 2.5, 3.7, 4.3, 5.9}));
        System.out.println(ArrayUtil.charArrayToInput(new char[]{'A', 'B', 'C', 'D'}));
        System.out.println(ArrayUtil.charArrayToInput(ArrayUtil.generateRandomCharArray('A', 'F', 10)));
    }

    public static int sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];
        return sum;
    }

    public static int[] half(int[] arr) {
        int[] half = new int[arr.length / 2];
        for (int i = 0; i < half.length; i++)
            half[i] = arr[i];
        return half;
    }
}
