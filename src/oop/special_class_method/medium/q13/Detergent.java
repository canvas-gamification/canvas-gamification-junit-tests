package oop.special_class_method.medium.q13;

public class Detergent {
    private double volume;
    private String manufacturer;

    public Detergent(double c, String m) {
        volume = c;
        manufacturer = m;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String a) {
        manufacturer = a;
    }
}
