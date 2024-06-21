package oop.static_modifier.medium.q5;

public class Hat {
    private static String companyName = "Nike";
    private String colour;

    public Hat(String c) {
        colour = c;
    }

    public String toString() {
        return "This is a " + companyName + " Hat that is " + colour + " in colour";
    }
}
