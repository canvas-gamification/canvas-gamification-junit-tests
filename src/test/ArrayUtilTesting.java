package test;

import global.utils.ArrayUtil;

public class ArrayUtilTesting {

    public static void main(String[] args) {
        char[] randomChar1 = ArrayUtil.generateRandomCharArray('A', 'S', 15);
        System.out.println(ArrayUtil.arrayToInput(randomChar1));
        char[] randomChar2 = ArrayUtil.generateRandomCharArray('S', 'Z', 15);
        System.out.println(ArrayUtil.arrayToInput(randomChar2));
        char[] randomMerge = ArrayUtil.merge(randomChar1, randomChar2);
        System.out.println(ArrayUtil.arrayToInput(randomMerge));
    }
}
