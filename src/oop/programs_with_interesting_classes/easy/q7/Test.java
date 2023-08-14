package oop.programs_with_interesting_classes.easy.q7;

public class Test {
    public static void main(String[] args) {
        Song s1 = new Song("Bow-Wow", 3.5);
        Song s2 = new Song("Wackadoo", 3);
        Song s3 = new Song("DooWop", 5.8);
        Song s4 = new Song("Shoowop", 2.6);
        Song s5 = new Song("Twang", 2.5);
        Playlist p1 = new Playlist();
        p1.addToPlaylist(s1);
        p1.addToPlaylist(s2);
        p1.addToPlaylist(s3);
        p1.addToPlaylist(s4);
        p1.addToPlaylist(s5);
        System.out.println(p1.toString());
    }
}

