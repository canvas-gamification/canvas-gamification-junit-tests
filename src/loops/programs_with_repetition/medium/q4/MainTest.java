package loops.programs_with_repetition.medium.q4;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
  // Java
  public Clause[] testSentence() {
    return trianglePatternClause(5);
  }

  public void runMain() {
    ThatWay.main(new String[0]);
  }

  Clause[] trianglePatternClause(int n) {
    Clause[] c = new Clause[n * 4 - 2];
    int index = 0;
    for (int i = 1; i <= n; ++i) {
      StringBuilder sb = new StringBuilder();
      sb.append("\\* ".repeat(i));
      c[index++] = new StringLiteral(sb.toString());
      c[index++] = new NewLine();
    }
    for (int i = n - 1; i >= 1; --i) {
      StringBuilder sb = new StringBuilder();
      sb.append("\\* ".repeat(i));
      c[index++] = new StringLiteral(sb.toString());
      c[index++] = new NewLine();
    }

    return c;
  }

}