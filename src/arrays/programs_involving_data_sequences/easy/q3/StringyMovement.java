package arrays.programs_involving_data_sequences.easy.q3;

/*
Make a program that calls a method named nextPlease that takes an array of people's first names as input and
removes the first name and shifts the remaining names to mimic a waiting list. Specifically, the method removes the
first name from the array, shifts the remaining names one spot earlier (so the second element moves to the first, the
third element moves to second, etc.), and makes the last name an empty string. The method should then print which name
was removed. Finally, the method returns the shifted array as the output, with the new first element being printed.
 */
public class StringyMovement {
    public static void main(String[] args) {
        String[] names = {"Travis", "Laura", "Liam", "Matthew", "Sam", "Marisha"};
        String[] nextName = nextPlease(names);
        System.out.println("The first person in the queue is now: " + nextName[0]);
    }

    public static String[] nextPlease(String[] names) {
        String nextInLine = names[0];
        for (int i = 0; i < names.length - 1; i++)
            names[i] = names[i + 1];
        names[names.length - 1] = "";
        System.out.println("The name removed from the queue is: " + nextInLine);
        return names;
    }
}
