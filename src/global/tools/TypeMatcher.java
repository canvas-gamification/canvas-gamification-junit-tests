package global.tools;

public class TypeMatcher {
    static String simplifyPrimitiveTypeName(String canonicalTypeName) {
        if (canonicalTypeName.startsWith("java.lang.")) {
            String typeName = canonicalTypeName.split("java\\.lang\\.")[1];
            switch (typeName) {
                case "Integer":
                    return "int";
                case "String":
                    return "string";
                case "Character":
                    return "char";
                default:
                    return typeName;
            }
        }
        return canonicalTypeName;
    }
}
