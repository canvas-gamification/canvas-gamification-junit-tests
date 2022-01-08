package global.variables.wrappers;

import global.variables.Clause;

// Idea: AnyOf([RandomChar(), StringLiteral()], [StringLiteral(), RandomInt()])
public class AnyOf implements Clause {
    // Any one of the options
    Clause[][] outputOptions;
    public AnyOf(Clause[]... outputOptions) {
        this.outputOptions = outputOptions;
    }

    public String getRegex() {
        // TODO: finish
        return "|";
    }
}
