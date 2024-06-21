package oop.static_modifier.hard.q6;

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

    private final String className = "Farm";
    private final String staticAttributeName = "foodInSilo";
    private final String attributeName1 = "amountPerAnimal";
    private final String attributeName2 = "numAnimals";
    private final String methodName1 = "foodNeeded";
    private final String methodName2 = "feedAnimals";
    private final String testClassName = "TestFeeding";
    private final String printOutput1 = "Animals fed and happy";
    private final String printOutput2 = "We need to buy more food";
    private final double amount1 = 0.5;
    private final int num1 = 10;
    private final double amount2 = 0.2;
    private final int num2 = 20;
    private final double amount3 = 1.0;
    private final int num3 = 50;

    private final static double initialFeed = 50;

    private ObjectTest testClass;
    private ObjectTest classObject;

    @BeforeEach
    public void setUp() {
        String packageString = "oop.static_modifier.hard.q6." + className;
        testClass = new ObjectTest(packageString);
        String testClassString = "oop.static_modifier.hard.q6." + testClassName;
        classObject = new ObjectTest(testClassString);
    }

    @Test
    @Order(1)
    public void farmHasRequiredAttributes() {
        String missingAttributeMessage = "The %s class is missing the %s attribute. Make sure that the class contains the attribute and it is spelt correctly.";
        String wrongTypeMessage = "The %s attribute in the %s class has the wrong type.";
        String wrongModifierMessage = "The %s attribute in the %s class has the wrong visibility modifier.";
        assertTrue(testClass.hasField(attributeName1), String.format(missingAttributeMessage, className, attributeName1));
        assertTrue(testClass.hasField(attributeName1, double.class), String.format(wrongTypeMessage, attributeName1, className));
        assertTrue(testClass.hasModifier(attributeName1, "private"), String.format(wrongModifierMessage, attributeName1, className));
        assertTrue(testClass.hasField(staticAttributeName), String.format(missingAttributeMessage, className, staticAttributeName));
        assertTrue(testClass.hasField(staticAttributeName, double.class), String.format(wrongTypeMessage, staticAttributeName, className));
        assertTrue(testClass.hasModifier(staticAttributeName, "private"), String.format(wrongModifierMessage, staticAttributeName, className));
        assertTrue(testClass.hasModifier(staticAttributeName, "static"), String.format(wrongModifierMessage, staticAttributeName, className));
        assertTrue(testClass.hasField(attributeName2), String.format(missingAttributeMessage, className, attributeName2));
        assertTrue(testClass.hasField(attributeName2, int.class), String.format(wrongTypeMessage, attributeName2, className));
        assertTrue(testClass.hasModifier(attributeName2, "private"), String.format(wrongModifierMessage, attributeName2, className));
        _assertEquals(initialFeed, testClass.getFieldValue(null, staticAttributeName),
                "Your " + staticAttributeName + " static attribute is not initialized correctly.");
    }

    @Test
    @Order(2)
    public void farmHasRequiredConstructor() {
        String missingConstructorMessage = "The %s class is missing a required constructor. Make sure that it is named correctly and has the correct parameters.";
        String wrongAccessModifier = "The %s class constructor has the wrong visibility modifier. Make sure that it is visible from all other classes.";
        Class<?>[] constructorArgs = new Class[]{double.class, int.class};
        assertTrue(testClass.hasConstructor(constructorArgs), String.format(missingConstructorMessage, className));
        assertTrue(testClass.hasModifier(constructorArgs, "public"), String.format(wrongAccessModifier, className));
    }

    private static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(2.5, 3, 6.0),
                Arguments.of(1.7, 5, 10.0),
                Arguments.of(3.1, 4, 15.0),
                Arguments.of(2.3, 2, 4.0),
                Arguments.of(1.9, 6, 10.5),
                Arguments.of(2.8, 5, 12.0),
                Arguments.of(3.4, 3, 11.0),
                Arguments.of(1.6, 4, 7.5),
                Arguments.of(2.5, 7, 18.0),
                Arguments.of(3.0, 3, 9.5)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    @Tag("dependency1")
    @Order(3)
    public void farmConstructorInitializesValuesCorrectly(double value1, int value2) throws Throwable {
        String wrongValueMessage = "The %s constructor did not initialize the %s attribute to the correct value based on the parameters passed to the constructor.";
        Object[][] constructorArgs = {
                {value1, double.class},
                {value2, int.class}
        };
        Object checkupInstance = testClass.createInstance(constructorArgs);
        _assertEquals(value1, testClass.getFieldValue(checkupInstance, attributeName1), String.format(wrongValueMessage, className, attributeName1));
        _assertEquals(value2, testClass.getFieldValue(checkupInstance, attributeName2), String.format(wrongValueMessage, className, attributeName2));
        _assertEquals(initialFeed, testClass.getFieldValue(null, staticAttributeName),
                "Your " + className + " constructor should not alter the value of the " + staticAttributeName + " attribute.");
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    @Tag("dependency1")
    @Order(5)
    public void farmClassHasCorrectFeedAnimalsMethod(double value1, int value2, double value3) throws Throwable {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(methodName2, null), String.format(incorrectMethodDefinition, methodName2, className));
        assertTrue(testClass.hasModifier(methodName2, null, "public"), String.format(incorrectModifierMessage, methodName2, className));
        assertTrue(testClass.hasReturnType(methodName2, null, boolean.class), String.format(incorrectReturnType, methodName2, className));
        Object[][] constructorArgs = {
                {value1, double.class},
                {value2, int.class}
        };
        Object classInstance = testClass.createInstance(constructorArgs);
        testClass.setFieldValue(null, value3, staticAttributeName);
        Clause[] testSentence;
        if (value1 * value2 <= value3) {
            testSentence = new Clause[]{
                    new StringLiteral(printOutput1),
                    new Optional(new StringLiteral(" "))
            };
        } else {
            testSentence = new Clause[]{
                    new StringLiteral(printOutput2),
                    new Optional(new StringLiteral(" "))
            };
        }
        Object output = testClass.callMethod(methodName2, classInstance, testSentence,
                "Your " + methodName2 + " method does not print the correct output.");
        if (value1 * value2 <= value3) {
            _assertEquals(value3 - value1 * value2, testClass.getFieldValue(null, staticAttributeName),
                    "Your " + methodName2 + " method does not correctly change the value of " + staticAttributeName + " attribute.");
            _assertEquals(true, output, "Your " + methodName2 + " method does not return the correct value.");
        } else {
            _assertEquals(value3, testClass.getFieldValue(null, staticAttributeName),
                    "Your " + methodName2 + " method changes the value of " + staticAttributeName + " attribute when it should not.");
            _assertEquals(false, output, "Your " + methodName2 + " method does not return the correct value.");
        }
        testClass.setFieldValue(null, initialFeed, staticAttributeName);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    @Tag("dependency1")
    @Order(7)
    public void farmClassHasCorrectFoodNeededMethod(double value1, int value2) throws Throwable {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(methodName1, null), String.format(incorrectMethodDefinition, methodName1, className));
        assertTrue(testClass.hasModifier(methodName1, null, "public"), String.format(incorrectModifierMessage, methodName1, className));
        assertTrue(testClass.hasReturnType(methodName1, null, double.class), String.format(incorrectReturnType, methodName1, className));
        Object[][] constructorArgs = {
                {value1, double.class},
                {value2, int.class}
        };
        Object classInstance = testClass.createInstance(constructorArgs);
        Object output = testClass.callMethod(methodName1, classInstance);
        _assertEquals(value1 * value2, output,
                "Your " + methodName1 + " method does not return the correct value.");
    }

    @Test
    @Tag("dependent1")
    @Order(8)
    public void correctMainMethod() throws Throwable {
        double temp = initialFeed;
        Clause[] holdClause = new Clause[20];
        int count = 0;
        double[] amounts = {amount1*num1, amount2*num2, amount3*num3};

        for(int x = 0; x < 3; x++){
            holdClause[count++] = new StringLiteral("Try to feed animals here\\.\\.\\.");
            holdClause[count++] = new Optional(new StringLiteral(" "));
            holdClause[count++] = new NewLine();
            if(temp >= amounts[x]){
                temp -= amounts[x];
                holdClause[count++] = new StringLiteral(printOutput1);
                holdClause[count++] = new Optional(new StringLiteral(" "));
                holdClause[count++] = new NewLine();
            }
            else {
                holdClause[count++] = new StringLiteral(printOutput2);
                holdClause[count++] = new Optional(new StringLiteral(" "));
                holdClause[count++] = new NewLine();
                break;
            }
        }
        holdClause[count++] = new StringLiteral("There is no more food left today\\.");
        holdClause[count] = new Optional(new StringLiteral(" "));

        if (count + 1 != holdClause.length){
            Clause[] clause = new Clause[count + 1];
            System.arraycopy(holdClause, 0, clause, 0, count + 1);
            holdClause = clause;
        }

        _assertEquals(initialFeed, testClass.getFieldValue(null, staticAttributeName),
                "Your " + className + " class does not have the correct initial value for the " + staticAttributeName + " attribute.");
        Object classInstance = classObject.createInstance();
        classObject.callMethod("main", new Object[][]{{new String[0], String[].class}}, new String[]{"public"}, classInstance,
                holdClause,
                "Your " + testClassName + " class main method does not print the correct output");
        _assertEquals(temp, testClass.getFieldValue(null, staticAttributeName),
                "Your main method does not correctly alter the value of the " + staticAttributeName + " attribute.");
    }
}
