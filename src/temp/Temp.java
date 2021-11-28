package temp;

import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Temp {
    public static void main(String[] args) {
        HashSet<Integer> test = new HashSet<>();
        for(int i = 0; i < 5; i++){
            test.add(i);
        }

        System.out.println(test);
        System.out.println(test.size());
    }
}
