package oop.special_class_method.hard.q4;

public class Detergent {
    private String name;
    private String strength;

    public Detergent(String a, String b) {
        name = a;
        strength = b;
    }

    public String toString() {
        return "Detergent{name: " + name + ", strength: " + strength + "}";
    }

    public void setName(String a) {
        name = a;
    }

    public String getName() {
        return name;
    }

    public void setStrength(String a) {
        strength = a;
    }

    public String getStrength() {
        return strength;
    }
}
