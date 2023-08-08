package oop.special_class_method.medium.q12;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    // Java

    private final String className = "Shirt";
    private final String attributeName1 = "size";
    private final String getAttributeMethodName1 = "getSize";
    private final String attributeName2 = "yearMade";
    private final String methodName = "displaySize";
    private static final int yearPivot = 2000;
    private ObjectTest testClass;

    @BeforeEach
    public void setUp() throws Throwable {
        String classString = "oop.special_class_method.medium.q12." + className;
        this.testClass = new ObjectTest(classString);
        String modifiedClassMessage =
                "You have modified the provided portions of class " + className + " for the %s attribute. Please revert them to the original state.";
        assertTrue(testClass.hasField(attributeName1, int.class, new String[]{"private"}),
                String.format(modifiedClassMessage, attributeName1));
        assertTrue(testClass.hasField(attributeName2, int.class, new String[]{"private"}),
                String.format(modifiedClassMessage, attributeName1));
        Object[][] tests = new Object[][]{
                {3, yearPivot + 2},
                {3, yearPivot + 1},
                {10, yearPivot -50},
                {12, yearPivot + 20},
                {43, yearPivot + 3},
                {7, yearPivot - 5},
                {7, yearPivot}
        };
        for (int i = 0; i < tests.length; i++) {
            int size = (int) tests[i][0];
            int yearMade = (int) tests[i][1];
            Object[][] arguments = {
                    {size, int.class},
                    {yearMade, int.class}
            };
            Class<?>[] classes = {int.class, int.class};
            Object testInstance = testClass.createInstance(arguments);
            _assertEquals(size, testClass.getFieldValue(testInstance, attributeName1), modifiedClassMessage);
            _assertEquals(yearMade, testClass.getFieldValue(testInstance, attributeName2), modifiedClassMessage);
            assertTrue(testClass.hasModifier(classes, "public"), modifiedClassMessage);
        }
    }


    private static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(3, yearPivot + 12),
                Arguments.of(3, yearPivot + 1),
                Arguments.of(10, yearPivot - 6),
                Arguments.of(12, yearPivot - 26),
                Arguments.of(43, yearPivot + 23),
                Arguments.of(7, yearPivot)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctGetSizeMethod(int value1, int value2) throws Throwable {
        Object[][] arguments = {
                {value1, int.class},
                {value2, int.class}
        };
        Object testInstance = testClass.createInstance(arguments);
        Object getMethodOutput = testClass.callMethod(getAttributeMethodName1, testInstance);
        assertTrue(testClass.hasModifier(getAttributeMethodName1, null, "public"),
                "Your " + getAttributeMethodName1 + " method does not have the correct visibility modifier.");
        _assertEquals(value1, getMethodOutput,
                "Your " + getAttributeMethodName1 + " method does not return the value of the " + attributeName1 + " attribute.");
    }


    @ParameterizedTest
    @MethodSource("inputProvider")
    public void correctDisplaySizeMethod(int value1, int value2) throws Throwable {
        Object[][] arguments = {
                {value1, int.class},
                {value2, int.class}
        };
        Object testInstance = testClass.createInstance(arguments);
        if (value2 > 2000) {
            testClass.callMethod(methodName, testInstance, new Clause[]{
                    new StringLiteral("The size is " + value1)
            });
        } else {
            testClass.callMethod(methodName, testInstance, new Clause[]{});
        }
    }

}
