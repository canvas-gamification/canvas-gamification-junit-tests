package oop.object_independence.hard.q5;

public class TestFragile {
    public static void main(String[] args) {
        Glass g1 = new Glass("New", false, 40.0);
        Glass g2 = new Glass("Worn", false, 32.9);
        Glass g3 = new Glass("Old", false, 813.25);
        System.out.println(g1.toString());
        System.out.println(g2.toString());
        System.out.println(g3.toString());
        g1.broken();
        g3.broken();
        System.out.println(g1.toString());
        System.out.println(g2.toString());
        System.out.println(g3.toString());
        Glass[] homeInventory = {g1, g2, g3};
        for (int i = 0; i < homeInventory.length; i++) {
            if (homeInventory[i].getIsBroken())
                homeInventory[i].fix();
        }
        System.out.println(g1.toString());
        System.out.println(g2.toString());
        System.out.println(g3.toString());
    }
}
