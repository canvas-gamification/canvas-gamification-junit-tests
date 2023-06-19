package oop.object_interactions.medium.q5;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
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
    private static final int minBlood = 5;

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
        assertTrue(testClass.hasModifier(myNameAttributeName, "private"),
                String.format("You have modified the provided %s attribute. Please revert it to the original state.", myNameAttributeName));
        assertTrue(testClass.hasField(numEyesAttributeName, int.class, new String[]{"private"}),
                String.format("You have modified the provided %s attribute. Please revert it to the original state.", numEyesAttributeName));
        assertTrue(testClass.hasModifier(numEyesAttributeName, "private"),
                String.format("You have modified the provided %s attribute. Please revert it to the original state.", numEyesAttributeName));
        Class<?>[] classArguments = {String.class, int.class};
        assertTrue(testClass.hasConstructor(classArguments),
                "You have modified the provided constructor on the " + className + " class. Please revert it to the original state.");
        assertTrue(testClass.hasModifier(classArguments, "public"),
                "You have modified the provided constructor on the " + className + " class. Please revert it to the original state.");
        assertTrue(testClass.hasMethod(getMyNameMethodName, null, String.class, new String[]{"public"}),
                String.format("You have modified the provided %s method method. Please revert it to the original state.", getMyNameMethodName));
        assertTrue(testClass.hasMethod(setMyNameMethodName, new Class<?>[]{String.class}, Void.TYPE, new String[]{"public"}),
                String.format("You have modified the provided %s method method. Please revert it to the original state.", setMyNameMethodName));
        assertTrue(testClass.hasMethod(getNumEyesMethodName, null, int.class, new String[]{"public"}),
                String.format("You have modified the provided %s method method. Please revert it to the original state.", getNumEyesMethodName));
        assertTrue(testClass.hasMethod(setNumEyesMethodName, new Class<?>[]{int.class}, Void.TYPE, new String[]{"public"}),
                String.format("You have modified the provided %s method method. Please revert it to the original state.", setNumEyesMethodName));
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
                    "You have modified the provided " + getMyNameMethodName + "method  on the " + className + " class. Please revert it to the original state.");
            output = testClass.callMethod(getNumEyesMethodName, classInstance);
            _assertEquals(eyes, output,
                    "You have modified the provided " + getNumEyesMethodName + "method  on the " + className + " class. Please revert it to the original state.");
            output = testClass.callMethod(setMyNameMethodName, new Object[][]{{updateName, String.class}}, classInstance);
            _assertEquals(updateName, testClass.getFieldValue(classInstance, myNameAttributeName),
                    "You have modified the provided " + setMyNameMethodName + "method  on the " + className + " class. Please revert it to the original state.");
            assertNull(output, String.join(" ", "Your", setMyNameMethodName, "should not return any output"));
            output = testClass.callMethod(setNumEyesMethodName, new Object[][]{{updateEyes, int.class}}, classInstance);
            _assertEquals(updateEyes, testClass.getFieldValue(classInstance, numEyesAttributeName),
                    "You have modified the provided " + setNumEyesMethodName + "method  on the " + className + " class. Please revert it to the original state.");
            assertNull(output, String.join(" ", "Your", setNumEyesMethodName, "should not return any output"));
        }
    }

    private static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of("Sarah", 0, "John", 1),
                Arguments.of("Amir", 1, "Sam", 2),
                Arguments.of("John", 0, "Jack", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctReceiveDonationMethod(String name, int eyes, String donName, int donEyes) throws Throwable {
        Object[][] arguments = {
                {name, String.class},
                {eyes, int.class}
        };
        Person donor = new Person(donName, donEyes);
        Object classInstance = testClass.createInstance(arguments);
        Object[][] methodArguments = {
                {donor, Person.class}
        };
        Object output = null;
        if (donEyes > 0) {
            output = testClass.callMethod(receiveDonationMethodName, methodArguments, new String[]{"public"}, classInstance, new Clause[]{
                    new StringLiteral("Transplant successful"),
                    new Optional(new StringLiteral(" "))
            });
            _assertEquals(eyes + 1, testClass.getFieldValue(classInstance, numEyesAttributeName),
                    "Your " + receiveDonationMethodName + " method does not correctly add the " + numEyesAttributeName + " attribute of the recipient.");
            _assertEquals(donEyes - 1, donor.getNumEyes(),
                    "Your " + receiveDonationMethodName + " method does not correctly decrease the " + numEyesAttributeName + " attribute of the donor.");
        }
        assertNull(output, String.join(" ", "Your", receiveDonationMethodName, "should not return any output"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void personClassHasCorrectToStringMethod(String name, int eyes) throws Throwable {
        Object[][] arguments = {
                {name, String.class},
                {eyes, int.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String[] methodModifiers = {"public"};
        String expected = name + " has " + eyes + " eyes";
        String incorrectToStringMessage = String.join(" ",
                "Your", className, " toString method does not return the correct String.");
        Object output = testClass.callMethod("toString", methodModifiers, classInstance);
        _assertEquals(expected, output, incorrectToStringMessage);
    }

    @Test
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
