package pre_defined_classes.programs_with_changing_behaviour.hard.q11;

import global.BaseRandomTest;
import global.variables.Clause;
import global.variables.clauses.*;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseRandomTest {
    // Java
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("Your score for this round was "),
                new RandomInteger(0, 100, "score"),
                new NewLine(),
                new StringLiteral("The modifier for this round is "),
                new RandomDouble(0, 5, "modifier"),
                new NewLine(),
                new StringLiteral("Your modified score is "),
                new DoubleLiteral("modifiedScore"),
                new StringLiteral("\\!"),
                new NewLine()
        };
    }

    public void runMain() {
        WhatAScore.main(new String[0]);
    }

    @RepeatedTest(10)
    void calculateModifiedScoreCorrectly() {
        int score = Integer.parseInt(getItemByName("score"));
        double modifier = Double.parseDouble(getItemByName("modifier"));
        double modifiedScore = score * modifier;
        assertEquals(modifiedScore, Double.parseDouble(getItemByName("modifiedScore")), "Your program does not correctly compute the modified score.");
    }
}
