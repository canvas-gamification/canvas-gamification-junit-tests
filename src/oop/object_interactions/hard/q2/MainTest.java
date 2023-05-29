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

    private static Stream<Arguments> setInputProvider() {
        return Stream.of(
                Arguments.of("Joe", "Hammock", "Not Joe", "Not Hammock"),
                Arguments.of("Bob", "Dod", "Dod", "Bob"),
                Arguments.of("Julie", "Novik", "Sterling", "Novak"),
                Arguments.of("Null", "null", "Richard", "Kessler")
        );
    }

    @ParameterizedTest
    @MethodSource("setInputProvider")
    public void correctSetNameMethod(String fName, String lName, String newFName, String newLName) throws Throwable {
        Object[][] constructorArguments = {
                {fName, String.class},
                {lName, String.class}
        };
        Object instance = classInstance.createInstance(constructorArguments);

        assertTrue(classInstance.hasMethod(setStringAttribute1, new Class[]{String.class}, Void.TYPE, new String[]{"public"}),
                String.format("Your %s class is missing the %s method, or the method name was spelt incorrectly.",
                        objectClassName, setStringAttribute1));
        Object[][] setArguments = {{newFName, String.class}};
        classInstance.callMethod(setStringAttribute1, setArguments, instance);
        _assertEquals(newFName, classInstance.getFieldValue(instance, stringAttribute1),
                String.format("Your %s method does not update the %s attribute with the correct value.", setStringAttribute1, stringAttribute1));

        assertTrue(classInstance.hasMethod(setStringAttribute2, new Class[]{String.class}, Void.TYPE, new String[]{"public"}),
                String.format("Your %s class is missing the %s method, or the method name was spelt incorrectly.",
                        objectClassName, setStringAttribute2));
        setArguments = new Object[][]{{newLName, String.class}};
        classInstance.callMethod(setStringAttribute2, setArguments, instance);
        _assertEquals(newLName, classInstance.getFieldValue(instance, stringAttribute2),
                String.format("Your %s method does not update the %s attribute with the correct value.", setStringAttribute2, stringAttribute2));
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void correctToStringMethod(String fName, String lName) throws Throwable {
        Object[][] constructorArguments = {
                {fName, String.class},
                {lName, String.class}
        };
        Object instance = classInstance.createInstance(constructorArguments);
        Object output = classInstance.callMethod("toString", instance);
        String expected = String.format("My name is: %s %s.", fName, lName);
        _assertEquals(expected, output,
                String.format("Your toString method for the %s class does not return the correct output. Please ensure you match the sample exactly and have not misspelled anything.", objectClassName));
    }

    private static Stream<Arguments> methodInputProvider() {
        return Stream.of(
                Arguments.of("Linda", "Johnson", "June", "Mayfield", "Johnson-Mayfield"),
                Arguments.of("Joseph", "Borrington", "Percy", "Borringson", "Borrington-Borringson"),
                Arguments.of("Colline", "Fisher", "Mina", "Harker", "Fisher-Harker"),
                Arguments.of("Real Name", "Last Name", "Realer First Name", "null", "Last Name-null")
        );
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    public void correctMarryMeMethod(String fName1, String lName1, String fName2, String lName2, String conjoined) throws Throwable {
        Object[][] person1Arguments = {
                {fName1, String.class},
                {lName1, String.class}
        };
        Object[][] person2Arguments = {
                {fName2, String.class},
                {lName2, String.class}
        };
        Object instance1 = classInstance.createInstance(person1Arguments);
        Object instance2 = classInstance.createInstance(person2Arguments);
        assertTrue(classInstance.hasMethod(methodName1, new Class[]{classInstance.getObjectClass()}, Void.TYPE, new String[]{"public"}),
                String.format(
                        "Your %s class is missing the %s method. Please check that the name is spelled correctly, the parameters and return type are correct, and it has the correct visibility modifier.",
                        objectClassName, methodName1
                ));
        Object[][] methodArguments = {{instance2, classInstance.getObjectClass()}};
        classInstance.callMethod(methodName1, methodArguments, instance1);
        _assertEquals(conjoined, classInstance.getFieldValue(instance1, stringAttribute2),
                String.format("Your %s method does not correctly update the last name of the %s calling the %s method.",
                        methodName1, objectClassName, methodName1));
        _assertEquals(conjoined, classInstance.getFieldValue(instance2, stringAttribute2),
                String.format("Your %s method does not correctly update the last name of the %s passed to the %s method.",
                        methodName1, objectClassName, methodName1));
    }

    private static Stream<Arguments> workTogetherInputProvider() {
        return Stream.of(
                Arguments.of("Kathy", "Saints", "Max", "Gladstone", "Emma", "Straub", "Straub-Gladstone"),
                Arguments.of("Catherynne", "Valente", "Steven", "Barnes", "Tananarive", "Due", "Due-Barnes"),
                Arguments.of("Brooke", "Bolander", "Rachel", "Swirsky", "null", "Rickert", "Rickert-Swirsky")
        );
    }

    @ParameterizedTest
    @MethodSource("workTogetherInputProvider")
    public void partnerMethodsWorkCorrectlyWorkTogether(String fName1, String lName1, String fName2, String lName2, String newFName, String newLName, String conjoined) throws Throwable {
        Object[][] person1Arguments = {
                {fName1, String.class},
                {lName1, String.class}
        };
        Object[][] person2Arguments = {
                {fName2, String.class},
                {lName2, String.class}
        };
        Object instance1 = classInstance.createInstance(person1Arguments);
        Object instance2 = classInstance.createInstance(person2Arguments);

        classInstance.callMethod(setStringAttribute1, new Object[][]{{newFName, String.class}}, instance1);
        classInstance.callMethod(setStringAttribute2, new Object[][]{{newLName, String.class}}, instance1);
        Object output1 = classInstance.callMethod(getStringAttribute1, instance1);
        Object output2 = classInstance.callMethod(getStringAttribute2, instance1);
        classInstance.callMethod(methodName1, new Object[][]{{instance2, classInstance.getObjectClass()}}, instance1);
        Object toStringOutput = classInstance.callMethod("toString", instance1);
        String expectedToStringOutput = "My name is: " + newFName + " " + conjoined + ".";
        String incorrectSetGet =
                "Your %s method does not return the correct value after updating the %s attribute using the %s method.";
        String incorrectToString = "Your toString method does not return the correct String after updating the %s and %s attributes using the %s, %s and %s methods.";
        _assertEquals(newFName, output1,
                String.format(incorrectSetGet, getStringAttribute1, stringAttribute1, setStringAttribute1));
        _assertEquals(newLName, output2,
                String.format(incorrectSetGet, getStringAttribute2, stringAttribute2, setStringAttribute2));
        _assertEquals(expectedToStringOutput, toStringOutput,
                String.format(incorrectToString, stringAttribute1, stringAttribute2, setStringAttribute1,
                        setStringAttribute2, methodName1));
    }
}

