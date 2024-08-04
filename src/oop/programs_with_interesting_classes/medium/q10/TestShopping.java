package oop.programs_with_interesting_classes.medium.q10;

public class TestShopping {
    public static void main(String[] args) {
        Cashier c1 = new Cashier(50, 45, 60);
        c1.scanItem("Ramen", 30);
        c1.scanItem("Coke", 36);
        Cashier c2 = new Cashier();
        c2.scanItem("Chocolate", 26);
        c2.scanItem("Coke", 21);
        c2.restock();
    }
}
