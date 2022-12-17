package arrays.programs_involving_multidimensional_data.easy.q2;

/*
Create a Java program that uses a 2D array to keep track of the order of people who appear in a line. In particular,
each row represents the names of those who lined up for a musical event. Then, your program should go through all the
lines and check if the person in the last spot is the same. If it is the same, the program should print "Match". For
example, if the name "Sam" is last in two of the lines, your program should print "Match" twice.
 */

public class LineUps {
    public static void main(String[] args) {
        String[][] arr = {{"May", "Joe", "Sam"}, {"Neo", "Sal", "Joe"}, {"Dan", "Ray", "Joe"}, {"El", "Ally", "Sam"}};
        String[] lastOnes = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int lastIndex = arr[i].length;
            String lastPerson = arr[i][lastIndex - 1];
            lastOnes[i] = lastPerson;
        }
        for (int i = 0; i < lastOnes.length; i++) {
            String name = lastOnes[i];
            for (int j = (i + 1); j < lastOnes.length; j++)
                if (name == lastOnes[j])
                    System.out.println("Match");
        }
    }
}
