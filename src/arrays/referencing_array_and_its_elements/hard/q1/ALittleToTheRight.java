package arrays.referencing_array_and_its_elements.hard.q1;

/*
Given the following array ( { 3, 4, 6, 21, 48, 42, 89, 2, 0, 91, 33 } ),
write a program called ALittleToTheRight, with a method called LilToDaRight, that will shift the
elements of the integer array forward by one. For example, the element at index 4 will move to index 5, and so on.
Then, the last element of the array will be pushed to the front of the array. At the end, print the resulting array
after shifting all the elements, with each value on a separate line.
 */
public class ALittleToTheRight {
    public static void main(String[] args) {
        int[] arr = {3, 4, 6, 21, 48, 42, 89, 2, 0, 91, 33};
        int[] changed = LilToDaRight(arr);
        for (int i = 0; i < changed.length; i++) {
            System.out.println(changed[i]);
        }
    }

    public static int[] LilToDaRight(int[] argg) {
        int[] ans = argg;
        int last = ans[ans.length - 1];
        for (int i = ans.length - 1; i > 0; i--)
            ans[i] = ans[i - 1];
        ans[0] = last;
        return ans;
    }

}
