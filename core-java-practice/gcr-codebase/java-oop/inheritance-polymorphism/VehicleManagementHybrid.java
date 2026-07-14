public class VehicleManagementHybrid {
    static class Vehicle {
        int maxSpeed;
        String model;

        public Vehicle(int maxSpeed, String model) {
            this.maxSpeed = maxSpeed;
            this.model = model;
        }
    }

    interface Refuelable {
        void refuel();
    }

    static class ElectricVehicle extends Vehicle {
        public ElectricVehicle(int maxSpeed, String model) {
            super(maxSpeed, model);
        }

        public void charge() {
            System.out.println("Charging the electric vehicle: " + model);
        }
    }

    static class PetrolVehicle extends Vehicle implements Refuelable {
        public PetrolVehicle(int maxSpeed, String model) {
            super(maxSpeed, model);
        }

        @Override
        public void refuel() {
            System.out.println("Refueling the petrol vehicle: " + model);
        }
    }

    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle(150, "Tesla Model 3");
        PetrolVehicle pv = new PetrolVehicle(180, "Ford Mustang");

        ev.charge();
        pv.refuel();
        
        System.out.println(ev.model + " max speed: " + ev.maxSpeed);
        System.out.println(pv.model + " max speed: " + pv.maxSpeed);
    }
}
