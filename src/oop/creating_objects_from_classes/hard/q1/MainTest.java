package oop.creating_objects_from_classes.hard.q1;

import global.ObjectTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    // Java

    private final String pet = "Pet";
    private final String animalType = "Dog";
    private final String methodName = "makePet";
    private final String animalStringFieldName = "name";
    private ObjectTest petClass;
    private ObjectTest animalClass;

    @BeforeEach
    public void setUp() {
        String petClassString = "oop.creating_objects_from_classes.hard.q1." + pet;
        String animalClassString = "oop.creating_objects_from_classes.hard.q1." + animalType;
        petClass = new ObjectTest(petClassString);
        animalClass = new ObjectTest(animalClassString);
    }

    @Test
    public void petClassHasMakePetMethod() {
        Class<?>[] classes = {String.class};
        assertTrue(petClass.hasMethod(methodName, classes),
                "Your " + pet + " class is missing the method " + methodName + ".");
        assertTrue(petClass.hasReturnType(methodName, classes, Dog.class),
                "Your " + methodName + " method does not return the correct type.");
        assertTrue(petClass.hasModifier(methodName,  classes, "public"),
                "Your " + methodName + " method does not have the correct visibility modifier.");
    }

    private static Stream<String> petNameInputProvider() {
        return Stream.of("Carl", "John", "Joseph P Josephson", "Georgia", "Hailey");
    }

    @ParameterizedTest
    @MethodSource("petNameInputProvider")
    public void makePetClassReturnsCorrectValue(String name) throws Throwable {
        Object petInstance = petClass.createInstance();
        Object[][] arguments = {
                {name, String.class}
        };
        Object makePetOutput = petClass.callMethod(methodName, arguments, petInstance);
        assertTrue(makePetOutput instanceof Dog, "Your " + methodName + " method does not return the correct type.");
        _assertEquals(name, animalClass.getFieldValue(makePetOutput, animalStringFieldName),
                "Your " + methodName + " method does not return the correct output.");
    }
}
