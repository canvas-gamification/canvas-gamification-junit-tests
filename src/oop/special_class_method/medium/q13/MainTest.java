package oop.special_class_method.medium.q13;

import global.ObjectTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    // Java

    private final String className = "Detergent";
    private final String attributeName1 = "colour";
    private final String attributeName2 = "manufacturer";
    private final String getAttributeMethodName2 = "getManufacturer";
    private final String setAttributeMethodName2 = "setManufacturer";
    private ObjectTest testClass;

    @BeforeEach
    public void setUp() throws Throwable {
        String classString = "oop.special_class_method.medium.q13." + className;
        this.testClass = new ObjectTest(classString);
        String modifiedClassMessage =
                "You have modified the provided portions of class " + className + ". Please revert them to the original state.";
        assertTrue(testClass.hasField(attributeName1, String.class), modifiedClassMessage);
        assertTrue(testClass.hasModifier(attributeName1, "private"), modifiedClassMessage);
        assertTrue(testClass.hasField(attributeName2, String.class), modifiedClassMessage);
        assertTrue(testClass.hasModifier(attributeName2, "private"), modifiedClassMessage);
        Object[][] tests = new Object[][]{
                {"Red", "myCompany"},
                {"Black", "Best Det"},
                {"Blue", "clearer"},
                {"White", "Get Clean"},
                {"Yellow", "Good Detergent"}
        };
        for (int i = 0; i < tests.length; i++) {
            String value1 = (String) tests[i][0];
            String value2 = (String) tests[i][1];
            Object[][] arguments = {
                    {value1, String.class},
                    {value2, String.class}
            };
            Class<?>[] classes = {String.class, String.class};
            Object testInstance = testClass.createInstance(arguments);
            _assertEquals(value1, testClass.getFieldValue(testInstance, attributeName1), modifiedClassMessage);
            _assertEquals(value2, testClass.getFieldValue(testInstance, attributeName2), modifiedClassMessage);
            assertTrue(testClass.hasModifier(classes, "public"), modifiedClassMessage);
        }
    }


    private static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of("Red", "myCompany"),
                Arguments.of("Black", "Best Det"),
                Arguments.of("Blue", "clearer"),
                Arguments.of("White", "Get Clean"),
                Arguments.of("Yellow", "Good Detergent")
        );
    }

    private static Stream<Arguments> updateStringInputProvider() {
        return Stream.of(
                Arguments.of("Red", "myCompany", "Best Det"),
                Arguments.of("Black", "Best Det", "Get Clean"),
                Arguments.of("Blue", "clearer", "Good Detergent"),
                Arguments.of("White", "Get Clean", "myCompany"),
                Arguments.of("Yellow", "Good Detergent", "clearer")

        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctGetManufacturerMethod(String value1, String value2) throws Throwable {
        Object[][] arguments = {
                {value1, String.class},
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
    @MethodSource("updateStringInputProvider")
    public void correctSetSizeMethod(String value, String initialiValue, String updatedValue) throws Throwable {
        Object[][] instantiationArguments = {
                {value, String.class},
                {initialiValue, String.class}
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
    @MethodSource("updateStringInputProvider")
    public void methodsWorkingTogether(String value1, String initialValue, String updatedValue) throws Throwable {
        Object[][] initialArguments = {
                {value1, String.class},
                {initialValue, String.class}
        };
        Object testInstance = testClass.createInstance(initialArguments);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName2, testInstance);
        _assertEquals(initialValue, getMethodOutput,
                "Your " + getAttributeMethodName2 + " method does not return the value of the " + attributeName2 + " attribute.");
        Object[][] setMethodArguments = {
                {updatedValue, String.class}
        };
        testClass.callMethod(setAttributeMethodName2, setMethodArguments, testInstance);
        _assertEquals(updatedValue, testClass.callMethod(getAttributeMethodName2, testInstance),
                "Your " + getAttributeMethodName2 + " method does not correctly update the value of " + setAttributeMethodName2 + " after using the " + getAttributeMethodName2 + " method.");
    }
}
