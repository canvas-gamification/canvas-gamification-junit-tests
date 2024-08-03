package oop.programs_with_interesting_classes.medium.q9;

public class Movie {
    private Review[] reviews;
    private String name;

    public Movie(String s) {
        name = s;
        reviews = new Review[0];
    }

    public void setReviews(Review[] list) {
        reviews = list;
    }

    public void addReview(Review review) {
        Review[] newList = new Review[reviews.length + 1];
        System.arraycopy(reviews, 0, newList, 0, reviews.length);
        newList[reviews.length] = review;
        reviews = newList;
    }

    public double calcAvgRating() {
        double rating = 0.0;
        for (int i = 0; i < reviews.length; i++)
            rating += reviews[i].getRating();
        if(reviews.length > 0)
            rating = rating / reviews.length;
        return rating;
    }

    public int getHighestRating() {
        int max = -1;
        for (int x = 0; x < reviews.length; x++)
            if (reviews[x].getRating() > max)
                max = reviews[x].getRating();
        return max;
    }
}
