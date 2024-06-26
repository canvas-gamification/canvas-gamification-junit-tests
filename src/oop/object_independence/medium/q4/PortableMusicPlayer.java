package oop.object_independence.medium.q4;

public class PortableMusicPlayer {
    private String[] playlist;
    private int current;

    public PortableMusicPlayer(String[] pl) {
        playlist = pl;
        current = 0;
    }

    public void play() {
        System.out.println("Now Playing : " + playlist[current]);
    }

    public void playNext() {
        current ++;
        current %= playlist.length;
        System.out.println("Now Playing : " + playlist[current]);
    }

    public void playPrev() {
        current --;
        current += playlist.length;
        current %= playlist.length;
        System.out.println("Now Playing : " + playlist[current]);
    }
}

