public class VehicleRentalSystem {
    abstract static class Vehicle {
        private String vehicleNumber;
        private String vehicleType;

        public Vehicle(String vehicleNumber, String vehicleType) {
            this.vehicleNumber = vehicleNumber;
            this.vehicleType = vehicleType;
        }

        public String getVehicleNumber() { return vehicleNumber; }
        public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }

        public String getVehicleType() { return vehicleType; }
        public void setVehicleType(String vehicleType) { this.vehicleType = vehicleType; }

        public abstract double calculateRentalCost(int days);
    }

    static class Car extends Vehicle {
        private double dailyRate;

        public Car(String vehicleNumber, double dailyRate) {
            super(vehicleNumber, "Car");
            this.dailyRate = dailyRate;
        }

        public double getDailyRate() { return dailyRate; }
        public void setDailyRate(double dailyRate) { this.dailyRate = dailyRate; }

        @Override
        public double calculateRentalCost(int days) {
            return days * dailyRate;
        }
    }

    static class Bike extends Vehicle {
        private double dailyRate;

        public Bike(String vehicleNumber, double dailyRate) {
            super(vehicleNumber, "Bike");
            this.dailyRate = dailyRate;
        }

        public double getDailyRate() { return dailyRate; }
        public void setDailyRate(double dailyRate) { this.dailyRate = dailyRate; }

        @Override
        public double calculateRentalCost(int days) {
            return days * dailyRate;
        }
    }

    static class Truck extends Vehicle {
        private double dailyRate;
        private double loadingCharge;

        public Truck(String vehicleNumber, double dailyRate, double loadingCharge) {
            super(vehicleNumber, "Truck");
            this.dailyRate = dailyRate;
            this.loadingCharge = loadingCharge;
        }

        public double getDailyRate() { return dailyRate; }
        public void setDailyRate(double dailyRate) { this.dailyRate = dailyRate; }

        public double getLoadingCharge() { return loadingCharge; }
        public void setLoadingCharge(double loadingCharge) { this.loadingCharge = loadingCharge; }

        @Override
        public double calculateRentalCost(int days) {
            return (days * dailyRate) + loadingCharge;
        }
    }

    public static void main(String[] args) {
        Car car = new Car("C-111", 50);
        Bike bike = new Bike("B-222", 15);
        Truck truck = new Truck("T-333", 100, 200);

        int days = 3;
        System.out.println("Car Rental Cost for " + days + " days: $" + car.calculateRentalCost(days));
        System.out.println("Bike Rental Cost for " + days + " days: $" + bike.calculateRentalCost(days));
        System.out.println("Truck Rental Cost for " + days + " days: $" + truck.calculateRentalCost(days));
    }
}
