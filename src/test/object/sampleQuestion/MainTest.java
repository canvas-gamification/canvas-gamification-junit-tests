package test.object.sampleQuestion;

import global.ObjectTest;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    private final String defaultName = "Bob";
    private final int defaultAge = 21;
    private final boolean defaultEmployed = false;

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

    private static Stream<Arguments> constructorInputProvider() {
        return Stream.of(
                Arguments.of("Caroline", 35, true),
                Arguments.of("George", 20, false),
                Arguments.of("Elvin Elvis", 238, true),
                Arguments.of("Madalyn", 98, false),
                Arguments.of("Peterolomew", 1, true)
        );
    }

    private static Stream<String> nameInputProvider() {
        return Stream.of("Caroline", "George", "Elvin Elvis", "Madalyn", "Peterolomew");
    }

    private static Stream<Integer> ageInputProvider() {
        return Stream.of(4, 11, 91, 0, 2, 12993, 452);
    }

    private static Stream<Boolean> getEmployedInputProvider() {
        return Stream.of(true, false);
    }

    private static Stream<Arguments> setEmployedInputProvider() {
        return Stream.of(
                Arguments.of(true, true),
                Arguments.of(true, false),
                Arguments.of(false, true),
                Arguments.of(false, false)
        );
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void personClassConstructorsInitializeCorrectValues(String name, int age, boolean employed) throws Throwable {
        // Find object
        ObjectTest objectTest = new ObjectTest("test.object.sampleQuestion.Person");

        // Default constructor
        Object person = objectTest.createInstance();
        assertEquals(defaultName, objectTest.getFieldValue(person, "name"),
                "Your Person default constructor does not initialize the name field to the correct value.");
        assertEquals(defaultAge, objectTest.getFieldValue(person, "age"),
                "Your Person default constructor does not initialize the age field to the correct value.");
        assertEquals(defaultEmployed, objectTest.getFieldValue(person, "employed"),
                "Your Person default constructor does not initialize the employed field to the correct value.");

        // String name constructor
        Object[][] arguments = {{name, String.class}};
        person = objectTest.createInstance(arguments);
        assertEquals(name, objectTest.getFieldValue(person, "name"),
                "Your Person String name constructor does not initialize the name field to the correct value.");
        assertEquals(defaultAge, objectTest.getFieldValue(person, "age"),
                "Your default Person constructor does not initialize the age field to the correct value.");
        assertEquals(defaultEmployed, objectTest.getFieldValue(person, "employed"),
                "Your default Person constructor does not initialize the employed field to the correct value.");

        // int age constructor
        arguments = new Object[][]{{age, int.class}};
        person = objectTest.createInstance(arguments);
        assertEquals(defaultName, objectTest.getFieldValue(person, "name"),
                "Your Person String name constructor does not initialize the name field to the correct value.");
        assertEquals(age, objectTest.getFieldValue(person, "age"),
                "Your Person String name constructor does not initialize the age field to the correct value.");
        assertEquals(defaultEmployed, objectTest.getFieldValue(person, "employed"),
                "Your Person String name constructor does not initialize the employed field to the correct value.");

        // boolean employed constructor
        arguments = new Object[][]{{employed, boolean.class}};
        person = objectTest.createInstance(arguments);
        assertEquals(defaultName, objectTest.getFieldValue(person, "name"),
                "Your Person boolean employed constructor does not initialize the name field to the correct value.");
        assertEquals(defaultAge, objectTest.getFieldValue(person, "age"),
                "Your Person boolean employed constructor does not initialize the age field to the correct value.");
        assertEquals(employed, objectTest.getFieldValue(person, "employed"),
                "Your Person boolean employed constructor does not initialize the employed field to the correct value.");

        // String name, int age constructor
        arguments = new Object[][]{
                {name, String.class},
                {age, int.class}
        };
        person = objectTest.createInstance(arguments);
        assertEquals(name, objectTest.getFieldValue(person, "name"),
                "Your Person String name, int age constructor does not initialize the name field to the correct value.");
        assertEquals(age, objectTest.getFieldValue(person, "age"),
                "Your Person String name, int age constructor does not initialize the age field to the correct value.");
        assertEquals(defaultEmployed, objectTest.getFieldValue(person, "employed"),
                "Your Person String name, int age constructor does not initialize the employed field to the correct value.");

        // String name, boolean employed constructor
        arguments = new Object[][]{
                {name, String.class},
                {employed, boolean.class}
        };
        person = objectTest.createInstance(arguments);
        assertEquals(name, objectTest.getFieldValue(person, "name"),
                "Your Person String name, int age constructor does not initialize the name field to the correct value.");
        assertEquals(defaultAge, objectTest.getFieldValue(person, "age"),
                "Your Person String name, int age constructor does not initialize the age field to the correct value.");
        assertEquals(employed, objectTest.getFieldValue(person, "employed"),
                "Your Person String name, int age constructor does not initialize the employed field to the correct value.");

        // int age, boolean employed constructor
        arguments = new Object[][]{
                {age, int.class},
                {employed, boolean.class}
        };
        person = objectTest.createInstance(arguments);
        assertEquals(defaultName, objectTest.getFieldValue(person, "name"),
                "Your Person int age, boolean employed constructor does not initialize the name field to the correct value.");
        assertEquals(age, objectTest.getFieldValue(person, "age"),
                "Your Person int age, boolean employed constructor does not initialize the age field to the correct value.");
        assertEquals(employed, objectTest.getFieldValue(person, "employed"),
                "Your Person int age, boolean employed constructor does not initialize the employed field to the correct value.");

        // String name, int age, boolean employed constructor
        arguments = new Object[][]{
                {name, String.class},
                {age, int.class},
                {employed, boolean.class}
        };
        person = objectTest.createInstance(arguments);
        assertEquals(name, objectTest.getFieldValue(person, "name"),
                "Your Person String name, int age, boolean employed constructor does not initialize the name field to the correct value.");
        assertEquals(age, objectTest.getFieldValue(person, "age"),
                "Your Person String name, int age, boolean employed constructor does not initialize the age field to the correct value.");
        assertEquals(employed, objectTest.getFieldValue(person, "employed"),
                "Your Person String name, int age, boolean employed constructor does not initialize the employed field to the correct value.");
    }

    @ParameterizedTest
    @MethodSource("nameInputProvider")
    public void correctGetNameMethod(String name) throws Throwable {
        ObjectTest objectTest = new ObjectTest("test.object.sampleQuestion.Person");
        Object[][] arguments = {{name, String.class}};
        Object person = objectTest.createInstance(arguments);
        Object output = objectTest.callMethod("getName", person);
        assertEquals(name, output, "Your getName method does not return the value of the name field.");
    }

    @ParameterizedTest
    @MethodSource("nameInputProvider")
    public void correctSetNameMethod(String name) throws Throwable {
        ObjectTest objectTest = new ObjectTest("test.object.sampleQuestion.Person");
        Object person = objectTest.createInstance();
        Object[][] arguments = {{name, String.class}};
        objectTest.callMethod("setName", person, arguments);
        Object updatedName = objectTest.getFieldValue(person, "name");
        assertEquals(name, updatedName, "Your setName method does not update the value of the name field.");
    }

    @ParameterizedTest
    @MethodSource("ageInputProvider")
    public void correctGetAgeMethod(int age) throws Throwable {
        ObjectTest objectTest = new ObjectTest("test.object.sampleQuestion.Person");
        Object[][] arguments = {{age, int.class}};
        Object person = objectTest.createInstance(arguments);
        Object output = objectTest.callMethod("getAge", person);
        assertEquals(age, output, "Your getAge method does not return the value of the age field.");
    }

    @ParameterizedTest
    @MethodSource("ageInputProvider")
    public void correctSetAgeMethod(int age) throws Throwable {
        ObjectTest objectTest = new ObjectTest("test.object.sampleQuestion.Person");
        Object person = objectTest.createInstance();
        Object[][] arguments = {{age, int.class}};
        objectTest.callMethod("setAge", person, arguments);
        Object updatedAge = objectTest.getFieldValue(person, "age");
        assertEquals(age, updatedAge, "Your setAge method does not update the value of the age field.");
    }

    @ParameterizedTest
    @MethodSource("getEmployedInputProvider")
    public void correctIsEmployedMethod(boolean employed) throws Throwable {
        ObjectTest objectTest = new ObjectTest("test.object.sampleQuestion.Person");
        Object[][] arguments = {{employed, boolean.class}};
        Object person = objectTest.createInstance(arguments);
        Object output = objectTest.callMethod("isEmployed", person);
        assertEquals(employed, output, "Your isEmployed method does not return the value of the employed field.");
    }

    @ParameterizedTest
    @MethodSource("setEmployedInputProvider")
    public void correctSetEmployedMethod(boolean initialEmployed, boolean updateEmployed) throws Throwable {
        ObjectTest objectTest = new ObjectTest("test.object.sampleQuestion.Person");
        Object[][] constructionArguments = {{initialEmployed, boolean.class}};
        Object person = objectTest.createInstance(constructionArguments);
        Object[][] arguments = {{updateEmployed, boolean.class}};
        objectTest.callMethod("setEmployed", person, arguments);
        Object updatedAge = objectTest.getFieldValue(person, "employed");
        assertEquals(updateEmployed, updatedAge, "Your setEmployed method does not update the value of the employed field.");
    }
}
