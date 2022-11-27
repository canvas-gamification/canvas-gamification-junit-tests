package test.object;

import global.ObjectTest;

import java.lang.reflect.Field;

// TODO: Improve error messages

public class Objects {
    public static void main(String[] args) throws Throwable {
//        Field f = House.class.getDeclaredField("number");
//        ObjectTest objectTest = new ObjectTest("test.object.House");
//        boolean b = objectTest.checkModifier(f, "public");
//        System.out.println(b);
        Field ft = test.class.getDeclaredField("x");
        ObjectTest o = new ObjectTest("test.object.test");
        o.checkModifier(ft, "interface");
    }
}

class test {
    public static final int x = 5;
}
