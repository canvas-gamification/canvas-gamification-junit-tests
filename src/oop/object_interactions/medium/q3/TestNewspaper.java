package oop.object_interactions.medium.q3;

public class TestNewspaper {
    public static void main(String[] args) {
        Newspaper paper = new Newspaper(2021, 12, 5, "The votes are in!");
        System.out.println(paper.toString());
        Newspaper newPaper = new Newspaper();
        System.out.println(newPaper);
        newPaper.makeCopy(paper);
        System.out.println(newPaper);
    }
}
