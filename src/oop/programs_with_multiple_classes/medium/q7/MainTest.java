package oop.programs_with_multiple_classes.medium.q7;

import global.ObjectTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertArrayEquals;
import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    // Java

    private final String knifeClass = "Knife";
    private final String cabinetClass = "Cabinet";
    private final String varSize = "size";
    private final String varMaterial = "materialType";
    private final String varCapacity = "capacity";
    private final String varFull = "isFull";
    private final String varKnifes = "knifes";
    public ObjectTest knife;
    public ObjectTest cabinet;

    @BeforeEach
    public void setup() throws Throwable {
        String knifeClassString = "oop.programs_with_multiple_classes.medium.q7." + knifeClass;
        String cabinetClassString = "oop.programs_with_multiple_classes.medium.q7." + cabinetClass;
        knife = new ObjectTest(knifeClassString);
        cabinet = new ObjectTest(cabinetClassString);
        String modifiedKnifeMessage =
                "You have modified the provided portions of class " + knifeClass + ". Please revert them to the original state.";
        assertTrue(knife.hasField(varSize, int.class), modifiedKnifeMessage);
        assertTrue(knife.hasModifier(varSize, "private"), modifiedKnifeMessage);
        assertTrue(knife.hasField(varMaterial, String.class), modifiedKnifeMessage);
        assertTrue(knife.hasModifier(varMaterial, "private"), modifiedKnifeMessage);
        String modifiedCabMessage =
                "You have modified the provided portions of class " + cabinetClass + ". Please revert them to the original state.";
        Class<?>[] classArguments = {int.class, boolean.class};
        assertTrue(cabinet.hasConstructor(classArguments), modifiedCabMessage);
        assertTrue(cabinet.hasModifier(classArguments, "public"), modifiedCabMessage);

        Object[][] test = {{10, true}, {20, false}, {50, true}};
        for (int testNum = 0; testNum < test.length; testNum++) {
            int capacity = (int) test[testNum][0];
            boolean isFull = (boolean) test[testNum][1];
            Object[][] arguments = {
                    {capacity, int.class},
                    {isFull, boolean.class}
            };
            Object cabinetInstance = cabinet.createInstance(arguments);
            _assertEquals(capacity, cabinet.getFieldValue(cabinetInstance, varCapacity),modifiedCabMessage);
            _assertEquals(isFull, cabinet.getFieldValue(cabinetInstance, varFull),modifiedCabMessage);
            _assertArrayEquals(new Knife[capacity], cabinet.getFieldValue(cabinetInstance, varKnifes),modifiedCabMessage);
        }
    }

    @Test
    public void cabinetClassHasCorrectAttributes() {
        assertTrue(cabinet.hasField(varCapacity, int.class),
                "Your " + cabinetClass + " class is missing the " + varCapacity + " attribute.");
        assertTrue(cabinet.hasModifier(varCapacity, "private"),
                "Your " + varCapacity + " attribute does not have the correct visibility modifier.");
        assertTrue(cabinet.hasField(varFull, boolean.class),
                "Your " + cabinetClass + " class is missing the " + varFull + " attribute.");
        assertTrue(cabinet.hasModifier(varFull, "private"),
                "Your " + varFull + " attribute does not have the correct visibility modifier.");
        assertTrue(cabinet.hasField(varKnifes, Knife[].class),
                "Your " + cabinetClass + " class is missing the " + varKnifes + " attribute.");
        assertTrue(cabinet.hasModifier(varKnifes, "private"),
                "Your " + varKnifes + " attribute does not have the correct visibility modifier.");
    }

    @Test
    public void knifeClassHasRequiredConstructor() {
        Class<?>[] classArguments = {int.class, String.class};
        assertTrue(knife.hasConstructor(classArguments),
                "Your " + knifeClass + " constructor does not have the correct parameters.");
        assertTrue(knife.hasModifier(classArguments, "public"),
                "Your " + knifeClass + " constructor does not have the correct visibility modifier.");
    }


    private static Stream<Arguments> knifeInputProvider() {
        return Stream.of(
                Arguments.of(2, "Plastic"),
                Arguments.of(10, "Wood"),
                Arguments.of(7, "Steel"),
                Arguments.of(15, "Titanium")
        );
    }

    @ParameterizedTest
    @MethodSource("knifeInputProvider")
    public void knifeConstructorInitializesValuesCorrectly(int size, String materialType) throws Throwable {
        Object[][] arguments = {
                {size, int.class},
                {materialType, String.class}
        };
        Object knifeInstance = knife.createInstance(arguments);
        _assertEquals(size, knife.getFieldValue(knifeInstance, varSize),
                "Your " + knifeClass + " constructor does not correctly initialize the " + varSize + " field.");
        _assertEquals(materialType, knife.getFieldValue(knifeInstance, varMaterial),
                "Your " + knifeClass + " constructor does not correctly initialize the " + varMaterial + " field.");
    }

}
