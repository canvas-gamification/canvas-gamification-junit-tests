package oop.programs_with_interesting_classes.medium.q8;

public class Fridge {
    private Food[] items;
    private double currTemperature;

    public Fridge(Food[] f, double t) {
        items = f;
        currTemperature = t;
    }

    public Food[] getItems() {
        return items;
    }

    public void decreaseTemperature() {
        currTemperature -= 10;
        for (int i = 0; i < items.length; i++)
            items[i].increaseExpirationLength();
    }

    public void increaseTemperature() {
        currTemperature += 10;
        for (int i = 0; i < items.length; i++)
            items[i].decreaseExpirationLength();
    }

    public Food getNextToExpire() {
        int min = 999999;
        Food oldestItem = null;
        for (int i = 0; i < items.length; i++)
            if (items[i].getDaysToExpiration() < min)
                oldestItem = items[i];
        return oldestItem;
    }
}
