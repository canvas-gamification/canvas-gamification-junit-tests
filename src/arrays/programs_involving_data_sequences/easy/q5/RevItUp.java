package arrays.programs_involving_data_sequences.easy.q5;

public class RevItUp {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 9, 66, 29, 13};
        reverse(arr);
    }

    public static void reverse(int[] arr) {
        int front = 0;
        int back = arr.length - 1;
        int temp = 0;
        while (front < back) {
            temp = arr[front];
            arr[front] = arr[back];
            arr[back] = temp;
            front++;
            back--;
        }
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
