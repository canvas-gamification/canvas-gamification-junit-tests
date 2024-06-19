package oop.static_modifier.hard.q7;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MainTest {
    // Java

    private final String className = "Taxes";
    private final String testName = "RoadTrip";
    private final String staticAttributeName1 = "GST";
    private final String staticAttributeName2 = "PST";
    private final String method1 = "changeLocation";
    private final String method2 = "calculateTotal";
    private final int initialAttribute1 = 5;
    private final double initialAttribute2 = 7;

    private ObjectTest testClass;
    private ObjectTest classObject;

    @BeforeEach
    public void setUp() {
        String packageString = "oop.static_modifier.hard.q7." + className;
        testClass = new ObjectTest(packageString);
        String testClassString = "oop.static_modifier.hard.q7." + testName;
        classObject = new ObjectTest(testClassString);
    }

    @Test
    @Order(1)
    public void taxesHasRequiredAttributes() {
        String missingAttributeMessage = "The %s class is missing the %s attribute. Make sure that the class contains the attribute and it is spelt correctly.";
        String wrongTypeMessage = "The %s attribute in the %s class has the wrong type.";
        String wrongModifierMessage = "The %s attribute in the %s class has the wrong visibility modifier.";
        String wrongStaticModifierMessage = "The %s attribute in the %s class has the wrong modifier.";
        String wrongStaticValueMessage = "The %s attribute is not set to the correct initial value.";
        assertTrue(testClass.hasField(staticAttributeName1), String.format(missingAttributeMessage, className, staticAttributeName1));
        assertTrue(testClass.hasField(staticAttributeName1, int.class), String.format(wrongTypeMessage, staticAttributeName1, className));
        assertTrue(testClass.hasModifier(staticAttributeName1, "private"), String.format(wrongModifierMessage, staticAttributeName1, className));
        assertTrue(testClass.hasModifier(staticAttributeName1, "static"), String.format(wrongStaticModifierMessage, staticAttributeName1, className));
        assertEquals(initialAttribute1, testClass.getFieldValue(null, staticAttributeName1), String.format(wrongStaticValueMessage, staticAttributeName1));

        assertTrue(testClass.hasField(staticAttributeName2), String.format(missingAttributeMessage, className, staticAttributeName2));
        assertTrue(testClass.hasField(staticAttributeName2, double.class), String.format(wrongTypeMessage, staticAttributeName2, className));
        assertTrue(testClass.hasModifier(staticAttributeName2, "private"), String.format(wrongModifierMessage, staticAttributeName2, className));
        assertTrue(testClass.hasModifier(staticAttributeName2, "static"), String.format(wrongStaticModifierMessage, staticAttributeName2, className));
        assertEquals(initialAttribute2, testClass.getFieldValue(null, staticAttributeName2), String.format(wrongStaticValueMessage, staticAttributeName2));
    }

    private static Stream<Arguments> provincesInputProvider() {
        return Stream.of(
                Arguments.of("Alberta", 5, 0, 27.43, 28.8015),
                Arguments.of("British Columbia", 5, 7, 8432.54, 9444.4448),
                Arguments.of("Manitoba", 5, 7, 563, 630.56),
                Arguments.of("New Brunswick", 15, 0, 841.45, 967.6675),
                Arguments.of("Newfoundland and Labrador", 15, 0, 1, 1.15),
                Arguments.of("Northwest Territories", 5, 0, 0, 0),
                Arguments.of("Nova Scotia", 15, 0, 15, 17.25),
                Arguments.of("Nunavut", 5, 0, 2, 2.1),
                Arguments.of("Ontario", 13, 0, 184627, 208628.51),
                Arguments.of("Quebec", 5, 9.975, 8437.6, 9701.1306),
                Arguments.of("Prince Edward Island", 15, 0, 5, 5.75),
                Arguments.of("Saskatchewan", 5, 6, 100, 111),
                Arguments.of("Yukon", 5, 0, 768.4, 806.82)
        );
    }

    @ParameterizedTest
    @MethodSource("provincesInputProvider")
    @Order(3)
    public void taxesClassHasCorrectChangeLocationMethod(String value1, int value2, double value3) throws Throwable {
        String missingMethodMessage = "The %s class is missing the %s method. Make sure that the class contains the method and it is spelt correctly with the correct arguments as parameters.";
        String wrongTypeMessage = "The %s method in the %s class has the wrong return type.";
        String wrongModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String wrongStaticModifierMessage = "The %s method in the %s class does not have the static modifier.";
        String incorrectSetMethodMessage = String.join(" ",
                "Your", method1, "method does not correctly set the value of the %s attribute.");
        assertTrue(testClass.hasMethod(method1, new Class<?>[]{String.class}),
                String.format(missingMethodMessage, className, method1));
        assertTrue(testClass.hasMethod(method1, new Class<?>[]{String.class}, Void.TYPE),
                String.format(wrongTypeMessage, method1, className));
        assertTrue(testClass.hasMethod(method1, new Class<?>[]{String.class}, Void.TYPE, new String[]{"public"}),
                String.format(wrongModifierMessage, method1, className));
        assertTrue(testClass.hasMethod(method1, new Class<?>[]{String.class}, Void.TYPE, new String[]{"static"}),
                String.format(wrongStaticModifierMessage, method1, className));

        Object[][] arguments = {
                {value1, String.class}
        };
        testClass.callMethod(method1, arguments, new String[]{"public", "static"});
        _assertEquals(value2, testClass.getFieldValue(null, staticAttributeName1),
                String.format(incorrectSetMethodMessage, staticAttributeName1));
        _assertEquals(value3, testClass.getFieldValue(null, staticAttributeName2),
                String.format(incorrectSetMethodMessage, staticAttributeName2));
    }

    @ParameterizedTest
    @MethodSource("provincesInputProvider")
    @Order(4)
    public void taxesClassHasCorrectCalculateTotalMethod(String value1, int value2, double value3, double input, double output) throws Throwable {
        String missingMethodMessage = "The %s class is missing the %s method. Make sure that the class contains the method and it is spelt correctly with the correct arguments as parameters.";
        String wrongTypeMessage = "The %s method in the %s class has the wrong return type.";
        String wrongModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String wrongStaticModifierMessage = "The %s method in the %s class does not have the static modifier.";
        String incorrectSetMethodMessage = String.join(" ",
                "Your", method2, "method does not return the correct total cost. Make sure that the method does not prematurely round the total cost to two digits.");

        assertTrue(testClass.hasMethod(method2, new Class<?>[]{double.class}),
                String.format(missingMethodMessage, className, method2));
        assertTrue(testClass.hasMethod(method2, new Class<?>[]{double.class}, double.class),
                String.format(wrongTypeMessage, method2, className));
        assertTrue(testClass.hasMethod(method2, new Class<?>[]{double.class}, double.class, new String[]{"public"}),
                String.format(wrongModifierMessage, method2, className));
        assertTrue(testClass.hasMethod(method2, new Class<?>[]{double.class}, double.class, new String[]{"static"}),
                String.format(wrongStaticModifierMessage, method2, className));

        testClass.setFieldValue(null, value2, staticAttributeName1);
        testClass.setFieldValue(null, value3, staticAttributeName2);

        Object[][] arguments = {
                {input, double.class}
        };
        Object methodOutput = testClass.callMethod(method2, arguments, new String[]{"public", "static"});
        _assertEquals(output, methodOutput, 0.0001, incorrectSetMethodMessage);
    }

    @ParameterizedTest
    @MethodSource("provincesInputProvider")
    @Order(5)
    public void methodsWorkTogether(String value1, int value2, double value3, double input, double output) throws Throwable {
        String missingMethodMessage = "The %s class is missing the %s method. Make sure that the class contains the method and it is spelt correctly with the correct arguments as parameters.";
        String wrongTypeMessage = "The %s method in the %s class has the wrong return type.";
        String wrongModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String wrongStaticModifierMessage = "The %s method in the %s class does not have the static modifier.";
        String incorrectSetMethodMessage = String.join(" ",
                "Your", method2, "method does not return the correct total cost after calling the " + method1 + " method.");
        assertTrue(testClass.hasMethod(method1, new Class<?>[]{String.class}),
                String.format(missingMethodMessage, className, method1));
        assertTrue(testClass.hasMethod(method1, new Class<?>[]{String.class}, Void.TYPE),
                String.format(wrongTypeMessage, method1, className));
        assertTrue(testClass.hasMethod(method1, new Class<?>[]{String.class}, Void.TYPE, new String[]{"public"}),
                String.format(wrongModifierMessage, method1, className));
        assertTrue(testClass.hasMethod(method1, new Class<?>[]{String.class}, Void.TYPE, new String[]{"static"}),
                String.format(wrongStaticModifierMessage, method1, className));
        assertTrue(testClass.hasMethod(method2, new Class<?>[]{double.class}),
                String.format(missingMethodMessage, className, method2));
        assertTrue(testClass.hasMethod(method2, new Class<?>[]{double.class}, double.class),
                String.format(wrongTypeMessage, method2, className));
        assertTrue(testClass.hasMethod(method2, new Class<?>[]{double.class}, double.class, new String[]{"public"}),
                String.format(wrongModifierMessage, method2, className));
        assertTrue(testClass.hasMethod(method2, new Class<?>[]{double.class}, double.class, new String[]{"static"}),
                String.format(wrongStaticModifierMessage, method2, className));

        Object[][] arguments = {
                {value1, String.class}
        };
        testClass.callMethod(method1, arguments, new String[]{"public", "static"});

        arguments = new Object[][]{
                {input, double.class}
        };
        Object methodOutput = testClass.callMethod(method2, arguments, new String[]{"public", "static"});
        _assertEquals(output, methodOutput, 0.0001, incorrectSetMethodMessage);
    }

    @Test
    @Order(2)
    public void correctTestClass() throws Throwable {
        Clause[] clauses = {
                new StringLiteral("Pay \\$"),
                new DoubleLiteral(93.459, 93.461),
                new StringLiteral(" for gas"),
                new NewLine(),
                new StringLiteral("Driving to Alberta"),
                new NewLine(),
                new StringLiteral("Pay \\$"),
                new DoubleLiteral(24.149, 24.151),
                new StringLiteral(" for lunch"),
                new NewLine(),
                new StringLiteral("Driving to Saskatchewan"),
                new NewLine(),
                new StringLiteral("Pay \\$"),
                new DoubleLiteral(95.459, 95.461),
                new StringLiteral(" for a motel"),
                new NewLine(),
                new StringLiteral("Pay \\$"),
                new DoubleLiteral(84.149, 84.151),
                new StringLiteral(" for gas"),
        };
        assertEquals(initialAttribute1, testClass.getFieldValue(null, staticAttributeName1),
                "Your " + className + " class does not start with the correct initial value for the " + staticAttributeName1 + "attribute.");
        assertEquals(initialAttribute2, testClass.getFieldValue(null, staticAttributeName2),
                "Your " + className + " class does not start with the correct initial value for the " + staticAttributeName2 + "attribute.");
        Object classInstance = classObject.createInstance();
        classObject.callMethod("main", new Object[][]{{new String[0], String[].class}}, new String[]{"public"}, classInstance,
                clauses, "Your " + testName + " class main method does not print the correct output.");
        assertEquals(5, testClass.getFieldValue(null, staticAttributeName1),
                "Your main method does not correctly change the value of the " + staticAttributeName1 + " attribute.");
        assertEquals(6.0, testClass.getFieldValue(null, staticAttributeName2),
                "Your main method does not correctly change the value of the " + staticAttributeName2 + " attribute.");
    }

}
