package global.randomframework;

public class RandomUtil {
    public static String getRegexInt(int lower, int upper) {
        int minDigits = String.valueOf(lower).length();
        int maxDigits = String.valueOf(upper).length();

        return String.format("\\d{%d,%d}", minDigits, maxDigits);
    }

    public static int[] getSplitDecimal(double num) {
        String[] lowSplit = String.valueOf(num).split("\\.");

        return new int[]{Integer.parseInt(lowSplit[0]), Integer.parseInt(lowSplit[1])};
    }
}
