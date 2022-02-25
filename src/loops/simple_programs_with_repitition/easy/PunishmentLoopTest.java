package loops.simple_programs_with_repitition.easy;

import global.variables.*;
import global.variables.clauses.*;
import global.BaseTest;

public class PunishmentLoopTest extends BaseTest {
    
    String sentence = "Hello World";
    int repetitions = 3;

    public Clause[] testSentence() {

        Clause[] output = new Clause[repetitions * 2 + 3];

        output[0] = new StringLiteral("Enter a sentence: ");
        output[1] = new NewLine();
        output[2] = new StringLiteral("Enter the number of times to repeat the sentence: ");

        for (int i = 0; i < repetitions; i++){
            output[i * 2 + 3] = new NewLine();
            output[i * 2 + 4] = new StringLiteral(sentence);
        }

        return output;
        
    }

    public void runMain() {
        provideInput(sentence + System.lineSeparator() + repetitions);
        PunishmentLoop.main(new String[0]);
    }

}
