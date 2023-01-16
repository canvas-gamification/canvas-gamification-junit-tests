package test.object.sampleQuestion;

import global.ObjectTest;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    @Test
    public void programContainsPersonClass() {
        new ObjectTest("test.object.sampleQuestion.Person");
    }

    @Test
    public void personClassHasRequiredFields() {
        ObjectTest objectTest = new ObjectTest("test.object.sampleQuestion.Person");
        assertTrue(objectTest.hasField("name", String.class),
                "Your Person class is missing the string name field.");
        assertTrue(objectTest.hasModifier("name", "private"),
                "Your Person class name field does not have the correct modifiers.");
        assertTrue(objectTest.hasField("age", int.class),
                "Your Person class is missing the int age field.");
        assertTrue(objectTest.hasModifier("age", "private"),
                "Your Person class age field does not have the correct modifiers.");
        assertTrue(objectTest.hasField("employed", boolean.class),
                "Your Person class is missing the boolean employed field.");
        assertTrue(objectTest.hasModifier("employed", "private"),
                "Your Person class employed field does not have the correct modifiers.");
    }

    @Test
    public void personClassHasRequiredConstructors() {
        /*
            This test checks that the Person class has the required constructors, and that the constructors all have
            the public modifier.
         */
        ObjectTest objectTest = new ObjectTest("test.object.sampleQuestion.Person");
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
    public void personClassConstructorsInitializeCorrectValues() throws Throwable {
        ObjectTest objectTest = new ObjectTest("test.object.sampleQuestion.Person");
        // Default constructor
        Object person = objectTest.createInstance();
        assertEquals("Bob", objectTest.getFieldValue(person, "name"),
                "Your Person default constructor does not initialize the name field to the correct value.");
        assertEquals(21, objectTest.getFieldValue(person, "age"),
                "Your Person default constructor does not initialize the age field to the correct value.");
        assertEquals(false, objectTest.getFieldValue(person, "employed"),
                "Your Person default constructor does not initialize the employed field to the correct value.");

        // String name constructor
        Object[][] arguments = {{"Caroline", String.class}};
        person = objectTest.createInstance(arguments);
        assertEquals("Caroline", objectTest.getFieldValue(person, "name"),
                "Your Person String name constructor does not initialize the name field to the correct value.");
        assertEquals(21, objectTest.getFieldValue(person, "age"),
                "Your default Person constructor does not initialize the age field to the correct value.");
        assertEquals(false, objectTest.getFieldValue(person, "employed"),
                "Your default Person constructor does not initialize the employed field to the correct value.");

        // int age constructor
        arguments = new Object[][]{{39, int.class}};
        person = objectTest.createInstance(arguments);
        assertEquals("Bob", objectTest.getFieldValue(person, "name"),
                "Your Person String name constructor does not initialize the name field to the correct value.");
        assertEquals(39, objectTest.getFieldValue(person, "age"),
                "Your Person String name constructor does not initialize the age field to the correct value.");
        assertEquals(false, objectTest.getFieldValue(person, "employed"),
                "Your Person String name constructor does not initialize the employed field to the correct value.");

        // boolean employed constructor
        arguments = new Object[][]{{true, boolean.class}};
        person = objectTest.createInstance(arguments);
        assertEquals("Bob", objectTest.getFieldValue(person, "name"),
                "Your Person boolean employed constructor does not initialize the name field to the correct value.");
        assertEquals(21, objectTest.getFieldValue(person, "age"),
                "Your Person boolean employed constructor does not initialize the age field to the correct value.");
        assertEquals(true, objectTest.getFieldValue(person, "employed"),
                "Your Person boolean employed constructor does not initialize the employed field to the correct value.");

        // String name, int age constructor
        arguments = new Object[][]{
                {"Charlie", String.class},
                {4, int.class}
        };
        person = objectTest.createInstance(arguments);
        assertEquals("Charlie", objectTest.getFieldValue(person, "name"),
                "Your Person String name, int age constructor does not initialize the name field to the correct value.");
        assertEquals(4, objectTest.getFieldValue(person, "age"),
                "Your Person String name, int age constructor does not initialize the age field to the correct value.");
        assertEquals(false, objectTest.getFieldValue(person, "employed"),
                "Your Person String name, int age constructor does not initialize the employed field to the correct value.");
    }
}
