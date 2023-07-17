package test.random.random_boolean_testing;

import  global.BaseRandomTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.RandomBoolean;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static test.random.random_boolean_testing.RandomBooleanQuestion.random;

public class RandomBooleanQuestionTest extends BaseRandomTest {
    public Clause[] testSentence() {
        return new Clause[]{
                new RandomBoolean(),
                new NewLine(),
                new StringLiteral("Next random value: "),
                new NewLine(),
                new RandomBoolean("X", "O", "name")
        };
    }

    public void runMain() {
        RandomBooleanQuestion.main(new String[0]);
    }

    @Test
    public void randomTest() {
        ArrayList<String> s = new ArrayList<>();
        for (int i = 0; i < 1000; i++)
            s.add(random());
        RandomBoolean randomBoolean = new RandomBoolean("X", "O");
        assertTrue(randomBoolean.validateRandom(s), "Your program is not correctly generating random values. Please make sure to generate both O and X equally.");
    }
}
