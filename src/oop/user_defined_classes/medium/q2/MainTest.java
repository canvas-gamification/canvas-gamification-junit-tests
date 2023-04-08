package oop.user_defined_classes.medium.q2;

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
    private final String className = "Car";
    private final String varColour = "colour";
    private final String varPower = "horsePower";
    private final String varYear = "yearMade";
    private final String methodName = "printSpecs";

    private ObjectTest classInstance;

    @BeforeEach
    public void setUp() {
        String classString = "oop.user_defined_classes.medium.q2." + className;
        classInstance = new ObjectTest(classString);
    }

    @Test
    public void circleClassHasCorrectFields() {
        assertTrue(classInstance.hasField(varColour, String.class),
                "Your " + className + " class does not have the correct " + varColour + " field.");
        assertTrue(classInstance.hasModifier(varColour, "private"),
                "Your " + varColour + " field does not have the correct visibility modifier.");
        assertTrue(classInstance.hasField(varPower, int.class),
                "Your " + className + " class does not have the correct " + varPower + " field.");
        assertTrue(classInstance.hasModifier(varPower, "private"),
                "Your " + varPower + " field does not have the correct visibility modifier.");
        assertTrue(classInstance.hasField(varYear, int.class),
                "Your " + className + " class does not have the correct " + varYear + " field.");
        assertTrue(classInstance.hasModifier(varPower, "private"),
                "Your " + varPower + " field does not have the correct visibility modifier.");
    }

    @Test
    public void circleClassHasCorrectConstructor() {
        Class<?>[] arguments = {
                String.class, int.class, int.class
        };
        assertTrue(classInstance.hasConstructor(arguments),
                "Your " + className + " class is missing a required constructor.");
    }

    private static Stream<Arguments> constructorInputProvider() {
        return Stream.of(
                Arguments.of("Red", 300, 2003),
                Arguments.of("Blue", 200, 2014),
                Arguments.of("Black", 100, 1986),
                Arguments.of("Yellow", 250, 2001)
        );
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void circleConstructorInitializesObjectCorrectly(String colour, int horsePower, int yearMade) throws Throwable {
        Object[][] arguments = {
                {colour, String.class},
                {horsePower, int.class},
                {yearMade, int.class}
        };
        Object instance = classInstance.createInstance(arguments);
        _assertEquals(horsePower, classInstance.getFieldValue(instance, varPower),
                "Your " + className + " constructor does not correctly initialize the " + varPower + " field.");
        _assertEquals(yearMade, classInstance.getFieldValue(instance, varYear),
                "Your " + className + " constructor does not correctly initialize the " + varYear + " field.");
        _assertEquals(colour, classInstance.getFieldValue(instance, varColour),
                "Your " + className + " constructor does not correctly initialize the " + varColour + " field.");
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void correctPrintSpecsMethod(String colour, int horsePower, int yearMade) throws Throwable {
        Object[][] arguments = {
                {colour, String.class},
                {horsePower, int.class},
                {yearMade, int.class}
        };
        Object instance = classInstance.createInstance(arguments);
        Object methodOutput = classInstance.callMethod(methodName, instance);
        String ans = "I am " + colour + " with " + horsePower + " horsepower";
        _assertEquals(methodOutput, ans, "Your " + methodName + " method does not return the correct string");
    }
}

