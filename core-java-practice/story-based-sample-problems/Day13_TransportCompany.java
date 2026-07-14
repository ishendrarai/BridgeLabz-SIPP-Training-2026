public class Day13_TransportCompany {
    static abstract class Vehicle {
        String model;
        public Vehicle(String model) { this.model = model; }
        public abstract double fuelCost(double km);
    }
    
    static class Car extends Vehicle {
        public Car(String model) { super(model); }
        @Override
        public double fuelCost(double km) { return km * 0.15; }
    }
    
    static class Bus extends Vehicle {
        public Bus(String model) { super(model); }
        @Override
        public double fuelCost(double km) { return km * 0.40; }
    }
    
    static class Bike extends Vehicle {
        public Bike(String model) { super(model); }
        @Override
        public double fuelCost(double km) { return km * 0.05; }
    }
    
    static class ElectricCar extends Vehicle {
        public ElectricCar(String model) { super(model); }
        @Override
        public double fuelCost(double km) { return km * 0.02; }
    }
    
    public static void main(String[] args) {
        Vehicle[] fleet = {
            new Car("Sedan"), new Bus("CityBus"), new Bike("MountainBike"), new ElectricCar("Tesla")
        };
        
        double dist = 100;
        System.out.println("--- Fleet Fuel Cost for " + dist + " km ---");
        for (Vehicle v : fleet) {
            System.out.println(v.model + " cost: $" + String.format("%.2f", v.fuelCost(dist)));
            if (v instanceof ElectricCar) {
                System.out.println("   (Eco-friendly electric vehicle detected!)");
            }
        }
    }
}
