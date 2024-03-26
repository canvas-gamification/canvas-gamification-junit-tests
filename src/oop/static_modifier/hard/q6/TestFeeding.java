package oop.static_modifier.hard.q6;

public class TestFeeding {
    public static void main(String[] args) {
        Farm a1 = new Farm(0.5, 10);
        Farm a2 = new Farm(0.2, 20);
        Farm a3 = new Farm(1, 50);
        a1.feedAnimals();
        a2.feedAnimals();
        a3.feedAnimals();
    }
}

