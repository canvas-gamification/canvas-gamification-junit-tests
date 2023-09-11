package arrays.programs_involving_data_sequences.easy.q4;
/*
You want to create a Java program to model the game of musical chairs. Create a main method which initializes an array of strings with
the player's names, and call a method called musicalChairs. This method should randomly shuffle the names in the array. To do this, 
for each item in the array, randomly generate an index and swap the item with the item at the generated index. After randomizing the
array, print out the resulting array in the main method with each name on its own line.
 */

import java.util.Random;

public class GameNight {
    public static void main(String[] args) {
        String[] names = {"Travis", "Laura", "Liam", "Matthew", "Sam", "Marisha"};
        musicalChairs(names);
        for(int x = 0; x < 6; x ++){
            System.out.println(names[x]);
        }
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
