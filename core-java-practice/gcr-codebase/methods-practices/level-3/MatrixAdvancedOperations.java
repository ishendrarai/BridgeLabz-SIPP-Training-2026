public class MatrixAdvancedOperations {
    public static int[][] createRandomMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }
        return matrix;
    }

    public static int[][] transpose(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        int[][] trans = new int[c][r];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) trans[j][i] = matrix[i][j];
        }
        return trans;
    }

    public static int determinant2x2(int[][] matrix) {
        return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
    }

    public static int determinant3x3(int[][] m) {
        int x = m[0][0] * (m[1][1] * m[2][2] - m[1][2] * m[2][1]);
        int y = m[0][1] * (m[1][0] * m[2][2] - m[1][2] * m[2][0]);
        int z = m[0][2] * (m[1][0] * m[2][1] - m[1][1] * m[2][0]);
        return x - y + z;
    }

    public static double[][] inverse2x2(int[][] m) {
        int det = determinant2x2(m);
        if (det == 0) return null;
        double[][] inv = new double[2][2];
        inv[0][0] = (double) m[1][1] / det;
        inv[0][1] = (double) -m[0][1] / det;
        inv[1][0] = (double) -m[1][0] / det;
        inv[1][1] = (double) m[0][0] / det;
        return inv;
    }

    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) System.out.print(val + "\t");
            System.out.println();
        }
        System.out.println();
    }

    public static void displayMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double val : row) System.out.printf("%.2f\t", val);
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] A2x2 = createRandomMatrix(2, 2);
        System.out.println("2x2 Matrix:");
        displayMatrix(A2x2);
        
        System.out.println("Transpose:");
        displayMatrix(transpose(A2x2));
        
        System.out.println("Determinant: " + determinant2x2(A2x2));
        
        double[][] inv = inverse2x2(A2x2);
        if (inv != null) {
            System.out.println("Inverse:");
            displayMatrix(inv);
        } else {
            System.out.println("Inverse does not exist (det = 0).");
        }
        
        int[][] A3x3 = createRandomMatrix(3, 3);
        System.out.println("3x3 Matrix:");
        displayMatrix(A3x3);
        System.out.println("Determinant 3x3: " + determinant3x3(A3x3));
    }
}
