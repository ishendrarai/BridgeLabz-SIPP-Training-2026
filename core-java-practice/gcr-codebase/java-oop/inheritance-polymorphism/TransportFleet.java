public class TransportFleet {
    static class Vehicle {
        public double fuelCost(double km) {
            return 0.0;
        }
    }

    static class Car extends Vehicle {
        @Override
        public double fuelCost(double km) {
            return km * 0.15;
        }
    }

    static class Bus extends Vehicle {
        @Override
        public double fuelCost(double km) {
            return km * 0.30;
        }
    }

    static class Bike extends Vehicle {
        @Override
        public double fuelCost(double km) {
            return km * 0.05;
        }
    }

    static class ElectricCar extends Vehicle {
        @Override
        public double fuelCost(double km) {
            return km * 0.02; // electricity cost
        }
    }

    public static void main(String[] args) {
        Vehicle[] fleet = new Vehicle[]{new Car(), new Bus(), new Bike(), new ElectricCar()};
        double distance = 100.0;

        for (Vehicle v : fleet) {
            System.out.println("Vehicle: " + v.getClass().getSimpleName() + " | Fuel Cost for " + distance + "km: $" + v.fuelCost(distance));
            
            if (v instanceof ElectricCar) {
                System.out.println("-> This is an eco-friendly vehicle.");
            }
        }
    }
}
