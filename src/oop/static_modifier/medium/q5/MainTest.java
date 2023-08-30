package oop.static_modifier.medium.q5;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    ObjectTest testClass;
    ObjectTest outputClass;
    String className = "Hat";
    String staticAttributeName = "companyLogo";
    String attributeName = "colour";
    String initialName = "Nike";
    String initialColour = "Green";
    String testClassName = "Test";

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
    public void correctTestClass() throws Throwable {
        Object classInstance = outputClass.createInstance();
        String[] methodModifiers = {"public"};
        Object[][] arguments = {
                {new String[0], String[].class}
        };
        outputClass.callMethod("main", arguments, methodModifiers, classInstance, new Clause[]{
                new StringLiteral("This is a " + initialName + " that is " + initialColour + " in colour"),
                new Optional(new StringLiteral(" ")),
                new Optional(new NewLine())
        });
    }

    @Test
    public void hatClassHasCorrectAttributes() {
        String incorrectNameError = "Your %s class does not include the %s attribute.";
        String incorrectVisibilityError = "Your %s attribute does not have the correct visibility modifier.";
        String incorrectStaticError = "Your %s attribute does not have the static modifier.";
        assertTrue(testClass.hasField(staticAttributeName, String.class),
                String.format(incorrectNameError, className, staticAttributeName));
        assertTrue(testClass.hasModifier(staticAttributeName, "private"),
                String.format(incorrectVisibilityError, staticAttributeName));
        assertTrue(testClass.hasModifier(staticAttributeName, "static"),
                String.format(incorrectStaticError, staticAttributeName));
    }

    private static Stream<String> inputProvider() {
        return Stream.of(
                "Black", "Blue", "Red", "Brown"
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    @Tag("dependent1")
    public void correctToStringMethod(String colour) throws Throwable {
        Object[][] arguments = {
                {colour, String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod("toString", null), String.format(incorrectMethodDefinition, "toString", className));
        assertTrue(testClass.hasModifier("toString", null, "public"), String.format(incorrectModifierMessage, "toString", className));
        assertTrue(testClass.hasReturnType("toString", null, String.class), String.format(incorrectReturnType, "toString", className));
        String[] methodModifiers = {"public"};
        String expected = "This is a " + initialName + " that is " + colour + " in colour";
        String incorrectToStringMessage = String.join(" ",
                "Your", className, "toString method does not return the correct String.");
        Object output = testClass.callMethod("toString", methodModifiers, classInstance);
        _assertEquals(expected, output, incorrectToStringMessage);
    }

    @Test
    public void correctCompanyNameValue(){
        String incorrectValueError = "In your %s class, your %s static attribute is not initialized correctly.";
        _assertEquals(initialName, testClass.getFieldValue(null, staticAttributeName),
                String.format(incorrectValueError, className, staticAttributeName));
    }
}
