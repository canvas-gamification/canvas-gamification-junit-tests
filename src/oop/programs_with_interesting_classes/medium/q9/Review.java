package oop.programs_with_interesting_classes.medium.q9;

public class Review {
    private String user;
    private int rating;

    public Review(String u, int r) {
        user = u;
        if (r > 0 && r <= 5)
            rating = r;
        else
            rating = -1;
    }

    public String getUser() {
        return user;
    }

    public int getRating() {
        return rating;
    }

    public String toString() {
        return user + " rates this " + rating + " stars.";
    }
}
