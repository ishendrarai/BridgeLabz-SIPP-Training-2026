public class SmartParkingManagement {
    static class Vehicle {
        String vehicleNumber;
        String ownerName;
        String vehicleType;

        public Vehicle(String vehicleNumber, String ownerName, String vehicleType) {
            this.vehicleNumber = vehicleNumber;
            this.ownerName = ownerName;
            this.vehicleType = vehicleType;
        }

        public void displayDetails() {
            System.out.println("Vehicle: " + vehicleNumber + " | Owner: " + ownerName);
        }
    }

    public static void displayCars(Vehicle[] vehicles) {
        System.out.println("--- Parked Cars ---");
        for (Vehicle v : vehicles) {
            if (v != null && v.vehicleType.equalsIgnoreCase("Car")) {
                v.displayDetails();
            }
        }
    }

    public static void displayBikes(Vehicle[] vehicles) {
        System.out.println("--- Parked Bikes ---");
        for (Vehicle v : vehicles) {
            if (v != null && v.vehicleType.equalsIgnoreCase("Bike")) {
                v.displayDetails();
            }
        }
    }

    public static void main(String[] args) {
        Vehicle[] parkingLot = new Vehicle[10];
        
        parkingLot[0] = new Vehicle("C-123", "Alice", "Car");
        parkingLot[1] = new Vehicle("B-456", "Bob", "Bike");
        parkingLot[2] = new Vehicle("C-789", "Charlie", "Car");
        parkingLot[3] = new Vehicle("B-101", "David", "Bike");
        parkingLot[4] = new Vehicle("C-202", "Eve", "Car");

        displayCars(parkingLot);
        displayBikes(parkingLot);
    }
}
