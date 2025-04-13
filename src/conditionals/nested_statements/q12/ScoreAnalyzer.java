package conditionals.nested_statements.q12;

public class ScoreAnalyzer {
    public static void main(String[] args) {
        int score = 87; // You can change this value to test other scores

        switch (score % 2) {
            case 0:
                System.out.println("Even Score");

                switch (score / 10) {
                    case 9:
                        System.out.println("Excellent");
                        break;
                    case 8:
                        System.out.println("Good");
                        break;
                    case 7:
                        System.out.println("Fair");
                        break;
                    case 6:
                        System.out.println("Needs Improvement");
                        break;
                    default:
                        System.out.println("Fail");
                        break;
                }
                break;

            case 1:
                System.out.println("Odd Score");

                switch (score / 10) {
                    case 9:
                        System.out.println("Excellent");
                        break;
                    case 8:
                        System.out.println("Good");
                        break;
                    case 7:
                        System.out.println("Fair");
                        break;
                    case 6:
                        System.out.println("Needs Improvement");
                        break;
                    default:
                        System.out.println("Fail");
                        break;
                }
                break;
        }
    }
}
