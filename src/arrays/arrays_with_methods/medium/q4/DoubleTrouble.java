package arrays.arrays_with_methods.medium.q4;

/*
Create a method called DoubleTrouble that takes an integer array as input and returns a new array that is twice that
size with the elements copied over twice. For example, suppose the method is given [ 2, 4, 1 ], then it will return
[ 2, 4, 1, 2, 4, 1 ].

 */
public class DoubleTrouble {
    public static int[] doubleTrouble(int[] arr) {
        int[] result = new int[arr.length * 2];
        for (int i = 0; i < arr.length; i++)
            result[i] = arr[i];
        int j = arr.length;
        for (int i = 0; i < arr.length; i++) {
            result[j] = arr[i];
            j++;
        }
        return result;
    }
}
