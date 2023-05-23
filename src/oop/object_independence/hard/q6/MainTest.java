package oop.object_independence.hard.q6;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
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
    private final String objectClassName = "Lasagna";
    private final String testClassName = "TestFood";
    private final String booleanAttributeName1 = "isBad";
    private final String booleanAttributeName2 = "inGarbage";
    private final String doubleAttributeName1 = "hoursSinceMade";
    private final String getBooleanAttributeName1 = "getIsBad";
    private final String getBooleanAttributeName2 = "getInGarbage";
    private final String getDoubleAttributeName1 = "getHoursSinceMade";
    private final String methodName1 = "gettingOld";
    private final String methodName2 = "throwFood";
    private final boolean testBooleanAttributeName1a = false;
    private final boolean testBooleanAttributeName2a = false;
    private final boolean testBooleanAttributeName3a = false;
    private final boolean testBooleanAttributeName4a = false;
    private final boolean testBooleanAttributeName5a = false;
    private final boolean testBooleanAttributeName1b = false;
    private final boolean testBooleanAttributeName2b = false;
    private final boolean testBooleanAttributeName3b = false;
    private final boolean testBooleanAttributeName4b = false;
    private final boolean testBooleanAttributeName5b = false;
    private final double testDoubleAttributeName1 = 0.0;
    private final double testDoubleAttributeName2 = 1.0;
    private final double testDoubleAttributeName3 = 3.8;
    private final double testDoubleAttributeName4 = 2.76;
    private final double testDoubleAttributeName5 = 1.8;
    private ObjectTest classInstance;
    private ObjectTest testInstance;

    @BeforeEach
    public void setup() {
        String objectClassString = "oop.object_independence.hard.q6." + objectClassName;
        String testClassString = "oop.object_independence.hard.q6." + testClassName;
        classInstance = new ObjectTest(objectClassString);
        testInstance = new ObjectTest(testClassString);
    }

    @Test
    public void lasagnaClassHasCorrectAttributes() {
        String missingAttributeMessage = "Your %s class is missing the %s attribute. Please make sure you have added it, it is spelled correctly, and is of the correct type.";
        assertTrue(classInstance.hasField(booleanAttributeName1, boolean.class),
                String.format(missingAttributeMessage, objectClassName, booleanAttributeName1));
        assertTrue(classInstance.hasField(booleanAttributeName2, boolean.class),
                String.format(missingAttributeMessage, objectClassName, booleanAttributeName2));
        assertTrue(classInstance.hasField(doubleAttributeName1, double.class),
                String.format(missingAttributeMessage, objectClassName, doubleAttributeName1));
        String incorrectVisibilityModifier = "Your %s class %s attribute has the wrong visibility modifier.";
        assertTrue(classInstance.hasModifier(booleanAttributeName1, "private"),
                String.format(incorrectVisibilityModifier, objectClassName, booleanAttributeName1));
        assertTrue(classInstance.hasModifier(booleanAttributeName2, "private"),
                String.format(incorrectVisibilityModifier, objectClassName, booleanAttributeName2));
        assertTrue(classInstance.hasModifier(doubleAttributeName1, "private"),
                String.format(incorrectVisibilityModifier, objectClassName, doubleAttributeName1));
    }

    @Test
    public void lasagnaClassHasRequiredConstructor() {
        String missingConstructorMessage = "Your " + testClassName + " class is missing a required constructor.";
        Class<?>[] arguments = {boolean.class, boolean.class, double.class};
        assertTrue(classInstance.hasConstructor(arguments), missingConstructorMessage);
    }

    private static Stream<Arguments> constructorInputProvider() {
        return Stream.of(
                Arguments.of(false, false, 0.0),
                Arguments.of(true, false, 12.36),
                Arguments.of(false, true, 84903.3),
                Arguments.of(true, true, 47.3824)
        );
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void lasagnaConstructorInitializesAttributesCorrectly(boolean b, boolean g, double h) throws Throwable {
        Object[][] arguments = {
                {b, boolean.class},
                {g, boolean.class},
                {h, double.class}
        };
        String incorrectVisibilityModifier = "Your %s constructor has the incorrect visibility modifier.";
        assertTrue(classInstance.hasModifier(new Class[]{boolean.class, boolean.class, double.class}, "public"),
                String.format(incorrectVisibilityModifier, objectClassName));
        Object instance = classInstance.createInstance(arguments);
        String incorrectAttributeValue =
                "Your %s constructor does not correctly initialize the %s attribute based on the passed parameters.";
        _assertEquals(b, classInstance.getFieldValue(instance, booleanAttributeName1),
                String.format(incorrectAttributeValue, objectClassName, booleanAttributeName1));
        _assertEquals(g, classInstance.getFieldValue(instance, booleanAttributeName2),
                String.format(incorrectAttributeValue, objectClassName, booleanAttributeName2));
        _assertEquals(h, classInstance.getFieldValue(instance, doubleAttributeName1),
                String.format(incorrectAttributeValue, objectClassName, doubleAttributeName1));
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void lasagnaHasCorrectGetMethods(boolean bad, boolean garbage, double hours) throws Throwable {
        Object[][] arguments = {
                {bad, boolean.class},
                {garbage, boolean.class},
                {hours, double.class}
        };
        Object instance = classInstance.createInstance(arguments);
        String incorrectGetMethods = "Your %s method does not return the value of the %s attribute.";

        Object output = classInstance.callMethod(getBooleanAttributeName1, new String[]{"public"}, instance);
        _assertEquals(bad, output, String.format(incorrectGetMethods, getBooleanAttributeName1, booleanAttributeName1));
        output = classInstance.callMethod(getBooleanAttributeName2, new String[]{"public"}, instance);
        _assertEquals(garbage, output, String.format(incorrectGetMethods, getBooleanAttributeName2, booleanAttributeName2));
        output = classInstance.callMethod(getDoubleAttributeName1, new String[]{"public"}, instance);
        _assertEquals(hours, output, String.format(incorrectGetMethods, getDoubleAttributeName1, doubleAttributeName1));
    }

    private static Stream<Arguments> setMethodsInputProvider() {
        return Stream.of(
                Arguments.of(false, false, 45.3, false, true, false, true),
                Arguments.of(false, false, 1.1, true, false, true, false),
                Arguments.of(false, false, 743.32, true, true, true, true),
                Arguments.of(true, false, 45.3, false, true, true, true),
                Arguments.of(true, false, 1.1, true, false, true, false),
                Arguments.of(true, false, 743.32, true, true, true, true),
                Arguments.of(true, true, 45.3, false, true, true, true),
                Arguments.of(true, true, 1.1, true, false, true, true),
                Arguments.of(true, true, 743.32, true, true, true, true)
        );
    }

    @ParameterizedTest
    @MethodSource("setMethodsInputProvider")
    public void lasagnaHasCorrectValueChangeMethods(boolean bad, boolean garbage, double hours, boolean m1, boolean m2, boolean newBad, boolean newGarbage) throws Throwable {
        Object[][] arguments = {
                {bad, boolean.class},
                {garbage, boolean.class},
                {hours, double.class}
        };
        Object instance = classInstance.createInstance(arguments);
        if (m1)
            classInstance.callMethod(methodName1, new Object[][]{{newColour, String.class}}, instance);
        if (m2)
            classInstance.callMethod(methodName2, new Object[][]{{newGender, String.class}}, instance);

        String incorrectSetMethods = "Your %s method does not update the %s attribute to the passed parameter.";

        _assertEquals(newColour, classInstance.getFieldValue(instance, booleanAttributeName1),
                String.format(incorrectSetMethods, methodName1, booleanAttributeName1));
        _assertEquals(newGender, classInstance.getFieldValue(instance, booleanAttributeName2),
                String.format(incorrectSetMethods, methodName2, booleanAttributeName2));
        _assertEquals(newAge, classInstance.getFieldValue(instance, doubleAttributeName1),
                String.format(incorrectSetMethods, setIntAttributeName1, doubleAttributeName1));

        assertTrue(classInstance.hasReturnType(methodName1, new Class[]{String.class}, void.class));
        assertTrue(classInstance.hasReturnType(methodName2, new Class[]{String.class}, void.class));
        assertTrue(classInstance.hasReturnType(setIntAttributeName1, new Class[]{int.class}, void.class));
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void fishClassHasCorrectToStringMethod(String colour, String gender, int age) throws Throwable {
        Object[][] arguments = {
                {colour, String.class},
                {gender, String.class},
                {age, int.class}
        };
        Object instance = classInstance.createInstance(arguments);
        String expectedOutput = "This fish is " + colour + ", and is " + gender + ", and is " + age + " years old";
        Object output = classInstance.callMethod("toString", new String[]{"public"}, instance);
        String incorrectToString = String.format("Your toString method for the %s class does return the correct String.", objectClassName);
        _assertEquals(expectedOutput, output, incorrectToString);
    }

    @ParameterizedTest
    @MethodSource("setMethodsInputProvider")
    public void fishMethodsWorkCorrectlyWorkTogether(String colour, String gender, int age, String newColour, String newGender, int newAge) throws Throwable {
        Object[][] constructorArguments = {
                {colour, String.class},
                {gender, String.class},
                {age, int.class}
        };
        Object instance = classInstance.createInstance(constructorArguments);
        classInstance.callMethod(methodName1, new Object[][]{{newColour, String.class}}, instance);
        classInstance.callMethod(methodName2, new Object[][]{{newGender, String.class}}, instance);
        classInstance.callMethod(setIntAttributeName1, new Object[][]{{newAge, int.class}}, instance);
        Object output1 = classInstance.callMethod(getBooleanAttributeName1, instance);
        Object output2 = classInstance.callMethod(getBooleanAttributeName2, instance);
        Object output3 = classInstance.callMethod(getDoubleAttributeName1, instance);
        Object toStringOutput = classInstance.callMethod("toString", instance);
        String expectedToStringOutput = "This fish is " + newColour + ", and is " + newGender + ", and is " + newAge + " years old";
        String incorrectSetGet =
                "Your %s method does not return the correct value after updating the %s attribute using the %s method.";
        String incorrectToString = "Your toString method does not return the correct String after updating the %s, %s, and %s attributes using the %s, %s, and %s methods.";
        _assertEquals(newColour, output1,
                String.format(incorrectSetGet, getBooleanAttributeName1, booleanAttributeName1, methodName1));
        _assertEquals(newGender, output2,
                String.format(incorrectSetGet, getBooleanAttributeName2, booleanAttributeName2, methodName2));
        _assertEquals(newAge, output3,
                String.format(incorrectSetGet, getDoubleAttributeName1, doubleAttributeName1, setIntAttributeName1));
        _assertEquals(expectedToStringOutput, toStringOutput,
                String.format(incorrectToString, booleanAttributeName1, booleanAttributeName2, doubleAttributeName1,
                        methodName1, methodName2, setIntAttributeName1));
    }

    @Test
    public void testAquariumMainMethodProducesCorrectOutput() throws Throwable {
        Object[][] arguments = {{new String[0], String[].class}};
        Clause[] clauses = new Clause[]{
                new StringLiteral(String.format("This fish is %s, and is %s, and is %d years old",
                        testBooleanAttributeName1a, testBooleanAttributeName1b, testDoubleAttributeName1)),
                new NewLine(),
                new StringLiteral(String.format("This fish is %s, and is %s, and is %d years old",
                        testBooleanAttributeName2a, testBooleanAttributeName2b, testDoubleAttributeName2)),
                new NewLine(),
                new StringLiteral(String.format("This fish is %s, and is %s, and is %d years old",
                        testBooleanAttributeName3a, testBooleanAttributeName3b, testDoubleAttributeName3)),
                new NewLine(),
                new StringLiteral(String.format("This fish is %s, and is %s, and is %d years old",
                        testBooleanAttributeName1a, testBooleanAttributeName1b, testDoubleAttributeName1 + testIntAttributeNameUpdate)),
                new NewLine(),
                new StringLiteral(String.format("This fish is %s, and is %s, and is %d years old",
                        testBooleanAttributeName2a, testBooleanAttributeName2b, testDoubleAttributeName2 + testIntAttributeNameUpdate)),
                new NewLine(),
                new StringLiteral(String.format("This fish is %s, and is %s, and is %d years old",
                        testBooleanAttributeName3a, testBooleanAttributeName3b, testDoubleAttributeName3 + testIntAttributeNameUpdate)),
        };
        String incorrectOutput =
                String.format("Your %s class main method does not correctly initialize, update, and print the values of the three %s objects.",
                        testClassName, objectClassName);
        testInstance.callMethod("main", arguments, clauses, incorrectOutput);
    }
}
