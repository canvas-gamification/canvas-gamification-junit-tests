package oop.programs_with_interesting_classes.easy.q3;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static global.tools.CustomAssertions._assertEquals;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    private final String checkupClassName = "AnnualCheckup";
    private ObjectTest checkup;
    private final String remindMethodName = "remindMe";
    private final String patientAttributeName = "patient";
    private final String daysAttributeName = "numDays";

    @BeforeEach
    public void setUp() {
        String packageString = "oop.programs_with_interesting_classes.easy.q3." + checkupClassName;
        checkup = new ObjectTest(packageString);
    }

    @Test
    public void annualCheckupHasRequiredAttributes() {
        String missingAttributeMessage = "The %s class is missing the %s attribute. Make sure that the class contains the field and it is spelt correctly.";
        String wrongTypeMessage = "The %s attribute in the %s class has the wrong type.";
        String wrongModifierMessage = "The %s attribute in the %s class has the wrong visibility modifier.";
        assertTrue(checkup.hasField(patientAttributeName), String.format(missingAttributeMessage, checkupClassName, patientAttributeName));
        assertTrue(checkup.hasField(patientAttributeName, String.class), String.format(wrongTypeMessage, patientAttributeName, checkupClassName));
        assertTrue(checkup.hasModifier(patientAttributeName, "private"), String.format(wrongModifierMessage, patientAttributeName, checkupClassName));
        assertTrue(checkup.hasField(daysAttributeName), String.format(missingAttributeMessage, checkupClassName, daysAttributeName));
        assertTrue(checkup.hasField(daysAttributeName, int.class), String.format(wrongTypeMessage, daysAttributeName, checkupClassName));
        assertTrue(checkup.hasModifier(daysAttributeName, "private"), String.format(wrongModifierMessage, daysAttributeName, checkupClassName));
    }

    @Test
    public void annualCheckupHasRequiredConstructor() {
        String missingConstructorMessage = "The %s class is missing a required constructor. Make sure that it is named correctly and has the correct parameters.";
        String wrongAccessModifier = "The %s class constructor has the wrong visibility modifier. Make sure that it is visible from all other classes.";
        Class<?>[] constructorArgs = new Class[]{String.class, int.class};
        assertTrue(checkup.hasConstructor(constructorArgs), String.format(missingConstructorMessage, checkupClassName));
        assertTrue(checkup.hasModifier(constructorArgs, "public"), String.format(wrongAccessModifier, checkupClassName));
    }

    private static Stream<Arguments> checkupInputProvider() {
        return Stream.of(

        );
    }

    @ParameterizedTest
    @MethodSource("checkupInputProvider")
    public void annualCheckupConstructorInitializesValuesCorrectly(String name, int numDays) throws Throwable {
        String wrongValueMessage = "The %s constructor did not initialize the %s attribute to the correct value based on the parameters passed to the constructor.";
        Object[][] constructorArgs = {{name, String.class}, {numDays, int.class}};
        Object checkupInstance = checkup.createInstance(constructorArgs);
        _assertEquals(name, checkup.getFieldValue(checkupInstance, patientAttributeName), String.format(wrongValueMessage, checkupClassName, patientAttributeName));
        _assertEquals(numDays, checkup.getFieldValue(checkupInstance, daysAttributeName), String.format(wrongValueMessage, checkupClassName, daysAttributeName));
    }

    @Test
    public void remindMeMethodIsDefinedCorrectly() {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        assertTrue(checkup.hasMethod(remindMethodName, null), String.format(incorrectMethodDefinition, remindMethodName, checkupClassName));
        assertTrue(checkup.hasModifier(remindMethodName, null, "public"), String.format(incorrectModifierMessage, remindMethodName, checkupClassName));
    }

    @ParameterizedTest
    @MethodSource("checkupInputProvider")
    public void remindMeMethodProducesCorrectOutput(String name, int numDays) throws Throwable {
        Object[][] constructorArgs = {{name, String.class}, {numDays, int.class}};
        Object checkupInstance = checkup.createInstance(constructorArgs);
        Clause[] clauses;
        int expectedNumDays = 0;
        if (numDays >= 365) {
            clauses = new Clause[]{
                new StringLiteral(String.format("Patient %s is due for a checkup\\.", name))
            };
        } else {
            expectedNumDays = numDays + 1;
            clauses = new Clause[]{
                    new StringLiteral(String.format("%s still has ")),
                    new IntegerLiteral("days"),
                    new StringLiteral(" day\\(s\\) until the checkup is due\\.")
            };
        }
    }
}
