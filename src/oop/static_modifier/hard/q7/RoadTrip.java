package oop.static_modifier.hard.q7;

public class RoadTrip {
    public static void main(String[] args) {
        System.out.printf("Pay $%.2f for gas\n", Taxes.calculateTotal(83.45));
        System.out.println("Driving to Alberta");
        Taxes.changeLocation("Alberta");
        System.out.printf("Pay $%.2f for lunch\n", Taxes.calculateTotal(23));
        System.out.println("Driving to Saskatchewan");
        Taxes.changeLocation("Saskatchewan");
        System.out.printf("Pay $%.2f for a motel\n", Taxes.calculateTotal(86));
        System.out.printf("Pay $%.2f for gas\n", Taxes.calculateTotal(75.81));
    }
}
