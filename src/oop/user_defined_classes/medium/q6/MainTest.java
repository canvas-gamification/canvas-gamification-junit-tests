package oop.user_defined_classes.medium.q6;

import global.ObjectTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

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
        for (int num = 0; num < tests.length; num++) {
            double mark = (double) tests[num][0];
            int id = (int) tests[num][1];
            Object[][] arguments = {
                    {mark, double.class},
                    {id, int.class}
            };
            Object instance = classInstance.createInstance(arguments);
            _assertEquals(mark, classInstance.getFieldValue(instance, varMark), modifiedClassMessage);
            _assertEquals(id, classInstance.getFieldValue(instance, varNum), modifiedClassMessage);
        }
    }

    @Test
    public void cupboardClassHasCorrectAttributes() {
        assertTrue(classInstance.hasField(varMark),
                "Your " + className + " class is missing the " + varMark + " attribute, or it is spelled incorrectly.");
        assertTrue(classInstance.hasField(varMark, double.class),
                "Your " + varMark + " attribute does not have the correct return type.");
        assertTrue(classInstance.hasModifier(varMark, "private"),
                "Your " + varMark + " attribute does not have the correct visibility modifier.");
        assertTrue(classInstance.hasField(varNum),
                "Your " + className + " class is missing the " + varNum + " attribute, or it is spelled incorrectly.");
        assertTrue(classInstance.hasField(varNum, int.class),
                "Your " + varMark + " attribute does not have the correct return type.");
        assertTrue(classInstance.hasModifier(varNum, "private"),
                "Your " + varMark + " attribute does not have the correct visibility modifier.");
    }
}
