package oop.creating_objects_from_classes.hard.q4;

import global.ObjectTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    // Java

    private final String savings = "Savings";
    private final String bankAccount = "BankAccount";
    private final String methodName = "startInvestment";
    private ObjectTest savingsClass;
    private ObjectTest bankAccountClass;

    private final String initialFieldName = "initial";
    private final String bonusFieldName = "bonus";

    double initial = 200;
    double bonus = 0;

    @BeforeEach
    public void setUp() {
        String savingsClassString = "oop.creating_objects_from_classes.hard.q4." + savings;
        String bankAccountClassString = "oop.creating_objects_from_classes.hard.q4." + bankAccount;
        savingsClass = new ObjectTest(savingsClassString);
        bankAccountClass = new ObjectTest(bankAccountClassString);
    }

    @Test
    public void bankAccountClassHasStartInvestmentMethod() {
        Class<?>[] classes = {};
        assertTrue(bankAccountClass.hasMethod(methodName, classes),
                "Your " + bankAccount + " class is missing the method" + methodName + ".");
        assertTrue(bankAccountClass.hasReturnType(methodName, classes, Savings.class),
                "Your " + methodName + " method does not return the correct type.");
        assertTrue(bankAccountClass.hasModifier(methodName, classes, "public"),
                "Your " + methodName + " method does not have the correct visibility modifier.");
    }

    @Test
    public void startInvestmentMethodReturnsCorrectValue() throws Throwable {
        Object bankAccountInstance = bankAccountClass.createInstance();
        Object startInvestmentOutput = bankAccountClass.callMethod(methodName, bankAccountInstance);
        assertTrue(startInvestmentOutput instanceof Savings,
                "Your " + methodName + " method does not return the correct type.");
        _assertEquals(initial, savingsClass.getFieldValue(startInvestmentOutput, initialFieldName),
                "Your " + methodName + " method does not return the correct output.");
        _assertEquals(bonus, savingsClass.getFieldValue(startInvestmentOutput, bonusFieldName),
                "Your " + methodName + " method does not return the correct output.");
    }
}
