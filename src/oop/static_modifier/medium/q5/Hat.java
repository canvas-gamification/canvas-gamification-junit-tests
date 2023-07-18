package oop.static_modifier.medium.q5;

public class Hat {
    private static String companyLogo = "Nike";
    private String colour;

    public Hat(String c) {
        colour = c;
    }

    public String toString() {
        return "This is a " + companyLogo + " that is " + colour + " in colour";
    }
}
