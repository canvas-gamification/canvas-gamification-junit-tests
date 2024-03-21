package oop.static_modifier.hard.q2;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static global.tools.CustomAssertions._assertEquals;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class MainTest {
    // Java

    private final String className = "Lightbulb";
    private final String staticAttributeName = "voltage";
    private final String attributeName = "type";
    private final String setAttributeName = "setVoltage";
    private final String testClassName = "Test";
    private final int initialStaticVariable = 100;

    private ObjectTest testClass;
    private ObjectTest classObject;

    @BeforeEach
    public void setUp() {
        String packageString = "oop.static_modifier.hard.q2." + className;
        testClass = new ObjectTest(packageString);
        String testClassString = "oop.static_modifier.hard.q2." + testClassName;
        classObject = new ObjectTest(testClassString);
    }

    @Test
    @Order(1)
    public void lightbulbHasRequiredAttributes() {
        String missingAttributeMessage = "The %s class is missing the %s attribute. Make sure that the class contains the attribute and it is spelt correctly.";
        String wrongTypeMessage = "The %s attribute in the %s class has the wrong type.";
        String wrongModifierMessage = "The %s attribute in the %s class has the wrong visibility modifier.";
        String wrongStaticModifierMessage = "The %s attribute in the %s class has the wrong modifier.";
        assertTrue(testClass.hasField(attributeName), String.format(missingAttributeMessage, className, attributeName));
        assertTrue(testClass.hasField(attributeName, String.class), String.format(wrongTypeMessage, attributeName, className));
        assertTrue(testClass.hasModifier(attributeName, "private"), String.format(wrongModifierMessage, attributeName, className));
        assertTrue(testClass.hasField(staticAttributeName), String.format(missingAttributeMessage, className, staticAttributeName));
        assertTrue(testClass.hasField(staticAttributeName, int.class), String.format(wrongTypeMessage, staticAttributeName, className));
        assertTrue(testClass.hasModifier(staticAttributeName, "private"), String.format(wrongModifierMessage, staticAttributeName, className));
        assertTrue(testClass.hasModifier(staticAttributeName, "static"), String.format(wrongStaticModifierMessage, staticAttributeName, className));
    }

    @Test
    @Order(2)
    public void lightbulbHasRequiredConstructor() {
        String missingConstructorMessage = "The %s class is missing a required constructor. Make sure that it is named correctly and has the correct parameters.";
        String wrongAccessModifier = "The %s class constructor has the wrong visibility modifier. Make sure that it is visible from all other classes.";
        Class<?>[] constructorArgs = new Class[]{String.class};
        assertTrue(testClass.hasConstructor(constructorArgs), String.format(missingConstructorMessage, className));
        assertTrue(testClass.hasModifier(constructorArgs, "public"), String.format(wrongAccessModifier, className));
    }

    private static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of("Incandescent", 100),
                Arguments.of("Halogen", 200),
                Arguments.of("Compact Fluorescent Lamp (CFL)", 110),
                Arguments.of("LED", 20),
                Arguments.of("Tungsten Filament", 130),
                Arguments.of("High-Intensity Discharge (HID)", 40),
                Arguments.of("Carbon Filament", 20),
                Arguments.of("Carbon Filament", 0),
                Arguments.of("Fluorescent", 300),
                Arguments.of("Full Spectrum", 70),
                Arguments.of("Edison Bulb", 40)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    @Order(3)
    public void lightbulbConstructorInitializesValuesCorrectly(String value1) throws Throwable {
        String missingConstructorMessage = "The %s class is missing a required constructor. Make sure that it is named correctly and has the correct parameters.";
        String wrongAccessModifier = "The %s class constructor has the wrong visibility modifier. Make sure that it is visible from all other classes.";
        Class<?>[] constructorArgsDef = new Class[]{String.class};
        assertTrue(testClass.hasConstructor(constructorArgsDef), String.format(missingConstructorMessage, className));
        assertTrue(testClass.hasModifier(constructorArgsDef, "public"), String.format(wrongAccessModifier, className));
        String wrongValueMessage = "The %s constructor did not initialize the %s attribute to the correct value based on the parameters passed to the constructor.";
        Object[][] constructorArgs = {
                {value1, String.class}
        };
        Object checkupInstance = testClass.createInstance(constructorArgs);
        _assertEquals(value1, testClass.getFieldValue(checkupInstance, attributeName), String.format(wrongValueMessage, className, attributeName));
        _assertEquals(initialStaticVariable, testClass.getFieldValue(checkupInstance, staticAttributeName), String.format(wrongValueMessage, className, setAttributeName));
    }

    private static Stream<Arguments> setInputProvider() {
        return Stream.of(
                Arguments.of(100),
                Arguments.of(200),
                Arguments.of(110),
                Arguments.of(20),
                Arguments.of(130),
                Arguments.of(40),
                Arguments.of(20),
                Arguments.of(0),
                Arguments.of(300),
                Arguments.of(70),
                Arguments.of(40)
        );
    }

    @ParameterizedTest
    @MethodSource("setInputProvider")
    @Order(4)
    public void lightbulbClassHasCorrectSetVoltageMethod(int value2) throws Throwable {
        String missingMethodMessage = "The %s class is missing the %s method. Make sure that the class contains the method and it is spelt correctly with the correct arguments as parameters.";
        String wrongTypeMessage = "The %s method in the %s class has the wrong return type.";
        String wrongModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectSetMethodMessage = String.join(" ",
                "Your", setAttributeName, "does not correctly set the value of the", staticAttributeName, "attribute.");
        assertTrue(testClass.hasMethod(setAttributeName, new Class<?>[]{int.class}),
                String.format(missingMethodMessage, className, setAttributeName));
        assertTrue(testClass.hasMethod(setAttributeName, new Class<?>[]{int.class}, Void.TYPE),
                String.format(wrongTypeMessage, setAttributeName, className));
        assertTrue(testClass.hasMethod(setAttributeName, new Class<?>[]{int.class}, Void.TYPE, new String[]{"public"}),
                String.format(wrongModifierMessage, setAttributeName, className));
        Object[][] arguments = {
                {"value1", String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        Object[][] setSizeArguments = {
                {value2, int.class}
        };
        String[] setMethodModifiers = {"public"};
        testClass.callMethod(setAttributeName, setSizeArguments, setMethodModifiers, classInstance);
        _assertEquals(value2, testClass.getFieldValue(null, staticAttributeName), incorrectSetMethodMessage);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    @Tag("dependency1")
    @Order(5)
    public void lightbulbClassHasCorrectToStringMethod(String value1, int value2) throws Throwable {
        String missingMethodMessage = "The %s class is missing the %s method. Make sure that the class contains the method and it is spelt correctly with the correct arguments as parameters.";
        String wrongTypeMessage = "The %s method in the %s class has the wrong return type.";
        String wrongModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        assertTrue(testClass.hasMethod("toString", null),
                String.format(missingMethodMessage, className, "toString"));
        assertTrue(testClass.hasMethod("toString", null, String.class),
                String.format(wrongTypeMessage, "toString", className));
        assertTrue(testClass.hasMethod("toString", null, String.class, new String[]{"public"}),
                String.format(wrongModifierMessage, "toString", className));
        Object[][] arguments = {
                {value1, String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        testClass.setFieldValue(null, value2, staticAttributeName);
        String[] methodModifiers = {"public"};
        String expected = "This lightbulb is a " + value1 + " light with " + value2 + " voltage.";
        String incorrectToStringMessage = String.join(" ",
                "Your", className, "toString method does not return the correct String.");
        Object output = testClass.callMethod("toString", methodModifiers, classInstance);
        _assertEquals(expected, output, incorrectToStringMessage);
    }

    @Test
    @Tag("dependent1")
    @Order(6)
    public void correctTestClass() throws Throwable {
        Clause[] clauses = {
                new StringLiteral("This lightbulb is a LED light with 150 voltage."),
                new NewLine(),
                new StringLiteral("This lightbulb is a LCD light with 200 voltage."),
                new NewLine(),
                new StringLiteral("This lightbulb is a Halogen light with 300 voltage."),
                new NewLine(),
        };
        Object classInstance = classObject.createInstance();
        classObject.callMethod("main", new Object[][]{{new String[0], String[].class}}, new String[]{"public"}, classInstance,
                clauses, "Your " + testClassName + " class main method does not print the correct output.");
    }
}
