package oop.special_class_method.hard.q12;

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

    private final String className = "Laptop";
    private final String attributeName1 = "yearMade";
    private final String getAttributeMethodName1 = "getYearMade";
    private final String setAttributeMethodName1 = "setYearMade";
    private final String attributeName2 = "colour";
    private final String getAttributeMethodName2 = "getColour";
    private final String setAttributeMethodName2 = "setColour";
    private final String specialMethodName = "addSticker";
    private ObjectTest testClass;

    @BeforeEach
    public void setUp() throws Throwable {
        String classString = "oop.special_class_method.hard.q12." + className;
        this.testClass = new ObjectTest(classString);
    }

    @Test
    public void laptopClassHasCorrectAttributes() {
        assertTrue(testClass.hasField(attributeName1),
                "Your " + className + " class is missing the " + attributeName1 + " attribute, or it is spelled incorrectly.");
        assertTrue(testClass.hasField(attributeName1, int.class),
                "Your " + attributeName1 + " does not have the correct type.");
        assertTrue(testClass.hasModifier(attributeName1, "private"),
                "Your " + attributeName1 + " does not have the correct visibility modifier.");
        assertTrue(testClass.hasField(attributeName2),
                "Your " + className + " class is missing the " + attributeName2 + " attribute, or it is spelled incorrectly.");
        assertTrue(testClass.hasField(attributeName2, String.class),
                "Your " + attributeName2 + " does not have the correct type.");
        assertTrue(testClass.hasModifier(attributeName2, "private"),
                "Your " + attributeName2 + " does not have the correct visibility modifier.");
    }


    private static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(2002, "Red"),
                Arguments.of(1989, "Black"),
                Arguments.of(2020, "Blue"),
                Arguments.of(2017, "White"),
                Arguments.of(2010, "Yellow"),
                Arguments.of(0, "")
        );
    }

    private static Stream<Arguments> updateIntegerInputProvider() {
        return Stream.of(
                Arguments.of(2020, "Red", 2021),
                Arguments.of(2022, "Black", 1987),
                Arguments.of(2019, "Blue", 2001),
                Arguments.of(2013, "White", 2007),
                Arguments.of(1999, "Yellow", 2006),
                Arguments.of(2027, "Green", 0)

        );
    }

    private static Stream<Arguments> updateStringInputProvider() {
        return Stream.of(
                Arguments.of(3, "Red", "White"),
                Arguments.of(10, "Black", "Green"),
                Arguments.of(12, "Blue", "Red"),
                Arguments.of(43, "White", "Gray"),
                Arguments.of(7, "Yellow", "Orange"),
                Arguments.of(14, "lilac", "")

        );
    }

    @Test
    public void laptopClassHasRequiredConstructor() {
        Class<?>[] classArguments = {int.class, String.class};
        assertTrue(testClass.hasConstructor(classArguments),
                "Your " + className + " constructor does not have the correct parameters.");
        assertTrue(testClass.hasModifier(classArguments, "public"),
                "Your " + className + " constructor does not have the correct visibility modifiers.");
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void laptopClassHasCorrectConstructor(int value1, String value2) throws Throwable {
        Object[][] arguments = {
                {value1, int.class},
                {value2, String.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        _assertEquals(value1, testClass.getFieldValue(classInstance, attributeName1),
                "Your " + className + " constructor does not initialize the " + attributeName1 + " attribute to the correct value.");
        _assertEquals(value2, testClass.getFieldValue(classInstance, attributeName2),
                "Your " + className + " constructor does not initialize the " + attributeName2 + " attribute to the correct value.");
    }

    @Test
    public void getYearMadeIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getAttributeMethodName1, null), String.format(incorrectMethodDefinition, getAttributeMethodName1, className));
        assertTrue(testClass.hasModifier(getAttributeMethodName1, null, "public"), String.format(incorrectModifierMessage, getAttributeMethodName1, className));
        assertTrue(testClass.hasReturnType(getAttributeMethodName1, null, int.class), String.format(incorrectReturnType, getAttributeMethodName1, className));
    }


    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctGetYearMadeMethod(int value1, String value2) throws Throwable {
        Object[][] arguments = {
                {value1, int.class},
                {value2, String.class}
        };
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getAttributeMethodName1, null), String.format(incorrectMethodDefinition, getAttributeMethodName1, className));
        assertTrue(testClass.hasModifier(getAttributeMethodName1, null, "public"), String.format(incorrectModifierMessage, getAttributeMethodName1, className));
        assertTrue(testClass.hasReturnType(getAttributeMethodName1, null, int.class), String.format(incorrectReturnType, getAttributeMethodName1, className));
        Object testInstance = testClass.createInstance(arguments);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName1, testInstance);
        _assertEquals(value1, getMethodOutput,
                "Your " + getAttributeMethodName1 + " method does not return the value of the " + attributeName1 + " attribute.");
    }

    @Test
    public void getColourIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getAttributeMethodName2, null), String.format(incorrectMethodDefinition, getAttributeMethodName2, className));
        assertTrue(testClass.hasModifier(getAttributeMethodName2, null, "public"), String.format(incorrectModifierMessage, getAttributeMethodName2, className));
        assertTrue(testClass.hasReturnType(getAttributeMethodName2, null, String.class), String.format(incorrectReturnType, getAttributeMethodName2, className));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctGetColourMethod(int value1, String value2) throws Throwable {
        Object[][] arguments = {
                {value1, int.class},
                {value2, String.class}
        };
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(getAttributeMethodName2, null), String.format(incorrectMethodDefinition, getAttributeMethodName2, className));
        assertTrue(testClass.hasModifier(getAttributeMethodName2, null, "public"), String.format(incorrectModifierMessage, getAttributeMethodName2, className));
        assertTrue(testClass.hasReturnType(getAttributeMethodName2, null, String.class), String.format(incorrectReturnType, getAttributeMethodName2, className));
        Object testInstance = testClass.createInstance(arguments);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName2, testInstance);
        _assertEquals(value2, getMethodOutput,
                "Your " + getAttributeMethodName2 + " method does not return the value of the " + attributeName2 + " attribute.");
    }

    @Test
    public void setYearMadeIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(setAttributeMethodName1, new Class<?>[]{int.class}), String.format(incorrectMethodDefinition, setAttributeMethodName1, className));
        assertTrue(testClass.hasModifier(setAttributeMethodName1, new Class<?>[]{int.class}, "public"), String.format(incorrectModifierMessage, setAttributeMethodName1, className));
        assertTrue(testClass.hasReturnType(setAttributeMethodName1, new Class<?>[]{int.class}, Void.TYPE), String.format(incorrectReturnType, setAttributeMethodName1, className));
    }

    @ParameterizedTest
    @MethodSource("updateIntegerInputProvider")
    public void correctSetYearMadeMethod(int initialValue, String value2, int updatedValue) throws Throwable {
        Object[][] instantiationArguments = {
                {initialValue, int.class},
                {value2, String.class}
        };
        Object[][] setMethodArguments = {
                {updatedValue, int.class}
        };
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(setAttributeMethodName1, new Class<?>[]{int.class}), String.format(incorrectMethodDefinition, setAttributeMethodName1, className));
        assertTrue(testClass.hasModifier(setAttributeMethodName1, new Class<?>[]{int.class}, "public"), String.format(incorrectModifierMessage, setAttributeMethodName1, className));
        assertTrue(testClass.hasReturnType(setAttributeMethodName1, new Class<?>[]{int.class}, Void.TYPE), String.format(incorrectReturnType, setAttributeMethodName1, className));
        Object testInstance = testClass.createInstance(instantiationArguments);
        testClass.callMethod(setAttributeMethodName1, setMethodArguments, testInstance);
        String incorrectSetterMessage =
                "Your " + setAttributeMethodName1 + " method does not correctly update the value of " + attributeName1 + ".";
        _assertEquals(updatedValue, testClass.getFieldValue(testInstance, attributeName1),
                incorrectSetterMessage);
    }

    @Test
    public void setColourIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(setAttributeMethodName2, new Class<?>[]{String.class}), String.format(incorrectMethodDefinition, setAttributeMethodName2, className));
        assertTrue(testClass.hasModifier(setAttributeMethodName2, new Class<?>[]{String.class}, "public"), String.format(incorrectModifierMessage, setAttributeMethodName2, className));
        assertTrue(testClass.hasReturnType(setAttributeMethodName2, new Class<?>[]{String.class}, Void.TYPE), String.format(incorrectReturnType, setAttributeMethodName2, className));
    }

    @ParameterizedTest
    @MethodSource("updateStringInputProvider")
    public void correctSetColourMethod(int value1, String initialValue, String updatedValue) throws Throwable {
        Object[][] instantiationArguments = {
                {value1, int.class},
                {initialValue, String.class}
        };
        Object[][] setMethodArguments = {
                {updatedValue, String.class}
        };
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(setAttributeMethodName2, new Class<?>[]{String.class}), String.format(incorrectMethodDefinition, setAttributeMethodName2, className));
        assertTrue(testClass.hasModifier(setAttributeMethodName2, new Class<?>[]{String.class}, "public"), String.format(incorrectModifierMessage, setAttributeMethodName2, className));
        assertTrue(testClass.hasReturnType(setAttributeMethodName2, new Class<?>[]{String.class}, Void.TYPE), String.format(incorrectReturnType, setAttributeMethodName2, className));
        Object testInstance = testClass.createInstance(instantiationArguments);
        testClass.callMethod(setAttributeMethodName2, setMethodArguments, testInstance);
        String incorrectSetterMessage =
                "Your " + setAttributeMethodName2 + " method does not correctly update the value of " + attributeName2 + ".";
        _assertEquals(updatedValue, testClass.getFieldValue(testInstance, attributeName2),
                incorrectSetterMessage);
    }

    @Test
    public void addStickerIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(specialMethodName, new Class<?>[]{String.class}), String.format(incorrectMethodDefinition, specialMethodName, className));
        assertTrue(testClass.hasModifier(specialMethodName, new Class<?>[]{String.class}, "public"), String.format(incorrectModifierMessage, specialMethodName, className));
        assertTrue(testClass.hasReturnType(specialMethodName, new Class<?>[]{String.class}, Void.TYPE), String.format(incorrectReturnType, specialMethodName, className));
    }

    @ParameterizedTest
    @MethodSource("updateStringInputProvider")
    public void correctAddStickerMethod(int value1, String value2, String addedValue) throws Throwable {
        Object[][] instantiationArguments = {
                {value1, int.class},
                {value2, String.class}
        };
        Object[][] methodArguments = {
                {addedValue, String.class}
        };
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(specialMethodName, new Class<?>[]{String.class}), String.format(incorrectMethodDefinition, specialMethodName, className));
        assertTrue(testClass.hasModifier(specialMethodName, new Class<?>[]{String.class}, "public"), String.format(incorrectModifierMessage, specialMethodName, className));
        assertTrue(testClass.hasReturnType(specialMethodName, new Class<?>[]{String.class}, Void.TYPE), String.format(incorrectReturnType, specialMethodName, className));
        Object testInstance = testClass.createInstance(instantiationArguments);
        testClass.callMethod(specialMethodName, methodArguments, testInstance);
        String incorrectSetterMessage =
                "Your " + specialMethodName + " method does not correctly update the value of " + attributeName2 + ".";
        _assertEquals(value2 + " and " + addedValue, testClass.getFieldValue(testInstance, attributeName2),
                incorrectSetterMessage);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void methodsWorkingTogether(int value1, String value2) throws Throwable {
        Object[][] initialArguments = {
                {123, int.class},
                {"Initial String", String.class}
        };
        Object testInstance = testClass.createInstance(initialArguments);
        _assertEquals(123, testClass.getFieldValue(testInstance, attributeName1),
                "Your " + className + " constructor does not initialize the " + attributeName1 + " attribute to the correct value.");
        _assertEquals("Initial String", testClass.getFieldValue(testInstance, attributeName2),
                "Your " + className + " constructor does not initialize the " + attributeName2 + " attribute to the correct value.");
        Object[][] setMethodArguments = {
                {value1, int.class}
        };
        testClass.callMethod(setAttributeMethodName1, setMethodArguments, testInstance);
        _assertEquals(value1, testClass.callMethod(getAttributeMethodName1, testInstance),
                "Your " + getAttributeMethodName1 + " method does not correctly update the value of " + attributeName1 + " after using the " + setAttributeMethodName1 + " method.");
        setMethodArguments = new Object[][]{
                {value2, String.class}
        };
        testClass.callMethod(setAttributeMethodName2, setMethodArguments, testInstance);
        _assertEquals(value2, testClass.callMethod(getAttributeMethodName2, testInstance),
                "Your " + getAttributeMethodName2 + " method does not correctly update the value of " + attributeName2 + " after using the " + setAttributeMethodName2 + " method.");

        Object[][] methodArguments = {
                {"purple", String.class}
        };
        testClass.callMethod(specialMethodName, methodArguments, testInstance);
        String incorrectSetterMessage =
                "Your " + specialMethodName + " method does not correctly update the value of " + attributeName2 + " after using the other methods.";
        _assertEquals(value2 + " and purple", testClass.getFieldValue(testInstance, attributeName2),
                incorrectSetterMessage);
    }
}
