package test.random.general_random_testing;

import java.util.Arrays;

public class BinNumberTesting {
    public static void main(String[] args) {
        String[] arr = new String[10];
        for (int i = 65; i < 91; i++){
            arr[(int)Math.floor((i - 65) / 2.6)]  = "";
        }
        for (int i = 65; i < 91; i++){
            arr[(int)Math.floor((i - 65) / 2.6)]  += ((char) i) + " ";
        }
        System.out.println(Arrays.toString(arr));
    }
}
