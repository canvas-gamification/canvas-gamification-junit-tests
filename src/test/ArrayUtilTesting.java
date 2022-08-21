package test;

import global.utils.ArrayUtil;

public class ArrayUtilTesting {

    public static void main(String[] args) {
        // Chars
        char[] randomChar1 = ArrayUtil.generateRandomArray('a', 's', 15);
        System.out.println(ArrayUtil.arrayToInput(randomChar1));
        char[] randomChar2 = ArrayUtil.generateRandomArray('A', 'S', 15);
        System.out.println(ArrayUtil.arrayToInput(randomChar2));
        char[] randomMerge = ArrayUtil.merge(randomChar1, randomChar2);
        System.out.println(ArrayUtil.arrayToInput(randomMerge));
        System.out.println(ArrayUtil.arrayToInput(ArrayUtil.replicateArray('S', 10)));
        System.out.println(ArrayUtil.arrayToInput(ArrayUtil.generateAscendingArray('A', 26, 1)));
        System.out.println((int) 'A');
        System.out.println(ArrayUtil.sum(ArrayUtil.replicateArray('A', 5)));
        System.out.println(ArrayUtil.arrayToInput(ArrayUtil.increment(ArrayUtil.generateAscendingArray('!', 5), 2)));
        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println();
        // Ints
        int[] randomInt1 = ArrayUtil.generateRandomArray(1, 49, 15);
        System.out.println(ArrayUtil.arrayToInput(randomInt1));
        int[] randomInt2 = ArrayUtil.generateRandomArray(50, 55, 12);
        System.out.println(ArrayUtil.arrayToInput(randomInt2));
        int[] randomMergeInt = ArrayUtil.merge(randomInt1, randomInt2);
        System.out.println(ArrayUtil.arrayToInput(randomMergeInt));
        System.out.println(ArrayUtil.arrayToInput(ArrayUtil.replicateArray(39, 10)));
        System.out.println(ArrayUtil.arrayToInput(ArrayUtil.generateAscendingArray(95, 26, 1)));
        System.out.println(ArrayUtil.sum(ArrayUtil.replicateArray(11, 5)));
        System.out.println(ArrayUtil.arrayToInput(ArrayUtil.increment(ArrayUtil.generateAscendingArray(1, 5), 2)));
        System.out.println(ArrayUtil.arrayToInput(ArrayUtil.multiply(ArrayUtil.generateAscendingArray(48, 10, 3), 4)));
        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println();
        // Doubles
        double[] randomDouble1 = ArrayUtil.generateRandomArray(1.57, 10.78, 15);
        System.out.println(ArrayUtil.arrayToInput(randomDouble1));
        double[] randomDouble2 = ArrayUtil.generateRandomArray(1.98, 39.9999, 12);
        System.out.println(ArrayUtil.arrayToInput(randomDouble2));
        double[] randomMergeDouble = ArrayUtil.merge(randomDouble1, randomDouble2);
        System.out.println(ArrayUtil.arrayToInput(randomMergeDouble));
        System.out.println(ArrayUtil.arrayToInput(ArrayUtil.replicateArray(39.4, 10)));
        System.out.println(ArrayUtil.arrayToInput(ArrayUtil.generateAscendingArray(0.0001, 26, 1.57)));
        System.out.println(ArrayUtil.sum(ArrayUtil.replicateArray(3.1415926, 5)));
        System.out.println(ArrayUtil.arrayToInput(ArrayUtil.increment(ArrayUtil.generateAscendingArray(-4.57, 5), 0.69)));
        System.out.println(ArrayUtil.arrayToInput(ArrayUtil.multiply(ArrayUtil.generateAscendingArray(85.264, 10, 3.36), 0.5)));
    }
}
