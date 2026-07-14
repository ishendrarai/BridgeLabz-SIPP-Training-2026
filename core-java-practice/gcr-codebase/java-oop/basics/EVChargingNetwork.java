public class EVChargingNetwork {
    static class ChargingStation {
        String stationId;
        double unitsConsumed;
        static int totalStations = 0;
        static double electricityRate = 0.15; // per unit

        public ChargingStation(String stationId, double unitsConsumed) {
            this.stationId = stationId;
            this.unitsConsumed = unitsConsumed;
            totalStations++;
        }

        public double calculateBill() {
            return this.unitsConsumed * electricityRate;
        }

        public void displayStationDetails() {
            System.out.println("Station: " + stationId + " | Units: " + unitsConsumed + " | Bill: $" + calculateBill());
        }
    }

    public static void main(String[] args) {
        ChargingStation s1 = new ChargingStation("S-101", 100);
        ChargingStation s2 = new ChargingStation("S-102", 200);
        ChargingStation s3 = new ChargingStation("S-103", 150);
        ChargingStation s4 = new ChargingStation("S-104", 50);
        ChargingStation s5 = new ChargingStation("S-105", 300);

        System.out.println("Total Stations: " + ChargingStation.totalStations);
        
        System.out.println("--- Current Rates ---");
        s1.displayStationDetails();
        s2.displayStationDetails();

        System.out.println("--- Changing Rates to 0.20 ---");
        ChargingStation.electricityRate = 0.20;

        s1.displayStationDetails();
        s2.displayStationDetails();
        s3.displayStationDetails();
        s4.displayStationDetails();
        s5.displayStationDetails();
    }
}
