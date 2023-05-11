package oop.special_class_method.medium.q9;

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
    private final String className = "Car";
    private final String attributeName1 = "maker";
    private final String getAttributeMethodName1 = "getMaker";
    private final String attributeName2 = "topSpeed";
    private final String getAttributeMethodName2 = "getTopSpeed";
    private ObjectTest testClass;

    @BeforeEach
    public void setUp() {
        String classString = "oop.special_class_method.medium.q9." + className;
        this.testClass = new ObjectTest(classString);
    }

    @Test
    public void lufffyClassHasCorrectField() {
        String missingFieldMessage = "Your " + className + " class is missing the " + attributeName1 + " field.";
        String incorrectVisibilityModifierMessage =
                "Your " + attributeName1 + " field does not have the correct visibility modifier.";
        assertTrue(testClass.hasField(attributeName1, String.class), missingFieldMessage);
        assertTrue(testClass.hasModifier(attributeName1, "private"), incorrectVisibilityModifierMessage);
        String missingFieldMessage2 = "Your " + className + " class is missing the " + attributeName2 + " field.";
        String incorrectVisibilityModifierMessage2 =
                "Your " + attributeName2 + " field does not have the correct visibility modifier.";
        assertTrue(testClass.hasField(attributeName2, double.class), missingFieldMessage2);
        assertTrue(testClass.hasModifier(attributeName2, "private"), incorrectVisibilityModifierMessage2);
    }

    private static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of("Fire", 3.3),
                Arguments.of("Ice", 1323.23),
                Arguments.of("Battle", 213.43),
                Arguments.of("Fly", 434343.32),
                Arguments.of("Fight", 0.43)

        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctCarConstructor(String maker, double topSpeed) throws Throwable {
        Object[][] arguments = {
                {maker, String.class},
                {topSpeed, double.class}
        };
        String incorrectValueMessage = "Your " + className + " constructor does not correctly initialize the " +
                attributeName1 + " and " + attributeName2 + " fields.";
        String incorrectVisibilityModifier =
                "Your " + className + " constructor does not have the correct visibility modifier.";
        Class<?>[] classes = {String.class, double.class};
        Object testInstance = testClass.createInstance(arguments);
        _assertEquals(maker, testClass.getFieldValue(testInstance, attributeName1), incorrectValueMessage);
        _assertEquals(topSpeed, testClass.getFieldValue(testInstance, attributeName2), incorrectValueMessage);
        assertTrue(testClass.hasModifier(classes, "public"), incorrectVisibilityModifier);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctGetMakerMethod(String maker, double topSpeed) throws Throwable {
        Object[][] arguments = {
                {maker, String.class},
                {topSpeed, double.class}
        };
        Object testInstance = testClass.createInstance(arguments);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName1, testInstance);
        assertTrue(testClass.hasModifier(getAttributeMethodName1, null, "public"),
                "Your " + getAttributeMethodName1 + " method does not have the correct visibility modifier.");
        _assertEquals(maker, getMethodOutput,
                "Your " + getAttributeMethodName1 + " method does not return the value of the size field.");
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctGetTopSpeedMethod(String maker, double topSpeed) throws Throwable {
        Object[][] arguments = {
                {maker, String.class},
                {topSpeed, double.class}
        };
        Object testInstance = testClass.createInstance(arguments);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName2, testInstance);
        assertTrue(testClass.hasModifier(getAttributeMethodName2, null, "public"),
                "Your " + getAttributeMethodName2 + " method does not have the correct visibility modifier.");
        _assertEquals(topSpeed, getMethodOutput,
                "Your " + getAttributeMethodName2 + " method does not return the value of the size field.");
    }

}
