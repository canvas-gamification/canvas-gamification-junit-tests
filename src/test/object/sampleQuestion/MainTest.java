package test.object.sampleQuestion;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.StringLiteral;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    // Tests for Person class
    private final String defaultName = "Bob";
    private final int defaultAge = 21;
    private final boolean defaultEmployed = false;
    private final String personClassString = "test.object.sampleQuestion.Person";
    private final String houseClassString = "test.object.sampleQuestion.House";

    @Test
    public void programContainsPersonClass() {
        new ObjectTest(personClassString);
    }

    @Test
    public void personClassHasRequiredFields() {
        ObjectTest objectTest = new ObjectTest(personClassString);
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
        ObjectTest objectTest = new ObjectTest(personClassString);
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
        ObjectTest objectTest = new ObjectTest(personClassString);

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

    // TODO: Add modifier checks to methods

    @ParameterizedTest
    @MethodSource("nameInputProvider")
    public void correctGetNameMethod(String name) throws Throwable {
        ObjectTest objectTest = new ObjectTest(personClassString);
        Object[][] arguments = {{name, String.class}};
        Object person = objectTest.createInstance(arguments);
        String[] modifiers = {"public"};
        Object output = objectTest.callMethod("getName", modifiers, person);
        assertEquals(name, output, "Your getName method does not return the value of the name field.");
    }

    @ParameterizedTest
    @MethodSource("nameInputProvider")
    public void correctSetNameMethod(String name) throws Throwable {
        ObjectTest objectTest = new ObjectTest(personClassString);
        Object person = objectTest.createInstance();
        Object[][] arguments = {{name, String.class}};
        String[] modifiers = {"public"};
        objectTest.callMethod("setName", arguments, modifiers, person);
        Object updatedName = objectTest.getFieldValue(person, "name");
        assertEquals(name, updatedName, "Your setName method does not update the value of the name field.");
    }

    @ParameterizedTest
    @MethodSource("ageInputProvider")
    public void correctGetAgeMethod(int age) throws Throwable {
        ObjectTest objectTest = new ObjectTest(personClassString);
        Object[][] arguments = {{age, int.class}};
        Object person = objectTest.createInstance(arguments);
        String[] modifiers = {"public"};
        Object output = objectTest.callMethod("getAge", modifiers, person);
        assertEquals(age, output, "Your getAge method does not return the value of the age field.");
    }

    @ParameterizedTest
    @MethodSource("ageInputProvider")
    public void correctSetAgeMethod(int age) throws Throwable {
        ObjectTest objectTest = new ObjectTest(personClassString);
        Object person = objectTest.createInstance();
        Object[][] arguments = {{age, int.class}};
        String[] modifiers = {"public"};
        objectTest.callMethod("setAge", arguments, modifiers, person);
        Object updatedAge = objectTest.getFieldValue(person, "age");
        assertEquals(age, updatedAge, "Your setAge method does not update the value of the age field.");
    }

    @ParameterizedTest
    @MethodSource("getEmployedInputProvider")
    public void correctIsEmployedMethod(boolean employed) throws Throwable {
        ObjectTest objectTest = new ObjectTest(personClassString);
        Object[][] arguments = {{employed, boolean.class}};
        String[] modifiers = {"public"};
        Object person = objectTest.createInstance(arguments);
        Object output = objectTest.callMethod("isEmployed", modifiers, person);
        assertEquals(employed, output, "Your isEmployed method does not return the value of the employed field.");
    }

    @ParameterizedTest
    @MethodSource("setEmployedInputProvider")
    public void correctSetEmployedMethod(boolean initialEmployed, boolean updateEmployed) throws Throwable {
        ObjectTest objectTest = new ObjectTest(personClassString);
        Object[][] constructionArguments = {{initialEmployed, boolean.class}};
        Object person = objectTest.createInstance(constructionArguments);
        Object[][] arguments = {{updateEmployed, boolean.class}};
        String[] modifiers = {"public"};
        objectTest.callMethod("setEmployed", arguments, modifiers, person);
        Object updatedAge = objectTest.getFieldValue(person, "employed");
        assertEquals(updateEmployed, updatedAge, "Your setEmployed method does not update the value of the employed field.");
    }

    @ParameterizedTest
    @MethodSource("nameInputProvider")
    public void correctPrintNameMethod(String name) throws Throwable {
        ObjectTest objectTest = new ObjectTest(personClassString);
        Object[][] arguments = {{name, String.class}};
        Object person = objectTest.createInstance(arguments);
        String[] modifiers = {"public"};
        Clause[] methodSentence = {
                new StringLiteral(name)
        };
        objectTest.callMethod("printName", modifiers, person, methodSentence,
                "Your printName method in the Person class does not correctly print the name field.");
    }

    // TODO: Tests for House class

    @Test
    public void programContainsHouseClass() {
        new ObjectTest(houseClassString);
    }

    @Test
    public void houseClassHasRequiredFields() {
        ObjectTest objectTest = new ObjectTest(houseClassString);
        ObjectTest person = new ObjectTest(personClassString);
        assertTrue(objectTest.hasField("residents", person.getObjectClass().arrayType()),
                "Your House class is missing the Person[] residents field.");
        assertTrue(objectTest.hasModifier("residents", "private"),
                "Your House class residents field does not have the correct modifiers.");
        assertTrue(objectTest.hasField("number", int.class),
                "Your House class is missing the int number field.");
        assertTrue(objectTest.hasModifier("number", "private"),
                "Your House class number field does not have the correct modifiers.");
        assertTrue(objectTest.hasField("address", String.class),
                "Your House class is missing the String address field.");
        assertTrue(objectTest.hasModifier("address", "private"),
                "Your House class address filed does not have the correct modifiers.");
    }

    @Test
    public void houseClassHasRequiredConstructors() throws Throwable {
        ObjectTest houseClass = new ObjectTest(this.houseClassString);
        ObjectTest personClass = new ObjectTest(this.personClassString);
        String defaultAddress = "nowhere";
        int defaultNumber = 0;
        Object defaultResidents = personClass.createArray(0);

        // Default Constructor
        Object house = houseClass.createInstance();
        assertEquals(defaultAddress, houseClass.getFieldValue(house, "address"),
                "Your House default constructor does not initialize the address field to the correct value.");
        assertEquals(defaultNumber, houseClass.getFieldValue(house, "number"),
                "Your House default constructor does not initialize the address field to the correct value.");
        _assertArrayEquals(defaultResidents, houseClass.getFieldValue(house, "residents"),
                "Your House default constructor does not initialize the residents field to the correct value.");
    }
}
