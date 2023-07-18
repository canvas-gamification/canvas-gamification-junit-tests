package oop.object_independence.hard.q3;

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
    private final String objectClassName = "Tree";
    private final String testClassName = "TestFoliage";
    private final String booleanAttributeName1 = "isRare";
    private final String doubleAttributeName1 = "height";
    private final String getBooleanAttributeName1 = "getIsRare";
    private final String getDoubleAttributeName1 = "getHeight";
    private final String setBooleanAttributeName1 = "setIsRare";
    private final String setDoubleAttributeName1 = "setHeight";
    private final boolean testBooleanAttributeName1 = true;
    private final boolean testBooleanAttributeName2 = false;
    private final double testDoubleAttributeName1 = 50.5;
    private final double testDoubleAttributeName2 = 20.4;
    private final double testDoubleAttributeNameUpdate = 0.0;
    private ObjectTest classInstance;
    private ObjectTest testInstance;

    @BeforeEach
    public void setup() {
        String objectClassString = "oop.object_independence.hard.q3." + objectClassName;
        String testClassString = "oop.object_independence.hard.q3." + testClassName;
        classInstance = new ObjectTest(objectClassString);
        testInstance = new ObjectTest(testClassString);
    }

    @Test
    public void treeClassHasCorrectAttributes() {
        String missingAttributeMessage = "Your %s class is missing the %s attribute. Please make sure you have added it, it is spelled correctly, and has the correct type";
        assertTrue(classInstance.hasField(booleanAttributeName1),
                String.format(missingAttributeMessage, objectClassName, booleanAttributeName1));
        assertTrue(classInstance.hasField(doubleAttributeName1),
                String.format(missingAttributeMessage, objectClassName, doubleAttributeName1));
        String wrongTypeMessage = "Your %s class does not have the correct type.";
        assertTrue(classInstance.hasField(booleanAttributeName1, boolean.class),
                String.format(wrongTypeMessage, booleanAttributeName1));
        assertTrue(classInstance.hasField(doubleAttributeName1, double.class),
                String.format(wrongTypeMessage, doubleAttributeName1));
        String incorrectVisibilityModifier = "Your %s class %s attribute has the wrong visibility modifier.";
        assertTrue(classInstance.hasModifier(booleanAttributeName1, "private"),
                String.format(incorrectVisibilityModifier, objectClassName, booleanAttributeName1));
        assertTrue(classInstance.hasModifier(doubleAttributeName1, "private"),
                String.format(incorrectVisibilityModifier, objectClassName, doubleAttributeName1));
    }

    @Test
    public void treeClassHasRequiredConstructor() {
        Class<?>[] arguments = {boolean.class, double.class};
        assertTrue(classInstance.hasConstructor(arguments),
                String.format("Your %s class is missing a required constructor.", testClassName));
        assertTrue(classInstance.hasConstructor(arguments, new String[]{"public"}),
                String.format("Your %s class constructor has the incorrect visibility modifier.", testClassName));
    }

    private static Stream<Arguments> constructorInputProvider() {
        return Stream.of(
                Arguments.of(true, 0.0),
                Arguments.of(false, 1.1),
                Arguments.of(true, 23.1234),
                Arguments.of(false, 48901.424)
        );
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void treeConstructorInitializesAttributesCorrectly(boolean b, double d) throws Throwable {
        Object[][] arguments = {
                {b, boolean.class},
                {d, double.class}
        };
        Object instance = classInstance.createInstance(arguments);
        String incorrectAttributeValue =
                "Your %s constructor does not correctly initialize the %s attribute based on the passed parameters.";
        _assertEquals(b, classInstance.getFieldValue(instance, booleanAttributeName1),
                String.format(incorrectAttributeValue, objectClassName, booleanAttributeName1));
        _assertEquals(d, classInstance.getFieldValue(instance, doubleAttributeName1),
                String.format(incorrectAttributeValue, objectClassName, doubleAttributeName1));
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void treeHasCorrectGetIsRareMethod(boolean b, double d) throws Throwable {
        Object[][] arguments = {
                {b, boolean.class},
                {d, double.class}
        };
        Object instance = classInstance.createInstance(arguments);
        String incorrectGetMethods = "Your %s method does not return the value of the %s attribute.";

        Object output = classInstance.callMethod(getBooleanAttributeName1, new String[]{"public"}, instance);
        _assertEquals(b, output, String.format(incorrectGetMethods, getBooleanAttributeName1, booleanAttributeName1));
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void treeHasCorrectGetHeightMethod(boolean b, double d) throws Throwable {
        Object[][] arguments = {
                {b, boolean.class},
                {d, double.class}
        };
        Object instance = classInstance.createInstance(arguments);
        String incorrectGetMethods = "Your %s method does not return the value of the %s attribute.";

        Object output = classInstance.callMethod(getDoubleAttributeName1, new String[]{"public"}, instance);
        _assertEquals(d, output, String.format(incorrectGetMethods, getDoubleAttributeName1, doubleAttributeName1));
    }

    private static Stream<Arguments> setMethodsInputProvider() {
        return Stream.of(
                Arguments.of(true, 40.4, true, 41.4),
                Arguments.of(true, 15.7, false, 8.1),
                Arguments.of(false, 327189.95, true, 57839.372),
                Arguments.of(false, 0, false, 950.3)
        );
    }

    @ParameterizedTest
    @MethodSource("setMethodsInputProvider")
    public void treeHasCorrectSetIsRareMethod(boolean b, double d, boolean newB, double newD) throws Throwable {
        Object[][] arguments = {
                {b, boolean.class},
                {d, double.class}
        };
        Object instance = classInstance.createInstance(arguments);
        classInstance.callMethod(setBooleanAttributeName1, new Object[][]{{newB, boolean.class}}, instance);

        String incorrectSetMethods = "Your %s method does not update the %s attribute to the passed parameter.";

        _assertEquals(newB, classInstance.getFieldValue(instance, booleanAttributeName1),
                String.format(incorrectSetMethods, setBooleanAttributeName1, booleanAttributeName1));

        assertTrue(classInstance.hasReturnType(setBooleanAttributeName1, new Class[]{boolean.class}, void.class));
    }

    @ParameterizedTest
    @MethodSource("setMethodsInputProvider")
    public void treeHasCorrectSetHeightMethod(boolean b, double d, boolean newB, double newD) throws Throwable {
        Object[][] arguments = {
                {b, boolean.class},
                {d, double.class}
        };
        Object instance = classInstance.createInstance(arguments);
        classInstance.callMethod(setDoubleAttributeName1, new Object[][]{{newD, double.class}}, instance);

        String incorrectSetMethods = "Your %s method does not update the %s attribute to the passed parameter.";

        _assertEquals(newD, classInstance.getFieldValue(instance, doubleAttributeName1),
                String.format(incorrectSetMethods, setDoubleAttributeName1, doubleAttributeName1));

        assertTrue(classInstance.hasReturnType(setDoubleAttributeName1, new Class[]{double.class}, void.class));
    }

    @ParameterizedTest
    @MethodSource("constructorInputProvider")
    public void treeClassHasCorrectToStringMethod(boolean b, double d) throws Throwable {
        Object[][] arguments = {
                {b, boolean.class},
                {d, double.class}
        };
        Object instance = classInstance.createInstance(arguments);
        String expectedOutput = "This tree’s rarity is " + b + ", and is " + d + "m tall";
        Object output = classInstance.callMethod("toString", new String[]{"public"}, instance);
        String incorrectToString = String.format("Your toString method for the %s class does return the correct String.", objectClassName);
        _assertEquals(expectedOutput, output, incorrectToString);
    }

    @ParameterizedTest
    @MethodSource("setMethodsInputProvider")
    public void treeMethodsWorkCorrectlyWorkTogether(boolean b, double d, boolean newB, double newD) throws Throwable {
        Object[][] constructorArguments = {
                {b, boolean.class},
                {d, double.class}
        };
        Object instance = classInstance.createInstance(constructorArguments);
        classInstance.callMethod(setBooleanAttributeName1, new Object[][]{{newB, boolean.class}}, instance);
        classInstance.callMethod(setDoubleAttributeName1, new Object[][]{{newD, double.class}}, instance);
        Object output1 = classInstance.callMethod(getBooleanAttributeName1, instance);
        Object output2 = classInstance.callMethod(getDoubleAttributeName1, instance);
        Object toStringOutput = classInstance.callMethod("toString", instance);
        String expectedToStringOutput = "This tree’s rarity is " + newB + ", and is " + newD + "m tall";
        String incorrectSetGet =
                "Your %s method does not return the correct value after updating the %s attribute using the %s method.";
        String incorrectToString = "Your toString method does not return the correct String after updating the %s and %s attributes using the %s and %s methods.";
        _assertEquals(newB, output1,
                String.format(incorrectSetGet, getBooleanAttributeName1, booleanAttributeName1, setBooleanAttributeName1));
        _assertEquals(newD, output2,
                String.format(incorrectSetGet, getDoubleAttributeName1, doubleAttributeName1, setDoubleAttributeName1));
        _assertEquals(expectedToStringOutput, toStringOutput,
                String.format(incorrectToString, booleanAttributeName1, doubleAttributeName1, setBooleanAttributeName1,
                        setDoubleAttributeName1));
    }

    @Test
    public void testFoliageMainMethodProducesCorrectOutput() throws Throwable {
        Object[][] arguments = {{new String[0], String[].class}};
        Clause[] clauses = new Clause[]{
                new StringLiteral("This tree’s rarity is " + testBooleanAttributeName1 + ", and is " +
                        testDoubleAttributeName1 + "m tall"),
                new NewLine(),
                new StringLiteral("This tree’s rarity is " + testBooleanAttributeName2 + ", and is " +
                        testDoubleAttributeName2 + "m tall"),
                new NewLine(),
                new StringLiteral("This tree’s rarity is " + testBooleanAttributeName1 + ", and is " +
                        testDoubleAttributeNameUpdate + "m tall"),
                new NewLine(),
                new StringLiteral("This tree’s rarity is " + testBooleanAttributeName2 + ", and is " +
                        testDoubleAttributeName2 + "m tall"),
        };
        String incorrectOutput =
                String.format("Your %s class main method does not correctly initialize, update, and print the values of the two %s objects.",
                        testClassName, objectClassName);
        testInstance.callMethod("main", arguments, clauses, incorrectOutput);
    }
}
