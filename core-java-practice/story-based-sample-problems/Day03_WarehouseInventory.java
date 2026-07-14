public class Day03_WarehouseInventory {
    public static void main(String[] args) {
        int[] stock = {50, 20, 15, 50, 30, 40, 20};
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, total = 0;
        
        System.out.println("--- 1D Array ---");
        for (int s : stock) {
            if (s > max) max = s;
            if (s < min) min = s;
            total += s;
        }
        System.out.println("Max Stock: " + max + ", Min Stock: " + min + ", Total: " + total);
        
        // Rotate by k = 2
        int k = 2;
        int n = stock.length;
        k = k % n;
        int[] rotated = new int[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = stock[i];
        }
        System.out.print("Rotated by " + k + ": ");
        for (int r : rotated) System.out.print(r + " ");
        System.out.println();
        
        System.out.println("--- 2D Shelf Grid Transpose ---");
        int[][] grid = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int[][] trans = new int[grid[0].length][grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                trans[j][i] = grid[i][j];
            }
        }
        for (int i = 0; i < trans.length; i++) {
            for (int j = 0; j < trans[i].length; j++) {
                System.out.print(trans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
