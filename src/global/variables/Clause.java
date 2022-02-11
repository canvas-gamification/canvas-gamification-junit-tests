package global.variables;

import java.util.Objects;

public abstract class Clause implements Regexable {
    String INVALID_MESSAGE;
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

    public boolean validate(int matchGroupNum) {
        return true;
    }

    public String getInvalidMessage() {
        // TODO: return "Invalid ClauseClassName" if INVALID_MESSAGE == null
        return Objects.requireNonNullElse(this.INVALID_MESSAGE, "Invalid Clause");
    }
}
