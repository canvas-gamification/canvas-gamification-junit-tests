package global.variables;

import global.variables.Clause;

public class NewLine implements Clause {
    @Override
    public String getRegex() {
        return "(\\R)";
    }
}
