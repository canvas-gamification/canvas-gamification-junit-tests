package oop.programs_with_multiple_classes.medium.q5;

public class Monitor {
    private int size;
    private boolean isOn;

    public Monitor(int m, boolean n) {
        size = m;
        isOn = n;
    }

    public void change() {
       isOn = (isOn == false) ? true : false;
    }
}
