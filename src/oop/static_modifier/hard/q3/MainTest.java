package oop.static_modifier.hard.q3;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
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
    // Java

    private final String className = "CandyStore";
    private final String staticAttributeName = "gummies";
    private final String attributeName = "name";
    private final String methodName = "award";
    private final String testClassName = "Test";
    private final static int initialGummies = 100;
    private final String printString = "There are %s more to give away after the %s award.";

    private ObjectTest testClass;
    private ObjectTest classObject;

    @BeforeEach
    public void setUp() {
        String packageString = "oop.static_modifier.hard.q3." + className;
        testClass = new ObjectTest(packageString);
        String testClassString = "oop.static_modifier.hard.q3." + testClassName;
        classObject = new ObjectTest(testClassString);
    }

    @Test
    @Order(1)
    public void candyStoreHasRequiredAttributes() {
        String missingAttributeMessage = "The %s class is missing the %s attribute. Make sure that the class contains the attribute and it is spelt correctly.";
        String wrongTypeMessage = "The %s attribute in the %s class has the wrong type.";
        String wrongModifierMessage = "The %s attribute in the %s class has the wrong visibility modifier.";
        assertTrue(testClass.hasField(attributeName), String.format(missingAttributeMessage, className, attributeName));
        assertTrue(testClass.hasField(attributeName, String.class), String.format(wrongTypeMessage, attributeName, className));
        assertTrue(testClass.hasModifier(attributeName, "private"), String.format(wrongModifierMessage, attributeName, className));
        assertTrue(testClass.hasField(staticAttributeName), String.format(missingAttributeMessage, className, staticAttributeName));
        assertTrue(testClass.hasField(staticAttributeName, int.class), String.format(wrongTypeMessage, staticAttributeName, className));
        assertTrue(testClass.hasModifier(staticAttributeName, "private"), String.format(wrongModifierMessage, staticAttributeName, className));
        assertTrue(testClass.hasModifier(staticAttributeName, "static"), String.format(wrongModifierMessage, staticAttributeName, className));
        _assertEquals(initialGummies, testClass.getFieldValue(null, staticAttributeName),
                "Your " + staticAttributeName + " static attribute is not initialized correctly.");
    }

    @Test
    @Order(2)
    public void candyStoreHasRequiredConstructor() {
        String missingConstructorMessage = "The %s class is missing a required constructor. Make sure that it is named correctly and has the correct parameters.";
        String wrongAccessModifier = "The %s class constructor has the wrong visibility modifier. Make sure that it is visible from all other classes.";
        Class<?>[] constructorArgs = new Class[]{String.class};
        assertTrue(testClass.hasConstructor(constructorArgs), String.format(missingConstructorMessage, className));
        assertTrue(testClass.hasModifier(constructorArgs, "public"), String.format(wrongAccessModifier, className));
    }

    private static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of("CandyLand", initialGummies - 30),
                Arguments.of("GummyGrove", initialGummies - 50),
                Arguments.of("SugarShack", initialGummies / 2),
                Arguments.of("SweetSpot", initialGummies - 75),
                Arguments.of("TreatTown", initialGummies / 3),
                Arguments.of("BonbonBoulevard", initialGummies - 60),
                Arguments.of("Lollipop Lane", initialGummies / 4),
                Arguments.of("Jellybean Junction", initialGummies - 15),
                Arguments.of("Confectionery Corner", initialGummies / 5),
                Arguments.of("Dulce Drive", initialGummies - 90),
                Arguments.of("97", initialGummies + 15),
                Arguments.of("Sweet Treats", initialGummies)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    @Tag("dependency1")
    @Order(3)
    public void candyStoreConstructorInitializesValuesCorrectly(String value1) throws Throwable {
        String missingConstructorMessage = "The %s class is missing a required constructor. Make sure that it is named correctly and has the correct parameters.";
        String wrongAccessModifier = "The %s class constructor has the wrong visibility modifier. Make sure that it is visible from all other classes.";
        Class<?>[] constructorArgs2 = new Class[]{String.class};
        assertTrue(testClass.hasConstructor(constructorArgs2), String.format(missingConstructorMessage, className));
        assertTrue(testClass.hasModifier(constructorArgs2, "public"), String.format(wrongAccessModifier, className));
        String wrongValueMessage = "The %s constructor did not initialize the %s attribute to the correct value based on the parameters passed to the constructor.";
        Object[][] constructorArgs = {
                {value1, String.class}
        };
        Object checkupInstance = testClass.createInstance(constructorArgs);
        _assertEquals(value1, testClass.getFieldValue(checkupInstance, attributeName), String.format(wrongValueMessage, className, attributeName));
        _assertEquals(initialGummies, testClass.getFieldValue(null, staticAttributeName),
                "Your constructor should not change the " + staticAttributeName + " static attribute.");
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    @Tag("dependency1")
    @Order(5)
    public void candyStoreClassHasCorrectAwardMethod(String value1, int value2) throws Throwable {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(methodName, new Class<?>[]{int.class}), String.format(incorrectMethodDefinition, methodName, className));
        assertTrue(testClass.hasModifier(methodName, new Class<?>[]{int.class}, "public"), String.format(incorrectModifierMessage, methodName, className));
        assertTrue(testClass.hasReturnType(methodName, new Class<?>[]{int.class}, Void.TYPE), String.format(incorrectReturnType, methodName, className));
        Object[][] constructorArgs = {
                {value1, String.class}
        };
        Object classInstance = testClass.createInstance(constructorArgs);
        int expected = initialGummies - value2;
        if(initialGummies - value2 < 0)
            expected = initialGummies;
        Clause[] testSentence = new Clause[]{
                new StringLiteral(String.format(printString, expected, value1))
        };
        Object[][] arguments = {
                {value2, int.class}
        };
        testClass.callMethod(methodName, arguments, classInstance, testSentence);
        _assertEquals(expected, testClass.getFieldValue(null, staticAttributeName),
                "Your " + methodName + " method does not correctly change the value of " + staticAttributeName);
        testClass.setFieldValue(null, initialGummies, staticAttributeName);
    }

    @Test
    @Tag("dependent1")
    @Order(6)
    public void correctTestClass() throws Throwable {
        Clause[] clauses = {
                new StringLiteral(String.format(printString, 80, "Corner Jack")),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral(String.format(printString, 70, "Best Deals in Kelowna")),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral(String.format(printString, 55, "The Apple Mall")),
                new Optional(new StringLiteral(" "))
        };
        Object classInstance = classObject.createInstance();
        classObject.callMethod("main", new Object[][]{{new String[0], String[].class}}, new String[]{"public"}, classInstance,
                clauses,
                "Your " + testClassName + " class main method does not print the correct output.");
    }
}
