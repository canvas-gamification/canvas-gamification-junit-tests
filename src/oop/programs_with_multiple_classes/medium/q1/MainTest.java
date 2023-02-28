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

public class MainTest extends BaseTest {
    // Parsons
    public ObjectTest chair;
    public ObjectTest table;
    public ObjectTest testRoom;

    @BeforeEach
    public void setup() {
        String chairClassString = "oop.programs_with_multiple_classes.medium.q1.Chair";
        String tableClassString = "oop.programs_with_multiple_classes.medium.q1.Table";
        String testRoomClassString = "oop.programs_with_multiple_classes.medium.q1.TestRoom";
        chair = new ObjectTest(chairClassString);
        table = new ObjectTest(tableClassString);
        testRoom = new ObjectTest(testRoomClassString);
    }

    public Clause[] testSentence() {
        TestOption.incorrectStructureErrorMessage =
                "Your program does not print out the correct string for each initialized object in the TestRoom class.";
        return new Clause[]{
                new StringLiteral("Chair 1: Chair\\{comfort\\='"),
                new StringLiteral("couchy"),
                new StringLiteral("', weightCapacity\\="),
                new IntegerLiteral(350),
                new StringLiteral(", longevity\\="),
                new IntegerLiteral(5),
                new StringLiteral("\\}"),
                new NewLine(),
                new StringLiteral("Chair 2: Chair\\{comfort\\='"),
                new StringLiteral("back support"),
                new StringLiteral("', weightCapacity\\="),
                new IntegerLiteral(250),
                new StringLiteral(", longevity\\="),
                new IntegerLiteral(10),
                new StringLiteral("\\}"),
                new NewLine(),
                new StringLiteral("Table: Table\\{woodType\\='"),
                new StringLiteral("cherry"),
                new StringLiteral("', numSeats\\="),
                new IntegerLiteral(8),
                new StringLiteral("\\}")
        };
    }

    public void runMain() {
        TestRoom.main(new String[0]);
    }

    @Test
    public void chairClassHasCorrectAttributes() {
        String incorrectFieldMessage = "Your Chair class is missing a required field";
        String incorrectModifierMessage = "Your Chair class is missing a required field";
        assertTrue(chair.hasField("comfort", String.class), incorrectFieldMessage);
        assertTrue(chair.hasField("weightCapacity", int.class), incorrectFieldMessage);
        assertTrue(chair.hasField("longevity", int.class), incorrectModifierMessage);
        assertTrue(chair.hasModifier("comfort", "private"), incorrectModifierMessage);
        assertTrue(chair.hasModifier("weightCapacity", "private"), incorrectModifierMessage);
        assertTrue(chair.hasModifier("longevity", "private"), incorrectModifierMessage);
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

    @Test
    public void tableCLassHasRequiredConstructor() {
        Class<?>[] classArguments = {String.class, int.class};
        assertTrue(table.hasConstructor(classArguments),
                "Your Table constructor does not have the correct parameters.");
        assertTrue(table.hasModifier(classArguments, "public"),
                "Your Table constructor does not have the correct modifiers.");
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

    @ParameterizedTest
    @MethodSource("chairInputProvider")
    public void correctChairToStringMethod(String comfort, int weightCapacity, int longevity) throws Throwable {
        Object[][] arguments = {
                {comfort, String.class},
                {weightCapacity, int.class},
                {longevity, int.class}
        };
        Object chairInstance = chair.createInstance(arguments);
        Object chairToStringOutput = chair.callMethod("toString", chairInstance);
        _assertEquals(chairToStringResult(comfort, weightCapacity, longevity), chairToStringOutput,
                "Your chair toString method does not return the correct string.");
    }

    private static String chairToStringResult(String comfort, int weightCapacity, int longevity) {
        return "Chair{comfort='"
                + comfort
                + "', weightCapacity="
                + weightCapacity
                + ", longevity="
                + longevity + "}";
    }

    private static Stream<Arguments> tableInputProvider() {
        return Stream.of(
                Arguments.of("Oak", 321),
                Arguments.of("Birch", 2131),
                Arguments.of("Not actually wood", 11)
        );
    }

    @ParameterizedTest
    @MethodSource("tableInputProvider")
    public void tableConstructorInitializesValuesCorrectly(String woodType, int numSeats) throws Throwable {
        Object[][] arguments = {
                {woodType, String.class},
                {numSeats, int.class},
        };
        Object tableInstance = table.createInstance(arguments);
        _assertEquals(woodType, table.getFieldValue(tableInstance, "woodType"),
                "Your table constructor does not correctly initialize the woodType field.");
        _assertEquals(numSeats, table.getFieldValue(tableInstance, "numSeats"),
                "Your table constructor does not correctly initialize the numSeats field.");
    }

    @ParameterizedTest
    @MethodSource("tableInputProvider")
    public void correctTableToStringMethod(String woodType, int numSeats) throws Throwable {
        Object[][] arguments = {
                {woodType, String.class},
                {numSeats, int.class},
        };
        Object tableInstance = table.createInstance(arguments);
        Object tableToStringOutput = table.callMethod("toString", tableInstance);
        _assertEquals(tableToStringResult(woodType, numSeats), tableToStringOutput,
                "Your table toString method does not return the correct string.");
    }

    private static String tableToStringResult(String woodType, int numSeats) {
        return "Table{"
                + "woodType='"
                + woodType
                + '\''
                + ", numSeats="
                + numSeats
                + '}';
    }
}
