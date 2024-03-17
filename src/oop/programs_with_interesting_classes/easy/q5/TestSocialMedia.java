package oop.programs_with_interesting_classes.easy.q5;

public class TestSocialMedia {
    public static void main(String[] args) {
        Discord m1 = new Discord("Hello there", "Jeremy");
        Discord m2 = new Discord("The sky is blue", "Jane");
        Discord[] messages = {m1, m2};
        for (int i = 0; i < messages.length; i++)
            System.out.println(messages[i].toString());
    }
}
