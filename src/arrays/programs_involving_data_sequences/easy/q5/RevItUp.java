package arrays.programs_involving_data_sequences.easy.q5;

/*
Make a program that calls a method named reverse, which reverses an integer array without creating a new array. Assume
the array has an odd number of elements, so there is always a center element. Then, the method can swap the elements
left of the center element with those right of it. In particular, the method should swap the outermost elements and then
move inwards toward the center (e.g., swap the first element with the last element, then the second element with the
second to last element, etc.).

For example, given [2, 4, 1, 9, 66, 29, 13], the method does the first swap to get [13, 4, 1, 9, 66, 29, 2], then it
does the second swap to get [13,29,1,9,66,4,2], and eventually get to the final reversed array with
[13, 29, 66, 9, 1, 4, 2]. The method should then print the array.

 */

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
