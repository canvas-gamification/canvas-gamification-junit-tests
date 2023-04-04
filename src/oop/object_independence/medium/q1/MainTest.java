package oop.object_independence.medium.q1;

import global.ObjectTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    // Parsons question
    final String bankClassName = "BankAccount";
    final String testClassName = "TestAccount";
    ObjectTest bankAccount;
    ObjectTest testAccount;
    final String doubleFieldName = "currentBalance";
    final String longFieldName = "accountNumber";
    final String depositMethodName = "deposit";
    final String withdrawMethodName = "withdraw";
    final String listBalanceMethodName = "listBalance";

    @BeforeEach
    public void setUp() {
        String bankString = "oop.object_independence.medium.q1." + bankClassName;
        String testClassString = "oop.object_independence.medium.q1." + testClassName;
        bankAccount = new ObjectTest(bankString);
        testAccount = new ObjectTest(testClassString);
    }

    // Field Tests
    @Test
    public void bankAccountClassHasRequiredFields() {
        assertTrue(bankAccount.hasField(doubleFieldName, double.class, new String[]{"private"}),
                "Your " + bankClassName + " class is missing a required field.");
        assertTrue(bankAccount.hasField(longFieldName, long.class, new String[]{"private"}),
                "Your " + bankClassName + " class is missing a required field.");
    }

    // Constructor Tests
    private static Stream<Arguments> bankAccountInputProvider() {
        return Stream.of(
                Arguments.of(65412.52, 1564888552),
                Arguments.of(0.0, 0),
                Arguments.of(6565422.2215554, 986554321),
                Arguments.of(8, 7)
        );
    }

    @ParameterizedTest
    @MethodSource("bankAccountInputProvider")
    public void bankAccountClassHasCorrectConstructor(double accountBalance, long accountNumber) throws Throwable {
        Object[][] arguments = {
                {accountBalance, double.class},
                {accountNumber, long.class}
        };
        Class<?>[] constructorClasses = {double.class, long.class};
        assertTrue(bankAccount.hasConstructor(constructorClasses, new String[]{"public"}),
                "Your " + bankClassName + " class is missing a required constructor.");
        Object bankAccountInstance = bankAccount.createInstance(arguments);
        _assertEquals(accountBalance, bankAccount.getFieldValue(bankAccountInstance, doubleFieldName),
                "Your " + bankClassName + " constructor does not correctly initialize the " + doubleFieldName + " field.");
        _assertEquals(accountNumber, bankAccount.getFieldValue(bankAccountInstance, longFieldName),
                "Your " + bankClassName + " constructor does not correctly initialize the " + longFieldName + " field.");
    }

    private static Stream<Double> depositInputProvider() {
        return Stream.of(
                615.02, 89.00, 0.001, 1.99, 0.0
        );
    }

    // Method tests
    @ParameterizedTest
    @MethodSource("depositInputProvider")
    public void bankAccountHasCorrectDepositMethod(double depositAmount) throws Throwable {
        Object[][] constructorArguments = {
                {500.00, double.class},
                {123456789, long.class}
        };
        Object bankAccountInstance = bankAccount.createInstance(constructorArguments);
        Object[][] depositArguments = {
                {depositAmount, double.class}
        };
        String[] depositModifiers = {"public"};
        Object output = bankAccount.callMethod(depositMethodName, depositArguments, depositModifiers, bankAccountInstance);
        assertNull(output, "Your " + depositMethodName + " method does not have the correct return type.");
        _assertEquals(depositAmount + 500.00, bankAccount.getFieldValue(bankAccountInstance, doubleFieldName),
                "Your " + depositMethodName + " method does not correctly update the " + doubleFieldName + " field based on the deposit amount.");
    }

    private static Stream<Double> withdrawInputProvider() {
        return Stream.of(
                0.0, 500.00, 500.01, 499.00, 456.21, 0.99, 1.18
        );
    }

    @ParameterizedTest
    @MethodSource("withdrawInputProvider")
    public void bankAccountHasCorrectWithdrawMethod(double withdrawAmount) throws Throwable {
        Object[][] constructorArguments = {
                {500.00, double.class},
                {55556, long.class}
        };
        Object bankAccountInstance = bankAccount.createInstance(constructorArguments);
        Object[][] withdrawArguments = {
                {withdrawAmount, double.class}
        };
        String[] depositModifiers = {"public"};
        Object output = bankAccount.callMethod(withdrawMethodName, withdrawArguments, depositModifiers, bankAccountInstance);
        assertNull(output, "Your " + withdrawMethodName + " method does not have the correct return type.");
        double expectedAmount = withdrawAmount > 500.00 ? 500.00: 500.00 - withdrawAmount;
        _assertEquals(expectedAmount, bankAccount.getFieldValue(bankAccountInstance, doubleFieldName),
                "Your " + withdrawMethodName + " method does not correctly update the " + doubleFieldName + " field based on the withdraw amount.");
    }
}
