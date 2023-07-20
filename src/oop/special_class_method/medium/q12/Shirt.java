package oop.special_class_method.medium.q12;

public class Shirt {
    private int size;
    private int yearMade;

    public Shirt(int size, int yearMade) {
        this.size = size;
        this.yearMade = yearMade;
    }

    public int getSize() {
        return this.size;
    }

    public void displaySize() {
        if (this.yearMade > 2000)
            System.out.println("The size is " + getSize());
    }
}

