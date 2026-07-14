public class SmartHomeDevices {
    static class Device {
        String deviceId;
        String status;

        public Device(String deviceId, String status) {
            this.deviceId = deviceId;
            this.status = status;
        }
    }

    static class Thermostat extends Device {
        double temperatureSetting;

        public Thermostat(String deviceId, String status, double temperatureSetting) {
            super(deviceId, status);
            this.temperatureSetting = temperatureSetting;
        }

        public void displayStatus() {
            System.out.println("Device: " + deviceId + " | Status: " + status + " | Temp: " + temperatureSetting + "C");
        }
    }

    public static void main(String[] args) {
        Thermostat thermostat = new Thermostat("T-01", "ON", 22.5);
        thermostat.displayStatus();
    }
}
