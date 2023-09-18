package oop.static_modifier.medium.q1;

import global.ObjectTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    ObjectTest circle;
    String circleName = "Circle";
    String countField = "counter";
    String attributeName = "radius";
    String getMethodName = "getCounter";

    @BeforeEach
    public void setup() {
        String circleString = "oop.static_modifier.medium.q1." + circleName;
        circle = new ObjectTest(circleString);
    }

    @Test
    public void circleClassHasRequiredAttributes() {
        assertTrue(circle.hasField(attributeName, double.class, new String[]{"private"}),
                String.format("Your %s class is missing the %s field. Please make sure that is is spelt correctly, has the correct type, and has the correct visibility modifier.", circleName, attributeName));
        assertTrue(circle.hasField(countField, int.class),
                String.format("Your %s class is missing the %s field. Please make sure that is is spelt correctly and has the correct type.", circleName, countField));
        assertTrue(circle.hasModifier(countField, "private"),
                "Your %s field does not have the correct visibility modifier.");
        assertTrue(circle.hasModifier(countField, "static"),
                "Your %s field is missing the static modifier.");
    }

    @RepeatedTest(3)
    public void circleClassHasCorrectConstructor() throws Throwable {
        double radius = Math.random() * 100.00;
        Object[][] arguments = {{radius, double.class}};
        Object circleInstance = circle.createInstance(arguments);
        _assertEquals(radius, circle.getFieldValue(circleInstance, attributeName),
                String.format("Your %s constructor does not initialize the %s attribute to the passed value.", circleName, attributeName));
    }

    private static Stream<Arguments> countInputProvider() {
        return Stream.of(
                Arguments.of(0.0, 67),
                Arguments.of(234.322, 11),
                Arguments.of(1.2241, 0),
                Arguments.of(132.232, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("countInputProvider")
    public void circleClassTracksCountCorrectly(double radius, int numCircles) throws Throwable {
        circle.setFieldValue(null, 0, countField);
        Object[][] initialCircleArguments = {{radius, double.class}};
        for (int i = 0; i < numCircles; i++)
            circle.createInstance(initialCircleArguments);
        _assertEquals(numCircles, circle.getFieldValue(null, countField),
                String.format("Your %s attribute does not increment for each %s created.", countField, circleName));
    }

    @RepeatedTest(4)
    public void circleClassHasCorrectGetCounterMethod() throws Throwable{
        circle.setFieldValue(null, 0, countField);
        String missingMethodMessage =
                "Your %s class is missing the %s method. Make sure that the method name is spelt correctly, has the " +
                        "correct parameters, returns the correct type, and has the correct visibility modifier.";
        assertTrue(circle.hasMethod(getMethodName, null, int.class, new String[]{"public"}),
                String.format(missingMethodMessage, circleName, getMethodName));
        int numCircles = (int) Math.round((Math.random() * 50) + 9);
        Object[][] initialCircleArguments = {{Math.PI, double.class}};
        for (int i = 0; i < numCircles; i++)
            circle.createInstance(initialCircleArguments);
        _assertEquals(numCircles, circle.callMethod(getMethodName),
                String.format("Your %s method does not return the correct value of the %s attribute.", getMethodName, countField));
    }
}
