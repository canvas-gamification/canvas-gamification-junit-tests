package oop.object_interactions.hard.q2;

import global.ObjectTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    private ObjectTest classInstance;
    private final String objectClassName = "Partner";
    private final String stringAttribute1 = "firstName";
    private final String stringAttribute2 = "lastName";
    private final String getStringAttribute1 = "getFirstName";
    private final String getStringAttribute2 = "getLastName";
    private final String setStringAttribute1 = "setFirstName";
    private final String setStringAttribute2 = "setLastName";
    private final String methodName1 = "marryMe";

    @BeforeEach
    public void setup() {
        String objectString = "oop.object_interactions.hard.q2." + objectClassName;
        classInstance = new ObjectTest(objectString);
    }

    @Test
    public void partnerClassHasRequiredAttributes() {
        assertTrue(classInstance.hasField(stringAttribute1, String.class),
                String.format("We expected an attribute named %s in your code but it was not found or was misspelled.", stringAttribute1));
        assertTrue(classInstance.hasField(stringAttribute2, String.class),
                String.format("We expected an attribute named %s in your code but it was not found or was misspelled.", stringAttribute2));
        assertTrue(classInstance.hasModifier(stringAttribute1, "private"),
                String.format("The %s field does not have the correct visibility modifier.", stringAttribute1));
        assertTrue(classInstance.hasModifier(stringAttribute2, "private"),
                String.format("The %s field does not have the correct visibility modifier.", stringAttribute2));
    }

    private static Stream<Arguments> constructorInputProvider() {
        return Stream.of(
                Arguments.of("John", "Cena"),
                Arguments.of("Vincent", "Van Gogh"),
                Arguments.of("Cindy", "Marks")
        );
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void partnerClassHasCorrectConstructor(String fName, String lName) throws Throwable {
        Object[][] arguments = {
                {fName, String.class},
                {lName, String.class}
        };
        assertTrue(classInstance.hasConstructor(new Class[]{String.class, String.class}, new String[]{"public"}),
                String.format("Your %s class is missing a required constructor or has the incorrect visibility modifier.", objectClassName));
        Object instance = classInstance.createInstance(arguments);
        _assertEquals(fName, classInstance.getFieldValue(instance, stringAttribute1),
                String.format("Your %s constructor does not correctly initialize the %s attribute.", objectClassName, stringAttribute1));
        _assertEquals(lName, classInstance.getFieldValue(instance, stringAttribute2),
                String.format("Your %s constructor does not correctly initialize the %s attribute.", objectClassName, stringAttribute2));
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void correctGetMethods(String fName, String lName) throws Throwable {
        Object[][] constructorArguments = {
                {fName, String.class},
                {lName, String.class}
        };
        Object instance = classInstance.createInstance(constructorArguments);
        String incorrectGetMethods = "Your %s method does not return the value of the %s attribute.";
        assertTrue(classInstance.hasMethod(getStringAttribute1, null, String.class, new String[]{"public"}),
                String.format("Your %s class is missing the %s method, or the %s method has the wrong return type.", objectClassName, getStringAttribute1, getStringAttribute1));
        assertTrue(classInstance.hasMethod(getStringAttribute2, null, String.class, new String[]{"public"}),
                String.format("Your %s class is missing the %s method, or the %s method has the wrong return type.", objectClassName, getStringAttribute2, getStringAttribute2));

        Object output = classInstance.callMethod(getStringAttribute1, new String[]{"public"}, instance);
        _assertEquals(fName, output, String.format(incorrectGetMethods, getStringAttribute1, stringAttribute1));
        output = classInstance.callMethod(getStringAttribute2, new String[]{"public"}, instance);
        _assertEquals(lName, output, String.format(incorrectGetMethods, getStringAttribute2, stringAttribute2));
    }

    private static Stream<Arguments> setNameInputProvider() {
        return Stream.of(
                Arguments.of("Joe", "Not Joe"),
                Arguments.of("Initial Name", "Updated Name Right Here$$$"),
                Arguments.of("1245B$53", "dwdn842")
        );
    }

    @ParameterizedTest
    @MethodSource("setNameInputProvider")
    public void correctSetNameMethod(String nameInitial, String nameFinal) throws Throwable {
        Object[][] constructorArguments = {
                {nameInitial, String.class},
                {"Dob", String.class}
        };
        Object passportInstance = classInstance.createInstance(constructorArguments);
        assertTrue(classInstance.hasMethod(setStringAttribute2, new Class[]{String.class}, Void.TYPE, new String[]{"private"}),
                String.format("Your %s class is missing the %s method, or the method name was spelt incorrectly.",
                        objectClassName, setStringAttribute1));
        Object[][] setArguments = {{nameFinal, String.class}};
        classInstance.callMethod(setStringAttribute1, setArguments, passportInstance);
        _assertEquals(nameFinal, classInstance.getFieldValue(passportInstance, stringAttribute1),
                String.format("Your %s method does not update the %s attribute with the correct value.", setStringAttribute1, stringAttribute1));
    }

    private static Stream<Arguments> setDobInputProvider() {
        return Stream.of(
                Arguments.of("July 1st, 1867", "Today"),
                Arguments.of("14/11/1976", "31/04/2004"),
                Arguments.of("Null", "Null"),
                Arguments.of("My birthdate", "")
        );
    }

    @ParameterizedTest
    @MethodSource("setDobInputProvider")
    public void correctSetDobMethod(String dobInitial, String dobFinal) throws Throwable {
        Object[][] constructorArguments = {
                {"Joe", String.class},
                {dobInitial, String.class}
        };
        Object passportInstance = classInstance.createInstance(constructorArguments);
        assertTrue(classInstance.hasMethod(setStringAttribute2, new Class[]{String.class}, Void.TYPE, new String[]{"private"}),
                String.format("Your %s class is missing the %s method, or the method name was spelt incorrectly.",
                        objectClassName, setStringAttribute2));
        Object[][] setArguments = {{dobFinal, String.class}};
        classInstance.callMethod(setStringAttribute2, setArguments, passportInstance);
        _assertEquals(dobFinal, classInstance.getFieldValue(passportInstance, stringAttribute2),
                String.format("Your %s method does not update the %s attribute with the correct value.", setStringAttribute2, stringAttribute2));
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void correctToStringMethod(String name, String dob) throws Throwable {
        Object[][] constructorArguments = {
                {name, String.class},
                {dob, String.class}
        };
        Object passportInstance = classInstance.createInstance(constructorArguments);
        Object output = classInstance.callMethod("toString", passportInstance);
        String expected = String.format("My name is %s, and I was born on %s.", name, dob);
        _assertEquals(expected, output,
                String.format("Your toString method for the %s class does not return the correct output. Please ensure you match the sample exactly and have not misspelled anything.", objectClassName));
    }

    private static Stream<Arguments> stealMethodInputProvider() {
        return Stream.of(
                Arguments.of("Linda Johnson", "June 3, 1945", "Linda Jonson", "June 3, 1945 "),
                Arguments.of("Joseph P. Borrington III", "14/05/2023", "Joey", "I forgot my birthday :("),
                Arguments.of("Chicken Little $$$", "3rd August, 1242,24", "Chicken Big %%%", "01/01/345")
        );
    }

    @ParameterizedTest
    @MethodSource("stealMethodInputProvider")
    public void correctStealMethod(String name1, String dob1, String name2, String dob2) throws Throwable {
        Object[][] passport1Arguments = {
                {name1, String.class},
                {dob1, String.class}
        };
        Object[][] passport2Arguments = {
                {name2, String.class},
                {dob2, String.class}
        };
        Object passportInstance1 = classInstance.createInstance(passport1Arguments);
        Object passportInstance2 = classInstance.createInstance(passport2Arguments);
        assertTrue(classInstance.hasMethod(methodName1, new Class[]{classInstance.getObjectClass()}, Void.TYPE, new String[]{"public"}),
                String.format(
                        "Your %s class is missing the %s method. Please check that the name is spelled correctly, the parameters and return type are correct, and it has the correct visibility modifier.",
                        objectClassName,
                        methodName1
                ));
        Object[][] stealArguments = {{passportInstance2, classInstance.getObjectClass()}};
        classInstance.callMethod(methodName1, stealArguments, passportInstance1);
        _assertEquals(name2, classInstance.getFieldValue(passportInstance1, stringAttribute1),
                String.format("Your %s method does not copy the %s value from the input %s.", methodName1, stringAttribute1, objectClassName));
        _assertEquals(dob2, classInstance.getFieldValue(passportInstance1, stringAttribute2),
                String.format("Your %s method does not copy the %s value from the input %s.", methodName1, stringAttribute2, objectClassName));
        _assertEquals(name2, classInstance.getFieldValue(passportInstance2, stringAttribute1),
                String.format("Your %s method should not modify the %s value from the input %s.", methodName1, stringAttribute1, objectClassName));
        _assertEquals(dob2, classInstance.getFieldValue(passportInstance2, stringAttribute2),
                String.format("Your %s method should not modify the %s value from the input %s.", methodName1, stringAttribute2, objectClassName));
    }
}

