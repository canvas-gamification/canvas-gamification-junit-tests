package global.variables.clauses;

import global.tools.InvalidClauseException;
import global.variables.Clause;

public class DoubleLiteral extends Clause {
    private String mode;
    public static final String RANGE = "range";
    double upper;
    double lower;


    public DoubleLiteral(double lower, double upper, String name) {
        super(name);
        this.mode = RANGE;
        this.upper = upper;
        this.lower = lower;
    }

    public DoubleLiteral(double lower, double upper) {
        this.mode = RANGE;
        this.upper = upper;
        this.lower = lower;
    }

    public DoubleLiteral(String name) {
        super(name);
    }

    public DoubleLiteral() {
    }

    public double getUpper() {
        return upper;
    }

    public double getLower() {
        return lower;
    }

    @Override
    public boolean validate(String matchGroupString) {
        if (this.mode != null && this.mode.equals(DoubleLiteral.RANGE)) {
            double matchGroupDouble = Double.parseDouble(matchGroupString);
            return getLower() <= matchGroupDouble && matchGroupDouble <= getUpper();
        }
        return true;
    }

    @Override
    public void validateParams() throws InvalidClauseException {
        if (this.mode != null && this.mode.equals(IntegerLiteral.RANGE)) {
            if (getLower() > getUpper()) {
                throw new InvalidClauseException("Lower bound cannot be greater than upper bound");
            }
        }
    }

    @Override
    public String getInvalidMessage() {
        return "Invalid double value or value out of range";
    }

    @Override
    public String getRegex() {
        // This matches any double value as long as it has 1 or more digits in the number part and the decimal part
        return "(\\d+\\.\\d+)";
    }
}
