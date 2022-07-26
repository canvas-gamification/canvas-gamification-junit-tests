package temp;

import org.apache.commons.math3.stat.inference.ChiSquareTest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static global.utils.RandomUtil.*;
import static global.utils.RandomUtil.frequenciesAreRandom;

public class Temp {
    public static void main(String[] args) {
//        testChiSquareTest();
        System.out.println(testBins());
    }

    public static void testChiSquareTest() {
        double[] expected = new double[]{1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000};

        long[] observed1 = new long[]{771, 795, 927, 942, 1008, 1242, 1146, 1169};

        long[] observed2 = new long[]{990, 1021, 1018, 1003, 1005, 992, 1005, 1010};

        long[] observed3 = new long[]{1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000};
        ChiSquareTest cst = new ChiSquareTest();
        double pValue = cst.chiSquareTest(expected, observed3);
        boolean verdict = cst.chiSquareTest(expected, observed3, 0.05);
        System.out.println(pValue);
        System.out.println(verdict);
    }

    public static void testArray() {
        long[] arr = new long[50];
        System.out.println(++arr[45]);
    }

    public static void testRegex() {
        // String to be scanned to find the pattern.
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(.*)(\\d+)(.*)";

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = r.matcher(line);
        if (m.find()) {
            System.out.println("Found value: " + m.group(0));
            System.out.println("Found value: " + m.group(1));
            System.out.println("Found value: " + m.group(2));
        } else {
            System.out.println("NO MATCH");
        }
    }

    public static void testMap() {
        Map<Integer, ArrayList<?>> map = new HashMap<>();
        ArrayList<Integer> intList = new ArrayList<>();
//        intList.add(1);
//        intList.add(11);
//        intList.add(111);
        ArrayList<Double> dblList = new ArrayList<>();
        dblList.add(4.4);
        dblList.add(8.1);
        dblList.add(7.9);
        ArrayList<Character> chrList = new ArrayList<>();
        chrList.add('g');
        chrList.add('f');
        chrList.add('i');

        map.put(1, intList);
        map.put(2, dblList);
        map.put(3, chrList);

        ((ArrayList<Integer>) map.get(1)).add(4);
        int firstInt = ((ArrayList<Integer>) map.get(1)).get(0);
        System.out.println(firstInt);
    }

    public static boolean testBins() {
        int[] arr = new int[]{8, 15, 3, 12, 7, 6, 3, 9, 7, 2, 4, 12, 11, 1, 11, 0, 12, 1, 13, 1, 0, 1, 2, 15, 13, 14, 14, 10, 5, 13, 1, 4, 0, 3, 5, 15, 8, 13, 17, 2, 1, 15, 16, 2, 9, 12, 2, 13, 17, 14, 15, 5, 1, 15, 7, 7, 5, 9, 14, 4, 7, 11, 15, 6, 0, 3, 2, 11, 5, 2, 9, 2, 5, 11, 17, 17, 12, 3, 0, 16, 4, 0, 11, 4, 13, 1, 4, 17, 15, 14, 11, 15, 12, 14, 4, 10, 11, 10, 8, 3, 8, 14, 10, 9, 3, 11, 17, 16, 9, 17, 9, 3, 5, 3, 17, 3, 12, 3, 16, 1, 17, 17, 7, 8, 11, 13, 8, 16, 7, 5, 7, 12, 14, 5, 0, 11, 13, 2, 14, 11, 3, 14, 15, 2, 3, 12, 16, 12, 16, 15, 10, 17, 1, 2, 8, 14, 8, 10, 3, 9, 9, 15, 4, 5, 2, 5, 7, 2, 12, 16, 3, 13, 1, 11, 7, 9, 5, 16, 1, 17, 6, 7, 11, 6, 5, 12, 2, 3, 0, 17, 17, 3, 2, 1, 0, 1, 13, 4, 6, 4, 13, 2, 5, 11, 3, 14, 7, 7, 14, 13, 6, 12, 14, 6, 14, 3, 12, 17, 2, 15, 14, 0, 17, 3, 12, 17, 2, 7, 5, 3, 13, 17, 8, 7, 2, 5, 6, 4, 1, 0, 13, 5, 2, 14, 11, 3, 17, 6, 15, 2, 17, 2, 3, 1, 4, 3, 14, 3, 2, 12, 4, 4, 2, 16, 0, 8, 6, 8, 13, 12, 6, 14, 6, 0, 8, 6, 16, 6, 12, 2, 17, 2, 10, 0, 3, 0, 1, 8, 11, 10, 3, 7, 5, 10, 4, 3, 3, 0, 0, 2, 1, 15, 8, 3, 9, 12, 1, 12, 2, 1, 14, 0, 9, 13, 3, 9, 11, 13, 14, 4, 0, 12, 16, 1, 13, 3, 14, 8, 12, 0, 14, 0, 3, 12, 14, 17, 17, 1, 5, 10, 17, 17, 14, 2, 6, 5, 9, 3, 7, 10, 3, 3, 10, 1, 5, 14, 11, 9, 14, 16, 1, 5, 1, 1, 14, 1, 3, 2, 7, 1, 17, 7, 14, 0, 10, 5, 15, 10, 1, 17, 10, 5, 14, 7, 3, 7, 0, 5, 3, 7, 12, 4, 1, 4, 7, 11, 9, 3, 14, 4, 15, 0, 5, 8, 5, 3, 17, 14, 16, 11, 11, 5, 10, 7, 3, 13, 8, 4, 7, 7, 10, 8, 0, 11, 17, 9, 10, 5, 3, 16, 12, 16, 9, 2, 17, 11, 12, 17, 1, 14, 6, 12, 8, 8, 10, 16, 10, 10, 0, 1, 8, 5, 5, 2, 11, 7, 14, 2, 13, 6, 10, 13, 1, 9, 3, 15, 16, 16, 4, 13, 3, 5, 12, 9, 13, 1, 3, 11, 16, 4, 11, 7, 11, 12, 15, 9, 15, 4, 9, 15, 6, 16, 16, 16, 0, 5, 2, 8, 14, 16};
        final int NUM_BINS = getNumBins(0, 18);
        int[] observedCounts = new int[NUM_BINS];
        for (int value : arr) {
            int binNum = assignedBinIndex(value, 0, 18, NUM_BINS);
            if (binNum == NO_BIN) return false;  // TODO: maybe raise a error with descript message
            observedCounts[binNum]++;
        }
        System.out.println(Arrays.toString(observedCounts));
        return frequenciesAreRandom(observedCounts, NUM_BINS);
    }
}
