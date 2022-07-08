package pre_defined_classes.simple_programs_taking_string_user_input.medium.q10;

import global.BaseTest;
import global.tools.TestOption;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.PlaceHolder;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class MainTeset extends BaseTest {
    // Parsons
    public Clause[] testSentence() {
        TestOption.isInputTest = true;
        TestOption.defaultInput = "123";
        return new Clause[]{
                new StringLiteral("Enter your word:"),
                new NewLine(),
                new StringLiteral("Is the given word a palindrome? "),
                new PlaceHolder()
        };
    }

    public void runMain(){ Palindrome.main(new String[0]);}

    public static Stream<String> inputProvider() {
        return Stream.of("123", "LOL");
    }
}
