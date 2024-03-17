package oop.programs_with_interesting_classes.easy.q7;

import global.ObjectTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static global.tools.CustomAssertions._assertArrayEquals;
import static global.tools.CustomAssertions._assertEquals;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    // Parsons

    private final String className1 = "Song";
    private final String firstAttributeName1 = "title";
    private final String secondAttributeName1 = "length";
    private final String className2 = "Playlist";
    private final String firstAttributeName2 = "songs";
    private final String secondAttributeName2 = "numItems";
    private final String methodName1 = "expandPlaylist";
    private final String methodName2 = "addToPlaylist";
    private final String testClassName = "Test";

    private ObjectTest testClass1;
    private ObjectTest testClass2;
    private ObjectTest classObject;

    @BeforeEach
    public void setUp() {
        String packageString1 = "oop.programs_with_interesting_classes.easy.q7." + className1;
        testClass1 = new ObjectTest(packageString1);
        String packageString2 = "oop.programs_with_interesting_classes.easy.q7." + className2;
        testClass2 = new ObjectTest(packageString2);
        String testClassString = "oop.programs_with_interesting_classes.easy.q7." + testClassName;
        classObject = new ObjectTest(testClassString);
    }

    @Test
    public void songHasRequiredAttributes() {
        String missingAttributeMessage = "The %s class is missing the %s attribute. Make sure that the class contains the attribute and it is spelt correctly.";
        String wrongTypeMessage = "The %s attribute in the %s class has the wrong type.";
        String wrongModifierMessage = "The %s attribute in the %s class has the wrong visibility modifier.";
        assertTrue(testClass1.hasField(firstAttributeName1), String.format(missingAttributeMessage, className1, firstAttributeName1));
        assertTrue(testClass1.hasField(firstAttributeName1, String.class), String.format(wrongTypeMessage, firstAttributeName1, className1));
        assertTrue(testClass1.hasModifier(firstAttributeName1, "private"), String.format(wrongModifierMessage, firstAttributeName1, className1));
        assertTrue(testClass1.hasField(secondAttributeName1), String.format(missingAttributeMessage, className1, secondAttributeName1));
        assertTrue(testClass1.hasField(secondAttributeName1, double.class), String.format(wrongTypeMessage, secondAttributeName1, className1));
        assertTrue(testClass1.hasModifier(secondAttributeName1, "private"), String.format(wrongModifierMessage, secondAttributeName1, className1));
    }

    @Test
    public void playlistHasRequiredAttributes() {
        String missingAttributeMessage = "The %s class is missing the %s attribute. Make sure that the class contains the attribute and it is spelt correctly.";
        String wrongTypeMessage = "The %s attribute in the %s class has the wrong type.";
        String wrongModifierMessage = "The %s attribute in the %s class has the wrong visibility modifier.";
        assertTrue(testClass2.hasField(firstAttributeName2), String.format(missingAttributeMessage, className2, firstAttributeName2));
        assertTrue(testClass2.hasField(firstAttributeName2, Song[].class), String.format(wrongTypeMessage, firstAttributeName2, className2));
        assertTrue(testClass2.hasModifier(firstAttributeName2, "private"), String.format(wrongModifierMessage, firstAttributeName2, className2));
        assertTrue(testClass2.hasField(secondAttributeName2), String.format(missingAttributeMessage, className2, secondAttributeName2));
        assertTrue(testClass2.hasField(secondAttributeName2, int.class), String.format(wrongTypeMessage, secondAttributeName2, className2));
        assertTrue(testClass2.hasModifier(secondAttributeName2, "private"), String.format(wrongModifierMessage, secondAttributeName2, className2));
    }

    @Test
    public void songHasRequiredConstructor() {
        String missingConstructorMessage = "The %s class is missing a required constructor. Make sure that it is named correctly and has the correct parameters.";
        String wrongAccessModifier = "The %s class constructor has the wrong visibility modifier. Make sure that it is visible from all other classes.";
        Class<?>[] constructorArgs = new Class[]{String.class, double.class};
        assertTrue(testClass1.hasConstructor(constructorArgs), String.format(missingConstructorMessage, className1));
        assertTrue(testClass1.hasModifier(constructorArgs, "public"), String.format(wrongAccessModifier, className1));
    }

    @Test
    public void playlistHasRequiredConstructor() {
        String missingConstructorMessage = "The %s class is missing a required constructor. Make sure that it is named correctly and has the correct parameters.";
        String wrongAccessModifier = "The %s class constructor has the wrong visibility modifier. Make sure that it is visible from all other classes.";
        Class<?>[] constructorArgs = new Class[]{};
        assertTrue(testClass2.hasConstructor(constructorArgs), String.format(missingConstructorMessage, className2));
        assertTrue(testClass2.hasModifier(constructorArgs, "public"), String.format(wrongAccessModifier, className2));
    }

    private static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of("Bohemian Rhapsody", 5.92),
                Arguments.of("Billie Jean", 4.90),
                Arguments.of("Like a Rolling Stone", 6.22),
                Arguments.of("Stairway to Heaven", 8.03),
                Arguments.of("I Will Always Love You", 4.52),
                Arguments.of("Shape of You", 3.88),
                Arguments.of("Smells Like Teen Spirit", 5.02),
                Arguments.of("Rolling in the Deep", 3.80),
                Arguments.of("Imagine", 3.07),
                Arguments.of("Superstition", 4.43)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void songConstructorInitializesValuesCorrectly(String value1, double value2) throws Throwable {
        String wrongValueMessage = "The %s constructor did not initialize the %s attribute to the correct value based on the parameters passed to the constructor.";
        Object[][] constructorArgs = {
                {value1, String.class},
                {value2, double.class}
        };
        Object checkupInstance = testClass1.createInstance(constructorArgs);
        _assertEquals(value1, testClass1.getFieldValue(checkupInstance, firstAttributeName1), String.format(wrongValueMessage, className1, firstAttributeName1));
        _assertEquals(value2, testClass1.getFieldValue(checkupInstance, secondAttributeName1), String.format(wrongValueMessage, className1, secondAttributeName1));
    }

    @Test
    public void playlistConstructorInitializesValuesCorrectly() throws Throwable {
        String wrongValueMessage = "The %s constructor did not initialize the %s attribute to the correct value based on the parameters passed to the constructor.";
        Object[][] constructorArgs = {};
        Object checkupInstance = testClass2.createInstance(constructorArgs);
        _assertArrayEquals(new Song[3], testClass2.getFieldValue(checkupInstance, firstAttributeName2), String.format(wrongValueMessage, className2, firstAttributeName2));
        _assertEquals(0, testClass2.getFieldValue(checkupInstance, secondAttributeName2), String.format(wrongValueMessage, className2, secondAttributeName2));
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void songClassHasCorrectToStringMethod(String value1, double value2) throws Throwable {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass1.hasMethod("toString", null), String.format(incorrectMethodDefinition, "toString", className1));
        assertTrue(testClass1.hasModifier("toString", null, "public"), String.format(incorrectModifierMessage, "toString", className1));
        assertTrue(testClass1.hasReturnType("toString", null, String.class), String.format(incorrectReturnType, "toString", className1));
        Object[][] arguments = {
                {value1, String.class},
                {value2, double.class}
        };
        Object classInstance = testClass1.createInstance(arguments);
        String[] methodModifiers = {"public"};
        String expected = "The " + value1 + " track is " + value2 + " minuets long.";
        String incorrectToStringMessage = String.join(" ",
                "Your", className1, "toString method does not return the correct String.");
        Object output = testClass1.callMethod("toString", methodModifiers, classInstance);
        _assertEquals(expected, output, incorrectToStringMessage);
    }

    @Test
    public void playlistClassHasCorrectToStringMethod() throws Throwable {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass2.hasMethod("toString", null), String.format(incorrectMethodDefinition, "toString", className2));
        assertTrue(testClass2.hasModifier("toString", null, "public"), String.format(incorrectModifierMessage, "toString", className2));
        assertTrue(testClass2.hasReturnType("toString", null, String.class), String.format(incorrectReturnType, "toString", className2));
        Object tests[][] = {
                {"Bohemian Rhapsody", 5.92},
                {"Billie Jean", 4.90},
                {"Like a Rolling Stone", 6.22},
                {"Stairway to Heaven", 8.03},
                {"I Will Always Love You", 4.52},
                {"Shape of You", 3.88},
                {"Smells Like Teen Spirit", 5.02},
                {"Rolling in the Deep", 3.80},
                {"Imagine", 3.07},
                {"Superstition", 4.43}
        };
        Object classInstance = testClass2.createInstance();
        String[] methodModifiers = {"public"};
        Object output = testClass2.callMethod("toString", methodModifiers, classInstance);
        String incorrectToStringMessage = String.join(" ",
                "Your", className2, "toString method does not return the correct String.");
        String expected = "Playlist:\n";
        _assertEquals(expected, output, incorrectToStringMessage);
        Song[] songs = new Song[10];
        for(int i = 0; i < tests.length; i ++) {
            songs[i] = new Song((String) tests[i][0], (double) tests[i][1]);
            testClass2.setFieldValue(classInstance, songs, firstAttributeName2);
            testClass2.setFieldValue(classInstance, i + 1, secondAttributeName2);
            expected += "The " + tests[i][0] + " track is " + tests[i][1] + " minuets long.\n";
            output = testClass2.callMethod("toString", methodModifiers, classInstance);
            _assertEquals(expected, output, incorrectToStringMessage);
        }
    }

    @Test
    public void playlistClassHasCorrectExpandPlaylistMethod() throws Throwable {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass2.hasMethod(methodName1, null), String.format(incorrectMethodDefinition, methodName1, className2));
        assertTrue(testClass2.hasModifier(methodName1, null, "public"), String.format(incorrectModifierMessage, methodName1, className2));
        assertTrue(testClass2.hasReturnType(methodName1, null, Void.TYPE), String.format(incorrectReturnType, methodName1, className2));
        Object tests[][] = {
                {"Bohemian Rhapsody", 5.92},
                {"Billie Jean", 4.90},
                {"Like a Rolling Stone", 6.22},
                {"Stairway to Heaven", 8.03},
                {"I Will Always Love You", 4.52},
                {"Shape of You", 3.88},
                {"Smells Like Teen Spirit", 5.02},
                {"Rolling in the Deep", 3.80},
                {"Imagine", 3.07},
                {"Superstition", 4.43}
        };
        for(int i = 0; i < tests.length; i ++) {
            Object classInstance = testClass2.createInstance();
            Song[] songs = new Song[i + 1];
            for(int j = 0; j <= i; j ++) songs[j] = new Song((String)tests[i][0], (double)tests[i][1]);
            testClass2.setFieldValue(classInstance, songs, firstAttributeName2);
            testClass2.setFieldValue(classInstance, i + 1, secondAttributeName2);
            String incorrectNumDays = "The %s method in the %s class does not correctly expand the %s attribute.";
            testClass2.callMethod(methodName1, classInstance);
            Song[] ans = new Song[2 * i + 2];
            for(int j = 0; j <= i; j ++) ans[j] = songs[j];
            _assertArrayEquals(ans, testClass2.getFieldValue(classInstance, firstAttributeName2),
                    String.format(incorrectNumDays, methodName1, className2, firstAttributeName2));
        }
    }

    @Test
    public void playlistClassHasCorrectAddToPlaylistMethod() throws Throwable {
        String incorrectMethodDefinition = "The %s method in the %s class is not defined correctly. Make sure it is declared, spelt correctly, and has the correct parameters.";
        String incorrectModifierMessage = "The %s method in the %s class has the wrong visibility modifier.";
        String incorrectReturnType = "The %s method in the %s class has the incorrect return type.";
        assertTrue(testClass2.hasMethod(methodName2, new Class[]{Song.class}), String.format(incorrectMethodDefinition, methodName2, className2));
        assertTrue(testClass2.hasModifier(methodName2, new Class[]{Song.class}, "public"), String.format(incorrectModifierMessage, methodName2, className2));
        assertTrue(testClass2.hasReturnType(methodName2, new Class[]{Song.class}, Void.TYPE), String.format(incorrectReturnType, methodName2, className2));
        Object tests[][] = {
                {"Bohemian Rhapsody", 5.92},
                {"Billie Jean", 4.90},
                {"Like a Rolling Stone", 6.22},
                {"Stairway to Heaven", 8.03},
                {"I Will Always Love You", 4.52},
                {"Shape of You", 3.88},
                {"Smells Like Teen Spirit", 5.02},
                {"Rolling in the Deep", 3.80},
                {"Imagine", 3.07},
                {"Superstition", 4.43}
        };
        Object classInstance = testClass2.createInstance();
        Song[] songs = new Song[3];
        int t = 0;
        for(int i = 0; i < tests.length; i ++) {
            if(t == songs.length){
                Song[] temp = new Song[2 * songs.length];
                for(int j = 0; j < songs.length; j ++)
                    temp[j] = songs[j];
                songs = temp;

            }
            songs[t ++] = new Song((String)tests[i][0], (double)tests[i][1]);
            Object[][] arguments = new Object[][]{
                    {new Song((String)tests[i][0], (double)tests[i][1]), Song.class}
            };
            testClass2.callMethod(methodName2, arguments, classInstance);
            String incorrectNumDays = "The %s method in the %s class does not correctly add to the %s attribute.";
            Song[] ans = (Song[])testClass2.getFieldValue(classInstance, firstAttributeName2);
            for(int j = 0; j < songs.length; j++){
                if(songs[j] != null && ans[j] != null)
                    _assertEquals(songs[j].toString(), ans[j].toString(), String.format(incorrectNumDays, methodName2, className2, firstAttributeName2));
            }
            _assertEquals(t, testClass2.getFieldValue(classInstance, secondAttributeName2),
                    String.format(incorrectNumDays, methodName2, className2, secondAttributeName2));
        }
    }
}
