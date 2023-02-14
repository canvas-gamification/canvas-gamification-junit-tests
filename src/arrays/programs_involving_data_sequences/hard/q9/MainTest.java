package arrays.programs_involving_data_sequences.hard.q9;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.IntegerLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
    //Java

    String[] jurisdictions = new String[]{
            "Alberta",
            "British Columbia",
            "Manitoba",
            "New Brunswick",
            "Newfoundland and Labrador",
            "Northwest Territories",
            "Nova Scotia",
            "Nunavut",
            "Ontario",
            "Prince Edward Island",
            "Quebec",
            "Saskatchewan",
            "Yukon"
    };

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "Edmonton\nVictoria\nWinnipeg\nFredericton\nSt. John's\nYellowknife\nHalifax\nIqaluit\nToronto\nCharlottetown\nQuebec City\nRegina\nWhitehorse\n";

        Clause[] clause = new Clause[42];
        for (int i = 0; i < clause.length - 3; i += 3) {
            clause[i] = new StringLiteral("What is the capital of the Canadian jurisdiction of " + jurisdictions[i / 3] + "\\?");
            clause[i + 1] = new NewLine();
            clause[i + 2] = new PlaceHolder();
        }
        clause[clause.length - 3] = new StringLiteral("You got ");
        clause[clause.length - 2] = new IntegerLiteral("num");
        clause[clause.length - 1] = new StringLiteral(" questions correct\\!");
        return clause;
    }

    public void runMain() {
        QuizGameEh.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of("Edmonton" + System.lineSeparator() +
                        "Victoria" + System.lineSeparator() +
                        "Winnipeg" + System.lineSeparator() +
                        "Fredericton" + System.lineSeparator() +
                        "St. John's" + System.lineSeparator() +
                        "Yellowknife" + System.lineSeparator() +
                        "Halifax" + System.lineSeparator() +
                        "Iqaluit" + System.lineSeparator() +
                        "Toronto" + System.lineSeparator() +
                        "Charlottetown" + System.lineSeparator() +
                        "Quebec City" + System.lineSeparator() +
                        "Regina" + System.lineSeparator() +
                        "Whitehorse" + System.lineSeparator(), 13),
                Arguments.of("Edmonton" + System.lineSeparator() +
                        "Victoria" + System.lineSeparator() +
                        "Winnipeg" + System.lineSeparator() +
                        "I forgot" + System.lineSeparator() +
                        "St. John's" + System.lineSeparator() +
                        "Yellowknife" + System.lineSeparator() +
                        "Halifax" + System.lineSeparator() +
                        "Iqaluit" + System.lineSeparator() +
                        "Toronto" + System.lineSeparator() +
                        "idk" + System.lineSeparator() +
                        "Quebec City" + System.lineSeparator() +
                        "Regina" + System.lineSeparator() +
                        "Whitehorse" + System.lineSeparator(), 11),
                Arguments.of("?" + System.lineSeparator() +
                        "?" + System.lineSeparator() +
                        "?" + System.lineSeparator() +
                        "?" + System.lineSeparator() +
                        "?" + System.lineSeparator() +
                        "?" + System.lineSeparator() +
                        "?" + System.lineSeparator() +
                        "?" + System.lineSeparator() +
                        "?" + System.lineSeparator() +
                        "?" + System.lineSeparator() +
                        "?" + System.lineSeparator() +
                        "?" + System.lineSeparator() +
                        "?" + System.lineSeparator(), 0),
                Arguments.of("Victoria" + System.lineSeparator() +
                        "Winnipeg" + System.lineSeparator() +
                        "I forgot" + System.lineSeparator() +
                        "St. John's" + System.lineSeparator() +
                        "Yellowknife" + System.lineSeparator() +
                        "Halifax" + System.lineSeparator() +
                        "Iqaluit" + System.lineSeparator() +
                        "Toronto" + System.lineSeparator() +
                        "idk" + System.lineSeparator() +
                        "Quebec City" + System.lineSeparator() +
                        "Regina" + System.lineSeparator() +
                        "Whitehorse" + System.lineSeparator() +
                        "Edmonton" + System.lineSeparator(), 0),
                Arguments.of("Edmonton" + System.lineSeparator() +
                        "Winnipeg" + System.lineSeparator() +
                        "I forgot" + System.lineSeparator() +
                        "St. John's" + System.lineSeparator() +
                        "" + System.lineSeparator() +
                        "Yellowknife" + System.lineSeparator() +
                        "Iqaluit" + System.lineSeparator() +
                        "idk" + System.lineSeparator() +
                        "Toronto" + System.lineSeparator() +
                        "Quebec City" + System.lineSeparator() +
                        "Regina" + System.lineSeparator() +
                        "Whitehorse" + System.lineSeparator() +
                        "Edmonton" + System.lineSeparator(), 3)
        );

    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void printScoreCorrectly(String capital, int numCorrect) {
        runWithInput(capital);
        assertEquals(numCorrect, Integer.parseInt(getItemByName("num")));
    }
}
