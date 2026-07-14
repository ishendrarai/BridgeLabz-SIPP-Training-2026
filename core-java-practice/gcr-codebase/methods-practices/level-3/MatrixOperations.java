public class MatrixOperations {
    public static int[][] createRandomMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }
        return matrix;
    }

    public static int[][] addMatrices(int[][] a, int[][] b) {
        int rows = a.length, cols = a[0].length;
        int[][] res = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) res[i][j] = a[i][j] + b[i][j];
        }
        return res;
    }

    public static int[][] subtractMatrices(int[][] a, int[][] b) {
        int rows = a.length, cols = a[0].length;
        int[][] res = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) res[i][j] = a[i][j] - b[i][j];
        }
        return res;
    }

    public static int[][] multiplyMatrices(int[][] a, int[][] b) {
        int r1 = a.length, c1 = a[0].length, c2 = b[0].length;
        int[][] res = new int[r1][c2];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    res[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return res;
    }

    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) System.out.print(val + "\t");
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] A = createRandomMatrix(2, 2);
        int[][] B = createRandomMatrix(2, 2);

        System.out.println("Matrix A:");
        displayMatrix(A);
        System.out.println("Matrix B:");
        displayMatrix(B);

        System.out.println("A + B:");
        displayMatrix(addMatrices(A, B));

        System.out.println("A - B:");
        displayMatrix(subtractMatrices(A, B));

        System.out.println("A * B:");
        displayMatrix(multiplyMatrices(A, B));
    }
}
