package oop.creating_objects_from_classes.hard.q5;

import global.ObjectTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    private final String methodName = "makeBalls";

    private ObjectTest basketballClass;
    private ObjectTest sportsRoomClass;

    @BeforeEach
    public void setUp() {
        String petClassString = "oop.creating_objects_from_classes.hard.q5." + basketballClass;
        String animalClassString = "oop.creating_objects_from_classes.hard.q5." + sportsRoomClass;
        basketballClass = new ObjectTest(petClassString);
        sportsRoomClass = new ObjectTest(animalClassString);
    }

    @Test
    public void sportsRoomClassHasMakeBallsMethod() {
        Class<?>[] classes = {double[].class};
        assertTrue(sportsRoomClass.hasMethod(methodName, classes),
                "Your " + basketballClass + " class is missing the method" + methodName + ".");
        assertTrue(sportsRoomClass.hasReturnType(methodName, classes, Basketball[].class),
                "Your " + methodName + " method does not return the correct type.");
        assertTrue(basketballClass.hasModifier(methodName, classes, "public"),
                "Your " + methodName + " method does not have the correct visibility modifier.");
    }

    private static Stream<double[]> sizesInputProvider() {
        return Stream.of(new double[]{2.3, 2.4, 5.6, 7.8},
                new double[]{2.3, 2.4, 5.6, 7.8, 10.3, 7.6},
                new double[]{2.3, 3.3, 5.6, 7.8, 12.4},
                new double[]{2.3, 2.4, 5.6, 7.8, 10.4, 3.5},
                new double[]{2.3, 2.8, 5.6, 10.2, 30.2}
        );
    }

    @ParameterizedTest
    @MethodSource("sizesInputProvider")
    public void makeBallsMethodReturnCorrectValue() {

    }
}
