package loops.simple_programs_with_repitition.easy.q5;

import global.variables.*;
import global.variables.clauses.*;
import global.BaseTest;

public class MainTest extends BaseTest { // Parsons Test

    String input = "This is just for testing. Do not copy!";

    public Clause[] testSentence() {

        return new Clause[] {
            new StringLiteral("Enter a sentence: "),
            new NewLine(),
            new StringLiteral("The number of words in the sentence is " + countingWords(input) + " words.")
        };

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