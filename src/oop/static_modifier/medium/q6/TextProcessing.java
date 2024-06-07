package oop.static_modifier.medium.q6;

public class TextProcessing {
    public static String canadianize(String input) {
        return input + ", eh?";
    }

    public static String extractVowels(String input) {
        String str = "";
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u')
                str += ch;
        }
        return str;
    }
}

