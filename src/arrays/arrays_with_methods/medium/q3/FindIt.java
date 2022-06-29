package arrays.arrays_with_methods.medium.q3;
/*
Create a method called FindIt that takes a String array and a single character as input, and return the first element in
the array that starts with the given character. If there is no matching element, return "/". For example, suppose the
input array is ["How" , "Do" , "You", "Fare", "Friend"] and the input character is 'F'. The method should return "Fare."
However, if the input character is 'f' instead, the method returns "/".

Distractors:
    return "F";
    return arr;
    if( arr.char == start )
    if( arr.charAt(0) == start )
    if( arr[i].char == start )
    if( arr[i].charAt(0) == start+1 )
    if(arr[i].charAt(1) == start)
    return arr[i+1]
    public static String[] findIt(String arr, char start)
    for( int i = 0; i <= arr.length; i ++ )
    for( int i = 0; i <= arr.length + 1; i -- )
    for( int i = arr.length -1; i > 0; i-- )
 */

public class FindIt {
    public static String findIt(String[] arr, char start) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].charAt(0) == start)
                return arr[i];
        }
        return "/";
    }
}
