package oop.programs_with_interesting_classes.hard.q1;

public class BuildVocab {
    public static void main(String[] args) {
        String[] vocab = {"VOLLEYBALL", "BASKETBALL", "SOCCER", "SWIMMING", "SKIING"};
        WordSearch puzzle = new WordSearch(vocab);
        System.out.println(puzzle.toString());
    }
}
