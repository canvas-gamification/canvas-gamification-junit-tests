package oop.creating_objects_from_classes.hard.q4;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.*;
import global.variables.wrappers.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    // Java

    private final String savingsName = "Savings";
    private final String testSavingsName = "BankAccount";
    private final String method1Name = "getTotal";
    private final String method2Name = "receiveBonus";
    private ObjectTest testClass;
    private final double initial = 500.32;
    private final String field1 = "initial";
    public static double firstBonus = Math.random()*200;
    public static double secondBonus = Math.random()*200;

    @BeforeEach
    public void setUp() {
        String bankAccountClassString = "oop.creating_objects_from_classes.hard.q4." + testSavingsName;
        testClass = new ObjectTest(bankAccountClassString);
    }

    @Test
    public void correctBankAccountClass() throws Throwable {
        String missingMain = "Your %s class is missing the %s method. Make sure it has been declared, it is spelt correctly, and has the correct parameters.";
        String incorrectVisibility = "Your main method does not have the correct visibility modifier.";
        String missingStatic = "Your main method is missing the static modifier.";
        String wrongReturnType = "Your main method does not have the correct return type.";
        Class<?>[] mainArgs = new Class[]{String[].class};
        /* Check Method Definitions */
        assertTrue(testClass.hasMethod("main", mainArgs), String.format(missingMain, testSavingsName, "main"));
        assertTrue(testClass.hasModifier("main", mainArgs, "public"), incorrectVisibility);
        assertTrue(testClass.hasModifier("main", mainArgs, "static"), missingStatic);
        assertTrue(testClass.hasReturnType("main", mainArgs, Void.TYPE), wrongReturnType);

        String incorrectOutput = "Your main method in the %s class does not print the correct output. Make sure that you are printing the balance and calling all required methods.";
        Clause[] clauses = new Clause[]{
                new StringLiteral("Balance: "),
                new DoubleLiteral(initial + firstBonus, initial + firstBonus + 0.00001),
                new NewLine(),
                new StringLiteral("Balance: "),
                new DoubleLiteral(initial + firstBonus + secondBonus, initial + firstBonus + secondBonus + 0.00001),
                new Optional(new NewLine())
        };
        Object[][] mainParameters = {{new String[0], String[].class}};

        testClass.callMethod("main", mainParameters, clauses, String.format(incorrectOutput, testSavingsName));

        /* Check that the constructor was called and with the correct values */
        String noConstructorCall = "Your main method did not initialize a %s object.";
        String incorrectValue = "Your main method did not initialize a %s with the correct %s value.";
        assertTrue(Savings.isConstructorCalled(), String.format(noConstructorCall, savingsName));
        assertEquals(initial, Savings.getConstructorInitial(), String.format(incorrectValue, savingsName, field1));

        /* Check that methods were called */
        String methodNotCalled = "Your main method did not call the %s method%s.";
        assertTrue(Savings.isGetTotalCalled(), String.format(methodNotCalled, method1Name, ""));
        assertTrue(Savings.isGetTotalCalledTwice(), String.format(methodNotCalled, method1Name, " a second time"));
        assertTrue(Savings.isRecieveBonusCalled(), String.format(methodNotCalled, method2Name, ""));
    }

    public static double getRandomishBonus(){
        if (!Savings.isRecieveBonusCalled()){
            return firstBonus;
        }
        return secondBonus;
    }
}

// On website place Savings class here
