package oop.programs_with_multiple_classes.hard.q3;

public class Bookcase {
    private int sizeCapacity;

    public Bookcase(int sizeCapacity) {
        if (sizeCapacity >= 0) {
            this.sizeCapacity = sizeCapacity;
        } else {
            System.out.println("Error! Size capacity cannot be negative.");
        }
    }
}
