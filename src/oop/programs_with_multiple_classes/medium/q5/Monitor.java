package oop.programs_with_multiple_classes.medium.q5;

public class Monitor {
    private int countSize;

    public Monitor(int m) {
        countSize = m;
    }

    public void fallen() {
        countSize = countSize - 1;
    }
}
