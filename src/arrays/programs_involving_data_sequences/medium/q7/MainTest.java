package arrays.programs_involving_data_sequences.medium.q7;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.StringLiteral;

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
}
