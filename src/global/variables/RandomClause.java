package global.variables;

public interface RandomClause<T> {
    void trackValue(int groupNum, String newListValue);

    boolean validateRandom(int groupNum);

    T convertFromRegexGroup(String groupValue);
}
