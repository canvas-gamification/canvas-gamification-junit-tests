package oop.user_defined_classes.hard.q4;

public class Laundromat {
    private int gymClothes;

    public Laundromat(int n) {
        gymClothes = n;
    }

    public void doLaundry() {
        int dirtyItems = 1;
        while (dirtyItems <= gymClothes) {
            System.out.println("Cleaning item " + dirtyItems);
            dirtyItems++;
        }
        gymClothes = 0;
        System.out.println("Your laundry is done!");
    }
}

