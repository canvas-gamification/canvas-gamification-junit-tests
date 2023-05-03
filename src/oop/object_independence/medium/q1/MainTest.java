package oop.object_independence.medium.q1;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
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
    private final String bankClassName = "BankAccount";
    private final String testClassName = "TestAccount";
    private ObjectTest bankAccount;
    private ObjectTest testAccount;
    private final String doubleFieldName = "currentBalance";
    private final String longFieldName = "accountNumber";
    private final String depositMethodName = "deposit";
    private final String withdrawMethodName = "withdraw";
    private final String listBalanceMethodName = "listBalance";
    private final int accountNumber1 = 123456789;
    private final int accountNumber2 = 123456790;
    private final double accountBalance1 = 100.0;
    private final double accountBalance2 = 400.0;

    @Test
    public void correctTestAccountClass() throws Throwable {
        Clause[] c = new Clause[]{
                new StringLiteral("Account No\\. "),
                new IntegerLiteral(accountNumber1, "accountNumber1"),
                new StringLiteral(" currently has a balance of \\$"),
                new DoubleLiteral(accountBalance1, accountBalance1, "accountBalance1"),
                new NewLine(),
                new StringLiteral("Account No\\. "),
                new IntegerLiteral(accountNumber2, "accountNumber2"),
                new StringLiteral(" currently has a balance of \\$"),
                new DoubleLiteral(accountBalance2, accountBalance2, "accountBalance2"),
        };
        Object[][] arguments = {
                {new String[0], String[].class}
        };
        String incorrectMethodOutputMessage = "Your main method in the " + testClassName + " class does not print the correct output for the two bank accounts.";
        testAccount.callMethod("main", arguments, c, incorrectMethodOutputMessage);
    }

    public void runMain() {
        TestAccount.main(new String[0]);
    }

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
        double expectedAmount = withdrawAmount > 500.00 ? 500.00 : 500.00 - withdrawAmount;
        _assertEquals(expectedAmount, bankAccount.getFieldValue(bankAccountInstance, doubleFieldName),
                "Your " + withdrawMethodName + " method does not correctly update the " + doubleFieldName + " field based on the withdraw amount.");
    }

    @ParameterizedTest
    @MethodSource("bankAccountInputProvider")
    public void bankAccountHasCorrectListBalanceMethod(double amount, long accountNum) throws Throwable {
        Object[][] constructorArguments = {
                {amount, double.class},
                {accountNum, long.class}
        };
        Object accountInstance = bankAccount.createInstance(constructorArguments);
        // "Account No. " + accountNumber + " currently has a balance of $" + currentBalance
        Clause[] listBalanceOutput = {
                new StringLiteral("Account No\\. "),
                new IntegerLiteral((int) accountNum),
                new StringLiteral(" currently has a balance of \\$"),
                new DoubleLiteral(amount, amount),
                new NewLine()
        };
        String incorrectPrintOutput =
                "Your " + listBalanceMethodName + " method does not correctly print the account number and balance.";
        bankAccount.callMethod("listBalance", accountInstance, listBalanceOutput, incorrectPrintOutput);
    }
}
