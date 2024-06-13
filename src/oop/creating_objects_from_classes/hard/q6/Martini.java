package oop.creating_objects_from_classes.hard.q6;

/* NOTE: This class needs to be moved under the test file on the website so the student can access it */
public class Martini {
    private String[] ingredients;
    private double percentAlcohol;
    private boolean mixed;
    /*
     * These values below are used to track the actions of the student in their test class. They track what values they
     * initialize the martini object to, and if they have called the methods they are supposed to.
     */
    private static Martini martini;
    private static boolean constructorCalled = false;
    private static String[] constructorIngredients;
    private static double constructorPercentAlcohol;
    private static boolean mixCalled = false;
    private static boolean detectFlavourCalled = false;

    public Martini(String[] i, double p){
        ingredients = i;
        percentAlcohol = p;
        mixed = false;
        constructorCalled = true;
        martini = this;
        constructorIngredients = i;
        constructorPercentAlcohol = p;
    }

    public void mix(){
        mixed = true;
        mixCalled = true;
    }

    public void detectFlavour(){
        String flavour = ingredients[(int)(Math.random()*ingredients.length)];
        System.out.println("I detect " + flavour);
        detectFlavourCalled = true;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public static Martini getMartini() {
        return martini;
    }

    public static boolean isConstructorCalled() {
        return constructorCalled;
    }

    public static String[] getConstructorIngredients() {
        return constructorIngredients;
    }

    public static double getConstructorPercentAlcohol() {
        return constructorPercentAlcohol;
    }

    public static boolean isMixCalled() {
        return mixCalled;
    }

    public static boolean isDetectFlavourCalled() {
        return detectFlavourCalled;
    }
}
