package oop.programs_with_interesting_classes.medium.q10;

public class Cashier {
    private final int RAMEN_INDEX = 0;
    private final int CHOCO_INDEX = 1;
    private final int COKE_INDEX = 2;
    private static int[] stock;
    private static String[] items;

    public Cashier() {
        items = new String[]{"Ramen", "Chocolate", "Coke"};
    }

    public Cashier(int a, int b, int c) {
        stock = new int[3];
        stock[RAMEN_INDEX] = a;
        stock[CHOCO_INDEX] = b;
        stock[COKE_INDEX] = c;
        items = new String[]{"Ramen", "Chocolate", "Coke"};
    }

    public void scanItem(String s, int numBuys) {
        if (s.equals("Ramen"))
            stock[RAMEN_INDEX] -= numBuys;
        else if (s.equals("Chocolate"))
            stock[CHOCO_INDEX] -= numBuys;
        else if (s.equals("Coke"))
            stock[COKE_INDEX] -= numBuys;
        checkInventory();
    }

    private void checkInventory() {
        for (int i = 0; i < stock.length; i++)
            if (stock[i] <= 5)
                System.out.println("ALERT! Item: " + items[i] + " only has " + stock[i] + " left in stock");
    }

    public void restock() {
        for (int i = 0; i < stock.length; i++)
            if (stock[i] <= 5) {
                stock[i] += 20;
                System.out.println(items[i] + " has been restocked!");
            }
    }
}
