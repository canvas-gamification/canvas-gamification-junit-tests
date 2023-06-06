package oop.programs_with_multiple_classes.medium.q6;

public class Fridge {
    private int size;
    private Meat[] meats;

    public Fridge(int m) {
        if(m > 0)
            size = m;
        else
            m = 0;
        meats = new Meat[size];
    }

}
