package oop.creating_objects_from_classes.hard.q6;

public class OrderDrink {
    public static void main(String[] args) {
        Martini drink = new Martini(new String[]{"vodka", "lemon juice", "syrup", "triple sec"}, 15);
        drink.mix();
        drink.detectFlavour();
    }
}
