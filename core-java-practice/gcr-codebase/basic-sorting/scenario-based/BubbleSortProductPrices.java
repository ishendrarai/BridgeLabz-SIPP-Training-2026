public class BubbleSortProductPrices {
    public void sortPrices(int[] prices) {
        int n = prices.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (prices[j] > prices[j + 1]) {
                    int temp = prices[j];
                    prices[j] = prices[j + 1];
                    prices[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}
