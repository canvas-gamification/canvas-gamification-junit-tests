package arrays.referencing_array_and_its_elements.hard.q4;

/*
Write a Java program that defines an array of doubles given the following array [ 73, 15, 71, 67, 5, 96, 91, 12, 5, 82 ],
and then traverses through the array and prints out the index of students on the same line separated by
spaces (Eg: "3 4 6 " ) who got above 88% in the course, indicating they are potential candidates for teaching assistants
next year. Your program should use a method called PGS that takes
a double array and print the indices of the qualified students.

 */
public class PotentialGoodStudents {
    public static void main(String[] args) {
        double[] arr = {76.9, 50.8, 68.4, 95.7, 88.6, 81.2, 89.5, 74.9, 12.76, 64.0};
        PGS(arr);
    }

    public static void PGS(double[] arr) {
        String ans = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 88.0) {
                ans += i + " ";

            }
        }
        System.out.print(ans.trim());
    }
}
