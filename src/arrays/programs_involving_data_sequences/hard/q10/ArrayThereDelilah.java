package arrays.programs_involving_data_sequences.hard.q10;

/*
Create a Java program that takes an array of strings, finds the middle character in each string, and prints it to the
console. To do this, create a method called middle, which accepts a String array, finds the middle character in the
string, and adds it to a character array. For this method, find the middle element by dividing the length by two,
rounding the number, and subtracting one. After computing the array, return it and print each character in the main
method. Use the provided main method to call your method and print the output. Note that your middle method should be general enough to work with input of any length.

Sample Output:
        The middle letter of the array are:
        delilah

 */

public class ArrayThereDelilah {
    public static void main(String[] args) {
        String[] array = new String[]{"add", "here", "lilly", "president", "jelly", "advance", "archers"};
        char[] middleCharacter = middle(array);
        String output = "";
        for (char item : middleCharacter)
            output += item;
        System.out.println("The middle letters of the array are: ");
        System.out.println(output);
    }

    public static char[] middle(String[] arr) {
        char[] middle = new char[arr.length];
        for (int i = 0; i < arr.length; i++)
            middle[i] = arr[i].charAt((int) Math.round(arr[i].length() / 2.0) - 1);
        return middle;
    }
}
