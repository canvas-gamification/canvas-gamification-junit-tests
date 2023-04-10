package test.random.loggerMethodTestIssue;

import java.util.Random;

public class Generate {
    public static int randomInt() {
        Random random = new Random();
        return random.nextInt(45);
    }
}
