package oop.object_interactions.medium.q4;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    private ObjectTest testClass;
    private ObjectTest classObject;
    private final String className = "Snail";
    private final String testClassName = "TestTransfusion";
    private final String bloodTypeAttributeName = "bloodType";
    private final String volumeAttributeName = "volume";
    private final String getBloodTypeMethodName = "getBloodType";
    private final String setBloodTypeMethodName = "setBloodType";
    private final String getVolumeMethodName = "getVolume";
    private final String setVolumeMethodName = "setVolume";
    private final String transfusionFromMethodName = "transfusionFrom";
    private static final int minBlood = 5;

    @BeforeEach
    public void setup() throws Throwable {
        String classString = "oop.object_interactions.medium.q4." + className;
        String testClassString = "oop.object_interactions.medium.q4." + testClassName;
        testClass = new ObjectTest(classString);
        classObject = new ObjectTest(testClassString);
        assertTrue(testClass.hasModifier("public"),
                "You have changed the visibility modifier on the " + className + " class. Please revert it to the original state.");
        assertTrue(testClass.hasField(bloodTypeAttributeName, char.class, new String[]{"private"}),
                String.format("You have modified the provided %s attribute. Please revert it to the original state.", bloodTypeAttributeName));
        assertTrue(testClass.hasField(volumeAttributeName, double.class, new String[]{"private"}),
                String.format("You have modified the provided %s attribute. Please revert it to the original state.", volumeAttributeName));
        Class<?>[] classArguments = {char.class, double.class};
        assertTrue(testClass.hasConstructor(classArguments),
                "You have modified the provided constructor on the " + className + " class. Please revert it to the original state.");
        assertTrue(testClass.hasModifier(classArguments, "public"),
                "You have modified the provided constructor on the " + className + " class. Please revert it to the original state.");
        assertTrue(testClass.hasMethod(getBloodTypeMethodName, null, char.class, new String[]{"public"}),
                String.format("You have modified the provided %s method. Please revert it to the original state.", getBloodTypeMethodName));
        assertTrue(testClass.hasMethod(setBloodTypeMethodName, new Class<?>[]{char.class}, Void.TYPE, new String[]{"public"}),
                String.format("You have modified the provided %s method. Please revert it to the original state.", setBloodTypeMethodName));
        assertTrue(testClass.hasMethod(getVolumeMethodName, null, double.class, new String[]{"public"}),
                String.format("You have modified the provided %s method. Please revert it to the original state.", getVolumeMethodName));
        assertTrue(testClass.hasMethod(setVolumeMethodName, new Class<?>[]{double.class}, Void.TYPE, new String[]{"public"}),
                String.format("You have modified the provided %s method. Please revert it to the original state.", setVolumeMethodName));
        Object[][] test = new Object[][]{
                {'A', 10.3, 'B', 4.1},
                {'B', 4.2, 'A', 2.3},
                {'O', 3.5, 'B', 5.5},
        };
        for (int num = 0; num < test.length; num++) {
            char type = (char) test[num][0];
            double volume = (double) test[num][1];
            Object[][] arguments = {
                    {type, char.class},
                    {volume, double.class}
            };
            Object classInstance = testClass.createInstance(arguments);
            _assertEquals(type, testClass.getFieldValue(classInstance, bloodTypeAttributeName),
                    "You have modified the provided constructor on the " + className + " class. Please revert it to the original state.");
            _assertEquals(volume, testClass.getFieldValue(classInstance, volumeAttributeName),
                    "You have modified the provided constructor on the " + className + " class. Please revert it to the original state.");
            char updateType = (char) test[num][2];
            double updateVolume = (double) test[num][3];
            Object output = testClass.callMethod(getBloodTypeMethodName, classInstance);
            _assertEquals(type, output,
                    "You have modified the provided " + getBloodTypeMethodName + " method on the " + className + " class. Please revert it to the original state.");
            output = testClass.callMethod(getVolumeMethodName, classInstance);
            _assertEquals(volume, output,
                    "You have modified the provided " + getVolumeMethodName + " method on the " + className + " class. Please revert it to the original state.");
            output = testClass.callMethod(setBloodTypeMethodName, new Object[][]{{updateType, char.class}}, classInstance);
            _assertEquals(updateType, testClass.getFieldValue(classInstance, bloodTypeAttributeName),
                    "You have modified the provided " + setBloodTypeMethodName + " method on the " + className + " class. Please revert it to the original state.");
            assertNull(output, String.join(" ", "Your", setBloodTypeMethodName, "should not return any output"));
            output = testClass.callMethod(setVolumeMethodName, new Object[][]{{updateVolume, double.class}}, classInstance);
            _assertEquals(updateVolume, testClass.getFieldValue(classInstance, volumeAttributeName),
                    "You have modified the provided " + setVolumeMethodName + " method on the " + className + " class. Please revert it to the original state.");
            assertNull(output, String.join(" ", "Your", setVolumeMethodName, "should not return any output"));
        }
    }

    private static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of('A', 10.3, 'B', 4.9),
                Arguments.of('A', 15.5, 'A', 7.2),
                Arguments.of('A', 6.4, 'A', minBlood),
                Arguments.of('A', 0, 'A', minBlood - 1),
                Arguments.of('A', 0.5, 'A', minBlood + 1),
                Arguments.of('B', 0, 'A', 2.5),
                Arguments.of('O', 3.4, 'B', 5.7)
        );
    }

    @Test
    public void transfusionFromIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(transfusionFromMethodName, new Class<?>[]{Snail.class}), String.format(incorrectMethodDefinition, transfusionFromMethodName, className));
        assertTrue(testClass.hasModifier(transfusionFromMethodName, new Class<?>[]{Snail.class}, "public"), String.format(incorrectModifierMessage, transfusionFromMethodName, className));
        assertTrue(testClass.hasReturnType(transfusionFromMethodName, new Class<?>[]{Snail.class}, Void.TYPE), String.format(incorrectReturnType, transfusionFromMethodName, className));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    @Tag("dependent1")
    public void correctTransfusionFromMethod(char type, double volume, char donType, double donVolume) throws Throwable {
        Object[][] arguments = {
                {type, char.class},
                {volume, double.class}
        };
        Object[][] donArguments = {
                {donType, char.class},
                {donVolume, double.class}
        };
        Object donor = testClass.createInstance(donArguments);
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(transfusionFromMethodName, new Class<?>[]{Snail.class}), String.format(incorrectMethodDefinition, transfusionFromMethodName, className));
        assertTrue(testClass.hasModifier(transfusionFromMethodName, new Class<?>[]{Snail.class}, "public"), String.format(incorrectModifierMessage, transfusionFromMethodName, className));
        assertTrue(testClass.hasReturnType(transfusionFromMethodName, new Class<?>[]{Snail.class}, Void.TYPE), String.format(incorrectReturnType, transfusionFromMethodName, className));
        Object classInstance = testClass.createInstance(arguments);
        Object[][] methodArguments = {
                {donor, Snail.class}
        };
        if (type != donType) {
            testClass.callMethod(transfusionFromMethodName, methodArguments, new String[]{"public"}, classInstance, new Clause[]{
                    new StringLiteral("Blood type incompatible"),
                    new Optional(new StringLiteral(" "))
            });
        } else if (donVolume <= minBlood) {
            testClass.callMethod(transfusionFromMethodName, methodArguments, new String[]{"public"}, classInstance, new Clause[]{
                    new StringLiteral("Checking if donor has enough blood for a transfusion\\.\\.\\."),
                    new Optional(new StringLiteral(" ")),
                    new NewLine(),
                    new StringLiteral("Donor does not have enough blood for a transfusion"),
                    new Optional(new StringLiteral(" "))
            });
            _assertEquals(volume, testClass.getFieldValue(classInstance, volumeAttributeName),
                    "Your " + transfusionFromMethodName + " method does not correctly add blood to the recipient.");
            _assertEquals(donVolume, testClass.getFieldValue(donor, volumeAttributeName),
                    "Your " + transfusionFromMethodName + " method does not correctly take blood from the donor.");
        } else {
            testClass.callMethod(transfusionFromMethodName, methodArguments, new String[]{"public"}, classInstance, new Clause[]{
                    new StringLiteral("Checking if donor has enough blood for a transfusion\\.\\.\\."),
                    new Optional(new StringLiteral(" ")),
                    new NewLine(),
                    new StringLiteral("Blood transfusion completed"),
                    new Optional(new StringLiteral(" "))
            });
            _assertEquals(volume + 1, testClass.getFieldValue(classInstance, volumeAttributeName),
                    "Your " + transfusionFromMethodName + " method does not correctly add blood to the recipient.");
            _assertEquals(donVolume - 1, testClass.getFieldValue(donor, volumeAttributeName),
                    "Your " + transfusionFromMethodName + " method does not correctly take blood from the donor.");

        }
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    @Tag("dependent1")
    public void newspaperClassHasCorrectToStringMethod(char type, double volume) throws Throwable {
        Object[][] arguments = {
                {type, char.class},
                {volume, double.class}
        };
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod("toString", null), String.format(incorrectMethodDefinition, "toString", className));
        assertTrue(testClass.hasModifier("toString", null, "public"), String.format(incorrectModifierMessage, "toString", className));
        assertTrue(testClass.hasReturnType("toString", null, String.class), String.format(incorrectReturnType, "toString", className));
        Object classInstance = testClass.createInstance(arguments);
        String[] methodModifiers = {"public"};
        String expected = "My blood type is " + type + " and I have " + volume + "L of blood left";
        String incorrectToStringMessage = String.join(" ",
                "Your", className, " toString method does not return the correct String.");
        Object output = testClass.callMethod("toString", methodModifiers, classInstance);
        _assertEquals(expected, output, incorrectToStringMessage);
    }

    @Test
    @Tag("dependency1")
    public void correctMainMethod() throws Throwable {
        Clause[] clauses = {
                new StringLiteral("Blood type incompatible"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Checking if donor has enough blood for a transfusion\\.\\.\\."),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Blood transfusion completed"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Sarah: My blood type is A and I have 10.5L of blood left"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Jones: My blood type is B and I have 7.0L of blood left"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Cindy: My blood type is B and I have 1.5L of blood left"),
                new Optional(new StringLiteral(" "))

        };
        Object classInstance = classObject.createInstance();
        classObject.callMethod("main", new Object[][]{{new String[0], String[].class}}, new String[]{"public"}, classInstance,
                clauses);
    }
}
