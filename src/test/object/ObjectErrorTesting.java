package test.object;

import global.ObjectTest;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ObjectErrorTesting {
    @Test
    public void test() throws Throwable {
        ObjectTest objectTest = new ObjectTest("test.object.Cow");
        ObjectTest test2 = new ObjectTest("test.object.Animal");
        assertTrue(objectTest.implementsInterface(Serializable.class), "Your Cow class does not implement a required interface.");
        assertTrue(objectTest.implementsInterfaces(new Class<?>[]{Serializable.class, Iterable.class}), "Hola");
        assertTrue(objectTest.hasSuperclass(test2.getObjectClass()), "Does not extend Animal class.");
        objectTest.createInstance();
    }
}
