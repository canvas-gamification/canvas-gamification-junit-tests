package oop.creating_objects_from_classes.hard.q5;

/* NOTE: This class needs to be moved under the test file on the website so the student can access it */
public class Basketball {
    double size;
    String condition;
    /*
     * These values below are used to track the actions of the student in their test class. They track what values they
     * initialize the basketball object to, and if they have called the methods they are supposed to.
     */
    private static Basketball ball;
    private static boolean constructorCalled = false;
    private static double constructorSize;
    private static String constructorCondition;
    private static boolean inflateCalled = false;
    private static boolean playGameCalled = false;
    private static Basketball ballInPlay;
    private static boolean orderMoreCalled = false;
    private static int number;
    private static Basketball[] otherBalls;

    public Basketball(double s, String c) {
        if(!constructorCalled) {
            constructorCalled = true;
            ball = this;
            constructorSize = s;
            constructorCondition = c;
        }
        size = s;
        condition = c;
    }

    public void inflate(){
        inflateCalled = true;
        condition = "great";
    }

    public void playGame(){
        playGameCalled = true;
        ballInPlay = this;
        System.out.println("Cheers!");
    }

    public Basketball[] orderMore(int amount){
        orderMoreCalled = true;
        number = amount;
        Basketball[] newBalls = new Basketball[amount];
        for(int x = 0; x < amount; x++){
            newBalls[x] = new Basketball(this.size, "new");
        }
        otherBalls = newBalls;
        return newBalls;
    }

    public static Basketball getBall() {
        return ball;
    }

    public static boolean isConstructorCalled() {
        return constructorCalled;
    }

    public static double getConstructorSize() {
        return constructorSize;
    }

    public static String getConstructorCondition() {
        return constructorCondition;
    }

    public static boolean isInflateCalled() {
        return inflateCalled;
    }

    public static boolean isPlayGameCalled() {
        return playGameCalled;
    }

    public static boolean isOrderMoreCalled() {
        return orderMoreCalled;
    }

    public static int getNumber() {
        return number;
    }

    public static Basketball getBallInPlay() {
        return ballInPlay;
    }

    public static Basketball[] getOtherBalls() {
        return otherBalls;
    }
}
