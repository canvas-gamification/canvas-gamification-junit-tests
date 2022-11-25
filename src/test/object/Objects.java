package test.object;

import global.ObjectTest;

// TODO: Improve error messages

public class Objects {
    public static void main(String[] args) throws Throwable {
        Object[][] arguments = {
                {4, int.class},
                {"160 Spruce Close SE", String.class}
        };
        ObjectTest objectTest = new ObjectTest("test.object.House");
        Object output = objectTest.createInstance(arguments);
        House h = new House(4, "test");

    }
}
