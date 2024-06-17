package oop.programs_with_interesting_classes.easy.q7;

public class Playlist {
    private Song[] songs;
    private int numItems;

    public Playlist() {
        songs = new Song[3];
        numItems = 0;
    }

    public void addToPlaylist(Song newSong) {
        if (numItems == songs.length)
            expandPlaylist();
        songs[numItems] = newSong;
        numItems++;
    }

    public void expandPlaylist() {
        int nextSize = songs.length * 2;
        Song[] newList = new Song[nextSize];
        for (int i = 0; i < songs.length; i++)
            newList[i] = songs[i];
        songs = newList;
    }

    public String toString() {
        String allItems = "Playlist:\n";
        for (int i = 0; i < songs.length; i++)
            if (i < numItems)
                allItems += songs[i].toString() + "\n";
        return allItems;
    }
}
