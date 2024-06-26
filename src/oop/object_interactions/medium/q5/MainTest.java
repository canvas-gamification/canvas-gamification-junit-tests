package oop.object_interactions.medium.q5;

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
    private final String className = "Person";
    private final String testClassName = "TestTransplant";
    private final String myNameAttributeName = "myName";
    private final String numEyesAttributeName = "numEyes";
    private final String getMyNameMethodName = "getMyName";
    private final String setMyNameMethodName = "setMyName";
    private final String getNumEyesMethodName = "getNumEyes";
    private final String setNumEyesMethodName = "setNumEyes";
    private final String receiveDonationMethodName = "receiveDonation";
    private final int minEyes = 0;
    private final int eyesToTake = 1;

    @BeforeEach
    public void setup() throws Throwable {
        String classString = "oop.object_interactions.medium.q5." + className;
        String testClassString = "oop.object_interactions.medium.q5." + testClassName;
        testClass = new ObjectTest(classString);
        classObject = new ObjectTest(testClassString);
        assertTrue(testClass.hasModifier("public"),
                "You have changed the visibility modifier on the " + className + " class. Please revert it to the original state.");
        assertTrue(testClass.hasField(myNameAttributeName, String.class, new String[]{"private"}),
                String.format("You have modified the provided %s attribute. Please revert it to the original state.", myNameAttributeName));
        assertTrue(testClass.hasField(numEyesAttributeName, int.class, new String[]{"private"}),
                String.format("You have modified the provided %s attribute. Please revert it to the original state.", numEyesAttributeName));
        Class<?>[] classArguments = {String.class, int.class};
        assertTrue(testClass.hasConstructor(classArguments),
                "You have modified the provided constructor on the " + className + " class. Please revert it to the original state.");
        assertTrue(testClass.hasModifier(classArguments, "public"),
                "You have modified the provided constructor on the " + className + " class. Please revert it to the original state.");
        assertTrue(testClass.hasMethod(getMyNameMethodName, null, String.class, new String[]{"public"}),
                String.format("You have modified the provided %s method. Please revert it to the original state.", getMyNameMethodName));
        assertTrue(testClass.hasMethod(setMyNameMethodName, new Class<?>[]{String.class}, Void.TYPE, new String[]{"public"}),
                String.format("You have modified the provided %s method. Please revert it to the original state.", setMyNameMethodName));
        assertTrue(testClass.hasMethod(getNumEyesMethodName, null, int.class, new String[]{"public"}),
                String.format("You have modified the provided %s method. Please revert it to the original state.", getNumEyesMethodName));
        assertTrue(testClass.hasMethod(setNumEyesMethodName, new Class<?>[]{int.class}, Void.TYPE, new String[]{"public"}),
                String.format("You have modified the provided %s method. Please revert it to the original state.", setNumEyesMethodName));
        Object[][] test = new Object[][]{
                {"Sarah", 2, "John", 0},
                {"Amir", 1, "Sam", 2},
                {"John", 0, "Jack", 0},
        };
        for (int num = 0; num < test.length; num++) {
            String name = (String) test[num][0];
            int eyes = (int) test[num][1];
            Object[][] arguments = {
                    {name, String.class},
                    {eyes, int.class}
            };
            Object classInstance = testClass.createInstance(arguments);
            _assertEquals(name, testClass.getFieldValue(classInstance, myNameAttributeName),
                    "You have modified the provided constructor on the " + className + " class. Please revert it to the original state.");
            _assertEquals(eyes, testClass.getFieldValue(classInstance, numEyesAttributeName),
                    "You have modified the provided constructor on the " + className + " class. Please revert it to the original state.");
            String updateName = (String) test[num][2];
            int updateEyes = (int) test[num][3];
            Object output = testClass.callMethod(getMyNameMethodName, classInstance);
            _assertEquals(name, output,
                    "You have modified the provided " + getMyNameMethodName + " method on the " + className + " class. Please revert it to the original state.");
            output = testClass.callMethod(getNumEyesMethodName, classInstance);
            _assertEquals(eyes, output,
                    "You have modified the provided " + getNumEyesMethodName + " method on the " + className + " class. Please revert it to the original state.");
            output = testClass.callMethod(setMyNameMethodName, new Object[][]{{updateName, String.class}}, classInstance);
            _assertEquals(updateName, testClass.getFieldValue(classInstance, myNameAttributeName),
                    "You have modified the provided " + setMyNameMethodName + " method on the " + className + " class. Please revert it to the original state.");
            assertNull(output,
                    "You have modified the provided " + setMyNameMethodName + " method on the " + className + " class. Please revert it to the original state.");
            output = testClass.callMethod(setNumEyesMethodName, new Object[][]{{updateEyes, int.class}}, classInstance);
            _assertEquals(updateEyes, testClass.getFieldValue(classInstance, numEyesAttributeName),
                    "You have modified the provided " + setNumEyesMethodName + " method on the " + className + " class. Please revert it to the original state.");
            assertNull(output,
                    "You have modified the provided " + setNumEyesMethodName + " method on the " + className + " class. Please revert it to the original state.");
        }
    }

    private static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of("Sarah", 0, "John", 1),
                Arguments.of("Amir", 1, "Sam", 2),
                Arguments.of("John", 0, "Jack", 0),
                Arguments.of("Sarah", 2, "John", 1),
                Arguments.of("Amir", 12, "Sam", 24),
                Arguments.of("John", 30, "Jack", 10)
        );
    }

    @Test
    public void receiveDonationIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(receiveDonationMethodName, new Class<?>[]{Person.class}), String.format(incorrectMethodDefinition, receiveDonationMethodName, className));
        assertTrue(testClass.hasModifier(receiveDonationMethodName, new Class<?>[]{Person.class}, "public"), String.format(incorrectModifierMessage, receiveDonationMethodName, className));
        assertTrue(testClass.hasReturnType(receiveDonationMethodName, new Class<?>[]{Person.class}, Void.TYPE), String.format(incorrectReturnType, receiveDonationMethodName, className));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    @Tag("dependent1")
    public void correctReceiveDonationMethod(String name, int eyes, String donName, int donEyes) throws Throwable {
        Object[][] arguments = {
                {name, String.class},
                {eyes, int.class}
        };
        Object[][] donorArguments = {
                {donName, String.class},
                {donEyes, int.class}
        };
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod(receiveDonationMethodName, new Class<?>[]{Person.class}), String.format(incorrectMethodDefinition, receiveDonationMethodName, className));
        assertTrue(testClass.hasModifier(receiveDonationMethodName, new Class<?>[]{Person.class}, "public"), String.format(incorrectModifierMessage, receiveDonationMethodName, className));
        assertTrue(testClass.hasReturnType(receiveDonationMethodName, new Class<?>[]{Person.class}, Void.TYPE), String.format(incorrectReturnType, receiveDonationMethodName, className));
        Object classInstance = testClass.createInstance(arguments);
        Object donorInstance = testClass.createInstance(donorArguments);
        Object[][] methodArguments = {
                {donorInstance, Person.class}
        };
        if (donEyes > minEyes) {
            testClass.callMethod(receiveDonationMethodName, methodArguments, new String[]{"public"}, classInstance, new Clause[]{
                    new StringLiteral("Transplant successful"),
                    new Optional(new StringLiteral(" "))
            });
            _assertEquals(eyes + eyesToTake, testClass.getFieldValue(classInstance, numEyesAttributeName),
                    "Your " + receiveDonationMethodName + " method does not correctly add the " + numEyesAttributeName + " attribute of the recipient.");
            _assertEquals(donEyes - eyesToTake, testClass.getFieldValue(donorInstance, numEyesAttributeName),
                    "Your " + receiveDonationMethodName + " method does not correctly decrease the " + numEyesAttributeName + " attribute of the donor.");
        }
        else {
            testClass.callMethod(receiveDonationMethodName, methodArguments, new String[]{"public"}, classInstance, new Clause[]{
                    new StringLiteral("Transplant cannot be done"),
                    new Optional(new StringLiteral(" "))
            });
            _assertEquals(eyes, testClass.getFieldValue(classInstance, numEyesAttributeName),
                    "Your " + receiveDonationMethodName + " method does not correctly maintain the value of the " + numEyesAttributeName + " attribute of the recipient.");
            _assertEquals(donEyes, testClass.getFieldValue(donorInstance, numEyesAttributeName),
                    "Your " + receiveDonationMethodName + " method does not correctly maintain the value of the " + numEyesAttributeName + " attribute of the donor.");
        }
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    @Tag("dependent1")
    public void personClassHasCorrectToStringMethod(String name, int eyes) throws Throwable {
        Object[][] arguments = {
                {name, String.class},
                {eyes, int.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass.hasMethod("toString", null), String.format(incorrectMethodDefinition, "toString", className));
        assertTrue(testClass.hasModifier("toString", null, "public"), String.format(incorrectModifierMessage, "toString", className));
        assertTrue(testClass.hasReturnType("toString", null, String.class), String.format(incorrectReturnType, "toString", className));
        String[] methodModifiers = {"public"};
        String expected = name + " has " + eyes + " eyes";
        String incorrectToStringMessage = String.join(" ",
                "Your", className, "toString method does not return the correct String.");
        Object output = testClass.callMethod("toString", methodModifiers, classInstance);
        _assertEquals(expected, output, incorrectToStringMessage);
    }

    @Test
    @Tag("dependency1")
    public void correctMainMethod() throws Throwable {
        Clause[] clauses = {
                new StringLiteral("Tom has 2 eyes"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Jim has 0 eyes"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Transplant successful"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Tom has 1 eyes"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("Jim has 1 eyes"),
                new Optional(new StringLiteral(" "))

        };
        Object classInstance = classObject.createInstance();
        classObject.callMethod("main", new Object[][]{{new String[0], String[].class}}, new String[]{"public"}, classInstance,
                clauses);
    }
}
