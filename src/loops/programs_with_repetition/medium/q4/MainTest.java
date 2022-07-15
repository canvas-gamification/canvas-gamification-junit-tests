package loops.programs_with_repetition.medium.q4;

import global.BaseTest;
import global.variables.Clause;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;

public class MainTest extends BaseTest {
  // Java
  public Clause[] testSentence() {
    return hourGlassPatternClause(5);
  }

  public void runMain() {
    OurGlass.main(new String[0]);
  }

  Clause[] hourGlassPatternClause(int n) {
    Clause[] c = new Clause[n * 4 - 2];
    int index = 0;
    for (int i = n; i >= 1; --i) {
      StringBuilder sb = new StringBuilder();
      sb.append(" ".repeat(n - i));
      sb.append("\\* ".repeat(i));
      c[index++] = new StringLiteral(sb.toString());
      c[index++] = new NewLine();
    }
    for (int i = 2; i <= n; ++i) {
      StringBuilder sb = new StringBuilder();
      sb.append(" ".repeat(n - i));
      sb.append("\\* ".repeat(i));
      c[index++] = new StringLiteral(sb.toString());
      c[index++] = new NewLine();
    }

    return c;
  }
}
