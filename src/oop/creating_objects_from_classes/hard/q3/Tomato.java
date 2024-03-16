package oop.creating_objects_from_classes.hard.q3;

/* NOTE: This class needs to be moved under the test file on the website so the student can access it */
public class Tomato {
    private String type;
    private String nickname;
    /*
     * These values below are used to track the actions of the student in their test class. They track what values they
     * initialize the tomato objects to, and if they have called the methods they are supposed to.
     */
    private static Tomato tomato1;
    private static Tomato tomato2;
    private static Tomato tomato3;
    private static Tomato tomato4;
    private static boolean constructor1Called = false;
    private static boolean constructor2Called = false;
    private static boolean constructor3Called = false;
    private static boolean methodCalled = false;
    private static String constructor2Type;
    private static String constructor3Type;
    private static String constructor3Nickname;
    private static String methodNickname;

    public Tomato() {
        constructor1Called = true;
        if (tomato1 == null) {
            tomato1 = this;
        }
    }

    public Tomato(String t) {
        constructor2Called = true;
        type = t;
        if (tomato2 == null) {
            tomato2 = this;
            constructor2Type = t;
        }
    }

    public Tomato(String t, String n) {
        constructor3Called = true;
        type = t;
        nickname = n;
        if (tomato3 == null) {
            tomato3 = this;
            constructor3Type = t;
            constructor3Nickname = n;
        }
    }

    public Tomato produceSeed(String n) {
        methodCalled = true;
        if (tomato4 == null) {
            tomato4 = new Tomato(this.type, n);
            methodNickname = n;
            return tomato4;
        }
        else {
            return new Tomato(this.type, n);
        }
    }

    public String getType() {
        return type;
    }

    public String getNickname() {
        return nickname;
    }

    public static Tomato getTomato1() {
        return tomato1;
    }

    public static Tomato getTomato2() {
        return tomato2;
    }

    public static Tomato getTomato3() {
        return tomato3;
    }

    public static Tomato getTomato4() {
        return tomato4;
    }

    public static boolean isConstructor1Called() {
        return constructor1Called;
    }

    public static boolean isConstructor2Called() {
        return constructor2Called;
    }

    public static boolean isConstructor3Called() {
        return constructor3Called;
    }

    public static boolean isMethodCalled() {
        return methodCalled;
    }

    public static String getConstructor2Type() {
        return constructor2Type;
    }

    public static String getConstructor3Type() {
        return constructor3Type;
    }

    public static String getConstructor3Nickname() {
        return constructor3Nickname;
    }

    public static String getMethodNickname() {
        return methodNickname;
    }
}
