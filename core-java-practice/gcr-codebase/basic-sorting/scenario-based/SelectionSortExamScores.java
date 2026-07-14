public class SelectionSortExamScores {
    public void sortScores(int[] scores) {
        int n = scores.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = scores[i];
            scores[i] = scores[minIdx];
            scores[minIdx] = temp;
        }
    }
}
