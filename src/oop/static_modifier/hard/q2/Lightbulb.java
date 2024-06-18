package oop.static_modifier.hard.q2;

public class Lightbulb {
    private static int voltage = 100;
    private String type;

    public Lightbulb(String t) {
        type = t;
    }

    public void setVoltage(int b) {
        voltage = b;
    }

    public String toString(){
        return "This lightbulb is a " + type + " light with " + voltage + " voltage.";
    }
}

