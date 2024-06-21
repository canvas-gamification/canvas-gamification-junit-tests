package oop.static_modifier.hard.q3;

public class Test {
    public static void main(String[] args) {
        CandyStore c1 = new CandyStore("Corner Jack");
        CandyStore c2 = new CandyStore("Best Deals in Kelowna");
        CandyStore c3 = new CandyStore("The Apple Mall");
        c1.award(20);
        c2.award(10);
        c3.award(15);
    }
}

