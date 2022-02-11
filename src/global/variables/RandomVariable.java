package global.variables;

import global.utils.RandomUtil;

public interface RandomVariable<T> {
    void trackValue(int groupNum, String newListValue);

    boolean validateRandom(int groupNum);

    T convertFromRegexGroup(String groupValue);
}
