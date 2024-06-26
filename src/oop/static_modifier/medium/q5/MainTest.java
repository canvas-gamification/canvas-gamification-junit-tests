package oop.static_modifier.medium.q5;

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

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class MainTest {
    // Java

    ObjectTest testClass;
    ObjectTest outputClass;
    String className = "Hat";
    String staticAttributeName = "companyName";
    String attributeName = "colour";
    String initialName = "Nike";
    String initialColour = "Green";
    String testClassName = "Test";
    String toStringFormat = "This is a %s Hat that is %s in colour";

    @BeforeEach
    public void setup() throws Throwable {
        String classString = "oop.static_modifier.medium.q5." + className;
        testClass = new ObjectTest(classString);
        String outputClassString = "oop.static_modifier.medium.q5." + testClassName;
        outputClass = new ObjectTest(outputClassString);
        String modificationErrorMessage = "You have modified the provided portions of " + className + " class for %s attribute. Please revert them to the original state.";
        assertTrue(testClass.hasField(attributeName, String.class),
                String.format(modificationErrorMessage, attributeName));
        assertTrue(testClass.hasModifier(attributeName, "private"),
                String.format(modificationErrorMessage, attributeName));
        String[] test = new String[]{"Black", "Blue", "Red", "Brown"};
        for (int i = 0; i < test.length; i++) {
            Object[][] arguments = {
                    {test[i], String.class}
            };
            Object classInstance = testClass.createInstance(arguments);
            _assertEquals(test[i], testClass.getFieldValue(classInstance, attributeName),
                    String.format(modificationErrorMessage, attributeName));
        }
    }

    @Test
    @Tag("dependency1")
    @Order(2)
    public void correctTestClass() throws Throwable {
        Object classInstance = outputClass.createInstance();
        String[] methodModifiers = {"public"};
        Object[][] arguments = {
                {new String[0], String[].class}
        };
        outputClass.callMethod("main", arguments, methodModifiers, classInstance, new Clause[]{
                new StringLiteral("This is a " + initialName + " Hat that is " + initialColour + " in colour"),
                new Optional(new StringLiteral(" ")),
                new Optional(new NewLine())
        }, "Your " + testClassName + " class does not print the correct output.");
    }

    @Test
    @Order(1)
    public void hatClassHasCorrectAttributes() {
        String incorrectNameError = "Your %s class does not include the %s attribute.";
        String incorrectVisibilityError = "Your %s attribute does not have the correct visibility modifier.";
        String incorrectStaticError = "Your %s attribute does not have the static modifier.";
        String incorrectStaticInitialization = "Your %s attribute does not have the correct value";
        assertTrue(testClass.hasField(staticAttributeName, String.class),
                String.format(incorrectNameError, className, staticAttributeName));
        assertTrue(testClass.hasModifier(staticAttributeName, "private"),
                String.format(incorrectVisibilityError, staticAttributeName));
        assertTrue(testClass.hasModifier(staticAttributeName, "static"),
                String.format(incorrectStaticError, staticAttributeName));

        assertEquals(initialName, testClass.getFieldValue(null, staticAttributeName),
                String.format(incorrectStaticInitialization, staticAttributeName));
    }

    private static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of("Black", "Nike"),
                Arguments.of("", " "),
                Arguments.of("", ""),
                Arguments.of("Blue", "Adidas"),
                Arguments.of("Red", "Roots"),
                Arguments.of("Brown", "Gap")
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    @Tag("dependent1")
    @Order(3)
    public void correctToStringMethod(String colour, String compName) throws Throwable {
        Object[][] arguments = {
                {colour, String.class}
        };
        testClass.setFieldValue(null, compName, staticAttributeName);
        Object classInstance = testClass.createInstance(arguments);
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod("toString", null), String.format(incorrectMethodDefinition, "toString", className));
        assertTrue(testClass.hasModifier("toString", null, "public"), String.format(incorrectModifierMessage, "toString", className));
        assertTrue(testClass.hasReturnType("toString", null, String.class), String.format(incorrectReturnType, "toString", className));
        String[] methodModifiers = {"public"};
        String expected = String.format(toStringFormat, compName, colour);
        String incorrectToStringMessage = String.join(" ",
                "Your", className, "toString method does not return the correct String.");
        Object output = testClass.callMethod("toString", methodModifiers, classInstance);
        _assertEquals(expected, output, incorrectToStringMessage);
    }
}
