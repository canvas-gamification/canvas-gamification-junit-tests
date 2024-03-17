package oop.special_class_method.medium.q12;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.StringLiteral;
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

    private final String className = "Shirt";
    private final String attributeName1 = "size";
    private final String getAttributeMethodName1 = "getSize";
    private final String attributeName2 = "yearMade";
    private final String methodName = "displaySize";
    private static final int yearPivot = 2000;
    private ObjectTest testClass;

    @BeforeEach
    public void setUp() throws Throwable {
        String classString = "oop.special_class_method.medium.q12." + className;
        this.testClass = new ObjectTest(classString);
        String modifiedClassMessage =
                "You have modified the provided portions of class " + className + " for the %s attribute. Please revert them to the original state.";
        assertTrue(testClass.hasField(attributeName1, int.class, new String[]{"private"}),
                String.format(modifiedClassMessage, attributeName1));
        assertTrue(testClass.hasField(attributeName2, int.class, new String[]{"private"}),
                String.format(modifiedClassMessage, attributeName1));
        Object[][] tests = new Object[][]{
                {3, yearPivot + 2},
                {3, yearPivot + 1},
                {10, yearPivot -50},
                {12, yearPivot + 20},
                {43, yearPivot + 3},
                {7, yearPivot - 5},
                {7, yearPivot}
        };
        modifiedClassMessage =
                "You have modified the provided portions of class " + className + " for the constructor. Please revert them to the original state.";
        for (int i = 0; i < tests.length; i++) {
            int size = (int) tests[i][0];
            int yearMade = (int) tests[i][1];
            Object[][] arguments = {
                    {size, int.class},
                    {yearMade, int.class}
            };
            Class<?>[] classes = {int.class, int.class};
            Object testInstance = testClass.createInstance(arguments);
            _assertEquals(size, testClass.getFieldValue(testInstance, attributeName1), modifiedClassMessage);
            _assertEquals(yearMade, testClass.getFieldValue(testInstance, attributeName2), modifiedClassMessage);
            assertTrue(testClass.hasModifier(classes, "public"), modifiedClassMessage);
        }
    }


    private static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(3, yearPivot + 12),
                Arguments.of(3, yearPivot + 1),
                Arguments.of(3, yearPivot - 1),
                Arguments.of(10, yearPivot - 6),
                Arguments.of(12, yearPivot - 26),
                Arguments.of(43, yearPivot + 23),
                Arguments.of(7, yearPivot)
        );
    }

    @Test
    public void getSizeIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getAttributeMethodName1, null), String.format(incorrectMethodDefinition, getAttributeMethodName1, className));
        assertTrue(testClass.hasModifier(getAttributeMethodName1, null, "public"), String.format(incorrectModifierMessage, getAttributeMethodName1, className));
        assertTrue(testClass.hasReturnType(getAttributeMethodName1, null, int.class), String.format(incorrectReturnType, getAttributeMethodName1, className));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctGetSizeMethod(int value1, int value2) throws Throwable {
        Object[][] arguments = {
                {value1, int.class},
                {value2, int.class}
        };
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getAttributeMethodName1, null), String.format(incorrectMethodDefinition, getAttributeMethodName1, className));
        assertTrue(testClass.hasModifier(getAttributeMethodName1, null, "public"), String.format(incorrectModifierMessage, getAttributeMethodName1, className));
        assertTrue(testClass.hasReturnType(getAttributeMethodName1, null, int.class), String.format(incorrectReturnType, getAttributeMethodName1, className));
        Object testInstance = testClass.createInstance(arguments);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName1, testInstance);
        _assertEquals(value1, getMethodOutput,
                "Your " + getAttributeMethodName1 + " method does not return the value of the " + attributeName1 + " attribute.");
    }

    @Test
    public void displaySizeIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(methodName, null), String.format(incorrectMethodDefinition, methodName, className));
        assertTrue(testClass.hasModifier(methodName, null, "public"), String.format(incorrectModifierMessage, methodName, className));
        assertTrue(testClass.hasReturnType(methodName, null, Void.TYPE), String.format(incorrectReturnType, methodName, className));
    }


    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctDisplaySizeMethod(int value1, int value2) throws Throwable {
        Object[][] arguments = {
                {value1, int.class},
                {value2, int.class}
        };
        Object testInstance = testClass.createInstance(arguments);
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(methodName, null), String.format(incorrectMethodDefinition, methodName, className));
        assertTrue(testClass.hasModifier(methodName, null, "public"), String.format(incorrectModifierMessage, methodName, className));
        assertTrue(testClass.hasReturnType(methodName, null, Void.TYPE), String.format(incorrectReturnType, methodName, className));

        if (value2 > yearPivot) {
            testClass.callMethod(methodName, testInstance, new Clause[]{
                    new StringLiteral("The size is " + value1)
            }, "Your main method does not print the correct output");
        } else {
            testClass.callMethod(methodName, testInstance, new Clause[]{
                    new StringLiteral("This shirt is no longer carried")
            }, "Your main method does not print the correct output");
        }
    }

}
