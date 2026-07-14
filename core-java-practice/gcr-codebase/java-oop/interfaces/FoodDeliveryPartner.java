import java.util.UUID;

public class FoodDeliveryPartner {
    interface FoodDelivery {
        void deliverFood(String customer);
        default void trackOrder() {
            System.out.println("FoodDelivery: Tracking your restaurant order...");
        }

        static String generateDeliveryCode() {
            return "FD-" + UUID.randomUUID().toString().substring(0, 5);
        }
    }

    interface GroceryDelivery {
        void deliverGrocery(String customer);
        default void trackOrder() {
            System.out.println("GroceryDelivery: Tracking your grocery items...");
        }
    }

    static class DeliveryExecutive implements FoodDelivery, GroceryDelivery {
        @Override
        public void deliverFood(String customer) {
            System.out.println("Delivering hot food to " + customer + ". Code: " + FoodDelivery.generateDeliveryCode());
        }

        @Override
        public void deliverGrocery(String customer) {
            System.out.println("Delivering groceries to " + customer + ".");
        }

        @Override
        public void trackOrder() {
            FoodDelivery.super.trackOrder();
            GroceryDelivery.super.trackOrder();
        }
    }

    public static void main(String[] args) {
        String[] customers = {"Alice", "Bob", "Charlie"};
        DeliveryExecutive exec = new DeliveryExecutive();

        exec.trackOrder();
        System.out.println("--- Deliveries ---");

        for (int i = 0; i < customers.length; i++) {
            if (i % 2 == 0) {
                exec.deliverFood(customers[i]);
            } else {
                exec.deliverGrocery(customers[i]);
            }
        }
    }
}
