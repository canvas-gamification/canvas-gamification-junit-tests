package oop.special_class_method.medium.q4;

public class Plant {
    private String breed;

    public Plant(String brd) {
        breed = brd;
    }

    public void setBreed(String brd) {
        breed = brd;
    }

    public String getBreed() {
        return breed;
    }

    public String toString() {
        return "My breed is " + breed;
    }
}
