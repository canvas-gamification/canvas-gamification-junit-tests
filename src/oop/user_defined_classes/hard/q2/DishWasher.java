package oop.user_defined_classes.hard.q2;

public class DishWasher {
    private int forks;
    private int knives;

    public DishWasher(int a, int b) {
        forks = a;
        knives = b;
    }

    public void loadDishWasher(int a, int b) {
        forks = forks - a;
        System.out.println(forks + " forks are still clean");
        knives = knives - b;
        System.out.println(knives + " knives are still clean");
    }
}
