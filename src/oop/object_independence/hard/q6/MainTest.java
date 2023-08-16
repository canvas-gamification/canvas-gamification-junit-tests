package oop.object_independence.hard.q6;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
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
    private final boolean testBooleanUpdate = true;
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
        String missingAttributeMessage = "Your %s class is missing the %s attribute. Please make sure you have added it and that it is spelled correctly.";
        assertTrue(classInstance.hasField(booleanAttributeName1),
                String.format(missingAttributeMessage, objectClassName, booleanAttributeName1));
        assertTrue(classInstance.hasField(booleanAttributeName2),
                String.format(missingAttributeMessage, objectClassName, booleanAttributeName2));
        assertTrue(classInstance.hasField(doubleAttributeName1),
                String.format(missingAttributeMessage, objectClassName, doubleAttributeName1));
        String wrongTypeMessage = "Your %s attribute does not have the correct type.";
        assertTrue(classInstance.hasField(booleanAttributeName1, boolean.class),
                String.format(wrongTypeMessage, booleanAttributeName1));
        assertTrue(classInstance.hasField(booleanAttributeName2, boolean.class),
                String.format(wrongTypeMessage, booleanAttributeName2));
        assertTrue(classInstance.hasField(doubleAttributeName1, double.class),
                String.format(wrongTypeMessage, doubleAttributeName1));
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
        Class<?>[] arguments = {boolean.class, boolean.class, double.class};
        assertTrue(classInstance.hasConstructor(arguments),
                String.format("Your %s class is missing a required constructor.", testClassName));
        assertTrue(classInstance.hasConstructor(arguments, new String[]{"public"}),
                String.format("Your %s class constructor has the incorrect visibility modifier.", testClassName));    }

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

    @Tag("dependent1")
    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void lasagnaHasCorrectGetIsBadMethod(boolean bad, boolean garbage, double hours) throws Throwable {
        Object[][] arguments = {
                {bad, boolean.class},
                {garbage, boolean.class},
                {hours, double.class}
        };
        Object instance = classInstance.createInstance(arguments);
        String incorrectGetMethods = "Your %s method does not return the value of the %s attribute.";

        assertTrue(classInstance.hasMethod(getBooleanAttributeName1, new Class[]{}),
                "Your " + testClassName + " class is missing the method " + getBooleanAttributeName1 + ".");
        assertTrue(classInstance.hasMethod(getBooleanAttributeName1, new Class[]{}, boolean.class),
                "Your " + testClassName + " class " + getBooleanAttributeName1 + " method does not have the correct return type.");
        assertTrue(classInstance.hasMethod(getBooleanAttributeName1, new Class[]{}, boolean.class, new String[]{"public"}),
                "Your " + testClassName + " class " + getBooleanAttributeName1 + " method does not have the correct visibility modifier.");

        Object output = classInstance.callMethod(getBooleanAttributeName1, new String[]{"public"}, instance);
        _assertEquals(bad, output, String.format(incorrectGetMethods, getBooleanAttributeName1, booleanAttributeName1));
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void lasagnaHasCorrectGetInGarbageMethod(boolean bad, boolean garbage, double hours) throws Throwable {
        Object[][] arguments = {
                {bad, boolean.class},
                {garbage, boolean.class},
                {hours, double.class}
        };
        Object instance = classInstance.createInstance(arguments);
        String incorrectGetMethods = "Your %s method does not return the value of the %s attribute.";

        assertTrue(classInstance.hasMethod(getBooleanAttributeName2, new Class[]{}),
                "Your " + testClassName + " class is missing the method " + getBooleanAttributeName2 + ".");
        assertTrue(classInstance.hasMethod(getBooleanAttributeName2, new Class[]{}, boolean.class),
                "Your " + testClassName + " class " + getBooleanAttributeName2 + " method does not have the correct return type.");
        assertTrue(classInstance.hasMethod(getBooleanAttributeName2, new Class[]{}, boolean.class, new String[]{"public"}),
                "Your " + testClassName + " class " + getBooleanAttributeName2 + " method does not have the correct visibility modifier.");

        Object output = classInstance.callMethod(getBooleanAttributeName2, new String[]{"public"}, instance);
        _assertEquals(garbage, output, String.format(incorrectGetMethods, getBooleanAttributeName2, booleanAttributeName2));
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void lasagnaHasCorrectGetHoursSinceMadeMethods(boolean bad, boolean garbage, double hours) throws Throwable {
        Object[][] arguments = {
                {bad, boolean.class},
                {garbage, boolean.class},
                {hours, double.class}
        };
        Object instance = classInstance.createInstance(arguments);
        String incorrectGetMethods = "Your %s method does not return the value of the %s attribute.";

        assertTrue(classInstance.hasMethod(getDoubleAttributeName1, new Class[]{}),
                "Your " + testClassName + " class is missing the method " + getDoubleAttributeName1 + ".");
        assertTrue(classInstance.hasMethod(getDoubleAttributeName1, new Class[]{}, double.class),
                "Your " + testClassName + " class " + getDoubleAttributeName1 + " method does not have the correct return type.");
        assertTrue(classInstance.hasMethod(getDoubleAttributeName1, new Class[]{}, double.class, new String[]{"public"}),
                "Your " + testClassName + " class " + getDoubleAttributeName1 + " method does not have the correct visibility modifier.");

        Object output = classInstance.callMethod(getDoubleAttributeName1, new String[]{"public"}, instance);
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

    @Tag("dependent1")
    @ParameterizedTest
    @MethodSource("setMethodsInputProvider")
    public void lasagnaHasCorrectGettingOldMethod(boolean bad, boolean garbage, double hours, boolean m1, boolean m2, boolean newBad, boolean newGarbage) throws Throwable {
        Object[][] arguments = {
                {bad, boolean.class},
                {garbage, boolean.class},
                {hours, double.class}
        };
        Object instance = classInstance.createInstance(arguments);
        assertTrue(classInstance.hasMethod(methodName1, new Class[]{}),
                "Your " + testClassName + " class is missing the method " + methodName1 + ".");
        assertTrue(classInstance.hasMethod(methodName1, new Class[]{}, Void.TYPE),
                "Your " + testClassName + " class " + methodName1 + " method does not have the correct return type.");
        assertTrue(classInstance.hasMethod(methodName1, new Class[]{}, Void.TYPE, new String[]{"public"}),
                "Your " + testClassName + " class " + methodName1 + " method does not have the correct visibility modifier.");
        if (m1)
            classInstance.callMethod(methodName1, instance);

        String incorrectMethods = "Your %s method does not correctly update the %s attribute.";

        _assertEquals(newBad, classInstance.getFieldValue(instance, booleanAttributeName1),
                String.format(incorrectMethods, methodName1, booleanAttributeName1));
    }

    @Tag("dependent1")
    @ParameterizedTest
    @MethodSource("setMethodsInputProvider")
    public void lasagnaHasCorrectThrowFoodMethod(boolean bad, boolean garbage, double hours, boolean m1, boolean m2, boolean newBad, boolean newGarbage) throws Throwable {
        Object[][] arguments = {
                {bad, boolean.class},
                {garbage, boolean.class},
                {hours, double.class}
        };
        Object instance = classInstance.createInstance(arguments);
        assertTrue(classInstance.hasMethod(methodName1, new Class[]{}),
                "Your " + testClassName + " class is missing the method " + methodName1 + ".");
        assertTrue(classInstance.hasMethod(methodName1, new Class[]{}, Void.TYPE),
                "Your " + testClassName + " class " + methodName1 + " method does not have the correct return type.");
        assertTrue(classInstance.hasMethod(methodName1, new Class[]{}, Void.TYPE, new String[]{"public"}),
                "Your " + testClassName + " class " + methodName1 + " method does not have the correct visibility modifier.");
        if (m2)
            classInstance.callMethod(methodName2, instance);

        String incorrectMethods = "Your %s method does not correctly update the %s attribute.";

        _assertEquals(newGarbage, classInstance.getFieldValue(instance, booleanAttributeName2),
                String.format(incorrectMethods, methodName2, booleanAttributeName2));
    }

    @Tag("dependent1")
    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void lasagnaClassHasCorrectToStringMethod(boolean bad, boolean garbage, double hours) throws Throwable {
        Object[][] arguments = {
                {bad, boolean.class},
                {garbage, boolean.class},
                {hours, double.class}
        };
        Object instance = classInstance.createInstance(arguments);
        assertTrue(classInstance.hasMethod("toString", new Class[]{}),
                "Your " + testClassName + " class is missing the toString method.");
        assertTrue(classInstance.hasMethod("toString", new Class[]{}, String.class),
                "Your " + testClassName + " class toString method does not have the correct return type.");
        assertTrue(classInstance.hasMethod("toString", new Class[]{}, String.class, new String[]{"public"}),
                "Your " + testClassName + " class toString method does not have the correct visibility modifier.");
        String expectedOutput =
                "The dish was made " + hours + " hours ago. Is it bad? " + bad + ". Has it been thrown out? " + garbage + ".";
        Object output = classInstance.callMethod("toString", new String[]{"public"}, instance);
        String incorrectToString = String.format("Your toString method for the %s class does return the correct String.", objectClassName);
        _assertEquals(expectedOutput, output, incorrectToString);
    }

    @ParameterizedTest
    @MethodSource("setMethodsInputProvider")
    public void lasagnaMethodsWorkCorrectlyWorkTogether(boolean bad, boolean garbage, double hours, boolean m1, boolean m2, boolean newBad, boolean newGarbage) throws Throwable {
        Object[][] constructorArguments = {
                {bad, boolean.class},
                {garbage, boolean.class},
                {hours, double.class}
        };
        Object instance = classInstance.createInstance(constructorArguments);
        if (m1)
            classInstance.callMethod(methodName1, instance);
        if (m2)
            classInstance.callMethod(methodName2, instance);
        Object output1 = classInstance.callMethod(getBooleanAttributeName1, instance);
        Object output2 = classInstance.callMethod(getBooleanAttributeName2, instance);
        Object output3 = classInstance.callMethod(getDoubleAttributeName1, instance);
        Object toStringOutput = classInstance.callMethod("toString", instance);
        String expectedToStringOutput =
                "The dish was made " + hours + " hours ago. Is it bad? " + newBad + ". Has it been thrown out? " + newGarbage + ".";
        String incorrectSetGet =
                "Your %s method does not return the correct value after updating the %s attribute using the %s method.";
        String incorrectToString = "Your toString method does not return the correct String after updating the %s and %s attributes using the %s and %s methods.";
        _assertEquals(newBad, output1,
                String.format(incorrectSetGet, getBooleanAttributeName1, booleanAttributeName1, methodName1));
        _assertEquals(newGarbage, output2,
                String.format(incorrectSetGet, getBooleanAttributeName2, booleanAttributeName2, methodName2));
        _assertEquals(hours, output3,
                "Your " + doubleAttributeName1 + " attribute does not remain unchanged after calling other methods.");
        _assertEquals(expectedToStringOutput, toStringOutput,
                String.format(incorrectToString, booleanAttributeName1, booleanAttributeName2, methodName1, methodName2));
    }

    @Tag("dependency1")
    @Test
    public void testFoodMainMethodProducesCorrectOutput() throws Throwable {
        Object[][] arguments = {{new String[0], String[].class}};
        Clause[] clauses = new Clause[]{
                new StringLiteral("The dish was made " + testDoubleAttributeName1 + " hours ago\\. Is it bad\\? " +
                        testBooleanAttributeName1a + "\\. Has it been thrown out\\? " + testBooleanAttributeName1b +
                        "\\."),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The dish was made " + testDoubleAttributeName2 + " hours ago\\. Is it bad\\? " +
                        testBooleanAttributeName2a + "\\. Has it been thrown out\\? " + testBooleanAttributeName2b +
                        "\\."),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The dish was made " + testDoubleAttributeName3 + " hours ago\\. Is it bad\\? " +
                        testBooleanAttributeName3a + "\\. Has it been thrown out\\? " + testBooleanAttributeName3b +
                        "\\."),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The dish was made " + testDoubleAttributeName4 + " hours ago\\. Is it bad\\? " +
                        testBooleanAttributeName4a + "\\. Has it been thrown out\\? " + testBooleanAttributeName4b +
                        "\\."),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The dish was made " + testDoubleAttributeName5 + " hours ago\\. Is it bad\\? " +
                        testBooleanAttributeName5a + "\\. Has it been thrown out\\? " + testBooleanAttributeName5b +
                        "\\."),
                new Optional(new StringLiteral(" ")),
                new NewLine(),

                new StringLiteral("Some time passed\\.\\.\\."),
                new Optional(new StringLiteral(" ")),
                new NewLine(),

                new StringLiteral("The dish was made " + testDoubleAttributeName1 + " hours ago\\. Is it bad\\? " +
                        testBooleanUpdate + "\\. Has it been thrown out\\? " + testBooleanUpdate +
                        "\\."),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The dish was made " + testDoubleAttributeName2 + " hours ago\\. Is it bad\\? " +
                        testBooleanAttributeName2a + "\\. Has it been thrown out\\? " + testBooleanAttributeName2b +
                        "\\."),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The dish was made " + testDoubleAttributeName3 + " hours ago\\. Is it bad\\? " +
                        testBooleanUpdate + "\\. Has it been thrown out\\? " + testBooleanUpdate +
                        "\\."),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The dish was made " + testDoubleAttributeName4 + " hours ago\\. Is it bad\\? " +
                        testBooleanAttributeName4a + "\\. Has it been thrown out\\? " + testBooleanAttributeName4b +
                        "\\."),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The dish was made " + testDoubleAttributeName5 + " hours ago\\. Is it bad\\? " +
                        testBooleanAttributeName5a + "\\. Has it been thrown out\\? " + testBooleanAttributeName5b +
                        "\\."),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
        };
        String incorrectOutput =
                String.format("Your %s class main method does not correctly initialize, update, and print the values of the five %s objects.",
                        testClassName, objectClassName);
        testInstance.callMethod("main", arguments, clauses, incorrectOutput);
    }
}
