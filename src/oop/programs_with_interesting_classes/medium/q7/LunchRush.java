package oop.programs_with_interesting_classes.medium.q7;

public class LunchRush {
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();
        vm.buyItem(5.50); //purchase 1
        vm.buyItem(3.10); //purchase 2
        vm.buyItem(10.00); //purchase 3
        vm.buyItem(1.75); //purchase 4
        vm.buyItem(2.55); //purchase 5
        vm.buyItem(2.66); //purchase 6
        System.out.print("Lunch rush over");
    }
}
