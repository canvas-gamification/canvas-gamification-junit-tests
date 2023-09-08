package oop.object_interactions.hard.q1;

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
    private ObjectTest passport;
    private final String passportName = "Passport";
    private final String nameAttribute = "name";
    private final String dobAttribute = "dob";
    private final String getNameMethodName = "getName";
    private final String getDobMethodName = "getDob";
    private final String setNameMethodName = "setName";
    private final String setDobMethodName = "setDob";
    private final String stealMethodName = "steal";

    @BeforeEach
    public void setup() {
        String passportString = "oop.object_interactions.hard.q1." + passportName;
        passport = new ObjectTest(passportString);
    }

    @Test
    public void passportClassHasRequiredAttributes() {
        assertTrue(passport.hasField(nameAttribute, String.class),
                String.format("We expected an attribute named %s in your code but it was not found or was misspelled.", nameAttribute));
        assertTrue(passport.hasField(dobAttribute, String.class),
                String.format("We expected an attribute named %s in your code but it was not found or was misspelled.", dobAttribute));
        assertTrue(passport.hasModifier(nameAttribute, "private"),
                String.format("The %s field does not have the correct visibility modifier.", nameAttribute));
        assertTrue(passport.hasModifier(dobAttribute, "private"),
                String.format("The %s field does not have the correct visibility modifier.", dobAttribute));
    }

    private static Stream<Arguments> passportConstructorInputProvider() {
        return Stream.of(
                Arguments.of("John Cena", "April 23, 1977"),
                Arguments.of("null", "null"),
                Arguments.of("One longer name with other sumbols&&@$#$", "mnsaidawkd2@#")
        );
    }

    @ParameterizedTest
    @MethodSource("passportConstructorInputProvider")
    public void passportClassHasCorrectConstructor(String name, String birthday) throws Throwable {
        Object[][] arguments = {
                {name, String.class},
                {birthday, String.class}
        };
        assertTrue(passport.hasConstructor(new Class[]{String.class, String.class}, new String[]{"public"}),
                String.format("Your %s class is missing a required constructor or has the incorrect visibility modifier.", passportName));
        Object passportInstance = passport.createInstance(arguments);
        _assertEquals(name, passport.getFieldValue(passportInstance, nameAttribute),
                String.format("Your %s constructor does not correctly initialize the %s attribute.", passportName, nameAttribute));
        _assertEquals(birthday, passport.getFieldValue(passportInstance, dobAttribute),
                String.format("Your %s constructor does not correctly initialize the %s attribute.", passportName, dobAttribute));
    }

    @ParameterizedTest
    @MethodSource("passportConstructorInputProvider")
    public void correctGetNameMethod(String name, String birthday) throws Throwable {
        Object[][] constructorArguments = {
                {name, String.class},
                {birthday, String.class}
        };
        Object passportInstance = passport.createInstance(constructorArguments);
        assertTrue(passport.hasMethod(getNameMethodName, null, String.class),
                String.format("Your %s class is missing the %s method, or the %s method has the wrong return type.", passportName, getNameMethodName, getNameMethodName));
        Object getOutput = passport.callMethod(getNameMethodName, passportInstance);
        _assertEquals(name, getOutput,
                String.format("Your %s method does not return the value of the %s attribute.", getNameMethodName, nameAttribute));
    }

    @ParameterizedTest
    @MethodSource("passportConstructorInputProvider")
    public void correctGetDobMethod(String name, String birthday) throws Throwable {
        Object[][] constructorArguments = {
                {name, String.class},
                {birthday, String.class}
        };
        Object passportInstance = passport.createInstance(constructorArguments);
        assertTrue(passport.hasMethod(getDobMethodName, null, String.class, new String[]{"public"}),
                String.format("Your %s class is missing the %s method, or the %s method has the wrong return type.", passportName, getDobMethodName, getDobMethodName));
        Object getOutput = passport.callMethod(getDobMethodName, passportInstance);
        _assertEquals(birthday, getOutput,
                String.format("Your %s method does not return the value of the %s attribute.", getDobMethodName, dobAttribute));
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
        Object passportInstance = passport.createInstance(constructorArguments);
        assertTrue(passport.hasMethod(setDobMethodName, new Class[]{String.class}, Void.TYPE, new String[]{"private"}),
                String.format("Your %s class is missing the %s method, or the method name was spelt incorrectly.",
                        passportName, setNameMethodName));
        Object[][] setArguments = {{nameFinal, String.class}};
        passport.callMethod(setNameMethodName, setArguments, passportInstance);
        _assertEquals(nameFinal, passport.getFieldValue(passportInstance, nameAttribute),
                String.format("Your %s method does not update the %s attribute with the correct value.", setNameMethodName, nameAttribute));
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
        Object passportInstance = passport.createInstance(constructorArguments);
        assertTrue(passport.hasMethod(setDobMethodName, new Class[]{String.class}, Void.TYPE, new String[]{"private"}),
                String.format("Your %s class is missing the %s method, or the method name was spelt incorrectly.",
                        passportName, setDobMethodName));
        Object[][] setArguments = {{dobFinal, String.class}};
        passport.callMethod(setDobMethodName, setArguments, passportInstance);
        _assertEquals(dobFinal, passport.getFieldValue(passportInstance, dobAttribute),
                String.format("Your %s method does not update the %s attribute with the correct value.", setDobMethodName, dobAttribute));
    }

    @ParameterizedTest
    @MethodSource("passportConstructorInputProvider")
    public void correctToStringMethod(String name, String dob) throws Throwable {
        Object[][] constructorArguments = {
                {name, String.class},
                {dob, String.class}
        };
        Object passportInstance = passport.createInstance(constructorArguments);
        Object output = passport.callMethod("toString", passportInstance);
        String expected = String.format("My name is %s, and I was born on %s.", name, dob);
        _assertEquals(expected, output,
                String.format("Your toString method for the %s class does not return the correct output. Please ensure you match the sample exactly and have not misspelled anything.", passportName));
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
        Object passportInstance1 = passport.createInstance(passport1Arguments);
        Object passportInstance2 = passport.createInstance(passport2Arguments);
        assertTrue(passport.hasMethod(stealMethodName, new Class[]{passport.getObjectClass()}, Void.TYPE, new String[]{"public"}),
                String.format(
                        "Your %s class is missing the %s method. Please check that the name is spelled correctly, the parameters and return type are correct, and it has the correct visibility modifier.",
                        passportName,
                        stealMethodName
                ));
        Object[][] stealArguments = {{passportInstance2, passport.getObjectClass()}};
        passport.callMethod(stealMethodName, stealArguments, passportInstance1);
        _assertEquals(name2, passport.getFieldValue(passportInstance1, nameAttribute),
                String.format("Your %s method does not copy the %s value from the input %s.", stealMethodName, nameAttribute, passportName));
        _assertEquals(dob2, passport.getFieldValue(passportInstance1, dobAttribute),
                String.format("Your %s method does not copy the %s value from the input %s.", stealMethodName, dobAttribute, passportName));
        _assertEquals(name2, passport.getFieldValue(passportInstance2, nameAttribute),
                String.format("Your %s method should not modify the %s value from the input %s.", stealMethodName, nameAttribute, passportName));
        _assertEquals(dob2, passport.getFieldValue(passportInstance2, dobAttribute),
                String.format("Your %s method should not modify the %s value from the input %s.", stealMethodName, dobAttribute, passportName));
    }
}
