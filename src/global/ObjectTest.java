package global;

import global.exceptions.InvalidClauseException;
import global.variables.Clause;
import global.variables.RandomClause;
import global.variables.clauses.PlaceHolder;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.*;
import java.util.*;
import java.util.regex.Matcher;

import static global.tools.CustomAssertions._assertTrue;
import static global.tools.CustomAssertions._fail;
import static global.tools.Logger.parseTestInformation;
import static global.utils.RegexUtil.*;
import static org.junit.jupiter.api.Assertions.*;

public class ObjectTest {
    Class<?> objectClass;

    public ObjectTest(String objectClass) {
        try {
            this.objectClass = Class.forName(objectClass);
        } catch (ClassNotFoundException e) {
            fail("Your program does not contain the class " + objectClass);
        }
    }
    // TODO: When specifying methods and parameters, you can also specify the modifier (public, private, etc.) and it should check that

    public boolean hasSuperclass(Class<?> superClass) {
        Class<?> objectSuperclass = objectClass.getSuperclass();
        return superClass.equals(objectSuperclass);
    }

    public boolean implementsInterfaces(Class<?>[] interfaces) {
        ArrayList<Class<?>> objectClassInterfaces = new ArrayList<>(Arrays.asList(objectClass.getInterfaces()));
        for (Class<?> item : interfaces) {
            if (!objectClassInterfaces.contains(item))
                return false;
        }
        return true;
    }

    public boolean implementsInterface(Class<?> interfaceClass) {
        ArrayList<Class<?>> objectClassInterfaces = new ArrayList<>(Arrays.asList(objectClass.getInterfaces()));
        return objectClassInterfaces.contains(interfaceClass);
    }

    public boolean hasConstructor(Class<?>[] argsClass) {
        try {
            Constructor<?> constructor = objectClass.getDeclaredConstructor(argsClass);
            return true;
        } catch (NoSuchMethodException e) {
            return false;
        }
    }

    public boolean hasConstructor(Class<?>[] argsClass, String[] modifiers) {
        try {
            Constructor<?> constructor = objectClass.getDeclaredConstructor(argsClass);
            return true;
        } catch (NoSuchMethodException e) {
            return false;
        }
    }

    public Object createInstance(Object[][] arguments) throws Throwable {
        // Creates an instance of the object using the constructor which matches the provided arguments.
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

    // Only check if that field exists

    // If it exists AND has correct modifiers

    public boolean hasField(String fieldName, Class<?> fieldClass, String[] modifiers) {
        try {
            Field f = objectClass.getDeclaredField(fieldName);
            return fieldClass.equals(f.getType());
        } catch (NoSuchFieldException e) {
            return false;
        }
    }

    public void assertField(boolean hasField, String fieldName, Class<?> fieldClass) {
        assertTrue(hasField, String.join(
                " ",
                "Your", objectClass.getSimpleName(),
                "does not contain the field",
                fieldName,
                " of the type ",
                fieldClass.getSimpleName(),
                " with the correct modifiers.")
        );
    }

    public boolean hasModifier(Field field, String modifier) {
        return hasModifier(field.getModifiers(), modifier);
    }

    public boolean hasModifier(Constructor<?> constructor, String modifier) {
        return hasModifier(constructor.getModifiers(), modifier);
    }

    public boolean hasModifier(String modifier) {
        return hasModifier(objectClass.getModifiers(), modifier);
    }

    public boolean hasModifier(Method method, String modifier) {
        return hasModifier(method.getModifiers(), modifier);
    }

    private boolean hasModifier(int modifierInteger, String modifier) {
        /*
            The modifier values below for the default modifier is based on the java constant values documentation.
            The comparison is done in binary as there is no method in the modifiers class for checking if something
            has the default modifier, but the modifier int in binary will have its final three bits as zeros if the field
            is using the default modifier.

            // Documentation on modifier ints
            https://docs.oracle.com/javase/7/docs/api/constant-values.html#java.lang
         */

        switch (modifier) {
            case "public":
                return Modifier.isPublic(modifierInteger);
            case "private":
                return Modifier.isPrivate(modifierInteger);
            case "protected":
                return Modifier.isProtected(modifierInteger);
            case "static":
                return Modifier.isStatic(modifierInteger);
            case "final":
                return Modifier.isFinal(modifierInteger);
            case "abstract":
                return Modifier.isAbstract(modifierInteger);
            case "interface":
                return Modifier.isInterface(modifierInteger);
            case "default":
                // Gets last three bits of modifier binary number and checks if they are zero
                String binaryInt = Integer.toBinaryString(modifierInteger);
                String fieldModifier = binaryInt.substring(binaryInt.length() > 3 ? binaryInt.length() - 3 : 0);
                int number = Integer.parseInt(fieldModifier, 2);
                return number == 0;
        }
        return false;
    }

    public Field getObjectField(Object testObject, String fieldName) {
        Field field = null;
        try {
            field = testObject.getClass().getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            fail(String.join("", "Your ", objectClass.getSimpleName(), " class does not contain the field ", fieldName, " ."));
        }
        return field;
    }

    public Object getFieldValue(Object testObject, String fieldName) {
        // Returns the value of the specified field from the passed object
        Object fieldValue = null;
        try {
            Field field = testObject.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            fieldValue = field.get(testObject);
        } catch (NoSuchFieldException e) {
            fail(String.join("", "Your ", objectClass.getSimpleName(), " class does not contain the field ", fieldName, " ."));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return fieldValue;
    }

    public void setFieldValue(Object testObject, Object value, String fieldName, Class<?> fieldClass) {
        // Sets the value of the specified field of the passed object
        try {
            Field field = testObject.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(testObject, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail(String.join(" ", "Your", objectClass.getSimpleName(), "does not contain the field", fieldName, "."));
        }
    }

    public void setFieldValue(Object testObject, int value, String fieldName) {
        try {
            Field field = testObject.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(testObject, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail(String.join(" ", "Your", objectClass.getSimpleName(), "does not contain the field", fieldName, "."));
        }
    }

    public void setFieldValue(Object testObject, double value, String fieldName) {
        try {
            Field field = testObject.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(testObject, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail(String.join(" ", "Your", objectClass.getSimpleName(), "does not contain the field", fieldName, "."));
        }
    }

    public void setFieldValue(Object testObject, boolean value, String fieldName) {
        try {
            Field field = testObject.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(testObject, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail(String.join(" ", "Your", objectClass.getSimpleName(), "does not contain the field", fieldName, "."));
        }
    }

    public void setFieldValue(Object testObject, char value, String fieldName) {
        try {
            Field field = testObject.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
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
