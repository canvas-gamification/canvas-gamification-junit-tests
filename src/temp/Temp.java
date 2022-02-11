package temp;

import org.apache.commons.math3.stat.inference.ChiSquareTest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Temp {
    public static void main(String[] args) {
        testChiSquareTest();
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
}
