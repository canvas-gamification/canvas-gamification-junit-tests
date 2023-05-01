package oop.programs_with_multiple_classes.medium.q1;

public class Chair {
    private String comfort;
    private int weightCapacity;
    private int longevity;

    public Chair(String c, int wc, int lv) {
        comfort = c;
        if (wc < 0)
            weightCapacity = 100;
        else
            weightCapacity = wc;
        if (lv < 0)
            longevity = 12;
        else
            longevity = lv;
    }
}
