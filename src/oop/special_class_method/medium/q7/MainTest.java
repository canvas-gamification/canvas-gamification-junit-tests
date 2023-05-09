package oop.special_class_method.medium.q7;

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
    private final String className = "PiggyBank";
    private final String attributeName1 = "numPennies";
    private final String getAttributeMethodName1 = "getNumPennies";
    private final String setAttributeMethodName1 = "setNumPennies";
    private final String attributeName2 = "numNickels";
    private final String getAttributeMethodName2 = "getNumNickels";
    private final String setAttributeMethodName2 = "setNumNickels";
    private final String toStringMessage = "The total amount is $";
    private ObjectTest testClass;

    @BeforeEach
    public void setUp() {
        String classString = "oop.special_class_method.medium.q7." + className;
        this.testClass = new ObjectTest(classString);
    }

    @Test
    public void piggyBankClassHasCorrectField() {
        String missingFieldMessage = "Your " + className + " class is missing the " + attributeName1 + " field.";
        String incorrectVisibilityModifierMessage =
                "Your " + attributeName1 + " field does not have the correct visibility modifier.";
        assertTrue(testClass.hasField(attributeName1, int.class), missingFieldMessage);
        assertTrue(testClass.hasModifier(attributeName1, "private"), incorrectVisibilityModifierMessage);
        String missingFieldMessage2 = "Your " + className + " class is missing the " + attributeName2 + " field.";
        String incorrectVisibilityModifierMessage2 =
                "Your " + attributeName2 + " field does not have the correct visibility modifier.";
        assertTrue(testClass.hasField(attributeName2, int.class), missingFieldMessage2);
        assertTrue(testClass.hasModifier(attributeName2, "private"), incorrectVisibilityModifierMessage2);
    }

    private static Stream<Integer> intInputProvider() {
        return Stream.of(
                0, 23, 553233333, 111111, 3554
        );
    }

    @ParameterizedTest
    @MethodSource("intInputProvider")
    public void correctPiggyBankConstructor(int value) throws Throwable {
        String incorrectValueMessage = "Your " + className + " constructor does not correctly initialize the " +
                attributeName1 + " and " + attributeName2 + " fields.";
        String incorrectVisibilityModifier =
                "Your " + className + " constructor does not have the correct visibility modifier.";
        Class<?>[] classes = {};
        Object testInstance = testClass.createInstance();
        _assertEquals(0, testClass.getFieldValue(testInstance, attributeName1), incorrectValueMessage);
        _assertEquals(0, testClass.getFieldValue(testInstance, attributeName2), incorrectValueMessage);
        assertTrue(testClass.hasModifier(classes, "public"), incorrectVisibilityModifier);
    }

    @Test
    public void correctGetNumPennyMethod() throws Throwable {
        Object testInstance = testClass.createInstance();
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName1, testInstance);
        assertTrue(testClass.hasModifier(getAttributeMethodName1, null, "public"),
                "Your " + getAttributeMethodName1 + " method does not have the correct visibility modifier.");
        _assertEquals(0, getMethodOutput,
                "Your " + getAttributeMethodName1 + " method does not return the value of the size field.");
    }

    @Test
    public void correctGetNickelMethod() throws Throwable {
        Object testInstance = testClass.createInstance();
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName2, testInstance);
        assertTrue(testClass.hasModifier(getAttributeMethodName2, null, "public"),
                "Your " + getAttributeMethodName2 + " method does not have the correct visibility modifier.");
        _assertEquals(0, getMethodOutput,
                "Your " + getAttributeMethodName2 + " method does not return the value of the size field.");
    }

    @ParameterizedTest
    @MethodSource("intInputProvider")
    public void correctSetPennyMethod(int updatedValue) throws Throwable {
        Object[][] instantiationArguments = {
        };
        Object testInstance = testClass.createInstance(instantiationArguments);
        Object[][] setMethodArguments = {
                {updatedValue, int.class}
        };
        Class<?>[] methodModifierClasses = {
                int.class
        };
        testClass.callMethod(setAttributeMethodName1, setMethodArguments, testInstance);
        assertTrue(testClass.hasModifier(setAttributeMethodName1, methodModifierClasses, "public"),
                "Your " + setAttributeMethodName1 + " method does not have the correct visibility modifier.");
        String incorrectSetterMessage =
                "Your " + setAttributeMethodName1 + " method does not correctly update the value of " + attributeName1 + ".";
        _assertEquals(updatedValue, testClass.getFieldValue(testInstance, attributeName1),
                incorrectSetterMessage);
    }

    @ParameterizedTest
    @MethodSource("intInputProvider")
    public void correctSetNickelMethod(int updatedValue) throws Throwable {
        Object[][] instantiationArguments = {
        };
        Object testInstance = testClass.createInstance(instantiationArguments);
        Object[][] setMethodArguments = {
                {updatedValue, int.class}
        };
        Class<?>[] methodModifierClasses = {
                int.class
        };
        testClass.callMethod(setAttributeMethodName2, setMethodArguments, testInstance);
        assertTrue(testClass.hasModifier(setAttributeMethodName2, methodModifierClasses, "public"),
                "Your " + setAttributeMethodName2 + " method does not have the correct visibility modifier.");
        String incorrectSetterMessage =
                "Your " + setAttributeMethodName2 + " method does not correctly update the value of " + attributeName2 + ".";
        _assertEquals(updatedValue, testClass.getFieldValue(testInstance, attributeName2),
                incorrectSetterMessage);
    }

    private static Stream<Arguments> intInputProvider2() {
        return Stream.of(
                Arguments.of(2, 3),
                Arguments.of(32, 1323),
                Arguments.of(43, 213),
                Arguments.of(124332, 434343),
                Arguments.of(223, 0)

        );
    }


    @ParameterizedTest
    @MethodSource("intInputProvider2")
    public void correctToStringMethod(int value1, int value2) throws Throwable {
        Object[][] arguments1 = {
                {value1, int.class}
        };
        Object[][] arguments2 = {
                {value2, int.class}
        };
        double value = (value1 * 1 + value2 * 5) / 100.0;
        String incorrectToStringMessage = "Your toString method does not return the correct String.";
        Object testInstance = testClass.createInstance(null);
        testClass.callMethod(setAttributeMethodName1, arguments1, testInstance);
        testClass.callMethod(setAttributeMethodName2, arguments2, testInstance);
        String expectedOutput = toStringMessage + value;
        Object toStringOutput = testClass.callMethod("toString", testInstance);
        _assertEquals(expectedOutput, toStringOutput, incorrectToStringMessage);
    }

    @ParameterizedTest
    @MethodSource("intInputProvider")
    public void correctGetSetMethods(int updatedValue) throws Throwable {
        String errorMessage = "Your " + className + " class " + getAttributeMethodName1 +
                " method does not return the updated value after calling the " + setAttributeMethodName1 + " method.";
        Object testInstance = testClass.createInstance();
        Object[][] setMethodArguments = {
                {updatedValue, int.class}
        };
        testClass.callMethod(setAttributeMethodName1, setMethodArguments, testInstance);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName1, testInstance);
        _assertEquals(updatedValue, getMethodOutput, errorMessage);
    }

    @ParameterizedTest
    @MethodSource("intInputProvider")
    public void correctGetSetMethods2(int updatedValue) throws Throwable {
        String errorMessage = "Your " + className + " class " + getAttributeMethodName2 +
                " method does not return the updated value after calling the " + setAttributeMethodName2 + " method.";
        Object testInstance = testClass.createInstance();
        Object[][] setMethodArguments = {
                {updatedValue, int.class}
        };
        testClass.callMethod(setAttributeMethodName2, setMethodArguments, testInstance);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName2, testInstance);
        _assertEquals(updatedValue, getMethodOutput, errorMessage);
    }
}
