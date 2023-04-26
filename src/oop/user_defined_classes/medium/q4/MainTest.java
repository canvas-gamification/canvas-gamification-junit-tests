package oop.user_defined_classes.medium.q4;

import global.ObjectTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    // Java
    private final String className = "Water";
    private final String varVol = "volume";
    private final String varQual = "quality";

    private ObjectTest classInstance;

    @BeforeEach
    public void setUp() throws Throwable {
        String classString = "oop.user_defined_classes.medium.q4." + className;
        classInstance = new ObjectTest(classString);
        String modifiedClassMessage =
                "You have modified the class fields in the " + className + " class. Please revert them back to the original state they were provided in.";
        assertTrue(classInstance.hasField(varVol, double.class), modifiedClassMessage);
        assertTrue(classInstance.hasModifier(varVol, "private"), modifiedClassMessage);
        assertTrue(classInstance.hasField(varQual, String.class), modifiedClassMessage);
        assertTrue(classInstance.hasModifier(varQual, "private"), modifiedClassMessage);
    }

    @Test
    public void classHasRequiredConstructor() {
        Class<?>[] classArguments = {double.class, String.class};
        assertTrue(classInstance.hasConstructor(classArguments),
                "Your " + className + " constructor does not have the correct parameters.");
        assertTrue(classInstance.hasModifier(classArguments, "public"),
                "Your " + className + " constructor does not have the correct modifier.");
    }

    private static Stream<Arguments> constructorInputProvider() {
        return Stream.of(
                Arguments.of(534.32, "Good"),
                Arguments.of(354.4, "Bad"),
                Arguments.of(93828.12, "Fair"),
                Arguments.of(2232.3, "Excellent")
        );
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void horseConstructorInitializesObjectCorrectly(double volume, String quality) throws Throwable {
        Object[][] arguments = {
                {volume, double.class},
                {quality, String.class}
        };
        Object instance = classInstance.createInstance(arguments);
        _assertEquals(volume, classInstance.getFieldValue(instance, varVol),
                "Your " + className + " constructor does not correctly initialize the " + varVol + " field.");
        _assertEquals(quality, classInstance.getFieldValue(instance, varQual),
                "Your " + className + " constructor does not correctly initialize the " + varQual + " field.");
    }
}
