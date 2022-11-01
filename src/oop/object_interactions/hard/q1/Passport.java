package oop.object_interactions.hard.q1;

public class Passport {
    private String name;
    private String dob;

    Passport(String n, String d) {
        name = n;
        dob = d;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    private void setName(String n) {
        name = n;
    }

    private void setDob(String d) {
        dob = d;
    }

    public String toString() {
        return "My name is " + name + " and I was born on " + dob + ".";
    }

    // define steal()
    public void steal(Passport victim) {
        name = victim.getName();
        dob = victim.getDob();
    }
}
