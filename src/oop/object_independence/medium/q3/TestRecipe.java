package oop.object_independence.medium.q3;

public class TestRecipe {
    public static void main(String[] args) {
        Cocktail item1 = new Cocktail(new String[]{"Pineapple Juice", "Coconut Milk"});
        Cocktail item2 = new Cocktail(new String[]{"Apple Juice", "Almond Milk"});
        System.out.println(item1.toString());
        System.out.println(item2.toString());
    }
}
