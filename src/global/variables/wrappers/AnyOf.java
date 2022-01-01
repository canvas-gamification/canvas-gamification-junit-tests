package global.variables.wrappers;

import global.variables.Regexable;

// Idea: AnyOf([RandomChar(), StringLiteral()], [StringLiteral(), RandomInt()])
public class AnyOf implements Regexable {
    // Any one of the options
    Regexable[][] outputOptions;
    public AnyOf(Regexable[]... outputOptions) {
        this.outputOptions = outputOptions;
    }

    public String getRegex() {
        // TODO: finish
        return "|";
    };
}
