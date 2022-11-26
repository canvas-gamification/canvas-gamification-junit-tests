package global;

import global.exceptions.InvalidClauseException;
import global.tools.Logger;
import global.variables.Clause;
import global.variables.RandomClause;
import global.variables.clauses.PlaceHolder;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;

import static global.tools.CustomAssertions._assertTrue;
import static global.tools.CustomAssertions._fail;
import static global.tools.Logger.parseTestInformation;
import static global.utils.RegexUtil.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class ObjectTest {
    Class<?> objectClass;

    public ObjectTest(String objectClass) {
        try {
            this.objectClass = Class.forName(objectClass);
        } catch (ClassNotFoundException e) {
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

    public Object createInstance() throws Throwable {
        Object object = null;
        try {
            object = objectClass.getDeclaredConstructor().newInstance();
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw e.getCause();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            fail(String.join(" ", "The", objectClass.getSimpleName(), "class does not contain a required constructor."));
        }
        return object;
    }

    public boolean hasField(String fieldName, Class<?> fieldClass) {
        try {
            Field field = objectClass.getDeclaredField(fieldName);
            return true;
        } catch (NoSuchFieldException e) {
            // fail(String.join(" ", "Your", objectClass.getSimpleName(), "does not contain the field", fieldName, "."));
            return false;
        }
    }

    public Object getFieldValue(Object testObject, String fieldName, Class<?> fieldClass) {
        Object fieldValue = null;
        try {
            Field field = testObject.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            assertEquals(fieldClass, field.getType(), String.join(" ", "The field", fieldName, "is not the correct type."));
            fieldValue = field.get(testObject);
        } catch (NoSuchFieldException e) {
            fail(String.join("", "Your ", objectClass.getSimpleName(), " class does not contain the field ", fieldName, " ."));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return fieldValue;
    }

    public void setFieldValue(Object testObject, Object value, String fieldName, Class<?> fieldClass) {
        try {
            Field field = testObject.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            assertEquals(fieldClass, field.getType(), String.join(" ", "The field", fieldName, "is not the correct type."));
            Logger.logMessage(value.getClass() + "\n" + fieldClass.toString());
            Logger.logMessage(value.getClass().isInstance(fieldClass) + "");
            if (!value.getClass().isInstance(fieldClass)) {
                _fail("Error with test definition, please contact an administrator.",
                        "The type of value must match the type of the field you are trying to set.");
            }
            field.set(testObject, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail(String.join(" ", "Your", objectClass.getSimpleName(), "does not contain the field", fieldName, "."));
        }
    }

    public void setFieldValue(Object testObject, int value, String fieldName) {
        try {
            Field field = testObject.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            assertEquals(int.class, field.getType(), String.join(" ", "The field", fieldName, "is not the correct type."));
            field.set(testObject, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail(String.join(" ", "Your", objectClass.getSimpleName(), "does not contain the field", fieldName, "."));
        }
    }

    public void setFieldValue(Object testObject, double value, String fieldName) {
        try {
            Field field = testObject.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            assertEquals(double.class, field.getType(), String.join(" ", "The field", fieldName, "is not the correct type."));
            field.set(testObject, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail(String.join(" ", "Your", objectClass.getSimpleName(), "does not contain the field", fieldName, "."));
        }
    }

    public void setFieldValue(Object testObject, boolean value, String fieldName) {
        try {
            Field field = testObject.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            assertEquals(boolean.class, field.getType(), String.join(" ", "The field", fieldName, "is not the correct type."));
            field.set(testObject, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail(String.join(" ", "Your", objectClass.getSimpleName(), "does not contain the field", fieldName, "."));
        }
    }

    public void setFieldValue(Object testObject, char value, String fieldName) {
        try {
            Field field = testObject.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            assertEquals(char.class, field.getType(), String.join(" ", "The field", fieldName, "is not the correct type."));
            field.set(testObject, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail(String.join(" ", "Your", objectClass.getSimpleName(), "does not contain the field", fieldName, "."));
        }
    }

    public Object callMethod(String methodName) throws Throwable {
        return callMethod(methodName, null, null, null, "");
    }

    public Object callMethod(String methodName, Object object) throws Throwable {
        return callMethod(methodName, object, null, null, "");
    }

    public Object callMethod(String methodName, Object[][] arguments) throws Throwable {
        return callMethod(methodName, null, null, null, "");
    }

    public Object callMethod(String methodName, Clause[] methodTestSentence) throws Throwable {
        return callMethod(methodName, null, null, methodTestSentence, "");
    }

    public Object callMethod(String methodName, Object object, Object[][] arguments) throws Throwable {
        return callMethod(methodName, object, arguments, null, "");
    }

    public Object callMethod(String methodName, Object object, Clause[] methodTestSentence) throws Throwable {
        return callMethod(methodName, object, null, methodTestSentence, "");
    }

    public Object callMethod(String methodName, Object[][] arguments, Clause[] methodTestSentence) throws Throwable {
        return callMethod(methodName, null, arguments, methodTestSentence, "");
    }

    public Object callMethod(String methodName, Clause[] methodTestSentence, String incorrectMethodStructureErrorMessage) throws Throwable {
        return callMethod(methodName, null, null, methodTestSentence, incorrectMethodStructureErrorMessage);
    }

    public Object callMethod(String methodName, Object object, Object[][] arguments, Clause[] methodTestSentence) throws Throwable {
        return callMethod(methodName, object, arguments, methodTestSentence, "");
    }

    public Object callMethod(String methodName, Object[][] arguments, Clause[] methodTestSentence, String incorrectMethodStructureErrorMessage) throws Throwable {
        return callMethod(methodName, null, arguments, methodTestSentence, incorrectMethodStructureErrorMessage);
    }

    public Object callMethod(String methodName, Object object, Clause[] methodTestSentence, String incorrectMethodStructureErrorMessage) throws Throwable {
        return callMethod(methodName, object, null, methodTestSentence, incorrectMethodStructureErrorMessage);
    }

    public Object callMethod(String methodName, Object object, Object[][] arguments, Clause[] methodTestSentence, String incorrectMethodStructureErrorMessage) throws Throwable {
        Class<?>[] argsClass = getArgumentClasses(arguments);
        Object[] args = getArguments(arguments);
        try {
            Method objectMethodInvoke = objectClass.getMethod(methodName, argsClass);
            ByteArrayOutputStream methodOutput = new ByteArrayOutputStream();
            System.setOut(new PrintStream(methodOutput));
            Object output = objectMethodInvoke.invoke(object, args);
            methodOutputFollowsCorrectStructure(methodName, methodTestSentence, incorrectMethodStructureErrorMessage, methodOutput);
            return output;
        } catch (NoSuchMethodException e) {
            fail(String.join("", "Your ", objectClass.getSimpleName(),
                    " class does not contain the method ", methodName, "."));
            return null;
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw e.getCause();
        }
    }

    private Class<?>[] getArgumentClasses(Object[][] arguments) {
        if (Objects.isNull(arguments))
            return null;
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

    private Object[] getArguments(Object[][] arguments) {
        if (Objects.isNull(arguments))
            return null;
        Object[] args = new Object[arguments.length];
        for (int i = 0; i < arguments.length; i++)
            args[i] = arguments[i][0];
        return args;
    }

    private void methodOutputFollowsCorrectStructure(String methodName, Clause[] methodTestSentence, String incorrectMethodStructureErrorMessage, ByteArrayOutputStream methodOutput) throws InvalidClauseException {
        /*
            This method is a tweaked version of the outputFollowsCorrectStructure method in BaseTest which is used
            to check method console output using clauses. Note that random clauses and the placeHolder clause is not
            currently supported for methods.
         */

        String output = methodOutput.toString();

        if (methodTestSentence == null) {
            assertEquals("", output,
                    String.join(
                            "",
                            "Your ",
                            methodName,
                            " method ",
                            " in your ",
                            objectClass.getSimpleName(),
                            " class should not have any printed output.")
            );
        } else {
            // Checks that the test writer writes valid clauses does not use random clauses or placeHolder clauses
            validateMethodTestSentence(methodName, methodTestSentence);
            Matcher matcher = getMatches(output, processRegexForPrintlnOutput(combineRegex(methodTestSentence)));
            if (incorrectMethodStructureErrorMessage.equals(""))
                incorrectMethodStructureErrorMessage = String.join("", "Your ", methodName, " method output did not follow the correct structure/syntax.");
            _assertTrue(matcher.find(), incorrectMethodStructureErrorMessage, parseTestInformation(output, methodTestSentence, incorrectMethodStructureErrorMessage));
            // Ensures that the output matches the pattern exactly
            assertEquals(output.substring(matcher.start(), matcher.end()), output, incorrectMethodStructureErrorMessage);

            // check all clauses valid
            int matchGroupNum = 1;  // match group numbers are 1-indexed
            for (Clause clause : methodTestSentence) {
                // TODO: student-facing message can include details + feedback should be dynamic to the clause's error
                _assertTrue(clause.validate(matcher.group(matchGroupNum)), incorrectMethodStructureErrorMessage, "Invalid Clause output at index " + matchGroupNum + " :" + clause.getInvalidMessage());
                matchGroupNum++;
            }
        }
    }

    private void validateMethodTestSentence(String methodName, Clause[] methodTestSentence) throws InvalidClauseException {
        /*
         This method makes sure that the clause structure is defined correctly, and the test writer does not use any
         features which are not allowed in methods. Parts of this method are adapted from the setRegexSentence in
         BaseTest.
         */

        //By using a set we can ensure that there are no duplicates in the regexSentence
        Set<String> namesSet = new HashSet<>();

        int i = 1;
        for (Clause clause : methodTestSentence) {
            if (clause instanceof RandomClause || clause instanceof PlaceHolder)
                _fail("There is an issue with the test definition. Please contact an administrator.",
                        "Error with test definition: The method clause system does not support random clauses or the placeHolder clause.");
            if (clause.getName() != null) {
                if (namesSet.contains(clause.getName())) {
                    _fail("There is an issue with the test definition. Please contact an administrator.",
                            "The name " + clause.getName() + " is already in use. Make sure all names are unique");
                }
                namesSet.add(clause.getName());
            }
            try {
                clause.validateParams();
            } catch (InvalidClauseException e) {
                throw new InvalidClauseException("The parameter(s) for the " + methodName + " method clause at index " + i + " are invalid. " + e.getMessage());
            }
            i += 1;
        }
    }

    public String missingFieldValueMessage(String fieldName) {
        return String.join("", "Your ", objectClass.getSimpleName(), " class does not contain the field ", fieldName, ".");
    }
}
