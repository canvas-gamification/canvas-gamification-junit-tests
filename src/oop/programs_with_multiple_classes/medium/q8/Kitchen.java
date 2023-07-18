package oop.programs_with_multiple_classes.medium.q8;

public class Kitchen {
    private int size;
    private int personCapacity;
    private Light[] lights;

    public Kitchen(int s, int p) {
        if(s > 0)
            size = s;
        else
            size = 0;
        personCapacity = p;
        lights = new Light[size];
    }
}
