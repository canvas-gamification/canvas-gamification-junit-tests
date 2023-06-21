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
        String modifiedClassMessage =
                "You have modified the provided portions of class " + className + ". Please revert them to the original state.";
        assertTrue(testClass.hasField(attributeName1, String.class), modifiedClassMessage);
        assertTrue(testClass.hasModifier(attributeName1, "private"), modifiedClassMessage);
        assertTrue(testClass.hasField(attributeName2, double.class), modifiedClassMessage);
        assertTrue(testClass.hasModifier(attributeName2, "private"), modifiedClassMessage);
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
                attributeName1 + " and " + attributeName2 + " attributes.";
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
                "Your " + getAttributeMethodName1 + " method does not return the value of the " + attributeName1 + " attribute.");
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
                "Your " + getAttributeMethodName2 + " method does not return the value of the " + attributeName2 + " attribute.");
    }

}
