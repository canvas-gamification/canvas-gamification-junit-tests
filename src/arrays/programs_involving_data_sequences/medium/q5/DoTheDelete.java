package arrays.programs_involving_data_sequences.medium.q5;

/*
Make a program that calls a method that takes as input an array of numbers and another target number. The method tries
to find the target number in the array. If found, the value in the array is set to 0 and the method stores the index
where that value was found. Note that there could be multiple numbers in the array matching the target. In that case,
the method returns the index of the last match. If none of the numbers in the array match the target number, then the
method returns -1 instead. The main method should then print out the array.

 */
public class DoTheDelete {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 7};
        deletThis(arr, 7);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static int deletThis(int[] arr, int num) {
        int delet = -1;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == num) {
                arr[i] = 0;
                delet = i;
            }
        return delet;
    }
}
