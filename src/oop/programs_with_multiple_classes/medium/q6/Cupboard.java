package oop.programs_with_multiple_classes.medium.q6;

public class Cupboard {
    private int size;
    private Vegetable[] vegetables;

    public Cupboard(int m) {
        if(m > 0)
            size = m;
        else
            m = 0;
        vegetables = null;
    }

}

