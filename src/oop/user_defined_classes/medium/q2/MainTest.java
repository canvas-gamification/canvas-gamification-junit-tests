package oop.user_defined_classes.medium.q2;

import global.ObjectTest;
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
    private final String className = "Car";
    private final String varColour = "colour";
    private final String varPower = "horsePower";
    private final String varYear = "yearMade";

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
        String wrongFieldMessage = "Your " + className + " class is missing some of the required fields.";
        String wrongModifierMessage = "Your " + className + " class does not have some of the required modifiers.";
        assertTrue(classInstance.hasField(varColour, String.class), wrongFieldMessage);
        assertTrue(classInstance.hasModifier(varColour, "private"), wrongModifierMessage);
        assertTrue(classInstance.hasField(varPower, int.class), wrongFieldMessage);
        assertTrue(classInstance.hasModifier(varPower, "private"), wrongModifierMessage);
        assertTrue(classInstance.hasField(varYear, int.class), wrongFieldMessage);
        assertTrue(classInstance.hasModifier(varPower, "private"), wrongModifierMessage);
    }
    private static Stream<Arguments> methodInputProvider() {
        return Stream.of(
                Arguments.of("Red", 300, 2003),
                Arguments.of("Blue", 200, 2014),
                Arguments.of("Black", 100, 1986),
                Arguments.of("Yellow", 250, 2001)
        );
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    public void correctVegetableEatingMethod(String colour, int horsePower, int yearMade) throws Throwable {
        Object[][] arguments = {
                {colour, String.class},
                {horsePower, int.class},
                {yearMade, int.class}
        };
        Object instance = classInstance.createInstance(arguments);
        classInstance.callMethod("improve", instance);
        _assertEquals(horsePower * 2, classInstance.getFieldValue(instance, varPower),
                "Your " + className + " improve method does not doubles the " + varPower + ".");
    }

}

