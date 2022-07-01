package arrays.programs_involving_data_sequences.easy.q4;

import java.util.Random;

public class GameNight {
    public static void main(String[] args) {
        String[] names = {"Travis", "Laura", "Liam", "Matthew", "Sam", "Marisha"};
        musicalChairs(names);
    }

    public static void musicalChairs(String[] names) {
        Random rand = new Random();
        for (int i = 0; i < names.length; i++) {
            int ridx = rand.nextInt(names.length);
            String temp = names[ridx];
            names[ridx] = names[i];
            names[i] = temp;
        }
    }
}
