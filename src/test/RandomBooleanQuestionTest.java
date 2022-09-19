package test;

import global.BaseRandomTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.RandomBoolean;

public class RandomBooleanQuestionTest extends BaseRandomTest {
    public Clause[] testSentence() {
        return new Clause[]{
                new RandomBoolean(),
                new NewLine(),
                new RandomBoolean(0.01),
                new NewLine(),
                new RandomBoolean(4.0/5.0)
        };
    }

    public void runMain() {
        RandomBooleanQuestion.main(new String[0]);
    }
}
