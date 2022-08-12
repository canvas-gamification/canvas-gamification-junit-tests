package global.utils;

import java.util.Random;

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
        int[] randomArr = new int[length];
        Random r = new Random();
        int range = upper - lower;
        for (int i = 0; i < randomArr.length; i++)
            randomArr[i] = r.nextInt(range) + lower;
        return randomArr;
    }

    public static double[] generateRandomDoubleArray(double lower, double upper, int length) {
        double[] randomArr = new double[length];
        Random r = new Random();
        double range = upper - lower;
        for (int i = 0; i < randomArr.length; i++)
            randomArr[i] = r.nextDouble() * range + lower;
        return randomArr;
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
        int sum = 0;
        for (int item : arr)
            sum += item;
        return sum;
    }

    public static double sum(double[] arr) {
        double sum = 0;
        for (double value : arr) sum += value;
        return sum;
    }

    public static String intArrayToInput(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int item : arr)
            sb.append(item).append(" ");
        return sb.toString();
    }

    public static String doubleArrayToInput(double[] arr) {
        StringBuilder sb = new StringBuilder();
        for (double item : arr)
            sb.append(item).append(" ");
        return sb.toString();
    }

    public static String charArrayToInput(char[] arr) {
        StringBuilder sb = new StringBuilder();
        for (char item : arr)
            sb.append(item).append(" ");
        return sb.toString();
    }

    public static String stringArrayToInput(String[] arr){
        StringBuilder sb = new StringBuilder();
        for (String item : arr)
            sb.append(item).append(" ");
        return sb.toString();
    }
}
