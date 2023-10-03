package oop.object_independence.hard.q6;

public class TestFood {
    public static void main(String[] args) {
        Lasagna l1 = new Lasagna(false, false, 0);
        Lasagna l2 = new Lasagna(false, false, 1.0);
        Lasagna l3 = new Lasagna(false, false, 3.8);
        Lasagna l4 = new Lasagna(false, false, 2.76);
        Lasagna l5 = new Lasagna(false, false, 1.8);
        Lasagna[] fridge = {l1, l2, l3, l4, l5};
        for (int i = 0; i < fridge.length; i++) {
            System.out.println(fridge[i].toString());
        }
        System.out.println("Some time passed...");
        l1.gettingOld();
        l3.gettingOld();
        for (int i = 0; i < fridge.length; i++) {
            if (fridge[i].getIsBad())
                fridge[i].throwFood();
        }
        for (int i = 0; i < fridge.length; i++) {
            System.out.println(fridge[i].toString());
        }
    }
}
