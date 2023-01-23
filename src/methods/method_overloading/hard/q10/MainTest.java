package methods.method_overloading.hard.q10;

import java.util.stream.Stream;

import global.MethodTest;
import global.tools.TestOption;
import global.variables.clauses.PlaceHolder;
import global.variables.wrappers.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import global.BaseTest;
import global.tools.CustomAssertions;
import global.utils.MethodUtil;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
    // Java

    public static int n = 5;

    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "John false";
        return new Clause[]{
                new StringLiteral("Enter a name or a name with gender:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new PlaceHolder(),
                new Optional(new StringLiteral(" "))
        };
    }

    public void runMain() {
        Overload10.main(new String[0]);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of("Carina true", "The baby's name is Carina and the gender is Female"),
                Arguments.of("Carina false", "The baby's name is Carina and the gender is Male"),
                Arguments.of("Carina", "The baby's name is Carina"),
                Arguments.of("Alex true", "The baby's name is Alex and the gender is Female"),
                Arguments.of("Alex false", "The baby's name is Alex and the gender is Male"),
                Arguments.of("Alex", "The baby's name is Alex")
        );
    }

    static Stream<Arguments> inputBabyWithGenderProvider() {
        return Stream.of(
                Arguments.of("Carina", true, "The baby's name is Carina and the gender is Female"),
                Arguments.of("Carina", false, "The baby's name is Carina and the gender is Male"),
                Arguments.of("Alex", true, "The baby's name is Alex and the gender is Female"),
                Arguments.of("Alex", false, "The baby's name is Alex and the gender is Male")
        );
    }

    static Stream<String> inputBabyWithoutGenderProvider() {
        return Stream.of(" ", "asd", "", "Gloria", "Bred", "123321");
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void printsCorrectOutput(String babyName, String ans) throws Throwable {
        runWithInput(babyName, new Clause[]{
                new StringLiteral(ans)
        });
    }

    @ParameterizedTest
    @MethodSource("inputBabyWithGenderProvider")
    void babyWithGenderCorrect(String babyName, Boolean babyGender, String babyStr) throws Throwable {
        Object[][] arguments = {
                {babyName, String.class},
                {babyGender, Boolean.class}
        };
        MethodTest m = new MethodTest(Overload10.class, "baby", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(babyStr, output, "Your baby method does not correctly print the name and gender.");
    }

    @ParameterizedTest
    @MethodSource("inputBabyWithoutGenderProvider")
    void babyWithoutGenderCorrect(String babyName) throws Throwable {
        String ans = "The baby's name is " + babyName;
        Object[][] arguments = {
                {babyName, String.class},
        };
        MethodTest m = new MethodTest(Overload10.class, "baby", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(ans, output, "Your baby method does not correctly print only the name.");
    }
}
