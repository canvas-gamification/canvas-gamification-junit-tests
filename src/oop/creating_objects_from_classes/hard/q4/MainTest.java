package oop.creating_objects_from_classes.hard.q4;

import global.BaseTest;
import global.MethodTest;
import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.*;
import global.variables.wrappers.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
    private final double bonusMin = 0;
    private final double bonusMax = 200; //non-inclusive
    private final String field1 = "initial";
    private final String field2 = "bonus";

    @BeforeEach
    public void setUp() {
        String bankAccountClassString = "oop.creating_objects_from_classes.hard.q4." + testSavingsName;
        testClass = new ObjectTest(bankAccountClassString);
    }

    @Test
    public void correctDogTestClass() throws Throwable {
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

        String incorrectOutput = "Your main method in the %s class does not print the correct output. Make sure that you are printing the balance.";
        Clause[] clauses = new Clause[]{
                new StringLiteral("Balance: "),
                new DoubleLiteral("num1"),
                new NewLine(),
                new StringLiteral("Balance: "),
                new DoubleLiteral("num2"),
                new Optional(new NewLine())
        };
        Object[][] mainParameters = {{new String[0], String[].class}};

        ArrayList<Double> firstRandomValues = new ArrayList<>();
        ArrayList<Double> secondRandomValues = new ArrayList<>();

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

        /* Call method and check randomness */
        for (int x = 0; x < 1500; x++) {
            MethodTest m = new MethodTest(BankAccount.class, "main", mainParameters, clauses);
            m.callMethod();
            double first = Double.parseDouble(m.getMethodItemByName("num1"));
            firstRandomValues.add(first - initial);
            secondRandomValues.add(Double.parseDouble(m.getMethodItemByName("num2")) - first);
        }

        RandomDouble randomDouble = new RandomDouble(bonusMin, bonusMax);
        assertTrue(randomDouble.validateRandom(firstRandomValues), "Your first balance is not being correctly generated. Please ensure you are setting the correct initial value.");
        assertTrue(randomDouble.validateRandom(secondRandomValues), "Your second balance is not being correctly generated. Please ensure you have called the " + method2Name + " method.");
    }
}

// On website place Savings class here
