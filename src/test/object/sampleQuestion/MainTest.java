package test.object.sampleQuestion;

import global.ObjectTest;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    @Test
    public void personClassHasRequiredConstructors() {
        ObjectTest objectTest = new ObjectTest("test.object.sampleQuestion.Person");
        assertTrue(objectTest.hasConstructor(null),
                "Your Person class does not have a default constructor.");
        assertTrue(objectTest.hasModifier(new Class[]{}, "public"),
                "Your Person class default constructor does not have the correct modifiers.");
        assertTrue(objectTest.hasConstructor(new Class[]{int.class}), "Your Person class does not have a constructor");
    }
}
