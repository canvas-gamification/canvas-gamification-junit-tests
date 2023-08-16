package oop.user_defined_classes.medium.q2;

import global.ObjectTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    // Java
    private final String className = "Car";
    private final String varColour = "colour";
    private final String varPower = "horsePower";
    private final String varYear = "yearMade";
    private final String methodName = "improve";

    private ObjectTest classInstance;

    @BeforeEach
    public void setUp() throws Throwable {
        String classString = "oop.user_defined_classes.medium.q2." + className;
        classInstance = new ObjectTest(classString);
        String modifiedClassMessage =
                "You have modified the provided portions of class " + className + ". Please revert them to the original state.";
        Object[][] test = new Object[][]{
                {"Red", 300, 2003},
                {"Blue", 200, 2014},
                {"Black", 100, 1986},
                {"Yellow", 250, 2001}
        };
        for (int num = 0; num < test.length; num++) {
            String colour = (String) test[num][0];
            int horsePower = (int) test[num][1];
            int yearMade = (int) test[num][1];
            Object[][] arguments = {
                    {colour, String.class},
                    {horsePower, int.class},
                    {yearMade, int.class}
            };
            Object instance = classInstance.createInstance(arguments);
            _assertEquals(horsePower, classInstance.getFieldValue(instance, varPower), modifiedClassMessage);
            _assertEquals(yearMade, classInstance.getFieldValue(instance, varYear), modifiedClassMessage);
            _assertEquals(colour, classInstance.getFieldValue(instance, varColour), modifiedClassMessage);
        }
    }
    @Test
    public void classHasRequiredFields() {
        assertTrue(classInstance.hasField(varColour),
                "Your " + className + " class is missing the " + varColour + " attribute, or it is spelled incorrectly.");
        assertTrue(classInstance.hasField(varColour, String.class),
                "Your " + varColour + " attribute does not have the correct return type.");
        assertTrue(classInstance.hasModifier(varColour, "private"),
                "Your " + varColour + " attribute does not have the correct visibility modifier.");
        assertTrue(classInstance.hasField(varPower),
                "Your " + className + " class is missing the " + varPower + " attribute, or it is spelled incorrectly.");
        assertTrue(classInstance.hasField(varPower, int.class),
                "Your " + varPower + " attribute does not have the correct return type.");
        assertTrue(classInstance.hasModifier(varPower, "private"),
                "Your " + varPower + " attribute does not have the correct visibility modifier.");
        assertTrue(classInstance.hasField(varYear),
                "Your " + className + " class is missing the " + varYear+ " attribute, or it is spelled incorrectly..");
        assertTrue(classInstance.hasField(varYear, int.class),
                "Your " + varYear + " attribute does not have the correct return type.");
        assertTrue(classInstance.hasModifier(varYear, "private"),
                "Your " + varYear + " attribute does not have the correct visibility modifier.");
    }
    private static Stream<Arguments> methodInputProvider() {
        return Stream.of(
                Arguments.of("Red", 300, 2003),
                Arguments.of("Blue", 200, 2014),
                Arguments.of("Black", 100, 1986),
                Arguments.of("White", 250, 2001),
                Arguments.of("Yellow", 0, 1),
                Arguments.of("Purple", 0, 0),
                Arguments.of("Green", 1, 1)
        );
    }

    @Test
    public void improveIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(classInstance.hasMethod(methodName, null), String.format(incorrectMethodDefinition, methodName, className));
        assertTrue(classInstance.hasModifier(methodName, null, "public"), String.format(incorrectModifierMessage, methodName, className));
        assertTrue(classInstance.hasReturnType(methodName, null, Void.TYPE), String.format(incorrectReturnType, methodName, className));
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    public void correctImproveMethod(String colour, int horsePower, int yearMade) throws Throwable {
        Object[][] arguments = {
                {colour, String.class},
                {horsePower, int.class},
                {yearMade, int.class}
        };
        Object instance = classInstance.createInstance(arguments);
        Object output = classInstance.callMethod(methodName, instance);
        _assertEquals(horsePower * 2, classInstance.getFieldValue(instance, varPower),
                "Your " + className + " improve method does not doubles the " + varPower + ".");
    }

}

