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
                new RandomBoolean()
        };
    }

    public void runMain() {
        RandomBooleanQuestion.main(new String[0]);
    }
}
