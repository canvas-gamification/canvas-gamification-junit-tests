package oop.programs_with_interesting_classes.easy.q7;

public class Song {
    private String title;
    private double length;
    private String artist;

    public Song(String title, double length, String artist) {
        this.title = title;
        this.length = length;
        this.artist = artist;
    }

    public String toString() {
        return "The " + title + " track by " + artist + " is " + length + " minutes long.";
    }
}

