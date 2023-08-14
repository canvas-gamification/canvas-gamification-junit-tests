package oop.programs_with_interesting_classes.easy.q8;

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

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    private final String className = "Activity";
    private final String attributeName1 = "name";
    private final String attributeName2 = "consumptionRate";
    private final String attributeName3 = "duration";
    private final String methodName = "usageCalculator";
    private final String getAttributeName1 = "getName";
    private final String testClassName = "TestWaterUsage";

    private ObjectTest testClass;
    private ObjectTest classObject;

    @BeforeEach
    public void setUp() {
        String packageString = "oop.programs_with_interesting_classes.easy.q8." + className;
        testClass = new ObjectTest(packageString);
        String testClassString = "oop.programs_with_interesting_classes.easy.q8." + testClassName;
        classObject = new ObjectTest(testClassString);
    }

    @Test
    public void activityHasRequiredAttributes() {
        String missingAttributeMessage = "The %s class is missing the %s attribute. Make sure that the class contains the attribute and it is spelt correctly.";
        String wrongTypeMessage = "The %s attribute in the %s class has the wrong type.";
        String wrongModifierMessage = "The %s attribute in the %s class has the wrong visibility modifier.";
        assertTrue(testClass.hasField(attributeName1), String.format(missingAttributeMessage, className, attributeName1));
        assertTrue(testClass.hasField(attributeName1, String.class), String.format(wrongTypeMessage, attributeName1, className));
        assertTrue(testClass.hasModifier(attributeName1, "private"), String.format(wrongModifierMessage, attributeName1, className));
        assertTrue(testClass.hasField(attributeName2), String.format(missingAttributeMessage, className, attributeName2));
        assertTrue(testClass.hasField(attributeName2, double.class), String.format(wrongTypeMessage, attributeName2, className));
        assertTrue(testClass.hasModifier(attributeName2, "private"), String.format(wrongModifierMessage, attributeName2, className));
        assertTrue(testClass.hasField(attributeName3), String.format(missingAttributeMessage, className, attributeName3));
        assertTrue(testClass.hasField(attributeName3, int.class), String.format(wrongTypeMessage, attributeName3, className));
        assertTrue(testClass.hasModifier(attributeName3, "private"), String.format(wrongModifierMessage, attributeName3, className));
    }

    @Test
    public void activityHasRequiredConstructor() {
        String missingConstructorMessage = "The %s class is missing a required constructor. Make sure that it is named correctly and has the correct parameters.";
        String wrongAccessModifier = "The %s class constructor has the wrong visibility modifier. Make sure that it is visible from all other classes.";
        Class<?>[] constructorArgs = new Class[]{String.class, double.class, int.class};
        assertTrue(testClass.hasConstructor(constructorArgs), String.format(missingConstructorMessage, className));
        assertTrue(testClass.hasModifier(constructorArgs, "public"), String.format(wrongAccessModifier, className));
    }

    private static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of("Jogging", 0.05, 30),
                Arguments.of("Swimming", 0.08, 45),
                Arguments.of("Cycling", 0.07, 60),
                Arguments.of("Yoga", 0.03, 40),
                Arguments.of("Weightlifting", 0.06, 50),
                Arguments.of("Dancing", 0.05, 30),
                Arguments.of("Basketball", 0.08, 40),
                Arguments.of("Gardening", 0.04, 90),
                Arguments.of("Hiking", 0.06, 180),
                Arguments.of("Meditation", 0.02, 20)
        );
    }


    @ParameterizedTest
    @MethodSource("inputProvider")
    public void activityConstructorInitializesValuesCorrectly(String value1, double value2, int value3) throws Throwable {
        String wrongValueMessage = "The %s constructor did not initialize the %s attribute to the correct value based on the parameters passed to the constructor.";
        Object[][] constructorArgs = {
                {value1, String.class},
                {value2, double.class},
                {value3, int.class}
        };
        Object checkupInstance = testClass.createInstance(constructorArgs);
        _assertEquals(value1, testClass.getFieldValue(checkupInstance, attributeName1), String.format(wrongValueMessage, className, attributeName1));
        _assertEquals(value2, testClass.getFieldValue(checkupInstance, attributeName2), String.format(wrongValueMessage, className, attributeName2));
        _assertEquals(value3, testClass.getFieldValue(checkupInstance, attributeName3), String.format(wrongValueMessage, className, attributeName3));
    }

    @Test
    public void usageCalculatorIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(methodName, null), String.format(incorrectMethodDefinition, methodName, className));
        assertTrue(testClass.hasModifier(methodName, null, "public"), String.format(incorrectModifierMessage, methodName, className));
        assertTrue(testClass.hasReturnType(methodName, null, double.class), String.format(incorrectReturnType, methodName, className));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void activityClassHasCorrectUsageCalculatorMethod(String value1, double value2, int value3) throws Throwable {
        Object[][] constructorArgs = {
                {value1, String.class},
                {value2, double.class},
                {value3, int.class}
        };
        Object classInstance = testClass.createInstance(constructorArgs);
        String incorrectNumDays = "The %s method in the %s class does not correctly return the total consumption.";
        Object output = testClass.callMethod(methodName, classInstance);
        _assertEquals(value2 * value3, output,
                String.format(incorrectNumDays, methodName, className));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void activityClassHasCorrectGetNameMethod(String value1, double value2, int value3) throws Throwable {
        Object[][] arguments = {
                {value1, String.class},
                {value2, double.class},
                {value3, int.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String[] getMethodModifiers = {"public"};
        String incorrectGetMethodMessage = String.join(" ",
                "Your", getAttributeName1, "does not correctly get the value of the", attributeName1, "attribute.");
        Object getMethodOutput = testClass.callMethod(getAttributeName1, getMethodModifiers, classInstance);
        _assertEquals(value1, getMethodOutput, incorrectGetMethodMessage);
    }

    @Test
    @Tag("dependent1")
    public void correctMainMethod() throws Throwable {
        Clause[] clauses = {
                new StringLiteral("The total water usage is 315.0"),
                new NewLine(),
                new StringLiteral("The activity that uses the most water is Watering Plants")
        };
        Object classInstance = classObject.createInstance();
        classObject.callMethod("main", new Object[][]{{new String[0], String[].class}}, new String[]{"public"}, classInstance,
                clauses);
    }
}
