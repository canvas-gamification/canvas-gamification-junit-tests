package loops.simple_programs_with_repitition.easy.q7;

import global.variables.*;
import global.variables.clauses.*;
import global.BaseTest;

public class AlTeRnAtInGcAsETest extends BaseTest {

    String input = "This is a sentence. This is another sentence.";

    public Clause[] testSentence() {

        Clause[] output = new Clause[3];

        output[0] = new StringLiteral("Enter a sentence: ");
        output[1] = new NewLine();
        output[2] = new StringLiteral("YoUr SeNtEnCe In AlTeRnAtInG cAsE iS: " + alternate(input));

        return output;

    }

    public void runMain() {
        provideInput(input);
        AlTeRnAtInGcAsE.main(new String[0]);
    }

    public static String alternate(String sentence) {
        String result = "";
        int i = 0;
        while (i < sentence.length()) {
            if (i % 2 == 0)
                result += Character.toUpperCase(sentence.charAt(i));
            else
                result += Character.toLowerCase(sentence.charAt(i));
            i++;
        }
        return result;
    }

}