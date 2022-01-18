package global.variables;

public abstract class Clause implements Regexable {
    String name;

    public Clause(String name) {
        this.name = name;
    }

    public Clause() {
        this.name = "";
    }

    public String getName() {
        return this.name;
    }
}
