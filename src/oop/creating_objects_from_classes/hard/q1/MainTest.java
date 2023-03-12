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
    private final String pet = "Pet";
    private final String animalType = "Dog";
    private final String methodName = "makePet";
    private ObjectTest petClass;

    @BeforeEach
    public void setUp() {
        String petClassString = "oop.creating_objects_from_classes.hard.q1." + pet;
        petClass = new ObjectTest(petClassString);
    }

    @Test
    public void petClassHasMakePetMethod() {
        Class<?>[] classes = {String.class};
        assertTrue(petClass.hasMethod("makePet", classes),
                "Your " + pet + " class is missing the method" + methodName + ".");
        assertTrue(petClass.hasReturnType("makePet", classes, Dog.class),
                "Your " + methodName + " method does not have the correct return type.");
        assertTrue(petClass.hasModifier("makePet",  classes, "public"),
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
        Object makePetOutput = petClass.callMethod("makePet", arguments, petInstance);
        Dog expectedOutput = new Dog(name);
        _assertEquals(expectedOutput, makePetOutput,
                "Your makePet method does not return the correct output.");
    }
}
