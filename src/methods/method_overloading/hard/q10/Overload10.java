package methods.method_overloading.hard.q10;

/*
Write a Java Program for a hospital that displays the name and the gender of a baby to the parents. The main method
should take only the name or both the name and a boolean for the gender (true = girl, false = boy). The program should
pass the input information to an overloaded method called baby which takes either a String or a String and a boolean,
and returns a String. The main method should then print out the returned String. (Hint: You may want to use the Scanner
method .hasNextBoolean)

Sample Output 1:
        Enter a name or a name with gender:
        Carina true
		The baby's name is Carina and the gender is Female

Sample Output 2:
        Enter a name or a name with gender:
        John false
		The baby's name is John and the gender is Male

Sample Output 3:
        Enter a name or a name with gender:
        John
		The baby's name is John

 */

import java.util.Scanner;

public class Overload10 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter a name or a name with gender:");
        String st = inp.nextLine();
        Scanner in = new Scanner(st);
        String name = in.next();
        if (in.hasNextBoolean()) {
            boolean gen = in.nextBoolean();
            System.out.println(baby(name, gen));
        } else {
            System.out.println(baby(name));
        }

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

