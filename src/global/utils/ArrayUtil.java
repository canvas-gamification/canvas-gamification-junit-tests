package global.utils;

public class ArrayUtil {
    public static double sum(int[] arr) {
        double sum = 0;
        for(int value: arr) sum += value;
        return sum;
    }
}
