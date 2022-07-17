package global.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class ClassUtil {
    static String removePackageNameFromClassProperty(String classProperty) {
        String[] classPropertySplit = classProperty.split("\\s");
        String className = classPropertySplit[classPropertySplit.length - 1];
        String cleanClassName = className.substring(className.lastIndexOf('.') + 1);
        classPropertySplit[classPropertySplit.length - 1] = cleanClassName;
        return String.join(" ", classPropertySplit);
    }

    public static String[] getAllConstructors(Class<?> testClass) {
        ArrayList<String> constructors = new ArrayList<>();
        for (Constructor<?> c : testClass.getDeclaredConstructors()) {
            constructors.add(removePackageNameFromClassProperty(c.toString()));
        }
        String[] constructorsArray = new String[constructors.size()];
        constructors.toArray(constructorsArray);
        return constructorsArray;
    }

    public static String[] getAllMethods(Class<?> testClass) {
        ArrayList<String> methods = new ArrayList<>();
        for (Method m : testClass.getDeclaredMethods()) {
            methods.add(removePackageNameFromClassProperty(m.toString()));
        }
        String[] methodsArray = new String[methods.size()];
        methods.toArray(methodsArray);
        return methodsArray;
    }

    public static String[] getAllAttributes(Class<?> testClass) {
        ArrayList<String> attributes = new ArrayList<>();
        for (Field f : testClass.getDeclaredFields()) {
            attributes.add(removePackageNameFromClassProperty(f.toString()));
        }
        String[] attributesArray = new String[attributes.size()];
        attributes.toArray(attributesArray);
        return attributesArray;
    }

    public static boolean classHasAttribute(Class<?> testClass, String attribute) {
        String[] attributes = getAllAttributes(testClass);
        for (String attr : attributes) {
            if (attr.contains(attribute)) {
                return true;
            }
        }
        return false;
    }

    public static boolean classHasMethod(Class<?> testClass, String method) {
        String[] methods = getAllMethods(testClass);
        for (String m : methods) {
            if (m.contains(method)) {
                return true;
            }
        }
        return false;
    }

    public static boolean classHasConstructor(Class<?> testClass, String constructor) {
        String[] constructors = getAllConstructors(testClass);
        for (String c : constructors) {
            if (c.contains(constructor)) {
                return true;
            }
        }
        return false;
    }

    public static boolean classHasAttributes(Class<?> testClass, String... attributes) {
        for (String attribute : attributes) {
            if (!classHasAttribute(testClass, attribute)) {
                return false;
            }
        }
        return true;
    }

    public static boolean classHasMethods(Class<?> testClass, String... methods) {
        for (String method : methods) {
            if (!classHasMethod(testClass, method)) {
                return false;
            }
        }
        return true;
    }

    public static boolean classHasConstructors(Class<?> testClass, String... constructors) {
        for (String constructor : constructors) {
            if (!classHasConstructor(testClass, constructor)) {
                return false;
            }
        }
        return true;
    }
}
