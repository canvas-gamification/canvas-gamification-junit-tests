package loops.simple_programs_with_repitition.easy.q5;

import global.variables.*;
import global.variables.clauses.*;
import global.BaseTest;

public class WordCountTest extends BaseTest {

    String input = "This is just for testing. Do not copy!";

    public Clause[] testSentence() {

        Clause[] output = new Clause[3];
        output[0] = new StringLiteral("Enter a sentence: ");
        output[1] = new NewLine();
        output[2] = new StringLiteral("The number of words in the sentence is " + countingWords(input) + " words.");

        return output;

    }

    public void runMain() {
        provideInput(input);
        WordCount.main(new String[0]);
    }

    public static int countingWords(String message) {
        message.toLowerCase();
        int count = 0;
        for (int i = 0; i < message.length(); i++)
            if (message.charAt(i) == ' ')
                count++;
        return count + 1;
    }
}