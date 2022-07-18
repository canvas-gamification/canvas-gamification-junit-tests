package global.tools;

public class TypeMatcher {
    static String simplifyPrimitiveTypeName(String canonicalTypeName) {
        if (canonicalTypeName.startsWith("java.lang.")) {
            String typeName = canonicalTypeName.split("java\\.lang\\.")[1];
            return switch (typeName) {
                case "Integer" -> "int";
                case "String" -> "string";
                case "Character" -> "char";
                default -> typeName;
            };
        }
        return canonicalTypeName;
    }
}
