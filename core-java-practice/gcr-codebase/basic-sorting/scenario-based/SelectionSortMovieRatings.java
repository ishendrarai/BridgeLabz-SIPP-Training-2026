public class SelectionSortMovieRatings {
    public void sortRatings(int[] ratings) {
        int n = ratings.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (ratings[j] < ratings[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = ratings[i];
            ratings[i] = ratings[minIdx];
            ratings[minIdx] = temp;
        }
    }
}
