package oop.object_interactions.medium.q6;

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
    private final String className = "Airplane";
    private final String testClassName = "TestBooking";
    private final String maxSeatsAttributeName = "maxSeats";
    private final String numPassengersAttributeName = "numPassengers";
    private final String getMaxSeatsMethodName = "getMaxSeats";
    private final String setMaxSeatsMethodName = "setMaxSeats";
    private final String getNumPassengersMethodName = "getNumPassengers";
    private final String setNumPassengersMethodName = "setNumPassengers";
    private final String transferPassengersMethodName = "transferPassengers";

    @BeforeEach
    public void setup() throws Throwable {
        String classString = "oop.object_interactions.medium.q6." + className;
        String testClassString = "oop.object_interactions.medium.q6." + testClassName;
        testClass = new ObjectTest(classString);
        classObject = new ObjectTest(testClassString);
        assertTrue(testClass.hasModifier("public"),
                "You have changed the visibility modifier on the " + className + " class. Please revert it to the original state.");
        assertTrue(testClass.hasField(maxSeatsAttributeName, int.class, new String[]{"private"}),
                String.format("You have modified the provided %s attribute. Please revert it to the original state.", maxSeatsAttributeName));
        assertTrue(testClass.hasModifier(maxSeatsAttributeName, "private"),
                String.format("You have modified the provided %s attribute. Please revert it to the original state.", maxSeatsAttributeName));
        assertTrue(testClass.hasField(numPassengersAttributeName, int.class, new String[]{"private"}),
                String.format("You have modified the provided %s attribute. Please revert it to the original state.", numPassengersAttributeName));
        assertTrue(testClass.hasModifier(numPassengersAttributeName, "private"),
                String.format("You have modified the provided %s attribute. Please revert it to the original state.", numPassengersAttributeName));
        Class<?>[] classArguments = {int.class};
        assertTrue(testClass.hasConstructor(classArguments),
                "You have modified the provided constructor on the " + className + " class. Please revert it to the original state.");
        assertTrue(testClass.hasModifier(classArguments, "public"),
                "You have modified the provided constructor on the " + className + " class. Please revert it to the original state.");
        classArguments = new Class[]{int.class, int.class};
        assertTrue(testClass.hasConstructor(classArguments),
                "You have modified the provided constructor on the " + className + " class. Please revert it to the original state.");
        assertTrue(testClass.hasModifier(classArguments, "public"),
                "You have modified the provided constructor on the " + className + " class. Please revert it to the original state.");
        assertTrue(testClass.hasMethod(getMaxSeatsMethodName, null, int.class, new String[]{"public"}),
                String.format("You have modified the provided %s method method. Please revert it to the original state.", getMaxSeatsMethodName));
        assertTrue(testClass.hasMethod(setMaxSeatsMethodName, new Class<?>[]{int.class}, Void.TYPE, new String[]{"public"}),
                String.format("You have modified the provided %s method method. Please revert it to the original state.", setMaxSeatsMethodName));
        assertTrue(testClass.hasMethod(getNumPassengersMethodName, null, int.class, new String[]{"public"}),
                String.format("You have modified the provided %s method method. Please revert it to the original state.", getNumPassengersMethodName));
        assertTrue(testClass.hasMethod(setNumPassengersMethodName, new Class<?>[]{int.class}, Void.TYPE, new String[]{"public"}),
                String.format("You have modified the provided %s method method. Please revert it to the original state.", setNumPassengersMethodName));
        Object[][] test = new Object[][]{
                {20, 10, 40, 35},
                {10, 20, 15, 30},
                {150, 200, 100, 50},
                {20, 20, 10, 20}
        };
        for (int num = 0; num < test.length; num++) {
            int seat = (int) test[num][0];
            int pass = (int) test[num][1];
            Object classInstance = testClass.createInstance(new Object[][]{{seat, int.class}});
            _assertEquals(seat, testClass.getFieldValue(classInstance, maxSeatsAttributeName),
                    "You have modified the provided constructor on the " + className + " class. Please revert it to the original state.");
            _assertEquals(0, testClass.getFieldValue(classInstance, numPassengersAttributeName),
                    "You have modified the provided constructor on the " + className + " class. Please revert it to the original state.");
            Object[][] arguments = {
                    {seat, int.class},
                    {pass, int.class}
            };
            classInstance = testClass.createInstance(arguments);
            _assertEquals(seat, testClass.getFieldValue(classInstance, maxSeatsAttributeName),
                    "You have modified the provided constructor on the " + className + " class. Please revert it to the original state.");
            _assertEquals(pass, testClass.getFieldValue(classInstance, numPassengersAttributeName),
                    "You have modified the provided constructor on the " + className + " class. Please revert it to the original state.");
            int updateSeat = (int) test[num][2];
            int updatePass = (int) test[num][3];
            Object output = testClass.callMethod(getMaxSeatsMethodName, classInstance);
            _assertEquals(seat, output,
                    "You have modified the provided " + getMaxSeatsMethodName + "method  on the " + className + " class. Please revert it to the original state.");
            output = testClass.callMethod(getNumPassengersMethodName, classInstance);
            _assertEquals(pass, output,
                    "You have modified the provided " + getNumPassengersMethodName + "method  on the " + className + " class. Please revert it to the original state.");
            output = testClass.callMethod(setMaxSeatsMethodName, new Object[][]{{updateSeat, int.class}}, classInstance);
            _assertEquals(updateSeat, testClass.getFieldValue(classInstance, maxSeatsAttributeName),
                    "You have modified the provided " + setMaxSeatsMethodName + "method  on the " + className + " class. Please revert it to the original state.");
            assertNull(output, String.join(" ", "Your", setMaxSeatsMethodName, "should not return any output"));
            output = testClass.callMethod(setNumPassengersMethodName, new Object[][]{{updatePass, int.class}}, classInstance);
            _assertEquals(updatePass, testClass.getFieldValue(classInstance, numPassengersAttributeName),
                    "You have modified the provided " + setNumPassengersMethodName + "method  on the " + className + " class. Please revert it to the original state.");
            assertNull(output, String.join(" ", "Your", setNumPassengersMethodName, "should not return any output"));
        }
    }

    private static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(20, 10, 40, 35),
                Arguments.of(10, 20, 15, 30),
                Arguments.of(150, 200, 100, 50),
                Arguments.of(20, 20, 10, 20)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctTransferPassengersMethod(int seat, int pass, int busySeat, int busyPass) throws Throwable {
        Object[][] arguments = {
                {seat, int.class},
                {pass, int.class}
        };
        Airplane busy = new Airplane(busySeat, busyPass);
        Object classInstance = testClass.createInstance(arguments);
        Object[][] methodArguments = {
                {busy, Airplane.class}
        };
        Object output = null;
        if (seat - pass > 0) {
            int move = Math.min(busyPass - busySeat, seat - pass);
            output = testClass.callMethod(transferPassengersMethodName, methodArguments, new String[]{"public"}, classInstance, new Clause[]{
                    new StringLiteral("We moved " + move + " passengers"),
                    new Optional(new StringLiteral(" "))
            });
            _assertEquals(pass + move, testClass.getFieldValue(classInstance, numPassengersAttributeName),
                    "Your " + transferPassengersMethodName + " method does not correctly add the " + numPassengersAttributeName + " attribute of the recipient.");
            _assertEquals(busyPass - move, busy.getNumPassengers(),
                    "Your " + transferPassengersMethodName + " method does not correctly decrease the " + numPassengersAttributeName + " attribute of the donor.");
        } else {
            output = testClass.callMethod(transferPassengersMethodName, methodArguments, new String[]{"public"}, classInstance, new Clause[]{
                    new StringLiteral("This plane is full too and cannot accommodate anymore passengers"),
                    new Optional(new StringLiteral(" "))
            });
            _assertEquals(pass, testClass.getFieldValue(classInstance, numPassengersAttributeName),
                    "Your " + transferPassengersMethodName + " method does not correctly add the " + numPassengersAttributeName + " attribute of the recipient.");
            _assertEquals(busyPass, busy.getNumPassengers(),
                    "Your " + transferPassengersMethodName + " method does not correctly decrease the " + numPassengersAttributeName + " attribute of the donor.");
            _assertEquals(seat, testClass.getFieldValue(classInstance, maxSeatsAttributeName),
                    "Your " + transferPassengersMethodName + " method does not correctly add the " + maxSeatsAttributeName + " attribute of the recipient.");
            _assertEquals(busySeat, busy.getMaxSeats(),
                    "Your " + transferPassengersMethodName + " method does not correctly decrease the " + numPassengersAttributeName + " attribute of the donor.");
        }
        assertNull(output, String.join(" ", "Your", transferPassengersMethodName, "should not return any output"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void airplaneClassHasCorrectToStringMethod(int seat, int pass) throws Throwable {
        Object[][] arguments = {
                {seat, int.class},
                {pass, int.class}
        };
        Object classInstance = testClass.createInstance(arguments);
        String[] methodModifiers = {"public"};
        String expected = pass + " out of  " + seat + " seats are filled";
        String incorrectToStringMessage = String.join(" ",
                "Your", className, " toString method does not return the correct String.");
        Object output = testClass.callMethod("toString", methodModifiers, classInstance);
        _assertEquals(expected, output, incorrectToStringMessage);
    }

    @Test
    public void correctMainMethod() throws Throwable {
        Clause[] clauses = {
                new StringLiteral("We moved 2 passengers"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("We moved 2 passengers"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The first ride: 16 out of  12 seats are filled"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The second ride: 2 out of  6 seats are filled"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The third ride: 2 out of  4 seats are filled"),
                new Optional(new StringLiteral(" "))

        };
        Object classInstance = classObject.createInstance();
        classObject.callMethod("main", new Object[][]{{new String[0], String[].class}}, new String[]{"public"}, classInstance,
                clauses);
    }
}
