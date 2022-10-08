package global.utils;

import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class ArrayUtil {
    private static final String[] wordBank = new String[]{
            "hello", "world", "james", "bank", "calendar", "lamp", "skyrim", "people", "hat", "boat", "picture", "defenestration",
            "man", "women", "child", "airplane", "test", "cheese", "goat", "chicken", "surprise", "burger", "tiger",
            "lion", "lying", "lie", "leopard", "apathy", "banana", "car", "door", "edge", "final", "geography", "hiatus", "internet",
            "jealous", "king", "liberty", "might", "neither", "operate", "pride", "queue", "right", "sufficient", "trouble",
            "usurp", "viscous", "weather", "xenic", "yesterday", "zebra", "and", "he", "who", "shall", "be", "born",
            "of", "the", "dawn", "born", "of", "the", "maiden"
    };

    public static int[] generateRandomArray(int lower, int upper, int length) {
        Random r = new Random();
        return r.ints(length, lower, upper).toArray();
    }

    public static double[] generateRandomArray(double lower, double upper, int length) {
        Random r = new Random();
        return r.doubles(length, lower, upper).toArray();
    }

    public static char[] generateRandomArray(char lower, char upper, int length) {
        Random r = new Random();
        return r.ints(length, lower, upper).mapToObj(Character::toString).collect(Collectors.joining()).toCharArray();
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

    public static int sum(char[] arr) {
        return CharBuffer.wrap(arr).chars().boxed().mapToInt(Integer::intValue).sum();
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

    public static double[] increment(double[] arr, double increment) {
        return Arrays.stream(arr).map(number -> (number + increment)).toArray();
    }

    public static char[] increment(char[] arr, int increment) {
        return CharBuffer.wrap(arr).chars().map(i -> (i + increment)).mapToObj(Character::toString).
                collect(Collectors.joining()).toCharArray();
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

    public static char[] generateAscendingArray(char start, int length) {
        return IntStream.iterate(start, (i) -> i + 1).limit(length).mapToObj(Character::toString).
                collect(Collectors.joining()).toCharArray();
    }

    public static char[] generateAscendingArray(char start, int length, int step) {
        return IntStream.iterate(start, (i) -> i + step).limit(length).mapToObj(Character::toString).
                collect(Collectors.joining()).toCharArray();
    }

    public static int[] multiply(int[] arr, int multiply) {
        return Arrays.stream(arr).map((i) -> i * multiply).toArray();
    }

    public static double[] multiply(double[] arr, double multiply) {
        return Arrays.stream(arr).map((i) -> i * multiply).toArray();
    }

    public static int[] replicateArray(int number, int length) {
        return IntStream.iterate(number, (i) -> i).limit(length).toArray();
    }

    public static double[] replicateArray(double number, int length) {
        return DoubleStream.iterate(number, (i) -> i).limit(length).toArray();
    }

    public static char[] replicateArray(char character, int length) {
        return IntStream.iterate(character, (i) -> i).limit(length).
                mapToObj(Character::toString).collect(Collectors.joining()).toCharArray();
    }

    public static int[] merge(int[] firstArray, int[] secondArray) {
        return IntStream.concat(Arrays.stream(firstArray), Arrays.stream(secondArray)).toArray();
    }

    public static double[] merge(double[] firstArray, double[] secondArray) {
        return DoubleStream.concat(Arrays.stream(firstArray), Arrays.stream(secondArray)).toArray();
    }

    public static char[] merge(char[] firstArray, char[] secondArray) {
        return IntStream.concat(CharBuffer.wrap(firstArray).chars(), CharBuffer.wrap(secondArray).chars()).
                mapToObj(Character::toString).collect(Collectors.joining()).toCharArray();
    }

}
