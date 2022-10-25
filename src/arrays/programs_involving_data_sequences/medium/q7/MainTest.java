package arrays.programs_involving_data_sequences.medium.q7;

import global.BaseTest;
import global.MethodTest;
import global.tools.CustomAssertions;
import global.utils.ArrayUtil;
import global.variables.Clause;
import global.variables.clauses.StringLiteral;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest extends BaseTest {
    //Parsons with distractors
    public Clause[] testSentence() {
        return new Clause[]{
                new StringLiteral("homecominghomecominghomecominghomecominghomecominghomecominghomecominghomecominghomecominghomecoming")
        };
    }

    public void runMain(){
        DupeDupeDupeDupe.main(new String[0]);
    }

    static Stream<String[]> inputProvider(){
        return Stream.of(
                ArrayUtil.generateRandomWordArray(7),
                ArrayUtil.generateRandomWordArray(10),
                ArrayUtil.generateRandomWordArray(14),
                ArrayUtil.generateRandomWordArray(48),
                ArrayUtil.generateRandomWordArray(200),
                ArrayUtil.generateRandomWordArray(1000)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void correctStringRepeaterMethod(String[] in) throws Throwable {
        Object[][] arguments = {
                {in, String[].class}
        };
        MethodTest m = new MethodTest(DupeDupeDupeDupe.class, "stringRepeater", arguments);
        Object output = m.callMethod();
        CustomAssertions._assertEquals(getSolution(in), output, "Your stringRepeater method does not return a string with enough repetitions of the longest word.");
    }

    public static String getSolution(String [] words)
    {
        int greatestLength = 0;
        String newWord = "";
        for (int i = 0; i < words.length; i++)
        {
            if ( words[i].length() > words[greatestLength].length())
            {
                greatestLength = i;
            }
        }
        for (int j = 0; j < words[greatestLength].length(); j++)
            newWord += words[greatestLength];
        return newWord;
    }
}
