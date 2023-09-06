package oop.special_class_method.medium.q8;

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

    private final String className = "Luffy";
    private final String attributeName1 = "skill";
    private final String getAttributeMethodName1 = "getSkill";
    private final String setAttributeMethodName1 = "setSkill";
    private final String attributeName2 = "bounty";
    private final String getAttributeMethodName2 = "getBounty";
    private final String setAttributeMethodName2 = "setBounty";
    private ObjectTest testClass;

    @BeforeEach
    public void setUp() throws Throwable {
        String classString = "oop.special_class_method.medium.q8." + className;
        this.testClass = new ObjectTest(classString);
        String modifiedClassMessage =
                "You have modified the provided portions of class " + className + ". Please revert them to the original state.";
        assertTrue(testClass.hasField(attributeName1, String.class), modifiedClassMessage);
        assertTrue(testClass.hasModifier(attributeName1, "private"), modifiedClassMessage);
        assertTrue(testClass.hasField(attributeName2, int.class), modifiedClassMessage);
        assertTrue(testClass.hasModifier(attributeName2, "private"), modifiedClassMessage);
        Object[][] tests = new Object[][]{
                {"Fire", 3},
                {"Ice", 1323},
                {"Battle", 213},
                {"Fly", 434343},
                {"Fight", 0}
        };
        for (int i = 0; i < tests.length; i++) {
            String skill = (String) tests[i][0];
            int bounty = (int) tests[i][1];
            Object[][] arguments = {
                    {skill, String.class},
                    {bounty, int.class}
            };
            Class<?>[] classes = {String.class, int.class};
            Object testInstance = testClass.createInstance(arguments);
            _assertEquals(skill, testClass.getFieldValue(testInstance, attributeName1), modifiedClassMessage);
            _assertEquals(bounty, testClass.getFieldValue(testInstance, attributeName2), modifiedClassMessage);
            assertTrue(testClass.hasModifier(classes, "public"), modifiedClassMessage);
        }
    }


    private static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of("Fire", 3),
                Arguments.of("Ice", 1323),
                Arguments.of("Battle", 213),
                Arguments.of("Fly", 434343),
                Arguments.of("Fight", 0)

        );
    }

    private static Stream<Arguments> updateIntegerInputProvider() {
        return Stream.of(
                Arguments.of("Fire", 3, 5),
                Arguments.of("Ice", 1323, 43),
                Arguments.of("Battle", 213, 324),
                Arguments.of("Fly", 434343, 5435445),
                Arguments.of("Fight", 0, 313)

        );
    }

    private static Stream<Arguments> updateStringInputProvider() {
        return Stream.of(
                Arguments.of("Fire", "Ice", 3),
                Arguments.of("Ice", "Cola", 1323),
                Arguments.of("Battle", "Defense", 213),
                Arguments.of("Fly", "Sail", 434343),
                Arguments.of("Fight", "Run", 0)

        );
    }

    @Test
    public void getSkillIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getAttributeMethodName1, null), String.format(incorrectMethodDefinition, getAttributeMethodName1, className));
        assertTrue(testClass.hasModifier(getAttributeMethodName1, null, "public"), String.format(incorrectModifierMessage, getAttributeMethodName1, className));
        assertTrue(testClass.hasReturnType(getAttributeMethodName1, null, String.class), String.format(incorrectReturnType, getAttributeMethodName1, className));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctGetSkillMethod(String skill, int bounty) throws Throwable {
        Object[][] arguments = {
                {skill, String.class},
                {bounty, int.class}
        };
        Object testInstance = testClass.createInstance(arguments);
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getAttributeMethodName1, null), String.format(incorrectMethodDefinition, getAttributeMethodName1, className));
        assertTrue(testClass.hasModifier(getAttributeMethodName1, null, "public"), String.format(incorrectModifierMessage, getAttributeMethodName1, className));
        assertTrue(testClass.hasReturnType(getAttributeMethodName1, null, String.class), String.format(incorrectReturnType, getAttributeMethodName1, className));

        Object getMethodOutput = testClass.callMethod(getAttributeMethodName1, testInstance);
        assertTrue(testClass.hasModifier(getAttributeMethodName1, null, "public"),
                "Your " + getAttributeMethodName1 + " method does not have the correct visibility modifier.");
        _assertEquals(skill, getMethodOutput,
                "Your " + getAttributeMethodName1 + " method does not return the value of the " + attributeName1 + " attribute.");
    }

    @Test
    public void getBountyIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getAttributeMethodName2, null), String.format(incorrectMethodDefinition, getAttributeMethodName2, className));
        assertTrue(testClass.hasModifier(getAttributeMethodName2, null, "public"), String.format(incorrectModifierMessage, getAttributeMethodName2, className));
        assertTrue(testClass.hasReturnType(getAttributeMethodName2, null, int.class), String.format(incorrectReturnType, getAttributeMethodName2, className));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctGetBountyMethod(String skill, int bounty) throws Throwable {
        Object[][] arguments = {
                {skill, String.class},
                {bounty, int.class}
        };
        Object testInstance = testClass.createInstance(arguments);
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getAttributeMethodName2, null), String.format(incorrectMethodDefinition, getAttributeMethodName2, className));
        assertTrue(testClass.hasModifier(getAttributeMethodName2, null, "public"), String.format(incorrectModifierMessage, getAttributeMethodName2, className));
        assertTrue(testClass.hasReturnType(getAttributeMethodName2, null, int.class), String.format(incorrectReturnType, getAttributeMethodName2, className));

        Object getMethodOutput = testClass.callMethod(getAttributeMethodName2, testInstance);
        assertTrue(testClass.hasModifier(getAttributeMethodName2, null, "public"),
                "Your " + getAttributeMethodName2 + " method does not have the correct visibility modifier.");
        _assertEquals(bounty, getMethodOutput,
                "Your " + getAttributeMethodName2 + " method does not return the value of the " + attributeName2 + " attribute.");
    }

    @Test
    public void setSkillIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(setAttributeMethodName1, new Class<?>[]{String.class}), String.format(incorrectMethodDefinition, setAttributeMethodName1, className));
        assertTrue(testClass.hasModifier(setAttributeMethodName1, new Class<?>[]{String.class}, "public"), String.format(incorrectModifierMessage, setAttributeMethodName1, className));
        assertTrue(testClass.hasReturnType(setAttributeMethodName1, new Class<?>[]{String.class}, Void.TYPE), String.format(incorrectReturnType, setAttributeMethodName1, className));
    }

    @ParameterizedTest
    @MethodSource("updateStringInputProvider")
    public void correctSetSkillMethod(String initialiValue, String updatedValue, int bounty) throws Throwable {
        Object[][] instantiationArguments = {
                {initialiValue, String.class},
                {bounty, int.class}
        };
        Object testInstance = testClass.createInstance(instantiationArguments);
        Object[][] setMethodArguments = {
                {updatedValue, String.class}
        };
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(setAttributeMethodName1, new Class<?>[]{String.class}), String.format(incorrectMethodDefinition, setAttributeMethodName1, className));
        assertTrue(testClass.hasModifier(setAttributeMethodName1, new Class<?>[]{String.class}, "public"), String.format(incorrectModifierMessage, setAttributeMethodName1, className));
        assertTrue(testClass.hasReturnType(setAttributeMethodName1, new Class<?>[]{String.class}, Void.TYPE), String.format(incorrectReturnType, setAttributeMethodName1, className));
        testClass.callMethod(setAttributeMethodName1, setMethodArguments, testInstance);
        String incorrectSetterMessage =
                "Your " + setAttributeMethodName1 + " method does not correctly update the value of " + attributeName1 + ".";
        _assertEquals(updatedValue, testClass.getFieldValue(testInstance, attributeName1),
                incorrectSetterMessage);
    }

    @Test
    public void setBountyIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(setAttributeMethodName2, new Class<?>[]{int.class}), String.format(incorrectMethodDefinition, setAttributeMethodName2, className));
        assertTrue(testClass.hasModifier(setAttributeMethodName2, new Class<?>[]{int.class}, "public"), String.format(incorrectModifierMessage, setAttributeMethodName2, className));
        assertTrue(testClass.hasReturnType(setAttributeMethodName2, new Class<?>[]{int.class}, Void.TYPE), String.format(incorrectReturnType, setAttributeMethodName2, className));
    }

    @ParameterizedTest
    @MethodSource("updateIntegerInputProvider")
    public void correctSetBountyMethod(String skill, int initialValue, int updatedValue) throws Throwable {
        Object[][] instantiationArguments = {
                {skill, String.class},
                {initialValue, int.class}
        };
        Object testInstance = testClass.createInstance(instantiationArguments);
        Object[][] setMethodArguments = {
                {updatedValue, int.class}
        };
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(setAttributeMethodName2, new Class<?>[]{int.class}), String.format(incorrectMethodDefinition, setAttributeMethodName2, className));
        assertTrue(testClass.hasModifier(setAttributeMethodName2, new Class<?>[]{int.class}, "public"), String.format(incorrectModifierMessage, setAttributeMethodName2, className));
        assertTrue(testClass.hasReturnType(setAttributeMethodName2, new Class<?>[]{int.class}, Void.TYPE), String.format(incorrectReturnType, setAttributeMethodName2, className));
        testClass.callMethod(setAttributeMethodName2, setMethodArguments, testInstance);
        String incorrectSetterMessage =
                "Your " + setAttributeMethodName2 + " method does not correctly update the value of " + attributeName2 + ".";
        _assertEquals(updatedValue, testClass.getFieldValue(testInstance, attributeName2),
                incorrectSetterMessage);
    }


    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctToStringMethod(String value1, int value2) throws Throwable {
        Object[][] arguments = {
                {value1, String.class},
                {value2, int.class}
        };
        String incorrectToStringMessage = "Your toString method does not return the correct String.";
        Object testInstance = testClass.createInstance(arguments);
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod("toString", null), String.format(incorrectMethodDefinition, "toString", className));
        assertTrue(testClass.hasModifier("toString", null, "public"), String.format(incorrectModifierMessage, "toString", className));
        assertTrue(testClass.hasReturnType("toString", null, String.class), String.format(incorrectReturnType, "toString", className));
        String expectedOutput = "My special skill is " + value1 + " and my bounty is " + value2;
        Object toStringOutput = testClass.callMethod("toString", testInstance);
        _assertEquals(expectedOutput, toStringOutput, incorrectToStringMessage);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void methodsWorkingTogether(String value1, int value2) throws Throwable {
        Object[][] initialArguments = {
                {"initial string", String.class},
                {123, int.class}
        };
        Object testInstance = testClass.createInstance(initialArguments);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName1, testInstance);
        _assertEquals("initial string", getMethodOutput,
                "Your " + getAttributeMethodName1 + " method does not return the value of the " + attributeName1 + " attribute.");
        getMethodOutput = testClass.callMethod(getAttributeMethodName2, testInstance);
        _assertEquals(123, getMethodOutput,
                "Your " + getAttributeMethodName2 + " method does not return the value of the " + attributeName2 + " attribute.");
        Object[][] setMethodArguments = {
                {value1, String.class}
        };
        Object setMethodOutput = testClass.callMethod(setAttributeMethodName1, setMethodArguments, testInstance);
        _assertEquals(value1, testClass.callMethod(getAttributeMethodName1, testInstance),
                "Your " + getAttributeMethodName1 + " method does not correctly update the value of " + setAttributeMethodName1 + " after using the " + getAttributeMethodName1 + " method.");
        setMethodArguments = new Object[][]{
                {value2, int.class}
        };
        setMethodOutput = testClass.callMethod(setAttributeMethodName2, setMethodArguments, testInstance);
        _assertEquals(value2, testClass.callMethod(getAttributeMethodName2, testInstance),
                "Your " + getAttributeMethodName2 + " method does not correctly update the value of " + setAttributeMethodName2 + " after using the " + getAttributeMethodName2 + " method.");
        String expectedOutput = "My special skill is " + value1 + " and my bounty is " + value2;
        Object toStringOutput = testClass.callMethod("toString", testInstance);
        _assertEquals(expectedOutput, toStringOutput,
                "Your toString method does not print the correct String after using the getter and setter methods.");
    }
}
