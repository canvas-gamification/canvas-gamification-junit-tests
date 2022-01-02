package global.variables;

public class RandomChar implements Regexable, RandomVariable<Character> {
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

    public Character convertFromRegexGroup(String groupString) {
        if(groupString.length() > 1) {
            // TODO: throw appropriate error for this case
            throw new IndexOutOfBoundsException();
        }
        return groupString.charAt(0);
    }

    @Override
    public String getRegex() {
        String regex = "[" + (char)getLower() + "-" + (char)getUpper() + "]";
        return "(" + regex + ")";
    }
}
