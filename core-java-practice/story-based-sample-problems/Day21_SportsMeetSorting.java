public class Day21_SportsMeetSorting {
    public static void main(String[] args) {
        int[] scores = {64, 25, 12, 22, 11};
        System.out.println("Original array: " + java.util.Arrays.toString(scores));
        
        // Bubble Sort
        int[] bubbleScores = scores.clone();
        int swaps = 0;
        boolean sorted = true;
        for (int i = 0; i < bubbleScores.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < bubbleScores.length - 1 - i; j++) {
                if (bubbleScores[j] < bubbleScores[j + 1]) { // Sort descending for medals
                    int temp = bubbleScores[j];
                    bubbleScores[j] = bubbleScores[j + 1];
                    bubbleScores[j + 1] = temp;
                    swapped = true;
                    swaps++;
                }
            }
            if (!swapped) {
                break;
            } else {
                sorted = false;
            }
        }
        System.out.println("Bubble Sort: " + java.util.Arrays.toString(bubbleScores));
        System.out.println("Total swaps: " + swaps);
        System.out.println("Was already sorted? " + sorted);
        
        // Insertion Sort
        int[] insertionScores = scores.clone();
        for (int i = 1; i < insertionScores.length; i++) {
            int key = insertionScores[i];
            int j = i - 1;
            while (j >= 0 && insertionScores[j] < key) { // Descending
                insertionScores[j + 1] = insertionScores[j];
                j--;
            }
            insertionScores[j + 1] = key;
        }
        System.out.println("Insertion Sort: " + java.util.Arrays.toString(insertionScores));
        
        System.out.println("Top 3 Medalists: " + insertionScores[0] + ", " + insertionScores[1] + ", " + insertionScores[2]);
    }
}
