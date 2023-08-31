package oop.programs_with_interesting_classes.easy.q6;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

public class MainTest {
    private final String className = "Course";
    private final String attributeName1 = "textBookFee";
    private final String attributeName2 = "suppliesFee";
    private final String attributeName3 = "labFee";
    private final String methodName = "calcTotalCost";
    private final String testClassName = "SemesterCost";

    private ObjectTest testClass;
    private ObjectTest classObject;

    @BeforeEach
    public void setUp() {
        String packageString = "oop.programs_with_interesting_classes.easy.q6." + className;
        testClass = new ObjectTest(packageString);
        String testClassString = "oop.programs_with_interesting_classes.easy.q6." + testClassName;
        classObject = new ObjectTest(testClassString);
    }

    @Test
    public void courseHasRequiredAttributes() {
        String missingAttributeMessage = "The %s class is missing the %s attribute. Make sure that the class contains the attribute and it is spelt correctly.";
        String wrongTypeMessage = "The %s attribute in the %s class has the wrong type.";
        String wrongModifierMessage = "The %s attribute in the %s class has the wrong visibility modifier.";
        assertTrue(testClass.hasField(attributeName1), String.format(missingAttributeMessage, className, attributeName1));
        assertTrue(testClass.hasField(attributeName1, double.class), String.format(wrongTypeMessage, attributeName1, className));
        assertTrue(testClass.hasModifier(attributeName1, "private"), String.format(wrongModifierMessage, attributeName1, className));
        assertTrue(testClass.hasField(attributeName2), String.format(missingAttributeMessage, className, attributeName2));
        assertTrue(testClass.hasField(attributeName2, double.class), String.format(wrongTypeMessage, attributeName2, className));
        assertTrue(testClass.hasModifier(attributeName2, "private"), String.format(wrongModifierMessage, attributeName2, className));
        assertTrue(testClass.hasField(attributeName3), String.format(missingAttributeMessage, className, attributeName3));
        assertTrue(testClass.hasField(attributeName3, double.class), String.format(wrongTypeMessage, attributeName3, className));
        assertTrue(testClass.hasModifier(attributeName3, "private"), String.format(wrongModifierMessage, attributeName3, className));
    }

    @Test
    public void courseHasRequiredConstructor() {
        String missingConstructorMessage = "The %s class is missing a required constructor. Make sure that it is named correctly and has the correct parameters.";
        String wrongAccessModifier = "The %s class constructor has the wrong visibility modifier. Make sure that it is visible from all other classes.";
        Class<?>[] constructorArgs = new Class[]{double.class, double.class, double.class};
        assertTrue(testClass.hasConstructor(constructorArgs), String.format(missingConstructorMessage, className));
        assertTrue(testClass.hasModifier(constructorArgs, "public"), String.format(wrongAccessModifier, className));
    }

    private static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(54.3, 73.4, 846.8),
                Arguments.of(34.3, 324.4, 65.4),
                Arguments.of(543.3, 543.3, 826.5),
                Arguments.of(849.5, 840.3, 103.2),
                Arguments.of(994.3, 430.4, 103.4),
                Arguments.of(549.3, 4392.3, 55.4),
                Arguments.of(2534.5, 54.4, 3.3),
                Arguments.of(3453.4, 754.5, 325.5)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    @Tag("dependent1")
    public void courseConstructorInitializesValuesCorrectly(double value1, double value2, double value3) throws Throwable {
        String wrongValueMessage = "The %s constructor did not initialize the %s attribute to the correct value based on the parameters passed to the constructor.";
        Object[][] constructorArgs = {
                {value1, double.class},
                {value2, double.class},
                {value3, double.class}
        };
        Object checkupInstance = testClass.createInstance(constructorArgs);
        _assertEquals(value1, testClass.getFieldValue(checkupInstance, attributeName1), String.format(wrongValueMessage, className, attributeName1));
        _assertEquals(value2, testClass.getFieldValue(checkupInstance, attributeName2), String.format(wrongValueMessage, className, attributeName2));
        _assertEquals(value3, testClass.getFieldValue(checkupInstance, attributeName3), String.format(wrongValueMessage, className, attributeName3));
    }

    @Test
    public void calcTotalCostIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(methodName, null), String.format(incorrectMethodDefinition, methodName, className));
        assertTrue(testClass.hasModifier(methodName, null, "public"), String.format(incorrectModifierMessage, methodName, className));
        assertTrue(testClass.hasReturnType(methodName, null, double.class), String.format(incorrectReturnType, methodName, className));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    @Tag("dependent1")
    public void discordClassHasCorrectCalcTotalCostMethod(double value1, double value2, double value3) throws Throwable {
        Object[][] constructorArgs = {
                {value1, double.class},
                {value2, double.class},
                {value3, double.class}
        };
        Object classInstance = testClass.createInstance(constructorArgs);
        String incorrectNumDays = "The %s method in the %s class does not correctly return the sum of all costs.";
        Object output = testClass.callMethod(methodName, classInstance);
        _assertEquals(value1 + value2 + value3, output,
                String.format(incorrectNumDays, methodName, className));
    }

    @Test
    @Tag("dependency1")
    public void correctMainMethod() throws Throwable {
        Clause[] clauses = {
                new StringLiteral("The total cost for this semester is: 737.71 dollars"),
                new NewLine()
        };
        Object classInstance = classObject.createInstance();
        classObject.callMethod("main", new Object[][]{{new String[0], String[].class}}, new String[]{"public"}, classInstance,
                clauses);
    }
}
