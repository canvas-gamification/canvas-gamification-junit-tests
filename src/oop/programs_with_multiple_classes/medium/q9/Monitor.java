package oop.programs_with_multiple_classes.medium.q9;

public class Monitor {
    private int countSize;
    private String typeScreen;
    private boolean isRenewed;

    public Monitor(int m, String s, boolean b) {
        countSize = m;
        typeScreen = s;
        isRenewed = b;
    }

    public void recycled() {
        isRenewed = true;
    }
}
