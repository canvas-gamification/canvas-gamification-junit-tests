package methods.defining_methods.hard.q5;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
  // Java
  public Clause[] testSentence() {
    TestOption.isInputTest = true;
    TestOption.defaultInput = "The Matrix\n12";
    return new Clause[] {
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
        Arguments.of("The Matrix", 1, "You've watched The Matrix a few times!"),
        Arguments.of("The Matrix", 2, "You've watched The Matrix a few times!"),
        Arguments.of("The Matrix", 5, "You've watched The Matrix a few times!"),
        Arguments.of("The Matrix", 6, "You've watched The Matrix a lot of times!"),
        Arguments.of("The Matrix", 8, "You've watched The Matrix a lot of times!"),
        Arguments.of("The Matrix", 10, "You've watched The Matrix a lot of times!"),
        Arguments.of("The Matrix", 11, "You've watched The Matrix so many times! Wow!"),
        Arguments.of("The Matrix", 81, "You've watched The Matrix so many times! Wow!"),
        Arguments.of("The Matrix", 200, "You've watched The Matrix so many times! Wow!"));
  }

  @ParameterizedTest
  @MethodSource("inputProvider")
  void correctMethodMovieCounter(String movieName, int timeWatched, String exclaimatory) throws Throwable {
    String errorMesasge = "Your method \"movieCounter()\" does not return the correct exclaimatory message.";
    Object output = MethodUtil.invokeIfMethodExists(FavMovie.class, "movieCounter",
        new Object[] { movieName, timeWatched }, String.class, int.class);
    CustomAssertions._assertEquals(output, exclaimatory, errorMesasge);
  }

  @ParameterizedTest
  @MethodSource("inputProvider")
  void printsCorrectOutput(String movieName, int timeWatched, String exclaimatory) throws InvalidClauseException {
    TestOption.incorrectStructureErrorMessage = "Your program does not print the correct exclaimatory message for the movie "
        + movieName + ".";
    runWithInput(movieName + "\n" + timeWatched, new Clause[] {
        new StringLiteral(exclaimatory),
    });
  }
}
