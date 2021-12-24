package global.randomframework;

public class RandomChar implements VariableNode, RandomVariable {
    public int lower, upper;

    public RandomChar(char lower, char upper) {
        this.lower = lower;
        this.upper = upper;
    }

    public int getLower() {
        return lower;
    }

    public int getUpper() {
        return upper;
    }

    @Override
    public String getRegex() {
        return "";
    }
}
