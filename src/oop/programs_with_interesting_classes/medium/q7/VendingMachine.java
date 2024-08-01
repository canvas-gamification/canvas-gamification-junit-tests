package oop.programs_with_interesting_classes.medium.q7;

public class VendingMachine {
    private final int CAPACITY = 50;
    private HotSoup[] items;
    private int numAvailable;

    public VendingMachine() {
        items = new HotSoup[CAPACITY];
        for (int i = 0; i < CAPACITY; i++)
            items[i] = new HotSoup(2.50, "Chicken Noodle");
        numAvailable = CAPACITY;
    }

    public void buyItem(double money) {
        String message;
        if (numAvailable > 0) {
            double change = money - items[numAvailable - 1].getPrice();
            if(change >= 0){
                items[--numAvailable] = null;
                message = "Your change is: \n" + getChange((int) (Math.round((change) * 100)));
            }
            else {
                message = "Not enough money. Returning payment...\n";
            }
        } else
            message = "The machine is sold out!";
        System.out.println(message);
    }

    public String getChange(int amount) {
        String msg = "";
        if (amount / 25 != 0) {
            msg += "Quarters: " + amount / 25 + "\n";
            amount = amount % 25;
        }
        if (amount / 10 != 0) {
            msg += "Dimes: " + amount / 10 + "\n";
            amount = amount % 10;
        }
        if (amount / 5 != 0) {
            msg += "Nickels: " + amount / 5 + "\n";
            amount = amount % 5;
        }
        if (amount != 0) {
            msg += "Pennies: " + amount + "\n";
        }
        return msg;
    }
}
