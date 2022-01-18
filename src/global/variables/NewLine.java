package global.variables;

import global.variables.Clause;

public class NewLine extends Clause {
    @Override
    public String getRegex() {
        return "(\\R)";
    }
}
