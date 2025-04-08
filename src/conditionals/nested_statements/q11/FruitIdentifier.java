package conditionals.nested_statements.q11;

public class FruitIdentifier {
    public static void main(String[] args) {
        String color = "Red";
        String taste = "Spicy";

        switch (color) {
            case "Red":
                switch (taste) {
                    case "Sweet":
                        System.out.println("Apple");
                        break;
                    case "Spicy":
                        System.out.println("Chili");
                        break;
                    default:
                        System.out.println("Not found");
                        break;
                }
                break;
            case "Yellow":
                switch (taste) {
                    case "Sweet":
                        System.out.println("Banana");
                        break;
                    default:
                        break;
                }
                break;
        }
    }
}

