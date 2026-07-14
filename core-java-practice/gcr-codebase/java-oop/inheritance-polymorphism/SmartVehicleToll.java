public class SmartVehicleToll {
    static class Vehicle {
        String vehicleNumber;
        String ownerName;
        double tollPaid;

        public Vehicle(String vehicleNumber, String ownerName) {
            this.vehicleNumber = vehicleNumber;
            this.ownerName = ownerName;
        }

        public double calculateToll() {
            return 0.0;
        }
    }

    static class Car extends Vehicle {
        public Car(String vNum, String owner) { super(vNum, owner); }
        @Override
        public double calculateToll() { tollPaid = 50.0; return tollPaid; }
    }

    static class Bus extends Vehicle {
        public Bus(String vNum, String owner) { super(vNum, owner); }
        @Override
        public double calculateToll() { tollPaid = 150.0; return tollPaid; }
    }

    static class Truck extends Vehicle {
        public Truck(String vNum, String owner) { super(vNum, owner); }
        @Override
        public double calculateToll() { tollPaid = 250.0; return tollPaid; }
    }

    public static double calculateTotalRevenue(Vehicle[] vehicles) {
        double total = 0;
        for (Vehicle v : vehicles) total += v.calculateToll();
        return total;
    }

    public static void searchVehicle(Vehicle[] vehicles, String vehicleNumber) {
        for (Vehicle v : vehicles) {
            if (v.vehicleNumber.equals(vehicleNumber)) {
                System.out.println("Found Vehicle - Owner: " + v.ownerName + " | Toll: $" + v.tollPaid);
                return;
            }
        }
        System.out.println("Vehicle not found.");
    }

    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car("C1", "Alice"),
            new Bus("B1", "Bob"),
            new Truck("T1", "Charlie")
        };

        System.out.println("Total Revenue: $" + calculateTotalRevenue(vehicles));
        
        Vehicle maxTollVehicle = vehicles[0];
        int cars = 0, buses = 0, trucks = 0;

        for (Vehicle v : vehicles) {
            if (v.tollPaid > maxTollVehicle.tollPaid) maxTollVehicle = v;
            
            if (v instanceof Car) cars++;
            else if (v instanceof Bus) buses++;
            else if (v instanceof Truck) trucks++;
        }

        System.out.println("Highest Toll Paid By: " + maxTollVehicle.vehicleNumber + " ($" + maxTollVehicle.tollPaid + ")");
        System.out.println("Counts - Cars: " + cars + ", Buses: " + buses + ", Trucks: " + trucks);

        searchVehicle(vehicles, "B1");
    }
}
