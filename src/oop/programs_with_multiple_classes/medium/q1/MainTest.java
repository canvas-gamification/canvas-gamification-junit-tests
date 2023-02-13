package oop.programs_with_multiple_classes.medium.q1;

import global.ObjectTest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    // Parsons
    public ObjectTest chair;
    public ObjectTest table;

    private final String chairClassString = "oop.programs_with_multiple_classes.medium.q1.Chair";
    private final String tableClassString = "oop.programs_with_multiple_classes.medium.q1.Table";

    @Before
    public void setup() {
        chair = new ObjectTest(chairClassString);
        table = new ObjectTest(tableClassString);
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
}
