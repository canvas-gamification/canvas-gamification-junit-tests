package oop.creating_objects_from_classes.hard.q3;

import global.ObjectTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    // Java

    private ObjectTest testTomato;
    private final String testClass = "TomatoTest";
    private final String methodName = "produceSeed";
    private final String objectName = "Tomato";
    private final String type = "type";
    private final String nickname = "nickname";
    private final String[] t1ExpectedValues = {null, null};
    private final String[] t2ExpectedValues = {"cherry", null};
    private final String[] t3ExpectedValues = {"plum", "Sherry"};
    private final String[] t4ExpectedValues = {"cherry", "Delilah"};

    @BeforeEach
    public void setUp() {
        String tomatoClassString = "oop.creating_objects_from_classes.hard.q3." + testClass;
        testTomato = new ObjectTest(tomatoClassString);
    }

    @Test
    public void correctTomatoTestClass() throws Throwable {
        String missingMain = "Your %s class is missing the %s method. Make sure it has been declared, it is spelt correctly, and has the correct parameters.";
        String incorrectVisibility = "Your main method does not have the correct visibility modifier.";
        String missingStatic = "Your main method is missing the static modifier.";
        String wrongReturnType = "Your main method does not have the correct return type.";
        Class<?>[] mainArgs = new Class[]{String[].class};
        /* Check Method Definitions */
        assertTrue(testTomato.hasMethod("main", mainArgs), String.format(missingMain, testClass, "main"));
        assertTrue(testTomato.hasModifier("main", mainArgs, "public"), incorrectVisibility);
        assertTrue(testTomato.hasModifier("main", mainArgs, "static"), missingStatic);
        assertTrue(testTomato.hasReturnType("main", mainArgs, Void.TYPE), wrongReturnType);

        Object[][] mainParameters = {{new String[0], String[].class}};
        testTomato.callMethod("main", mainParameters);

        /* Check that the constructor was called and with the correct values */
        String noConstructorCall = "Your main method did not initialize the %s %s object.";
        String incorrectValue = "Your main method did not initialize the %s %s with the correct %s value.";

        assertTrue(Tomato.isConstructor1Called(), String.format(noConstructorCall, "first", objectName));
        assertEquals(t1ExpectedValues[0], Tomato.getTomato1().getType(), String.format(incorrectValue, "first", objectName, type));
        assertEquals(t1ExpectedValues[1], Tomato.getTomato1().getNickname(), String.format(incorrectValue, "first", objectName, nickname));

        assertTrue(Tomato.isConstructor2Called(), String.format(noConstructorCall, "second", objectName));
        assertEquals(t2ExpectedValues[0], Tomato.getTomato2().getType(), String.format(incorrectValue, "second", objectName, type));
        assertEquals(t2ExpectedValues[1], Tomato.getTomato2().getNickname(), String.format(incorrectValue, "second", objectName, nickname));

        assertTrue(Tomato.isConstructor3Called(), String.format(noConstructorCall, "third", objectName));
        assertEquals(t3ExpectedValues[0], Tomato.getTomato3().getType(), String.format(incorrectValue, "third", objectName, type));
        assertEquals(t3ExpectedValues[1], Tomato.getTomato3().getNickname(), String.format(incorrectValue, "third", objectName, nickname));

        assertTrue(Tomato.isMethodCalled(), String.format(noConstructorCall, "fourth", objectName));
        assertEquals(t4ExpectedValues[0], Tomato.getTomato4().getType(), String.format(incorrectValue, "fourth", objectName, type));
        assertEquals(t4ExpectedValues[1], Tomato.getTomato4().getNickname(), String.format(incorrectValue, "fourth", objectName, nickname));
    }
}

// On website place Tomato class here
