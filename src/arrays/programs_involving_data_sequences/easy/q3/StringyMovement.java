package arrays.programs_involving_data_sequences.easy.q3;

/*
Make a program that calls a method named next please that takes an array of people's first names as input, removes the
first name, and shifts those remaining to mimic a queue. Specifically, the method removes the first name from the array,
shifts the remaining items one spot earlier (so the second element moves to the first, the third element moves to the
second, etc.), and makes the last name an empty string. The method should print the name removed from the queue and
return the shifted array. Print the first element of the returned array in the main method. If the input array is empty,
the method should return an array of length one which contains the String "The queue is empty.".

 */

public class StringyMovement {
    public static void main(String[] args) {
        String[] names = {"Travis", "Laura", "Liam", "Matthew", "Sam", "Marisha"};
        String[] nextName = nextPlease(names);
        System.out.println("The first person in the queue is now: " + nextName[0]);
    }

    public static String[] nextPlease(String[] names) {
        if (names.length == 0)
            return new String[]{"The queue is empty."};
        String nextInLine = names[0];
        for (int i = 0; i < names.length - 1; i++)
            names[i] = names[i + 1];
        names[names.length - 1] = "";
        System.out.println("The name removed from the queue is: " + nextInLine);
        return names;
    }
}
