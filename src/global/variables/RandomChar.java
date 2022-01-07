package global.variables;

import java.util.ArrayList;
import java.util.HashMap;

public class RandomChar implements Clause, RandomVariable<Character> {
    public int lower, upper;

    public RandomChar(char lower, char upper) {
        this.lower = lower;
        this.upper = upper;
    }

    public void addValueToMapListHelper(HashMap<Integer, ?> map, int mapKey, Object newListValue) {
        ((ArrayList<Character>) map.get(mapKey)).add((char) newListValue);
    }

    public ArrayList<Character> createArrayList() {
        return new ArrayList<>();
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
