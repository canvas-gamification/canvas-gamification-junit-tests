package global.variables.clauses;

import global.variables.Clause;

public class NewLine extends Clause {
    @Override
    public String getRegex() {
        return "(\\R)";
    }
}
