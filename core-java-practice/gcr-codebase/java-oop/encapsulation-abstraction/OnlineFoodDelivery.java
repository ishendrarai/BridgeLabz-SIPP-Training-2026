public class OnlineFoodDelivery {
    abstract static class FoodItem {
        private String itemName;
        private double price;
        private int quantity;

        public FoodItem(String itemName, double price, int quantity) {
            this.itemName = itemName;
            this.price = price;
            this.quantity = quantity;
        }

        public String getItemName() { return itemName; }
        public void setItemName(String itemName) { this.itemName = itemName; }

        public double getPrice() { return price; }
        public void setPrice(double price) { this.price = price; }

        public int getQuantity() { return quantity; }
        public void setQuantity(int quantity) { this.quantity = quantity; }

        public abstract double calculateTotalPrice();

        public void displayItemDetails() {
            System.out.println("Item: " + itemName + " | Price: $" + price + " | Qty: " + quantity + " | Total: $" + calculateTotalPrice());
        }
    }

    static class VegItem extends FoodItem {
        public VegItem(String itemName, double price, int quantity) {
            super(itemName, price, quantity);
        }

        @Override
        public double calculateTotalPrice() {
            return getPrice() * getQuantity();
        }
    }

    static class NonVegItem extends FoodItem {
        private double extraCharge = 2.0;

        public NonVegItem(String itemName, double price, int quantity) {
            super(itemName, price, quantity);
        }

        @Override
        public double calculateTotalPrice() {
            return (getPrice() + extraCharge) * getQuantity();
        }
    }

    public static void main(String[] args) {
        VegItem salad = new VegItem("Caesar Salad", 8.50, 2);
        NonVegItem burger = new NonVegItem("Chicken Burger", 10.00, 3);

        salad.displayItemDetails();
        burger.displayItemDetails();
    }
}
