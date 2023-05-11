package oop.special_class_method.medium.q8;

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
    private final String className = "Luffy";
    private final String attributeName1 = "skill";
    private final String getAttributeMethodName1 = "getSkill";
    private final String setAttributeMethodName1 = "setSkill";
    private final String attributeName2 = "bounty";
    private final String getAttributeMethodName2 = "getBounty";
    private final String setAttributeMethodName2 = "setBounty";
    private ObjectTest testClass;

    @BeforeEach
    public void setUp() {
        String classString = "oop.special_class_method.medium.q8." + className;
        this.testClass = new ObjectTest(classString);
    }

    @Test
    public void lufffyClassHasCorrectField() {
        String missingFieldMessage = "Your " + className + " class is missing the " + attributeName1 + " field.";
        String incorrectVisibilityModifierMessage =
                "Your " + attributeName1 + " field does not have the correct visibility modifier.";
        assertTrue(testClass.hasField(attributeName1, String.class), missingFieldMessage);
        assertTrue(testClass.hasModifier(attributeName1, "private"), incorrectVisibilityModifierMessage);
        String missingFieldMessage2 = "Your " + className + " class is missing the " + attributeName2 + " field.";
        String incorrectVisibilityModifierMessage2 =
                "Your " + attributeName2 + " field does not have the correct visibility modifier.";
        assertTrue(testClass.hasField(attributeName2, int.class), missingFieldMessage2);
        assertTrue(testClass.hasModifier(attributeName2, "private"), incorrectVisibilityModifierMessage2);
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

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctLuffyConstructor(String skill, int bounty) throws Throwable {
        Object[][] arguments = {
                {skill, String.class},
                {bounty, int.class}
        };
        String incorrectValueMessage = "Your " + className + " constructor does not correctly initialize the " +
                attributeName1 + " and " + attributeName2 + " fields.";
        String incorrectVisibilityModifier =
                "Your " + className + " constructor does not have the correct visibility modifier.";
        Class<?>[] classes = {String.class, int.class};
        Object testInstance = testClass.createInstance(arguments);
        _assertEquals(skill, testClass.getFieldValue(testInstance, attributeName1), incorrectValueMessage);
        _assertEquals(bounty, testClass.getFieldValue(testInstance, attributeName2), incorrectValueMessage);
        assertTrue(testClass.hasModifier(classes, "public"), incorrectVisibilityModifier);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctGetSkillMethod(String skill, int bounty) throws Throwable {
        Object[][] arguments = {
                {skill, String.class},
                {bounty, int.class}
        };
        Object testInstance = testClass.createInstance(arguments);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName1, testInstance);
        assertTrue(testClass.hasModifier(getAttributeMethodName1, null, "public"),
                "Your " + getAttributeMethodName1 + " method does not have the correct visibility modifier.");
        _assertEquals(skill, getMethodOutput,
                "Your " + getAttributeMethodName1 + " method does not return the value of the size field.");
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctGetNickelMethod(String skill, int bounty) throws Throwable {
        Object[][] arguments = {
                {skill, String.class},
                {bounty, int.class}
        };
        Object testInstance = testClass.createInstance(arguments);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName2, testInstance);
        assertTrue(testClass.hasModifier(getAttributeMethodName2, null, "public"),
                "Your " + getAttributeMethodName2 + " method does not have the correct visibility modifier.");
        _assertEquals(bounty, getMethodOutput,
                "Your " + getAttributeMethodName2 + " method does not return the value of the size field.");
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
        Class<?>[] methodModifierClasses = {
                String.class
        };
        testClass.callMethod(setAttributeMethodName1, setMethodArguments, testInstance);
        assertTrue(testClass.hasModifier(setAttributeMethodName1, methodModifierClasses, "public"),
                "Your " + setAttributeMethodName1 + " method does not have the correct visibility modifier.");
        String incorrectSetterMessage =
                "Your " + setAttributeMethodName1 + " method does not correctly update the value of " + attributeName1 + ".";
        _assertEquals(updatedValue, testClass.getFieldValue(testInstance, attributeName1),
                incorrectSetterMessage);
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
        Class<?>[] methodModifierClasses = {
                int.class
        };
        testClass.callMethod(setAttributeMethodName2, setMethodArguments, testInstance);
        assertTrue(testClass.hasModifier(setAttributeMethodName2, methodModifierClasses, "public"),
                "Your " + setAttributeMethodName2 + " method does not have the correct visibility modifier.");
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
        String expectedOutput = "My special skill is " + value1 + " and my bounty is " + value2;
        Object toStringOutput = testClass.callMethod("toString", testInstance);
        _assertEquals(expectedOutput, toStringOutput, incorrectToStringMessage);
    }

    @ParameterizedTest
    @MethodSource("updateStringInputProvider")
    public void correctGetSetMethods(String initialValue, String updatedValue, int bounty) throws Throwable {
        String errorMessage = "Your " + className + " class " + getAttributeMethodName1 +
                " method does not return the updated value after calling the " + setAttributeMethodName1 + " method.";
        Object[][] arguments = {
                {initialValue, String.class},
                {bounty, int.class}
        };
        Object testInstance = testClass.createInstance(arguments);
        Object[][] setMethodArguments = {
                {updatedValue, String.class}
        };
        testClass.callMethod(setAttributeMethodName1, setMethodArguments, testInstance);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName1, testInstance);
        _assertEquals(updatedValue, getMethodOutput, errorMessage);
    }

    @ParameterizedTest
    @MethodSource("updateIntegerInputProvider")
    public void correctGetSetMethods2(String skill, int initialValue, int updatedValue) throws Throwable {
        String errorMessage = "Your " + className + " class " + getAttributeMethodName2 +
                " method does not return the updated value after calling the " + setAttributeMethodName2 + " method.";
        Object[][] arguments = {
                {skill, String.class},
                {initialValue, int.class}
        };
        Object testInstance = testClass.createInstance(arguments);
        Object[][] setMethodArguments = {
                {updatedValue, int.class}
        };
        testClass.callMethod(setAttributeMethodName2, setMethodArguments, testInstance);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName2, testInstance);
        _assertEquals(updatedValue, getMethodOutput, errorMessage);
    }
}