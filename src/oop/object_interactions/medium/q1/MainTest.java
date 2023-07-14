package oop.object_interactions.medium.q1;

import global.ObjectTest;
import global.variables.Clause;
import global.variables.clauses.DoubleLiteral;
import global.variables.clauses.NewLine;
import global.variables.clauses.StringLiteral;
import global.variables.wrappers.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

import static global.tools.CustomAssertions._assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    private ObjectTest truck;
    private ObjectTest testTruck;
    private final String truckClass = "Truck";
    private final String testTruckClass = "TestTruck";
    private final String getWeightMethodName = "getCurrentWeight";
    private final String setWeightMethodName = "setCurrentWeight";
    private final String weightAttributeName = "currentWeight";
    private final String splitLoadName = "splitLoad";
    private final double initialWeight1 = 450.8;
    private final double initialWeight2 = 0.0;
    private final double splitWeight = (initialWeight1 + initialWeight2) / 2.0;

    @BeforeEach
    public void setup() {
        String truckString = "oop.object_interactions.medium.q1." + truckClass;
        String testTruckString = "oop.object_interactions.medium.q1." + testTruckClass;
        truck = new ObjectTest(truckString);
        testTruck = new ObjectTest(testTruckString);
        assertTrue(truck.hasModifier("public"),
                "You have changed the visibility modifier on the Truck class. Please revert it to the original state.");
        Class<?>[] constructorClasses = {double.class};
        assertTrue(truck.hasConstructor(constructorClasses, new String[]{"public"}),
                "You have modified the provided constructor on the Truck class. Please revert it to the original state.");
        assertTrue(truck.hasMethod(getWeightMethodName, null, double.class, new String[]{"public"}),
                String.format("You have modified the provided %s method method. Please revert it to the original state.", getWeightMethodName));
        assertTrue(truck.hasMethod(setWeightMethodName, new Class[]{double.class}, Void.TYPE, new String[]{"public"}),
                String.format("You have modified the provided %s method method. Please revert it to the original state.", setWeightMethodName));
        assertTrue(truck.hasMethod("toString", null, String.class),
                "You have modified the provided toString method. Please revert it to the original state.");
        assertTrue(truck.hasField(weightAttributeName, double.class, new String[]{"private"}),
                String.format("You have modified the provided %s attribute. Please revert it to the original state.", weightAttributeName));
    }

    private static Stream<Arguments> splitLoadInputProvider() {
        Random random = new Random();
        double rand1 = random.nextDouble() * 1000000000000.0;
        double rand2 = random.nextDouble() * 1000000000000.0;
        double split = (rand1 + rand2) / 2.0;
        return Stream.of(
                Arguments.of(451.23, 0.0, 225.615),
                Arguments.of(1000.0, 1000.0, 1000.0),
                Arguments.of(0.0, 122.49, 61.245),
                Arguments.of(0.0, 0.0, 0.0),
                Arguments.of(383563.232, 84293.25, 233928.241),
                Arguments.of(rand1, rand2, split)
        );
    }

    @ParameterizedTest
    @MethodSource("splitLoadInputProvider")
    public void correctSplitLoadMethod(double weight1, double weight2, double splitWeight) throws Throwable {
        Object[][] constructorArguments = {{weight1, double.class}};
        Object truck1 = truck.createInstance(constructorArguments);
        constructorArguments[0][0] = weight2;
        Object truck2 = truck.createInstance(constructorArguments);
        Class<?>[] methodParamaterClasses = {truck.getObjectClass()};
        Object[][] methodArguments = {{truck2, truck.getObjectClass()}};
        truck.callMethod(splitLoadName, methodArguments, truck1);
        assertTrue(truck.hasModifier(splitLoadName, methodParamaterClasses, "public"));
        _assertEquals(splitWeight, truck.getFieldValue(truck1, weightAttributeName),
                String.format("Your %s method does not correctly split the weight across both %s objects.", splitLoadName, truckClass));
        _assertEquals(splitWeight, truck.getFieldValue(truck2, weightAttributeName),
                String.format("Your %s method does not correctly split the weight across both %s objects.", splitLoadName, truckClass));
        truck.setFieldValue(truck1, weight2, weightAttributeName);
        truck.setFieldValue(truck2, weight1, weightAttributeName);
        truck.callMethod(splitLoadName, methodArguments, truck1);
        _assertEquals(splitWeight, truck.getFieldValue(truck1, weightAttributeName),
                String.format("Your %s method does not correctly split the weight across both %s objects.", splitLoadName, truckClass));
        _assertEquals(splitWeight, truck.getFieldValue(truck2, weightAttributeName),
                String.format("Your %s method does not correctly split the weight across both %s objects.", splitLoadName, truckClass));
    }

    @Test
    public void correctMainMethod() throws Throwable {
        Clause[] clauses = {
                new StringLiteral("Before split:"),
                new Optional(new StringLiteral(" ")),
                new NewLine(),
                new StringLiteral("\tMy weight is: "),
                new DoubleLiteral(initialWeight1, initialWeight1),
                new NewLine(),
                new StringLiteral("\tMy weight is: "),
                new DoubleLiteral(initialWeight2, initialWeight2),
                new NewLine(),
                new StringLiteral("After split: "),
                new NewLine(),
                new StringLiteral("\tMy weight is: "),
                new DoubleLiteral(splitWeight, splitWeight),
                new NewLine(),
                new StringLiteral("\tMy weight is: "),
                new DoubleLiteral(splitWeight, splitWeight)
        };
        String incorrectMainOutput = String.format("Your main method in the %s class does not correctly print out the weights before and after calling the %s method on the %s objects.",
                testTruckClass, splitLoadName, truckClass);
        testTruck.callMethod("main", new Object[][]{{new String[0], String[].class}},
                clauses, incorrectMainOutput);
    }
}
