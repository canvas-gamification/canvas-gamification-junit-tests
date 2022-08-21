package global.utils;

import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

/*
TODO: Merge array, ascending number array taking a start number, an optional step, and a length, array multiplier, increment by x,
TODO: replicate array (given a number, make an array of that element),
 */

public class ArrayUtil {
    private static final String[] wordBank = new String[]{
            "hello", "world", "james", "bank", "calendar", "lamp", "skyrim", "people", "hat", "boat", "picture", "defenestration",
            "man", "women", "child", "airplane", "test", "cheese", "goat", "chicken", "surprise", "burger", "tiger",
            "lion", "lying", "lie", "leopard", "apathy", "banana", "car", "door", "edge", "final", "geography", "hiatus", "internet",
            "jealous", "king", "liberty", "might", "neither", "operate", "pride", "queue", "right", "sufficient", "trouble",
            "usurp", "viscous", "weather", "xenic", "yesterday", "zebra", "and", "he", "who", "shall", "be", "born",
            "of", "the", "dawn", "born", "of", "the", "maiden"
    };

    public static int[] generateRandomIntArray(int lower, int upper, int length) {
        Random r = new Random();
        return r.ints(length, lower, upper).toArray();
    }

    public static double[] generateRandomDoubleArray(double lower, double upper, int length) {
        Random r = new Random();
        return r.doubles(length, lower, upper).toArray();
    }

    public static char[] generateRandomCharArray(char lower, char upper, int length) {
        char[] randomArr = new char[length];
        Random r = new Random();
        int range = upper - lower;
        for (int i = 0; i < randomArr.length; i++)
            randomArr[i] = (char) (r.nextInt(range) + lower);
        return randomArr;
    }

    public static String[] generateRandomWordArray(int length) {
        String[] randomArr = new String[length];
        Random r = new Random();
        for (int i = 0; i < length; i++)
            randomArr[i] = wordBank[r.nextInt(wordBank.length)];
        return randomArr;
    }

    public static int sum(int[] arr) {
        return Arrays.stream(arr).boxed().mapToInt(Integer::intValue).sum();
    }

    public static double sum(double[] arr) {
        return Arrays.stream(arr).boxed().mapToDouble(Double::doubleValue).sum();
    }

    public static String arrayToInput(int[] arr) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(arr).forEach((s) -> sb.append(s).append(" "));
        return sb.toString();
    }

    public static String arrayToInput(double[] arr) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(arr).forEach((s) -> sb.append(s).append(" "));
        return sb.toString();
    }

    public static String arrayToInput(char[] arr) {
        StringBuilder sb = new StringBuilder();
        CharBuffer.wrap(arr).chars().forEach((c) -> sb.append((char) c).append(" "));
        return sb.toString();
    }

    public static String arrayToInput(String[] arr) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(arr).forEach((s) -> sb.append(s).append(" "));
        return sb.toString();
    }

    public static int[] increment(int[] arr, int increment) {
        return Arrays.stream(arr).map(number -> (number + increment)).toArray();
    }

    public static double[] increment(double[] arr, int increment) {
        return Arrays.stream(arr).map(number -> (number + increment)).toArray();
    }

    public static int[] generateAscendingArray(int start, int length) {
        return IntStream.iterate(start, (i) -> i + 1).limit(length).toArray();
    }

    public static int[] generateAscendingArray(int start, int length, int step) {
        return IntStream.iterate(start, (i) -> i + step).limit(length).toArray();
    }

    public static double[] generateAscendingArray(double start, int length) {
        return DoubleStream.iterate(start, (i) -> i + 1).limit(length).toArray();
    }

    public static double[] generateAscendingArray(double start, int length, double step) {
        return DoubleStream.iterate(start, (i) -> i + step).limit(length).toArray();
    }

    public static int[] multiplyArray(int[] arr, int multiply) {
        return Arrays.stream(arr).map((i) -> i * multiply).toArray();
    }

    public static double[] multiplyArray(double[] arr, double multiply) {
        return Arrays.stream(arr).map((i) -> i * multiply).toArray();
    }

    public static int[] replicateArray(int[] arr, int number, int length) {
        return IntStream.iterate(number, (i) -> i).limit(length).toArray();
    }

    public static double[] replicateArray(double[] arr, double number, int length) {
        return DoubleStream.iterate(number, (i) -> i).limit(length).toArray();
    }

    public static int[] merge(int[] firstArray, int[] secondArray) {
        return IntStream.concat(Arrays.stream(firstArray), Arrays.stream(secondArray)).toArray();
    }

    public static double[] merge(double[] firstArray, double[] secondArray) {
        return DoubleStream.concat(Arrays.stream(firstArray), Arrays.stream(secondArray)).toArray();
    }

    public static char[] merge(char[] firstArray, char[] secondArray) {
        return CharBuffer.wrap(firstArray).append(CharBuffer.wrap(secondArray)).array();
    }

}
