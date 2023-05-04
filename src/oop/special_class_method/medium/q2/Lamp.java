package oop.special_class_method.medium.q2;

public class Lamp {
    private double brightness;
    private boolean isOn;

    public Lamp(double level) {
        brightness = level;
        isOn = true;
    }

    public Lamp(double level, boolean onOff) {
        brightness = level;
        isOn = onOff;
    }

    public void setBrightness(double a) {
        brightness = a;
    }

    public double getBrightness() {
        return brightness;
    }

    public void setIsOn(boolean a) {
        isOn = a;
    }

    public boolean getIsOn() {
        return isOn;
    }
}

