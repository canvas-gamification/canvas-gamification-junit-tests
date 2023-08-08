package oop.special_class_method.medium.q14;

import global.ObjectTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    // Java

    private final String className = "Water";
    private final String attributeName1 = "quality";
    private final String attributeName2 = "volume";
    private final String getAttributeMethodName2 = "getVolume";
    private final String setAttributeMethodName2 = "setVolume";
    private final String initialValue1 = "Good";
    private final double initialValue2 = 1000.0;
    private ObjectTest testClass;

    @BeforeEach
    public void setUp() throws Throwable {
        String classString = "oop.special_class_method.medium.q14." + className;
        this.testClass = new ObjectTest(classString);
        String modifiedClassMessage =
                "You have modified the provided portions of class " + className + " for %s attribute. Please revert them to the original state.";
        assertTrue(testClass.hasField(attributeName1, String.class, new String[]{"private"}),
                String.format(modifiedClassMessage, attributeName1));
        assertTrue(testClass.hasField(attributeName2, double.class, new String[]{"private"}),
                String.format(modifiedClassMessage, attributeName2));

        Class<?>[] classes = {};
        Object testInstance = testClass.createInstance();
        _assertEquals(initialValue1, testClass.getFieldValue(testInstance, attributeName1),
                "You have modified the provided portions of class " + className + " constructor. Please revert them to the original state.");
        _assertEquals(initialValue2, testClass.getFieldValue(testInstance, attributeName2),
                "You have modified the provided portions of class " + className + " constructor. Please revert them to the original state.");
        assertTrue(testClass.hasModifier(classes, "public"),
                "You have modified the provided portions of class " + className + " constructor. Please revert them to the original state.");

    }

    @RepeatedTest(10)
    public void correctGetVolumeMethod() throws Throwable {
        Object testInstance = testClass.createInstance();
        double value = Math.random() * 10000;
        testClass.setFieldValue(testInstance, value, attributeName2);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName2, testInstance);
        assertTrue(testClass.hasModifier(getAttributeMethodName2, null, "public"),
                "Your " + getAttributeMethodName2 + " method does not have the correct visibility modifier.");
        _assertEquals(value, getMethodOutput,
                "Your " + getAttributeMethodName2 + " method does not return the value of the " + attributeName2 + " attribute.");
    }

    @RepeatedTest(10)
    public void correctSetSizeMethod() throws Throwable {
        Object testInstance = testClass.createInstance();
        double updatedValue = Math.random() * 10000;
        Object[][] setMethodArguments = {
                {updatedValue, double.class}
        };
        Class<?>[] methodModifierClasses = {
                double.class
        };
        assertTrue(testClass.hasMethod(setAttributeMethodName2, methodModifierClasses, Void.TYPE),
                "Your " + setAttributeMethodName2 + " method does not have the correct name, return type, or parameters.");
        assertTrue(testClass.hasModifier(setAttributeMethodName2, methodModifierClasses, "public"),
                "Your " + setAttributeMethodName2 + " method does not have the correct visibility modifier.");
        testClass.callMethod(setAttributeMethodName2, setMethodArguments, testInstance);
        String incorrectSetterMessage =
                "Your " + setAttributeMethodName2 + " method does not correctly update the value of " + attributeName2 + ".";
        _assertEquals(updatedValue, testClass.getFieldValue(testInstance, attributeName2),
                incorrectSetterMessage);
    }

    @RepeatedTest(10)
    public void methodsWorkingTogether() throws Throwable {
        double value = Math.random() * 10000;
        Object testInstance = testClass.createInstance();
        Object[][] setMethodArguments = {
                {value, double.class}
        };
        testClass.callMethod(setAttributeMethodName2, setMethodArguments, testInstance);
        _assertEquals(value, testClass.callMethod(getAttributeMethodName2, testInstance),
                "Your " + getAttributeMethodName2 + " method does not correctly update the value of " + setAttributeMethodName2 + " after using the " + getAttributeMethodName2 + " method.");
    }
}
