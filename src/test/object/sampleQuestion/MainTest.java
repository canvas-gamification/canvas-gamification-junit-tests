package test.object.sampleQuestion;

import global.ObjectTest;
import global.tools.Logger;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.condition.DisabledIf;

import java.io.Console;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    private static ObjectTest objectTest;

    @Test
    public void programContainsPersonClass() {
        objectTest = new ObjectTest("test.object.sampleQuestion.Person");]
    }

    @Test
    public void personClassHasRequiredFields() {
        assertTrue(objectTest.hasField("name", String.class),
                "Your Person class is missing the string name field.");
        assertTrue(objectTest.hasModifier("name", "default"),
                "Your Person class name field does not have the correct modifiers.");
    }

    @Test
    public void personClassHasRequiredConstructors() {
        /*
            This test checks that the Person class has the required constructors, and that the constructors all have
            the public modifier.
         */
        assertTrue(objectTest.hasConstructor(null),
                "Your Person class does not have a default constructor.");
        assertTrue(objectTest.hasModifier(new Class[]{}, "public"),
                "Your Person class default constructor does not have the correct modifiers.");
        assertTrue(objectTest.hasConstructor(new Class[]{int.class}),
                "Your Person class does not have a constructor for only initializing the Person's age");
        assertTrue(objectTest.hasModifier(new Class[]{int.class}, "public"),
                "Your Person class int constructor does not have the correct modifiers.");
        assertTrue(objectTest.hasConstructor(new Class[]{String.class}),
                "Your Person class does not have a constructor with the String parameter.");
        assertTrue(objectTest.hasModifier(new Class[]{String.class}, "public"),
                "Your Person class String constructor does not have the correct modifiers.");
        assertTrue(objectTest.hasConstructor(new Class[]{String.class, int.class}),
                "Your Person class does not have a constructor with the String and int parameters.");
        assertTrue(objectTest.hasModifier(new Class[]{String.class, int.class}, "public"),
                "Your Person class String, int constructor does not have the correct modifiers.");
        assertTrue(objectTest.hasConstructor(new Class[]{String.class, boolean.class}),
                "Your Person class does not have a constructor with the parameters of String and boolean.");
        assertTrue(objectTest.hasModifier(new Class[]{String.class, boolean.class}, "public"),
                "Your Person class String, boolean constructor does not have the correct modifiers.");
        assertTrue(objectTest.hasConstructor(new Class[]{int.class, boolean.class}),
                "Your Person class does not have a constructor with the parameters of int and boolean.");
        assertTrue(objectTest.hasModifier(new Class[]{int.class, boolean.class}, "public"),
                "Your Person class int, boolean constructor does not have the correct modifiers.");
        assertTrue(objectTest.hasConstructor(new Class[]{String.class, int.class, boolean.class}),
                "Your Person class does not have a constructor with the parameters of String, int, and boolean.");
    }

    @Test
    public void personClassConstructorsInitializeCorrectValues() {
    }
}
