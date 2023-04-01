package oop.programs_with_multiple_classes.medium.q8;

public class Light {
    private boolean isOn;
    private String type;

    public Light(boolean b, String s) {
        isOn = b;
        type = s;
    }

    public String toString() {
        return "Light{isOn = " + isOn + ", type = " + type + "}";
    }
}
