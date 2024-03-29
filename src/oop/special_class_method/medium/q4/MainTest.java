package oop.special_class_method.medium.q4;

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
    private final String className = "Plant";
    private final String attributeName = "breed";
    private final String getAttributeMethodName = "getBreed";
    private final String setAttributeMethodName = "setBreed";
    private ObjectTest testClass;

    @BeforeEach
    public void setUp() throws Throwable {
        String classString = "oop.special_class_method.medium.q4." + className;
        this.testClass = new ObjectTest(classString);
        String modifiedClassMessage =
                "You have modified the provided portions of class " + className + ". Please revert them to the original state.";
        assertTrue(testClass.hasField(attributeName, String.class), modifiedClassMessage);
        assertTrue(testClass.hasModifier(attributeName, "private"), modifiedClassMessage);
        String[] tests = new String[]{"Normal", "Exotic", "Green", "Flower", "Cactus"};
        for (int i = 0; i < tests.length; i++) {
            String value = tests[i];
            Object[][] arguments = {
                    {value, String.class}
            };
            Class<?>[] classes = {String.class};
            Object testInstance = testClass.createInstance(arguments);
            _assertEquals(value, testClass.getFieldValue(testInstance, attributeName), modifiedClassMessage);
            assertTrue(testClass.hasModifier(classes, "public"), modifiedClassMessage);
        }
    }


    private static Stream<String> stringInputProvider() {
        return Stream.of(
                "Normal", "Exotic", "Green", "Flower", "Cactus"
        );
    }


    @ParameterizedTest
    @MethodSource("stringInputProvider")
    public void correctGetBreedMethod(String value) throws Throwable {
        Object[][] arguments = {
                {value, String.class}
        };
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getAttributeMethodName, null), String.format(incorrectMethodDefinition,getAttributeMethodName, className));
        assertTrue(testClass.hasModifier(getAttributeMethodName, null, "public"), String.format(incorrectModifierMessage, getAttributeMethodName, className));
        assertTrue(testClass.hasReturnType(getAttributeMethodName, null, String.class), String.format(incorrectReturnType, getAttributeMethodName, className));
        Object testInstance = testClass.createInstance(arguments);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName, testInstance);
        _assertEquals(value, getMethodOutput,
                "Your " + getAttributeMethodName + " method does not return the value of the " + attributeName + " attribute.");
    }

    private static Stream<Arguments> twoStringsInputProvider() {
        return Stream.of(
                Arguments.of("Cactus", "Flower"),
                Arguments.of("Green", "Normal"),
                Arguments.of("Exotic", "Tree")
        );
    }

    @ParameterizedTest
    @MethodSource("twoStringsInputProvider")
    public void correctSetBreedMethod(String initialValue, String updatedValue) throws Throwable {
        Object[][] instantiationArguments = {
                {initialValue, String.class}
        };
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(setAttributeMethodName, new Class<?>[]{String.class}), String.format(incorrectMethodDefinition,setAttributeMethodName, className));
        assertTrue(testClass.hasModifier(setAttributeMethodName, new Class<?>[]{String.class}, "public"), String.format(incorrectModifierMessage, setAttributeMethodName, className));
        assertTrue(testClass.hasReturnType(setAttributeMethodName, new Class<?>[]{String.class}, Void.TYPE), String.format(incorrectReturnType, setAttributeMethodName, className));
        Object testInstance = testClass.createInstance(instantiationArguments);
        Object[][] setMethodArguments = {
                {updatedValue, String.class}
        };
        testClass.callMethod(setAttributeMethodName, setMethodArguments, testInstance);
        String incorrectSetterMessage =
                "Your " + setAttributeMethodName + " method does not correctly update the value of " + attributeName + ".";
        _assertEquals(updatedValue, testClass.getFieldValue(testInstance, attributeName),
                incorrectSetterMessage);
    }

    @ParameterizedTest
    @MethodSource("twoStringsInputProvider")
    public void plantMethodsWorkCorrectlyWorkTogether(String initialValue, String updatedValue) throws Throwable {
        String errorMessage = "Your " + className + " class " + getAttributeMethodName +
                " method does not return the updated value after calling the " + setAttributeMethodName + " method.";
        Object[][] instantiationArguments = {
                {initialValue, String.class}
        };
        Object testInstance = testClass.createInstance(instantiationArguments);
        Object[][] setMethodArguments = {
                {updatedValue, String.class}
        };
        testClass.callMethod(setAttributeMethodName, setMethodArguments, testInstance);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName, testInstance);
        _assertEquals(updatedValue, getMethodOutput, errorMessage);
        String expectedOutput = "My breed is " + updatedValue;
        Object toStringOutput = testClass.callMethod("toString", testInstance);
        _assertEquals(expectedOutput, toStringOutput,
                "Your toString method does not return the correct String after using the accessors and mutators.");
    }

    @ParameterizedTest
    @MethodSource("stringInputProvider")
    public void correctToStringMethod(String value) throws Throwable {
        Object[][] arguments = {
                {value, String.class}
        };
        String incorrectToStringMessage = "Your toString method does not return the correct String.";
        Object testInstance = testClass.createInstance(arguments);
        String expectedOutput = "My breed is " + value;
        Object toStringOutput = testClass.callMethod("toString", testInstance);
        _assertEquals(expectedOutput, toStringOutput, incorrectToStringMessage);
    }
}
