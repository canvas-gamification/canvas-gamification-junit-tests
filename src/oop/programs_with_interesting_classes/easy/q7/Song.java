package oop.programs_with_interesting_classes.easy.q7;

public class Song {
    private String title;
    private double length;

    public Song(String title, double length) {
        this.title = title;
        this.length = length;
    }

    public String toString() {
        return "The " + title + " track is " + length + " minuets long.";
    }
}

