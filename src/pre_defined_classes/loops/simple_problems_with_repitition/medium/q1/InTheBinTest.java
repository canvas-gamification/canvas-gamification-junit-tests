package pre_defined_classes.loops.simple_problems_with_repitition.medium.q1;

import global.variables.*;
import global.variables.clauses.*;
import global.BaseTest;

public class InTheBinTest extends BaseTest {

    int input1 = 10;

    public Clause[] testSentence() {
        return new Clause[] {
            new StringLiteral("Enter a number : "),
            new NewLine(),
            new IntegerLiteral(input1),
            new StringLiteral(" in binary is "),
            new StringLiteral(convertBinary(input1))
        };
    }

    public void runMain() {
        provideInput("" + input1);
        InTheBin.main(new String[0]);
    }

    public String convertBinary(int n) {
      String result = "";
      int rem;
      while( n > 0 ) 
      {
         rem = n % 2;
         result = rem + result;  
         n = n / 2;
      }
      return(result);
    }
}
