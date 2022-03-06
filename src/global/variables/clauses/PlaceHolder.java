package global.variables.clauses;

import global.variables.Clause;

public class PlaceHolder extends Clause {
    @Override
    public String getRegex() {
        return null;  // PlaceHolder clauses are not present by the time the regex is compiled
    }
}
