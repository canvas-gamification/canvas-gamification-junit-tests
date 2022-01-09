package global.variables.wrappers;

import global.variables.Clause;

public class NewLine implements Clause {
    Clause clause;

    public NewLine(Clause clause) {
        this.clause = clause;
    }

    public Clause getVariableNode() {
        return clause;
    }

    @Override
    public String getRegex() {
        return "\\R" + getVariableNode().getRegex();
    }
}
