package oop.creating_objects_from_classes.hard.q1;

/* NOTE: This class needs to be moved under the test file on the website so the student can access it */
class Dog {
    private String name;
    private int age;
    private double weight;
    /*
     * These values below are used to track the actions of the student in their test class. They track what values they
     * initialize the dog object to, and if they have called the methods they are supposed to.
     */
    private static Dog dog;
    private static boolean constructorCalled = false;
    private static String constructorName;
    private static double constructorWeight;
    private static int constructorAge;
    private static boolean eatCalled = false;
    private static boolean barkCalled = false;

    public Dog(String n, int a, double w) {
        constructorCalled = true;
        if (dog == null) {
            name = n;
            age = a;
            weight = w;
            dog = this;
            constructorAge = a;
            constructorWeight = w;
            constructorName = n;
        }
    }

    public void eat() {
        eatCalled = true;
        weight += 2.5;
    }

    public void bark() {
        barkCalled = true;
        System.out.println("Bark!");
    }

    public static Dog getDog() {
        return dog;
    }

    public static boolean getBarkCalled() {
        return barkCalled;
    }

    public static boolean getEatCalled() {
        return eatCalled;
    }

    public static boolean getConstructorCalled() {
        return constructorCalled;
    }

    public static String getConstructorName() {
        return constructorName;
    }

    public static int getConstructorAge() {
        return constructorAge;
    }

    public static double getConstructorWeight() {
        return constructorWeight;
    }
}
