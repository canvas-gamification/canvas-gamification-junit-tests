package oop.object_independence.hard.q5;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
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
    private final String objectClassName = "Glass";
    private final String testClassName = "TestFragile";
    private final String stringAttributeName1 = "condition";
    private final String booleanAttributeName1 = "isBroken";
    private final String doubleAttributeName1 = "weight";
    private final String methodName1 = "broken";
    private final String methodName2 = "fix";
    private final String getMethodName = "getIsBroken";
    private final String testStringAttributeName1 = "New";
    private final String testStringAttributeName2 = "Worn";
    private final String testStringAttributeName3 = "Old";
    private final boolean testBooleanAttributeName1 = false;
    private final boolean testBooleanAttributeName2 = false;
    private final boolean testBooleanAttributeName3 = false;
    private final double testDoubleAttributeName1 = 40.0;
    private final double testDoubleAttributeName2 = 32.9;
    private final double testDoubleAttributeName3 = 813.25;
    private final boolean testBooleanAttributeNameUpdate = true;
    private ObjectTest classInstance;
    private ObjectTest testInstance;

    @BeforeEach
    public void setup() {
        String objectClassString = "oop.object_independence.hard.q5." + objectClassName;
        String testClassString = "oop.object_independence.hard.q5." + testClassName;
        classInstance = new ObjectTest(objectClassString);
        testInstance = new ObjectTest(testClassString);
    }

    @Test
    public void glassClassHasCorrectAttributes() {
        String missingAttributeMessage = "Your %s class is missing the %s attribute. Please make sure you have added it, it is spelled correctly, and is of the correct type.";
        assertTrue(classInstance.hasField(stringAttributeName1, String.class),
                String.format(missingAttributeMessage, objectClassName, stringAttributeName1));
        assertTrue(classInstance.hasField(booleanAttributeName1, boolean.class),
                String.format(missingAttributeMessage, objectClassName, booleanAttributeName1));
        assertTrue(classInstance.hasField(doubleAttributeName1, double.class),
                String.format(missingAttributeMessage, objectClassName, doubleAttributeName1));
        String incorrectVisibilityModifier = "Your %s class %s attribute has the wrong visibility modifier.";
        assertTrue(classInstance.hasModifier(stringAttributeName1, "private"),
                String.format(incorrectVisibilityModifier, objectClassName, stringAttributeName1));
        assertTrue(classInstance.hasModifier(booleanAttributeName1, "private"),
                String.format(incorrectVisibilityModifier, objectClassName, booleanAttributeName1));
        assertTrue(classInstance.hasModifier(doubleAttributeName1, "private"),
                String.format(incorrectVisibilityModifier, objectClassName, doubleAttributeName1));
    }

    @Test
    public void glassClassHasRequiredConstructor() {
        String missingConstructorMessage = "Your " + testClassName + " class is missing a required constructor.";
        Class<?>[] arguments = {String.class, boolean.class, double.class};
        assertTrue(classInstance.hasConstructor(arguments), missingConstructorMessage);
    }

    private static Stream<Arguments> constructorInputProvider() {
        return Stream.of(
                Arguments.of("Good", false, 50.38),
                Arguments.of("Fragmented", true, 12.1),
                Arguments.of("Graffitied", false, 78.281),
                Arguments.of("Poor", true, 1644.3)
        );
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void glassConstructorInitializesAttributesCorrectly(String s, boolean b, double d) throws Throwable {
        Object[][] arguments = {
                {s, String.class},
                {b, boolean.class},
                {d, double.class}
        };
        String incorrectVisibilityModifier = "Your %s constructor has the incorrect visibility modifier.";
        assertTrue(classInstance.hasModifier(new Class[]{String.class, boolean.class, double.class}, "public"),
                String.format(incorrectVisibilityModifier, objectClassName));
        Object instance = classInstance.createInstance(arguments);
        String incorrectAttributeValue =
                "Your %s constructor does not correctly initialize the %s attribute based on the passed parameters.";
        _assertEquals(s, classInstance.getFieldValue(instance, stringAttributeName1),
                String.format(incorrectAttributeValue, objectClassName, stringAttributeName1));
        _assertEquals(b, classInstance.getFieldValue(instance, booleanAttributeName1),
                String.format(incorrectAttributeValue, objectClassName, booleanAttributeName1));
        _assertEquals(d, classInstance.getFieldValue(instance, doubleAttributeName1),
                String.format(incorrectAttributeValue, objectClassName, doubleAttributeName1));
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void glassHasCorrectFixMethod(String condition, boolean broken, double weight) throws Throwable {
        Object[][] arguments = {
                {condition, String.class},
                {broken, boolean.class},
                {weight, double.class}
        };
        Object instance = classInstance.createInstance(arguments);
        String incorrectFixMethod = "Your %s method does not set the %s attribute to false.";

        classInstance.callMethod(methodName2, new String[]{"public"}, instance);
        _assertEquals(false, classInstance.getFieldValue(instance, "isBroken"),
                String.format(incorrectFixMethod, methodName2, booleanAttributeName1));
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void glassHasCorrectBrokenMethod(String condition, boolean broken, double weight) throws Throwable {
        Object[][] arguments = {
                {condition, String.class},
                {broken, boolean.class},
                {weight, double.class}
        };
        Object instance = classInstance.createInstance(arguments);
        String incorrectBrokenMethod = "Your %s method does not set the %s attribute to true.";

        classInstance.callMethod(methodName1, new String[]{"public"}, instance);
        _assertEquals(true, classInstance.getFieldValue(instance, "isBroken"),
                String.format(incorrectBrokenMethod, methodName1, booleanAttributeName1));
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void glassHasCorrectGetMethod(String condition, boolean broken, double weight) throws Throwable {
        Object[][] arguments = {
                {condition, String.class},
                {broken, boolean.class},
                {weight, double.class}
        };
        Object instance = classInstance.createInstance(arguments);
        String incorrectGetMethods = "Your %s method does not return the value of the %s attribute.";

        Object output = classInstance.callMethod(getMethodName, new String[]{"public"}, instance);
        _assertEquals(broken, output, String.format(incorrectGetMethods, getMethodName, booleanAttributeName1));
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void glassClassHasCorrectToStringMethod(String condition, boolean broken, double weight) throws Throwable {
        Object[][] arguments = {
                {condition, String.class},
                {broken, boolean.class},
                {weight, double.class}
        };
        Object instance = classInstance.createInstance(arguments);
        String expectedOutput = "The item is " + condition + ", and its weight is " + weight + " and is it broken? " + broken;
        Object output = classInstance.callMethod("toString", new String[]{"public"}, instance);
        String incorrectToString = String.format("Your toString method for the %s class does return the correct String.", objectClassName);
        _assertEquals(expectedOutput, output, incorrectToString);
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void glassMethodsWorkCorrectlyWorkTogether(String condition, boolean broken, double weight) throws Throwable {
        Object[][] constructorArguments = {
                {condition, String.class},
                {broken, boolean.class},
                {weight, double.class}
        };
        Object instance = classInstance.createInstance(constructorArguments);
        classInstance.callMethod(methodName1, instance);
        Object output1 = classInstance.callMethod(getMethodName, new String[]{"public"}, instance);
        _assertEquals(true, output1, String.format(
                "Your %s method does not return the correct value after updating the %s attribute using the %s method.",
                getMethodName, booleanAttributeName1, methodName1));
        classInstance.callMethod(methodName2, instance);
        Object output2 = classInstance.callMethod("toString", new String[]{"public"}, instance);
        String expectedToStringOutput = "The item is " + condition + ", and its weight is " + weight + " and is it broken? " + false;
        String incorrectToString = "Your toString method does not return the correct String after calling the %s method.";
        _assertEquals(expectedToStringOutput, output2, String.format(incorrectToString, methodName1));
    }

    @Test
    public void testFragileMainMethodProducesCorrectOutput() throws Throwable {
        Object[][] arguments = {{new String[0], String[].class}};
        Clause[] clauses = new Clause[]{
                new StringLiteral("The item is " + testStringAttributeName1 + ", and its weight is " + testDoubleAttributeName1
                        + " and is it broken\\? " + testBooleanAttributeName1),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The item is " + testStringAttributeName2 + ", and its weight is " + testDoubleAttributeName2
                        + " and is it broken\\? " + testBooleanAttributeName2),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The item is " + testStringAttributeName3 + ", and its weight is " + testDoubleAttributeName3
                        + " and is it broken\\? " + testBooleanAttributeName3),
                new Optional(new StringLiteral(" ")),
                new NewLine(),

                new StringLiteral("The item is " + testStringAttributeName1 + ", and its weight is " + testDoubleAttributeName1
                        + " and is it broken\\? " + testBooleanAttributeNameUpdate),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The item is " + testStringAttributeName2 + ", and its weight is " + testDoubleAttributeName2
                        + " and is it broken\\? " + testBooleanAttributeName2),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The item is " + testStringAttributeName3 + ", and its weight is " + testDoubleAttributeName3
                        + " and is it broken\\? " + testBooleanAttributeNameUpdate),
                new Optional(new StringLiteral(" ")),
                new NewLine(),

                new StringLiteral("The item is " + testStringAttributeName1 + ", and its weight is " + testDoubleAttributeName1
                        + " and is it broken\\? " + testBooleanAttributeName1),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The item is " + testStringAttributeName2 + ", and its weight is " + testDoubleAttributeName2
                        + " and is it broken\\? " + testBooleanAttributeName2),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The item is " + testStringAttributeName3 + ", and its weight is " + testDoubleAttributeName3
                        + " and is it broken\\? " + testBooleanAttributeName3),
                new Optional(new StringLiteral(" "))
        };
        String incorrectOutput =
                String.format("Your %s class main method does not correctly initialize, update, and print the values of the three %s objects.",
                        testClassName, objectClassName);
        testInstance.callMethod("main", arguments, clauses, incorrectOutput);
    }
}
