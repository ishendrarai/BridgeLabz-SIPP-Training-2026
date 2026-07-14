public class SmartWaterBottleTracker {
    static class WaterBottle {
        String ownerName;
        double dailyTarget;
        double consumed;

        public WaterBottle(String ownerName, double dailyTarget) {
            this.ownerName = ownerName;
            this.dailyTarget = dailyTarget;
            this.consumed = 0;
        }

        public void drink(double amount) {
            this.consumed += amount;
        }

        public void displayBottleInfo() {
            System.out.println("Owner: " + ownerName + " | Target: " + dailyTarget + "L | Consumed: " + consumed + "L");
        }
    }

    public static void main(String[] args) {
        WaterBottle wb1 = new WaterBottle("Alice", 2.5);
        WaterBottle wb2 = new WaterBottle("Bob", 3.0);

        wb1.drink(1.0);
        wb2.drink(1.5);
        wb1.drink(0.5);

        wb1.displayBottleInfo();
        wb2.displayBottleInfo();
    }
}
