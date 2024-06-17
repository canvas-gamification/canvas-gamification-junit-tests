package oop.creating_objects_from_classes.hard.q2;

/* NOTE: This class needs to be moved under the test file on the website so the student can access it */
class WaterToy {
    String colour;
    double size;
    boolean inflated;
    /*
     * These values below are used to track the actions of the student in their test class. They track what values they
     * initialize the dog object to, and if they have called the methods they are supposed to.
     */
    private static WaterToy waterToy;
    private static boolean constructorCalled = false;
    private static String constructedColour;
    private static double constructedSize;
    private static boolean constructedInflated;
    private static boolean inflateCalled = false;
    private static boolean throwInPoolCalled = false;

    public WaterToy(String c, double s, boolean i) {
        constructorCalled = true;
        if(waterToy == null) {
            colour = c;
            size = s;
            inflated = i;
            waterToy = this;
            constructedColour = c;
            constructedSize = s;
            constructedInflated = i;
        }
    }

    public void inflate(){
        inflateCalled = true;
        inflated = true;
    }

    public void throwInWater(){
        throwInPoolCalled = true;
        System.out.println("Splash!");
    }

    public static WaterToy getWaterToy() {
        return waterToy;
    }

    public static boolean isConstructorCalled() {
        return constructorCalled;
    }

    public static String getConstructedColour() {
        return constructedColour;
    }

    public static double getConstructedSize() {
        return constructedSize;
    }

    public static boolean isConstructedInflated() {
        return constructedInflated;
    }

    public static boolean isInflateCalled() {
        return inflateCalled;
    }

    public static boolean isThrowInPoolCalled() {
        return throwInPoolCalled;
    }
}
