package global.variables;

import java.util.ArrayList;

public interface RandomClause<T> {

    void trackValue(int groupNum, String newListValue);

    boolean validateRandom(int groupNum);

    T convertFromRegexGroup(String groupValue);

    ArrayList<T> getValuesForMatchGroup(int matchGroup);

    Class<?> getPrimitiveClass ();
    int getMapKey();

    void incrementMapKey();
}
