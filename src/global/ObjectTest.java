package global;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import static global.tools.CustomAssertions._fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ObjectTest {
    Class<?> objectClass;

    public ObjectTest(String objectClass) {
        try {
            this.objectClass = Class.forName(objectClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            fail("Your program does not contain the class " + objectClass);
        }
    }

    public Object createInstance(Object[][] arguments) throws Throwable {
        Class<?>[] argsClass = getArgumentClasses(arguments);
        Object[] args = getArguments(arguments);
        Object object = null;
        try {
            object = objectClass.getDeclaredConstructor(argsClass).newInstance(args);
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw e.getCause();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            fail(String.join(" ", "The", objectClass.getSimpleName(), "class does not contain a required constructor."));
        }
        return object;
    }

    public void hasField(String fieldName, Class<?> fieldClass) {
        try{
            Field field = objectClass.getField(fieldName);
            assertEquals(fieldClass, field.getDeclaringClass(), String.join(" ", "The field", fieldName, "is not the correct type."));
        } catch (NoSuchFieldException e) {
            fail(String.join(" ", "Your", objectClass.getSimpleName(), "does not contain the field", fieldName, "."));
        }
    }

    public Object getFieldValue(String fieldName, Class<?> fieldClass) {
        try{
            Field field = objectClass.getField(fieldName);
            assertEquals(fieldClass, field.getDeclaringClass(), String.join(" ", "The field", fieldName, "is not the correct type."));
            // return field.get(Object);
        } catch (NoSuchFieldException e) {
            fail(String.join(" ", "Your", objectClass.getSimpleName(), "does not contain the field", fieldName, "."));
        }
        return null;
    }

    public Object callMethod(){
        return null;
    }

    private Class<?>[] getArgumentClasses(Object[][] arguments){
        Class<?>[] argsClass = new Class[arguments.length];
        for (int i = 0; i < arguments.length; i++)
            if (arguments[i][1] instanceof Class<?>) {
                argsClass[i] = (Class<?>) arguments[i][1];
            } else {
                _fail("Error with test definition: please contact an administrator",
                        "Error with test definition: index [1] of the arguments array must contain a class type.");
            }
        return argsClass;
    }

    private Object[] getArguments(Object[][] arguments){
        Object[] args = new Object[arguments.length];
        for (int i = 0; i < arguments.length; i++)
            args[i] = arguments[i][0];
        return args;
    }
}
