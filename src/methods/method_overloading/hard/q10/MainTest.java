package methods.method_overloading.hard.q10;

import java.util.stream.Stream;

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
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("The baby's name is Carina and the gender is Female"),
                new NewLine(),
                new StringLiteral("The baby's name is Alex and the gender is Male"),
                new NewLine(),
                new StringLiteral("The baby's name is Bred"),
        };
    }

    public void runMain() {
        Overload10.main(new String[0]);
    }

    static Stream<Arguments> inputBabyWithGenderProvider() {
        return Stream.of(
                Arguments.of("Carina", true, "The baby's name is Carina and the gender is Female"),
                Arguments.of("Carina", false, "The baby's name is Carina and the gender is Male"),
                Arguments.of("Alex", true, "The baby's name is Alex and the gender is Female"),
                Arguments.of("Alex", false, "The baby's name is Alex and the gender is Male"),
                Arguments.of(" ", false, "The baby's name is   and the gender is Male"));
    }

    static Stream<String> inputBabyWithoutGenderProvider() {
        return Stream.of(" ", "asd", "", "Gloria", "Bred", "123321");
    }

    @ParameterizedTest
    @MethodSource("inputBabyWithGenderProvider")
    void babyWithGenderCorrect(String babyName, Boolean babyGender, String babyStr) throws Throwable {
        String errMsg = "Your method \"baby()\" does not give the correct output for baby with gender.";
        Object output = MethodUtil.invokeIfMethodExists(Overload10.class, "baby", new Object[]{babyName, babyGender}, String.class, Boolean.class);
        CustomAssertions._assertEquals(output, babyStr, errMsg);
    }

    @ParameterizedTest
    @MethodSource("inputBabyWithoutGenderProvider")
    void babyWithoutGenderCorrect(String babyName) throws Throwable {
        String errMsg = "Your method \"baby()\" does not give the correct output for baby with gender.";
        Object output = MethodUtil.invokeIfMethodExists(Overload10.class, "baby", new Object[]{babyName}, String.class);
        CustomAssertions._assertEquals(output, "The baby's name is " + babyName, errMsg);
    }
}
