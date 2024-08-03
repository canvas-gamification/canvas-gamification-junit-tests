package oop.programs_with_interesting_classes.medium.q9;

public class TestExpertReviews {
    public static void main(String[] args) {
        Movie mainAttraction = new Movie("The Revenge of the Sharks 2");
        Review m1 = new Review("John", 5);
        Review m2 = new Review("Jack", 5);
        Review m3 = new Review("Jonathon", 4);
        Review m4 = new Review("Jeremy", 3);
        Review m5 = new Review("Jerry", 1);
        Review[] reviewsList = {m1, m2, m3, m4, m5};
        mainAttraction.setReviews(reviewsList);
        System.out.println("The average rating is " + mainAttraction.calcAvgRating());
        System.out.println("The highest rating is " + mainAttraction.getHighestRating() + " stars");
    }
}
