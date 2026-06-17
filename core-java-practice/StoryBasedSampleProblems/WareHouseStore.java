import java.util.Scanner;

public class WareHouseStore {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of Items:- ");

        int itemNumber = sc.nextInt();
        int stockQuantities[] = new int[itemNumber];

        System.out.print("Enter the quantities :- ");
        for(int i = 0; i < stockQuantities.length; i++){
            stockQuantities[i] = sc.nextInt();
        }

        int maxStock = 0;
        int minStock = stockQuantities[0];
        int totalStock = 0;

        for (int i = 0; i < stockQuantities.length; i++) {
            
            if (stockQuantities[i] > maxStock) {
                maxStock = stockQuantities[i];
            }
           
            if (stockQuantities[i] < minStock) {
                minStock = stockQuantities[i];
            }

            totalStock += stockQuantities[i];
        }

        System.out.println("Maximum Quantity:- " + maxStock);
        System.out.println("Minimum Quantity:- " + minStock);
        System.out.println("Total Quantity:- " + totalStock);

         System.out.print("Duplicate Values :- " );

       for(int i = 0; i < stockQuantities.length-1; i++){
            for(int j = i+1; j < stockQuantities.length; j++){
                if(stockQuantities[i] == stockQuantities[j]){
                    System.out.print(stockQuantities[i] + " ");
                }
            }
        }

                System.out.print("\nEnter the value of k:- ");
        int k = sc.nextInt();

        int rotatedArray[] = new int[itemNumber];

        for (int i = 0; i < stockQuantities.length; i++) {
            rotatedArray[(i + k) % itemNumber] = stockQuantities[i];
        }

        System.out.print("Array after rotation:- ");
        for (int i = 0; i < rotatedArray.length; i++) {
            System.out.print(rotatedArray[i] + " ");
        }

        System.out.print("\nEnter number of rows for shelf grid:- ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns for shelf grid:- ");
        int cols = sc.nextInt();

        int shelfGrid[][] = new int[rows][cols];

        System.out.println("Enter the elements of the shelf grid:- ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                shelfGrid[i][j] = sc.nextInt();
            }
        }

        System.out.println("Transpose of the shelf grid:- ");
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(shelfGrid[j][i] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
