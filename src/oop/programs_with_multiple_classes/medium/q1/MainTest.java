package oop.programs_with_multiple_classes.medium.q1;

import global.BaseTest;
import global.ObjectTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    // Parsons
    public ObjectTest chair;
    public ObjectTest table;

    @BeforeEach
    public void setup() {
        String chairClassString = "oop.programs_with_multiple_classes.medium.q1.Chair";
        String tableClassString = "oop.programs_with_multiple_classes.medium.q1.Table";
        chair = new ObjectTest(chairClassString);
        table = new ObjectTest(tableClassString);

        // Make sure the students have not modified Chair fields
        String modifiedChairMessage =
                "You have modified the class fields in the Chair class. Please revert them back to the original state they were provided in.";
        assertTrue(chair.hasField("comfort", String.class, new String[]{"private"}), modifiedChairMessage);
        assertTrue(chair.hasField("weightCapacity", int.class, new String[]{"private"}), modifiedChairMessage);
        assertTrue(chair.hasField("longevity", int.class, new String[]{"private"}), modifiedChairMessage);

        // Make sure the students have not modified the Table constructor
        Class<?>[] classArguments = {String.class, int.class};
        String modifiedTableMessage =
                "Your have modified the provided constructor of the Table class. Please revert it back to its original state.";
        assertTrue(table.hasConstructor(classArguments, new String[]{"public"}), modifiedTableMessage);
    }

    @Test
    public void tableClassHasCorrectAttributes() {
        String incorrectFieldMessage = "Your Table class is missing a required field";
        String incorrectModifierMessage = "One of your chair class attributes does not have the correct modifier.";
        assertTrue(table.hasField("woodType", String.class), incorrectFieldMessage);
        assertTrue(table.hasField("numSeats", int.class), incorrectFieldMessage);
        assertTrue(table.hasModifier("woodType", "private"), incorrectModifierMessage);
        assertTrue(table.hasModifier("numSeats", "private"), incorrectModifierMessage);
    }

    @Test
    public void chairClassHasRequiredConstructor() {
        Class<?>[] classArguments = {String.class, int.class, int.class};
        assertTrue(chair.hasConstructor(classArguments),
                "Your Chair constructor does not have the correct parameters.");
        assertTrue(chair.hasModifier(classArguments, "public"),
                "Your Chair constructor does not have the correct modifiers.");
    }

    private static Stream<Arguments> chairInputProvider() {
        return Stream.of(
                Arguments.of("chairy the platypus", 5, 32123),
                Arguments.of("Another level of comfort. Simply build different", 123123321, 345),
                Arguments.of("Immensely comfy chair :)", 8, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("chairInputProvider")
    public void chairConstructorInitializesValuesCorrectly(String comfort, int weightCapacity, int longevity) throws Throwable {
        Object[][] arguments = {
                {comfort, String.class},
                {weightCapacity, int.class},
                {longevity, int.class}
        };
        Object chairInstance = chair.createInstance(arguments);
        _assertEquals(comfort, chair.getFieldValue(chairInstance, "comfort"),
                "Your chair constructor does not correctly initialize the comfort field.");
        _assertEquals(weightCapacity, chair.getFieldValue(chairInstance, "weightCapacity"),
                "Your chair constructor does not correctly initialize the weightCapacity field.");
        _assertEquals(longevity, chair.getFieldValue(chairInstance, "longevity"),
                "Your chair constructor does not correctly initialize the longevity field.");
    }
}
