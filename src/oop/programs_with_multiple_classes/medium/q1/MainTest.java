package oop.programs_with_multiple_classes.medium.q1;

import global.ObjectTest;
import global.variables.Clause;
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
    // Java
    public ObjectTest chair;
    public ObjectTest table;
    private final int defaultWeightCapacity = 100;
    private final int defaultLongevity = 12;
    private final String woodTypeMethodName = "woodType";
    private final String chairClassName = "Chair";
    private final String tableClassName = "Table";

    @BeforeEach
    public void setup() {
        String chairClassString = "oop.programs_with_multiple_classes.medium.q1." + chairClassName;
        String tableClassString = "oop.programs_with_multiple_classes.medium.q1." + tableClassName;
        chair = new ObjectTest(chairClassString);
        table = new ObjectTest(tableClassString);

        // Make sure the students have not modified Chair fields
        String modifiedChairMessage =
                "You have modified the class fields in the" + chairClassName+ " class. Please revert them back to the original state they were provided in.";
        assertTrue(chair.hasField("comfort", String.class, new String[]{"private"}), modifiedChairMessage);
        assertTrue(chair.hasField("weightCapacity", int.class, new String[]{"private"}), modifiedChairMessage);
        assertTrue(chair.hasField("longevity", int.class, new String[]{"private"}), modifiedChairMessage);

        // Make sure the students have not modified the Table constructor
        Class<?>[] classArguments = {String.class, int.class};
        String modifiedTableMessage =
                "Your have modified the provided constructor of the " + tableClassName + " class. Please revert it back to its original state.";
        assertTrue(table.hasConstructor(classArguments, new String[]{"public"}), modifiedTableMessage);
    }

    @Test
    public void tableClassHasCorrectAttributes() {
        String incorrectFieldMessage = "Your " + tableClassName + " class is missing a required field";
        String incorrectModifierMessage = "One of your " + tableClassName + " class attributes does not have the correct modifier.";
        assertTrue(table.hasField("woodType", String.class), incorrectFieldMessage);
        assertTrue(table.hasField("numSeats", int.class), incorrectFieldMessage);
        assertTrue(table.hasModifier("woodType", "private"), incorrectModifierMessage);
        assertTrue(table.hasModifier("numSeats", "private"), incorrectModifierMessage);
    }

    private static Stream<Arguments> tableInputProvider() {
        return Stream.of(
                Arguments.of("Oak", 4),
                Arguments.of("", 12),
                Arguments.of("Birch", 2344),
                Arguments.of("Another type of wood !!!##", 12)
        );
    }

    @ParameterizedTest
    @MethodSource("tableInputProvider")
    public void tableClassHasCorrectWoodTypeMethod(String woodType, int numSeats) throws Throwable {
        Object[][] arguments = {
                {woodType, String.class},
                {numSeats, int.class}
        };
        Object tableInstance = table.createInstance(arguments);
        Clause[] methodTestSentence = {
                new StringLiteral("This table is made out of "),
                new StringLiteral(woodType)
        };
        String incorrectStructureMessage = "Your " + woodTypeMethodName +
                " method in the " + tableClassName + " class does not correctly print the type of wood of the table.";
        table.callMethod(woodTypeMethodName, tableInstance, methodTestSentence, incorrectStructureMessage);
    }

    @Test
    public void chairClassHasRequiredConstructor() {
        Class<?>[] classArguments = {String.class, int.class, int.class};
        assertTrue(chair.hasConstructor(classArguments),
                "Your " + chairClassName + " constructor does not have the correct parameters.");
        assertTrue(chair.hasModifier(classArguments, "public"),
                "Your " + chairClassName + " constructor does not have the correct modifiers.");
    }

    private static Stream<Arguments> chairInputProvider() {
        return Stream.of(
                Arguments.of("chairy the platypus", 5, 32123),
                Arguments.of("Another level of comfort. Simply build different", 123123321, 345),
                Arguments.of("Immensely comfy chair :)", 8, 2),
                Arguments.of("Fairly comfy", -1, 2),
                Arguments.of("Immensely uncomfortable", 0, -1),
                Arguments.of("Even worse", -1, -1),
                Arguments.of("It is getting better", -2332, 0),
                Arguments.of("Even more so", 312, -23)
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
        int expectedWeightCapacity = weightCapacity < 0 ? defaultWeightCapacity : weightCapacity;
        int expectedLongevity = longevity < 0 ? defaultLongevity : longevity;
        _assertEquals(comfort, chair.getFieldValue(chairInstance, "comfort"),
                "Your " + chairClassName + " constructor does not correctly initialize the comfort field.");
        _assertEquals(expectedWeightCapacity, chair.getFieldValue(chairInstance, "weightCapacity"),
                "Your " + chairClassName + " constructor does not correctly initialize the weightCapacity field.");
        _assertEquals(expectedLongevity, chair.getFieldValue(chairInstance, "longevity"),
                "Your " + chairClassName + " constructor does not correctly initialize the longevity field.");
    }
}
