package global.variables;

import global.tools.InvalidClauseException;

public abstract class Clause implements Regexable {
    String name;

    public Clause(String name) {
        this.name = name;
    }

    public Clause() {
        this.name = null;
    }

    public String getName() {
        return this.name;
    }

    public boolean validate(String matchGroupString) {
        return true;
    }

    public void validateParams() throws InvalidClauseException {
    }

    public String getInvalidMessage() {
        return "Invalid Clause";
    }
}
