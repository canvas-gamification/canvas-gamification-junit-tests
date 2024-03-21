package oop.static_modifier.hard.q4;

public class TestWarehouse {
    public static void main(String[] args) {
        Bed[] furnitureForSell = new Bed[5];
        int t = 0;
        for (int i = 0; i < furnitureForSell.length; i++) {
            Bed item = new Bed(24);
            if (item.makeFurniture())
                furnitureForSell[i] = item;
            else
                break;
            t ++;
        }
        System.out.println(t + " pieces of furniture were made");
    }
}

