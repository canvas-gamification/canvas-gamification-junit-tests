package oop.variable_scope.hard.q3;

/*
Write a Java class called ArrayFinder with two instance fields, an int called number initialized to 7 and an int called
index initialized to -1. In your class create two methods, find and isEqual.

The isEqual method accepts an integer as a parameter and returns true if a passed integer equals the number field. The
find method receives an integer array as a parameter and searches through it to find an index where the number at that
index equals the instance number field. Use your isEquals method to check the equality. If a match is found the find
method should update the index instance variable to the index of the match. Note that if there are multiple matches,
the index variable should keep the index of the first match.
 */

public class ArrayFinder {
    int number = 7;
    int index = -1;

    public void find(int[] array) {
        for (int num = 0; num < array.length; num++) {
            if (isEqual(array[num])) {
                index = num;
                break;
            }
        }
    }

    public boolean isEqual(int num) {
        if (num == number)
            return true;
        return false;
    }
}
