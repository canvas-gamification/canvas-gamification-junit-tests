package oop.programs_with_interesting_classes.medium.q8;

import java.util.Arrays;

public class TestSmartFoodManagement {
    public static void main(String[] args) {
        Food f1 = new Food("Apples", 20);
        Food f2 = new Food("Bananas", 10);
        Food f3 = new Food("Tomatoes", 7);
        Food f4 = new Food("Ketchup", 180);
        Food f5 = new Food("Chicken", 4);
        Food[] groceries = {f1, f2, f3, f4, f5};
        Fridge kitchen = new Fridge(groceries, 4.5);
        System.out.println(Arrays.toString(kitchen.getItems()));
        Food gettingOld = kitchen.getNextToExpire();
        System.out.println("Quickly! The " + gettingOld.getName() + " will go bad in " + gettingOld.getDaysToExpiration() + " days!");
        kitchen.decreaseTemperature();
        System.out.println("Now the " + gettingOld.getName() + " will go bad in " + gettingOld.getDaysToExpiration() + " days instead!");
    }
}
