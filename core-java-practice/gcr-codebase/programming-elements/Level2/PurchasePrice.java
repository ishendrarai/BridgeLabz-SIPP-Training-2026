import java.util.Scanner;

class PurchasePrice {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the unit price: ");
        double unitPrice = input.nextDouble();

        System.out.print("Enter the quantity: ");
        int quantity = input.nextInt();

        double totalPurchasePrice = unitPrice * quantity;

        System.out.println("The total purchase price is INR " +
                           totalPurchasePrice + " if the quantity " +
                           quantity + " and unit price is INR " +
                           unitPrice);

        input.close();
    }
}