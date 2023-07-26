package oop.special_class_method.hard.q12;

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
    // Java

    private final String className = "Laptop";
    private final String attributeName1 = "yearMade";
    private final String getAttributeMethodName1 = "getYearMade";
    private final String setAttributeMethodName1 = "setYearMade";
    private final String attributeName2 = "texture";
    private final String getAttributeMethodName2 = "getTexture";
    private final String setAttributeMethodName2 = "setTexture";
    private ObjectTest testClass;

    @BeforeEach
    public void setUp() throws Throwable {
        String classString = "oop.special_class_method.hard.q12." + className;
        this.testClass = new ObjectTest(classString);
    }

    @Test
    public void alienClassHasCorrectAttributes() {
        assertTrue(testClass.hasField(attributeName1),
                "Your " + className + " class is missing the " + attributeName1 + " attributes, it is spelled incorrectly.");
        assertTrue(testClass.hasField(attributeName1, int.class),
                "Your " + attributeName1 + " does not have the correct type.");
        assertTrue(testClass.hasModifier(attributeName1, "private"),
                "Your " + attributeName1 + " does not have the correct visibility modifier.");
        assertTrue(testClass.hasField(attributeName2),
                "Your " + className + " class is missing the " + attributeName2 + " attributes, or it is spelled incorrectly.");
        assertTrue(testClass.hasField(attributeName2, String.class),
                "Your " + attributeName2 + " does not have the correct type.");
        assertTrue(testClass.hasModifier(attributeName2, "private"),
                "Your " + attributeName2 + " does not have the correct visibility modifier.");
    }


    private static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(2002, "Red"),
                Arguments.of(1989, "Black"),
                Arguments.of(2020, "Blue"),
                Arguments.of(2017, "White"),
                Arguments.of(2010, "Yellow")
        );
    }

    private static Stream<Arguments> updateIntegerInputProvider() {
        return Stream.of(
                Arguments.of(2020, "Red", 2021),
                Arguments.of(2022, "Black", 1987),
                Arguments.of(2019, "Blue", 2001),
                Arguments.of(2013, "White", 2007),
                Arguments.of(1999, "Yellow", 2006)

        );
    }

    private static Stream<Arguments> updateStringInputProvider() {
        return Stream.of(
                Arguments.of(3, "Red", "White"),
                Arguments.of(10, "Black", "Green"),
                Arguments.of(12, "Blue", "Red"),
                Arguments.of(43, "White", "Gray"),
                Arguments.of(7, "Yellow", "Orange")

        );
    }

    @Test
    public void alienClassHasRequiredConstructor() {
        Class<?>[] classArguments = {int.class, String.class};
        assertTrue(testClass.hasConstructor(classArguments),
                "Your " + className + " constructor does not have the correct parameters.");
        assertTrue(testClass.hasModifier(classArguments, "public"),
                "Your " + className + " constructor does not have the correct visibility modifiers.");
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void alienClassHasCorrectConstructor(int value1, String value2) throws Throwable {
        Object[][] arguments = {
                {value1, int.class},
                {value2, String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        _assertEquals(value1, testClass.getFieldValue(classInstance, attributeName1),
                "Your " + className + " constructor does not initialize the " + attributeName1 + " attribute to the correct value.");
        _assertEquals(value2, testClass.getFieldValue(classInstance, attributeName2),
                "Your " + className + " constructor does not initialize the " + attributeName2 + " attribute to the correct value.");
    }


    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctGetYearMadeMethod(int value1, String value2) throws Throwable {
        Object[][] arguments = {
                {value1, int.class},
                {value2, String.class}
        };
        Object testInstance = testClass.createInstance(arguments);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName1, testInstance);
        assertTrue(testClass.hasModifier(getAttributeMethodName1, null, "public"),
                "Your " + getAttributeMethodName1 + " method does not have the correct visibility modifier.");
        _assertEquals(value1, getMethodOutput,
                "Your " + getAttributeMethodName1 + " method does not return the value of the " + attributeName1 + " attribute.");
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctGetTextureMethod(int value1, String value2) throws Throwable {
        Object[][] arguments = {
                {value1, int.class},
                {value2, String.class}
        };
        Object testInstance = testClass.createInstance(arguments);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName2, testInstance);
        assertTrue(testClass.hasModifier(getAttributeMethodName2, null, "public"),
                "Your " + getAttributeMethodName2 + " method does not have the correct visibility modifier.");
        _assertEquals(value2, getMethodOutput,
                "Your " + getAttributeMethodName2 + " method does not return the value of the " + attributeName2 + " attribute.");
    }

    @ParameterizedTest
    @MethodSource("updateIntegerInputProvider")
    public void correctSetYearMadeMethod(int initialiValue, String value2, int updatedValue) throws Throwable {
        Object[][] instantiationArguments = {
                {initialiValue, int.class},
                {value2, String.class}
        };
        Object testInstance = testClass.createInstance(instantiationArguments);
        Object[][] setMethodArguments = {
                {updatedValue, int.class}
        };
        Class<?>[] methodModifierClasses = {
                int.class
        };
        assertTrue(testClass.hasMethod(setAttributeMethodName1, methodModifierClasses, Void.TYPE),
                "Your " + setAttributeMethodName1 + " method does not have the correct name, return type, or parameters.");
        testClass.callMethod(setAttributeMethodName1, setMethodArguments, testInstance);
        assertTrue(testClass.hasModifier(setAttributeMethodName1, methodModifierClasses, "public"),
                "Your " + setAttributeMethodName1 + " method does not have the correct visibility modifier.");
        String incorrectSetterMessage =
                "Your " + setAttributeMethodName1 + " method does not correctly update the value of " + attributeName1 + ".";
        _assertEquals(updatedValue, testClass.getFieldValue(testInstance, attributeName1),
                incorrectSetterMessage);
    }

    @ParameterizedTest
    @MethodSource("updateStringInputProvider")
    public void correctSetTextureMethod(int value1, String initialValue, String updatedValue) throws Throwable {
        Object[][] instantiationArguments = {
                {value1, int.class},
                {initialValue, String.class}
        };
        Object testInstance = testClass.createInstance(instantiationArguments);
        Object[][] setMethodArguments = {
                {updatedValue, String.class}
        };
        Class<?>[] methodModifierClasses = {
                String.class
        };
        assertTrue(testClass.hasMethod(setAttributeMethodName2, methodModifierClasses, Void.TYPE),
                "Your " + setAttributeMethodName2 + " method does not have the correct name, return type, or parameters.");
        testClass.callMethod(setAttributeMethodName2, setMethodArguments, testInstance);
        assertTrue(testClass.hasModifier(setAttributeMethodName2, methodModifierClasses, "public"),
                "Your " + setAttributeMethodName2 + " method does not have the correct visibility modifier.");
        String incorrectSetterMessage =
                "Your " + setAttributeMethodName2 + " method does not correctly update the value of " + attributeName2 + ".";
        _assertEquals(updatedValue, testClass.getFieldValue(testInstance, attributeName2),
                incorrectSetterMessage);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void methodsWorkingTogether(int value1, String value2) throws Throwable {
        Object[][] initialArguments = {
                {123, int.class},
                {"Initial String", String.class}
        };
        Object testInstance = testClass.createInstance(initialArguments);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName1, testInstance);
        _assertEquals(123, getMethodOutput,
                "Your " + getAttributeMethodName1 + " method does not return the value of the " + attributeName1 + " attribute.");
        getMethodOutput = testClass.callMethod(getAttributeMethodName2, testInstance);
        _assertEquals("Initial String", getMethodOutput,
                "Your " + getAttributeMethodName2 + " method does not return the value of the " + attributeName2 + " attribute.");
        Object[][] setMethodArguments = {
                {value1, int.class}
        };
        testClass.callMethod(setAttributeMethodName1, setMethodArguments, testInstance);
        _assertEquals(value1, testClass.callMethod(getAttributeMethodName1, testInstance),
                "Your " + getAttributeMethodName1 + " method does not correctly update the value of " + setAttributeMethodName1 + " after using the " + getAttributeMethodName1 + " method.");
        setMethodArguments = new Object[][]{
                {value2, String.class}
        };
        testClass.callMethod(setAttributeMethodName2, setMethodArguments, testInstance);
        _assertEquals(value2, testClass.callMethod(getAttributeMethodName2, testInstance),
                "Your " + getAttributeMethodName2 + " method does not correctly update the value of " + setAttributeMethodName2 + " after using the " + getAttributeMethodName2 + " method.");
    }
}
