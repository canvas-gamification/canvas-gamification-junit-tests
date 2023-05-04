package oop.user_defined_classes.medium.q6;

import global.ObjectTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    // Java
    private final String className = "Homework";
    private final String varMark = "marks";
    private final String varNum = "studentNumber";

    private ObjectTest classInstance;

    @BeforeEach
    public void setUp() throws Throwable {
        String classString = "oop.user_defined_classes.medium.q6." + className;
        classInstance = new ObjectTest(classString);
        String modifiedClassMessage =
                "You have modified the provided portions of class " + className + ". Please revert them to the original state.";
        Class<?>[] classArguments = {double.class, int.class};
        assertTrue(classInstance.hasConstructor(classArguments), modifiedClassMessage);
        assertTrue(classInstance.hasModifier(classArguments, "public"), modifiedClassMessage);
        Object[][] tests = new Object[][]{
                {67.5, 34443},
                {34.7, 33212},
                {95.6, 74832}
        };
        for(int num = 0; num < tests.length; num ++){
            double mark = (double)tests[num][0];
            int id = (int)tests[num][1];
            Object[][] arguments = {
                    {mark, double.class},
                    {id, int.class}
            };
            Object instance = classInstance.createInstance(arguments);
            _assertEquals(mark, classInstance.getFieldValue(instance, varMark),
                    "Your " + className + " constructor does not correctly initialize the " + varMark + " field.");
            _assertEquals(id, classInstance.getFieldValue(instance, varNum),
                    "Your " + className + " constructor does not correctly initialize the " + varNum + " field.");
        }
    }

    @Test
    public void cupboardClassHasCorrectAttributes() {
        String incorrectFieldMessage = "Your " + className + " class is missing a required field.";
        String incorrectModifierMessage = "One of your " + className + " class attributes does not have the correct modifier.";
        assertTrue(classInstance.hasField(varMark, double.class), incorrectFieldMessage);
        assertTrue(classInstance.hasModifier(varMark, "private"), incorrectModifierMessage);
        assertTrue(classInstance.hasField(varNum, int.class), incorrectFieldMessage);
        assertTrue(classInstance.hasModifier(varNum, "private"), incorrectModifierMessage);
    }
}