public class DroneDeliverySystem {
    static class Drone {
        String droneId;
        int batteryPercentage;
        static String companyName = "FastLogistics";

        public Drone(String droneId, int batteryPercentage) {
            this.droneId = droneId;
            this.batteryPercentage = batteryPercentage;
        }

        public void startDelivery() {
            if (this.batteryPercentage > 20) {
                this.batteryPercentage -= 20;
                System.out.println(droneId + " started delivery.");
            } else {
                System.out.println(droneId + " battery too low. Please charge.");
            }
        }

        public void displayStatus() {
            System.out.println("Company: " + companyName + " | Drone: " + droneId + " | Battery: " + batteryPercentage + "%");
        }
    }

    public static void main(String[] args) {
        Drone d1 = new Drone("D-01", 100);
        Drone d2 = new Drone("D-02", 80);
        Drone d3 = new Drone("D-03", 30);

        d1.startDelivery();
        d2.startDelivery();
        d3.startDelivery();
        d3.startDelivery();

        d1.displayStatus();
        d2.displayStatus();
        d3.displayStatus();
    }
}
