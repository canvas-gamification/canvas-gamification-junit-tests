package methods.defining_methods.hard.q5;

import java.util.stream.Stream;

import global.MethodTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    // Java

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "The Matrix\n12";
        return new Clause[]{
                new StringLiteral("Enter your favourite movie: "),
                new NewLine(),
                new StringLiteral("How many times have you watched this movie\\?"),
                new NewLine(),
                new PlaceHolder(),
        };
    }

    public void runMain() {
        FavMovie.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of("Chicken Little", -100, "You've watched Chicken Little no times!"),
                Arguments.of("Cloudy with a chance of meatballs", -1, "You've watched Cloudy with a chance of meatballs no times!"),
                Arguments.of("Legally Blonde", 0, "You've watched Legally Blonde no times!"),
                Arguments.of("The Matrix", 1, "You've watched The Matrix a few times!"),
                Arguments.of("Alien", 2, "You've watched Alien a few times!"),
                Arguments.of("The Grand Budapest Hotel", 5, "You've watched The Grand Budapest Hotel a few times!"),
                Arguments.of("Hot Fuzz", 6, "You've watched Hot Fuzz a lot of times!"),
                Arguments.of("Nausicaa and the valley of the wind", 8, "You've watched Nausicaa and the valley of the wind a lot of times!"),
                Arguments.of("Pacific Rim", 10, "You've watched Pacific Rim a lot of times!"),
                Arguments.of("Kung Fury", 11, "You've watched Kung Fury so many times! Wow!"),
                Arguments.of("Se7en", 81, "You've watched Se7en so many times! Wow!"),
                Arguments.of("The Last Unicorn", 200, "You've watched The Last Unicorn so many times! Wow!"));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctMovieCounterMethod(String movieName, int timeWatched, String exclaimatory) throws Throwable {
        Object[][] arguments = {
                {movieName, String.class},
                {timeWatched, int.class}
        };
        MethodTest m = new MethodTest(FavMovie.class, "movieCounter", arguments);
        Object output = m.callMethod();
        String errorMessage = "Your movieCounter() method does not return the correct message based on the move name and the number of times the user watched the moveie.";
        CustomAssertions._assertEquals(output, exclaimatory, errorMessage);
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void printsCorrectOutput(String movieName, int timeWatched, String exclaimatory) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not print the correct message for the input movie and the number of times the user watched it.";
        runWithInput(movieName + "\n" + timeWatched, new Clause[]{
                new StringLiteral(exclaimatory),
        });
    }
}
