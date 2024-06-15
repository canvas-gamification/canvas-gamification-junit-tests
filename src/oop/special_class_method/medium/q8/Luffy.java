package oop.special_class_method.medium.q8;

public class Luffy {
    private String skill;
    private int bounty;

    public Luffy(String s, int b) {
        skill = s;
        bounty = b;
    }

    public void setSkill(String s) {
        skill = s;
    }

    public void setBounty(int b) {
        bounty = b;
    }

    public String getSkill() {
        return skill;
    }

    public int getBounty() {
        return bounty;
    }

    public String toString() {
        String str = "My special skill is " + skill;
        str += " and my bounty is " + bounty;
        return str;
    }
}

