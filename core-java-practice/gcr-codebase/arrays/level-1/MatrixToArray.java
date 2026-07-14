import java.util.Scanner;

class MatrixToArray {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = input.nextInt();

        System.out.print("Enter number of columns: ");
        int columns = input.nextInt();

        int[][] matrix = new int[rows][columns];

        System.out.println("Enter matrix elements:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = input.nextInt();
            }
        }

        int[] array = new int[rows * columns];

        int index = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[index] = matrix[i][j];
                index++;
            }
        }

        System.out.println("Elements of 1D Array:");

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        input.close();
    }
}