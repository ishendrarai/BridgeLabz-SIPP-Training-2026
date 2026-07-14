public class GeneratePermutations {
    public static void generatePermutations(String str, String currentPermutation) {
        if (str.isEmpty()) {
            System.out.println(currentPermutation);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String remaining = str.substring(0, i) + str.substring(i + 1);
            generatePermutations(remaining, currentPermutation + ch);
        }
    }

    public static void main(String[] args) {
        String input = "ABC";
        System.out.println("Input:\n" + input);
        System.out.println("Output:");
        generatePermutations(input, "");
    }
}
