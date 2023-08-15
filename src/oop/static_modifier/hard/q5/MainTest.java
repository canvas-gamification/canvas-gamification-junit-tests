package oop.static_modifier.hard.q5;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static global.tools.CustomAssertions._assertEquals;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MainTest {
    private final String className = "Carpet";
    private final String staticAttributeName = "materialAreaAvailable";
    private final String attributeName = "houseArea";
    private final String methodName = "canCompleteFlooring";
    private final String testClassName = "TestCoverage";
    private final static double initialBeams = 300;

    private ObjectTest testClass;
    private ObjectTest classObject;

    @BeforeEach
    public void setUp() {
        String packageString = "oop.static_modifier.hard.q5." + className;
        testClass = new ObjectTest(packageString);
        String testClassString = "oop.static_modifier.hard.q5." + testClassName;
        classObject = new ObjectTest(testClassString);
    }

    @Test
    @Order(1)
    public void carpetHasRequiredAttributes() {
        String missingAttributeMessage = "The %s class is missing the %s attribute. Make sure that the class contains the attribute and it is spelt correctly.";
        String wrongTypeMessage = "The %s attribute in the %s class has the wrong type.";
        String wrongModifierMessage = "The %s attribute in the %s class has the wrong visibility modifier.";
        assertTrue(testClass.hasField(attributeName), String.format(missingAttributeMessage, className, attributeName));
        assertTrue(testClass.hasField(attributeName, double.class), String.format(wrongTypeMessage, attributeName, className));
        assertTrue(testClass.hasModifier(attributeName, "private"), String.format(wrongModifierMessage, attributeName, className));
        assertTrue(testClass.hasField(staticAttributeName), String.format(missingAttributeMessage, className, staticAttributeName));
        assertTrue(testClass.hasField(staticAttributeName, double.class), String.format(wrongTypeMessage, staticAttributeName, className));
        assertTrue(testClass.hasModifier(staticAttributeName, "private"), String.format(wrongModifierMessage, staticAttributeName, className));
        assertTrue(testClass.hasModifier(staticAttributeName, "static"), String.format(wrongModifierMessage, staticAttributeName, className));
    }

    @Test
    @Order(2)
    public void carpetHasRequiredConstructor() {
        String missingConstructorMessage = "The %s class is missing a required constructor. Make sure that it is named correctly and has the correct parameters.";
        String wrongAccessModifier = "The %s class constructor has the wrong visibility modifier. Make sure that it is visible from all other classes.";
        Class<?>[] constructorArgs = new Class[]{double.class};
        assertTrue(testClass.hasConstructor(constructorArgs), String.format(missingConstructorMessage, className));
        assertTrue(testClass.hasModifier(constructorArgs, "public"), String.format(wrongAccessModifier, className));
    }

    @Test
    @Order(3)
    @Tag("dependent2")
    public void staticVariableIsInitializedCorrectly() {
        _assertEquals(initialBeams, testClass.getFieldValue(null, staticAttributeName),
                "Your " + staticAttributeName + " static attribute is not initialized correctly.");
    }

    private static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(4.5, 3.2),
                Arguments.of(5.7, 6.9),
                Arguments.of(6.1, 5.8),
                Arguments.of(7.3, 2.5),
                Arguments.of(8.2, 10.6),
                Arguments.of(5.9, 4.4),
                Arguments.of(4.8, 9.1),
                Arguments.of(6.6, 1.7),
                Arguments.of(5.5, 8.3),
                Arguments.of(7.4, 0.5)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    @Tag("dependent3")
    @Order(4)
    public void carpetConstructorInitializesValuesCorrectly(double value1) throws Throwable {
        String wrongValueMessage = "The %s constructor did not initialize the %s attribute to the correct value based on the parameters passed to the constructor.";
        Object[][] constructorArgs = {
                {value1, double.class}
        };
        Object checkupInstance = testClass.createInstance(constructorArgs);
        _assertEquals(value1, testClass.getFieldValue(checkupInstance, attributeName), String.format(wrongValueMessage, className, attributeName));
    }

    @Test
    @Order(5)
    public void canCompleteFlooringIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(methodName, null), String.format(incorrectMethodDefinition, methodName, className));
        assertTrue(testClass.hasModifier(methodName, null, "public"), String.format(incorrectModifierMessage, methodName, className));
        assertTrue(testClass.hasReturnType(methodName, null, boolean.class), String.format(incorrectReturnType, methodName, className));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    @Tag("dependent1")
    @Order(6)
    public void carpetClassHasCorrectCanCompleteFlooringMethod(double value1, double value2) throws Throwable {
        Object[][] constructorArgs = {
                {value1, double.class}
        };
        Object classInstance = testClass.createInstance(constructorArgs);
        testClass.setFieldValue(null, value2, staticAttributeName);
        Object output = testClass.callMethod(methodName, classInstance);
        if (value1 <= value2) {
            _assertEquals(true, output,
                    "Your " + methodName + " method does not return the correct value.");
            _assertEquals(value2 - value1, testClass.getFieldValue(null, staticAttributeName),
                    "Your " + methodName + " method does not correctly change the value of " + staticAttributeName + " attribute.");
        } else {
            _assertEquals(false, output,
                    "Your " + methodName + " method does not return the correct value.");
            _assertEquals(value2, testClass.getFieldValue(null, staticAttributeName),
                    "Your " + methodName + " method changes the value of " + staticAttributeName + " attribute when it should not.");
        }
        testClass.setFieldValue(null, initialBeams, staticAttributeName);
    }

    @Test
    @Tag("dependent1")
    @Tag("dependent2")
    @Tag("dependent3")
    @Order(7)
    public void correctMainMethod() throws Throwable {
        Clause[] clauses = {
                new StringLiteral("There is enough material for 2 houses"),
                new Optional(new StringLiteral(" "))
        };
        Object classInstance = classObject.createInstance();
        classObject.callMethod("main", new Object[][]{{new String[0], String[].class}}, new String[]{"public"}, classInstance,
                clauses);
    }
}
