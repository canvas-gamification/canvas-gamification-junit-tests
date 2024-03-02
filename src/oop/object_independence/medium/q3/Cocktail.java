package oop.object_independence.medium.q3;

public class Cocktail {
    private String[] ingredients;

    public Cocktail(String[] ings) {
        ingredients = ings;
    }

    public String toString() {
        String str = "My ingredients are: ";
        for (int i = 0; i < ingredients.length; i++)
            str += ingredients[i] + " ";
        return str;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] il) {
        ingredients = il;
    }
}

