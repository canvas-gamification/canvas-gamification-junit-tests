package oop.user_defined_classes.medium.q7;

import global.ObjectTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    // Java
    private final String className = "Highway";
    private final String var1 = "speedLimit";
    private final String var2 = "fine";
    private final String methodName = "issueTicket";
    private static final int initialFee = 250;

    private ObjectTest classInstance;

    @BeforeEach
    public void setUp() throws Throwable {
        String classString = "oop.user_defined_classes.medium.q7." + className;
        classInstance = new ObjectTest(classString);
        String modifiedClassMessage =
                "You have modified the provided portions of class " + className + ". Please revert them to the original state.";
        assertTrue(classInstance.hasField(var1, int.class), modifiedClassMessage);
        assertTrue(classInstance.hasModifier(var1, "private"), modifiedClassMessage);
        assertTrue(classInstance.hasField(var2, int.class), modifiedClassMessage);
        assertTrue(classInstance.hasModifier(var2, "private"), modifiedClassMessage);
        Class<?>[] classArguments = {int.class};
        assertTrue(classInstance.hasConstructor(classArguments), modifiedClassMessage);
        assertTrue(classInstance.hasModifier(classArguments, "public"), modifiedClassMessage);
        Object[][] tests = new Object[][]{
                {120},
                {60},
                {30}
        };
        for (int num = 0; num < tests.length; num++) {
            int speed = (int) tests[num][0];
            Object[][] arguments = {
                    {speed, int.class}
            };
            Object instance = classInstance.createInstance(arguments);
            _assertEquals(speed, classInstance.getFieldValue(instance, var1),
                    "Your " + className + " constructor does not correctly initialize the " + var1 + " field.");
            _assertEquals(initialFee, classInstance.getFieldValue(instance, var2),
                    "Your " + className + " constructor does not correctly initialize the " + var2 + " field.");
        }


    }

    private static Stream<Arguments> methodInputProvider() {
        return Stream.of(
                Arguments.of(120, 40, 0),
                Arguments.of(60, 70, initialFee),
                Arguments.of(30, 40, initialFee),
                Arguments.of(100, 100, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("methodInputProvider")
    public void highwayCorrectIssueTicketMethod(int speedLim, int current, int ans) throws Throwable {
        Object[][] arguments1 = {
                {speedLim, int.class}
        };
        Object[][] arguments2 = {
                {current, int.class}
        };
        Object instance = classInstance.createInstance(arguments1);
        Object output = classInstance.callMethod(methodName, arguments2, (new String[]{"public"}), instance);
        _assertEquals(ans, output,
                "Your " + className + " " + methodName + " does not correctly calculate the fine.");

    }
}
