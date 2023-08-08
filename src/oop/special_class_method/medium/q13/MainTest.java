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
    private final String attributeName1 = "volume";
    private final String attributeName2 = "manufacturer";
    private final String getAttributeMethodName2 = "getManufacturer";
    private final String setAttributeMethodName2 = "setManufacturer";
    private ObjectTest testClass;

    @BeforeEach
    public void setUp() throws Throwable {
        String classString = "oop.special_class_method.medium.q13." + className;
        this.testClass = new ObjectTest(classString);
        String modifiedClassMessage =
                "You have modified the provided portions of class " + className + " class for the %s attribute. Please revert them to the original state.";
        assertTrue(testClass.hasField(attributeName1, double.class, new String[]{"private"}),
                String.format(modifiedClassMessage, attributeName1));
        assertTrue(testClass.hasField(attributeName2, String.class, new String[]{"private"}),
                String.format(modifiedClassMessage, attributeName1));
        Object[][] tests = new Object[][]{
                {5435.4, "myCompany"},
                {544.3, "Best Det"},
                {876.3, "clearer"},
                {75.3, "Get Clean"},
                {3.5, "Good Detergent"}
        };
        for (int i = 0; i < tests.length; i++) {
            double value1 = (double) tests[i][0];
            String value2 = (String) tests[i][1];
            Object[][] arguments = {
                    {value1, double.class},
                    {value2, String.class}
            };
            Object testInstance = testClass.createInstance(arguments);
            modifiedClassMessage = "You have modified the provided portions of class " + className + " constructor for the %s attribute. Please revert them to the original state.";
            _assertEquals(value1, testClass.getFieldValue(testInstance, attributeName1),
                    String.format(modifiedClassMessage, attributeName1));
            _assertEquals(value2, testClass.getFieldValue(testInstance, attributeName2),
                    String.format(modifiedClassMessage, attributeName2));
        }
    }


    private static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(432.3, "myCompany"),
                Arguments.of(54.3, "Best Det"),
                Arguments.of(123.3, "clearer"),
                Arguments.of(65.4, "Get Clean"),
                Arguments.of(234.4, "Good Detergent")
        );
    }

    private static Stream<Arguments> updateStringInputProvider() {
        return Stream.of(
                Arguments.of(34.3, "myCompany", "Best Det"),
                Arguments.of(432.2, "Best Det", "Get Clean"),
                Arguments.of(5.5, "clearer", "Good Detergent"),
                Arguments.of(23.3, "Get Clean", "myCompany"),
                Arguments.of(78.7, "Good Detergent", "clearer")

        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctGetManufacturerMethod(double value1, String value2) throws Throwable {
        Object[][] arguments = {
                {value1, double.class},
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
    public void correctSetSizeMethod(double value, String initialiValue, String updatedValue) throws Throwable {
        Object[][] instantiationArguments = {
                {value, double.class},
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
    public void methodsWorkingTogether(double value1, String initialValue, String updatedValue) throws Throwable {
        Object[][] initialArguments = {
                {value1, double.class},
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
