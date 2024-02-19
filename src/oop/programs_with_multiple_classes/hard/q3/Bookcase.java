package oop.programs_with_multiple_classes.hard.q3;

public class Bookcase {
    private int sizeCapacity;

    public Bookcase(int sizeCapacity) {
        if (validate(sizeCapacity)) {
            this.sizeCapacity = sizeCapacity;
        } else {
            this.sizeCapacity = 0;
        }
    }

    public boolean validate(int sizeCapacity){
        if (sizeCapacity >= 0){
            return true;
        }
        else {
            System.out.println("Error! Size capacity cannot be negative.");
            return false;
        }
    }
}
