package oop.user_defined_classes.medium.q1;

import global.ObjectTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainTest {
    // Parsons with distractors

    private final String className = "Circle";
    private final String intFieldName = "position";
    private final String stringFieldName = "colour";
    private ObjectTest classInstance;

    @BeforeEach
    public void setUp() {
        String classString = "oop.user_defined_classes.medium.q1" + className;
        classInstance = new ObjectTest(classString);
    }

    @Test
    public void circleClassHasCorrectFields() {

    }
}
