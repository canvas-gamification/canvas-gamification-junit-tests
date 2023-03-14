package global.variables.clauses;

import global.variables.Clause;

public class PlaceHolder extends Clause {
    @Override
    public String getRegex() {
        return "(" + "(?:.|\\R)*" + ")";  // the ?: makes the inner parentheses non-capturing -- IMPORTANT
    }
}
