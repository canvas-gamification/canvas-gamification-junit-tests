package methods.modular_programs.hard.q2;

import global.BaseTest;
import global.exceptions.InvalidClauseException;
import global.tools.CustomAssertions;
import global.tools.TestOption;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    // Java
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "ItIsWednesdayMyDude";
        return new Clause[]{
                new StringLiteral("Enter a sentence:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("The string with spaces is: "),
                new PlaceHolder(),
                new StringLiteral(".")
        };
    }

    public void runMain() {
        AddSpaces.main(new String[0]);
    }

    static Stream<Arguments> addSpaceInputProvider() {
        return Stream.of(
                Arguments.of("IUsedToBeAnAdventurerLikeYouButThenITookAnArrowToTheKnee", "I Used To Be An Adventurer Like You But Then I Took An Arrow To The Knee"),
                Arguments.of("It'sFunToStayAtTheYMCA", "It's Fun To Stay At The Y M C A"),
                Arguments.of("YouDrankWine369", "You Drank Wine369"),
                Arguments.of("thisisatest", "thisisatest"),
                Arguments.of("", "")
        );
    }

    static Stream<Arguments> mainMethodInputProvider() {
        return Stream.of(
                Arguments.of("YourProgramShouldAcceptThis ButNotThis", "Your Program Should Accept This"),
                Arguments.of("NeverGonnaGiveYouUp420", "Never Gonna Give You Up420"),
                Arguments.of("IUsedToBeAnAdventurerLikeYouButThenITookAnArrowToTheKnee", "I Used To Be An Adventurer Like You But Then I Took An Arrow To The Knee"),
                Arguments.of("isthisthereallife IsThisJustFantasy", "isthisthereallife")
        );
    }

    @ParameterizedTest
    @MethodSource("addSpaceInputProvider")
    void correctAddSpaceMethod(String input, String spaces) throws Throwable {
        Object output = MethodUtil.invokeIfMethodExists(AddSpaces.class, "addSpace", new Object[]{input},
                String.class);
        CustomAssertions._assertEquals(spaces, output, "Your addSpace method does not correctly add spaces between the words of the input string.");
    }

    @ParameterizedTest
    @MethodSource("mainMethodInputProvider")
    void printsOutputCorrectly(String input, String spaces) throws InvalidClauseException {
        TestOption.incorrectStructureErrorMessage = "Your program does not correctly print the string with spaces added.";
        runWithInput(input, new Clause[]{
                new StringLiteral(spaces)
        });
    }

}
