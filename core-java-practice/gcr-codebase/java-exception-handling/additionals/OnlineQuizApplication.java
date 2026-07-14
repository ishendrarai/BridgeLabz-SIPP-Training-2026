public class OnlineQuizApplication {
    public static void main(String[] args) {
        String[] answers = {"A", "B", "C", "D"};

        for (int i = 0; i <= 5; i++) {
            try {
                boolean isCorrect = answers[i].equals("A");
                System.out.println("Answer at index " + i + " is A: " + isCorrect);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Exception: Array index " + i + " is out of bounds. Skipping.");
            }
        }
        System.out.println("Finished checking answers.");
    }
}
