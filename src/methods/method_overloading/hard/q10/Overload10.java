package methods.method_overloading.hard.q10;

/**
 * [J] Write a Java Program for a hospital that displays the name and the gender
 * of the baby to the parents. The method takes in either only the name or the
 * name and the gender ( boolean, if true = girl, false = boy) of the baby. Use
 * method overloading to only call one method to complete this.
 * <p>
 * Input Sets:
 * - Carina, true
 * - Alex, false
 * - Bred
 * <p>
 * Sample Output:
 * The baby's name is Carina and the gender is Female
 * The baby's name is Alex and the gender is Male
 * The baby's name is Bred
 */
public class Overload10 {
    public static void main(String[] args) {
        System.out.println(baby("Carina", true));
        System.out.println(baby("Alex", false));
        System.out.println(baby("Bred"));
    }

    public static String baby(String name, Boolean gender) {
        String sex = "";
        if (gender)
            sex = "Female";
        else
            sex = "Male";

        return "The baby's name is " + name + " and the gender is " + sex;

    }

    public static String baby(String name) {
        return "The baby's name is " + name;
    }
}
