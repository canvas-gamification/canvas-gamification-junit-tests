package oop.creating_objects_from_classes.hard.q2;

import global.ObjectTest;
import oop.creating_objects_from_classes.hard.q1.Dog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    // Java

    private final String summerFun = "SummerFun";
    private final String waterToy = "WaterToy";
    private final String methodName = "inflateToy";
    private final String waterToyStringFieldName1 = "id";
    private final String waterToyStringFieldName2 = "size";
    private ObjectTest summerFunClass;
    private ObjectTest waterToyClass;

    @BeforeEach
    public void setUp() {
        String summerFunClassString = "oop.creating_objects_from_classes.hard.q2." + summerFun;
        String waterToyClassString = "oop.creating_objects_from_classes.hard.q2." + waterToy;
        summerFunClass = new ObjectTest(summerFunClassString);
        waterToyClass = new ObjectTest(waterToyClassString);
    }

    @Test
    public void summerFunClassHasInflateToyMethod() {
        Class<?>[] classes = {String.class};
        assertTrue(summerFunClass.hasMethod(methodName, classes),
                "Your " + summerFun + " class is missing the method " + methodName + ".");
        assertTrue(summerFunClass.hasReturnType(methodName, classes, Dog.class),
                "Your " + methodName + " method does not return the correct type.");
        assertTrue(summerFunClass.hasModifier(methodName, classes, "public"),
                "Your " + methodName + " method does not have the correct visibility modifier.");
    }

    private static Stream<Arguments> waterToyInputProvider() {
        return Stream.of(
                Arguments.of(1, 43.0),
                Arguments.of(2, 66.5),
                Arguments.of(2, 100010.0292),
                Arguments.of(2, -9292.992),
                Arguments.of(1, 92.99292)
        );
    }

    @ParameterizedTest
    @MethodSource("waterToyInputProvider")
    public void summerFunClassReturnsCorrectValue(int id, double size) throws Throwable {
        Object summerFunInstance = summerFunClass.createInstance();
        Object[][] arguments = {
                {id, int.class},
                {size, double.class}
        };
        Object inflateToyOutput = summerFunClass.callMethod(methodName, arguments, summerFunInstance);
        assertTrue(inflateToyOutput instanceof Dog, "Your " + methodName + " method does not return the correct type.");
        _assertEquals(id, waterToyClass.getFieldValue(inflateToyOutput, waterToyStringFieldName1),
                "Your " + methodName + " method does not return the correct output.");
        _assertEquals(size, waterToyClass.getFieldValue(inflateToyOutput, waterToyStringFieldName2),
                "Your " + methodName + " method does not return the correct output.");
    }

}
