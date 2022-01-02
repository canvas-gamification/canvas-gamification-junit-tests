package global.variables;

public interface RandomVariable<T> {
    T convertFromRegexGroup(String groupValue);
}
