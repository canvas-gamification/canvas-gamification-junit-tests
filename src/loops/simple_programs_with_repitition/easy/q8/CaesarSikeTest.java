package loops.simple_programs_with_repitition.easy.q8;

import global.variables.*;
import global.variables.clauses.*;
import global.BaseTest;

public class CaesarSikeTest extends BaseTest {
    
    String input1 = "This is a sentence. This is another sentence.";
    int input2 = 2; 

    public Clause[] testSentence() {

        Clause[] output = new Clause[5];

        output[0] = new StringLiteral("Enter a sentence: ");
        output[1] = new NewLine();
        output[2] = new StringLiteral("Enter a number to offset by: ");
        output[3] = new NewLine();
        output[4] = new StringLiteral("Your Encrypted Sentence is: " + encrypt(input1, input2));

        return output;
        
    }

    public void runMain() {
        provideInput(input1 + System.lineSeparator() + input2);
        CaesarSike.main(new String[0]);
    }

    public static String encrypt(String sentence, int offset) {
        String result = "";
        int i = 0;
        while (i < sentence.length()) {
            result += (char)(sentence.charAt(i) + offset);
            i++;
        }
        return result;
    }
}
