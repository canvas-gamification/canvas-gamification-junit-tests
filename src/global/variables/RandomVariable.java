package global.variables;

import java.util.ArrayList;
import java.util.HashMap;

public interface RandomVariable<T> {
    T convertFromRegexGroup(String groupValue);

    ArrayList<T> createArrayList();

    void addValueToMapListHelper(HashMap<Integer, ?> map, int mapKey, Object newListValue);
}
