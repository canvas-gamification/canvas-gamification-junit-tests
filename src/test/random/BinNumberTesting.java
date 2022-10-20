package test.random;

import static global.utils.ArrayUtil.generateAscendingArray;

public class BinNumberTesting {
    public static void main(String[] args) {
        int[] k = generateAscendingArray(1, 200);
        for (int item : k)
            getNumBins(item);
    }

    public static void getNumBins(int range) {
        if (range < 21) {
            System.out.println(range + " : " + range);
            return;
        }
        int binNumber = 20;
        while (binNumber > 1) {
            if ((range + 1) % binNumber < 3 || range > (10 * binNumber)) {
                System.out.println(range + " : " + binNumber);
                return;
            }
            binNumber--;
        }
        System.out.println(range + " : No Bin Number");
    }
}
