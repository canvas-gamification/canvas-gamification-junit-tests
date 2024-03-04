package oop.special_class_method.medium.q13;

public class Detergent {
    private double volume;
    private String manufacturer;

    public Detergent(double v, String m) {
        volume = v;
        manufacturer = m;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String a) {
        manufacturer = a;
    }
}
