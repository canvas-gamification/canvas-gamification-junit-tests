package oop.creating_objects_from_classes.hard.q1;

import global.ObjectTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    private final String pet = "pet";
    private final String animalType = "dog";
    private ObjectTest petClass;
    private ObjectTest animalClass;

    @BeforeEach
    public void setUp() {
        String petClassString = "oop.creating_objects_from_classes.hard.q1." + pet;
        String animalClassString = "oop.creating_objects_from_classes.hard.q1." + animalType;
        petClass =  new ObjectTest(petClassString);
    }

    private static Stream<String> petNameInputProvider() {
        return Stream.of("Carl", "John", "Joseph P Josephson", "Georgia", "Hailey");
    }

    @ParameterizedTest
    @MethodSource("petNameInputProvider")
    public void petClassHasCorrectMakePetMethod() throws Throwable {
        Object petInstance = petClass.createInstance();
        Class<?>[] classes = {String.class};
        assertTrue(petClass.hasMethod("makePet", classes), );
    }
}
