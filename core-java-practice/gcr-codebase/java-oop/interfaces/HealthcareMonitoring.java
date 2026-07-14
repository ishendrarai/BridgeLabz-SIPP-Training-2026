public class HealthcareMonitoring {
    interface HeartRateMonitor {
        void checkHeartRate(String patientId);
        default void displayHealthTips() {
            System.out.println("HeartRateMonitor: Stay hydrated and exercise.");
        }
    }

    interface TemperatureMonitor {
        void checkTemperature(String patientId);
        default void displayHealthTips() {
            System.out.println("TemperatureMonitor: Keep yourself warm.");
        }
    }

    static class HealthMonitoringSystem implements HeartRateMonitor, TemperatureMonitor {
        public static boolean isPatientIdValid(String patientId) {
            return patientId != null && patientId.startsWith("PT-");
        }

        @Override
        public void checkHeartRate(String patientId) {
            System.out.println("Checking heart rate for " + patientId + ": Normal (75 bpm)");
        }

        @Override
        public void checkTemperature(String patientId) {
            System.out.println("Checking temperature for " + patientId + ": Normal (98.6 F)");
        }

        @Override
        public void displayHealthTips() {
            HeartRateMonitor.super.displayHealthTips();
            TemperatureMonitor.super.displayHealthTips();
        }
    }

    public static void main(String[] args) {
        String[] patients = {"Alice", "Bob"};
        String[] ids = {"PT-001", "INVALID-ID"};

        HealthMonitoringSystem sys = new HealthMonitoringSystem();
        sys.displayHealthTips();
        
        System.out.println("--- Reports ---");
        for (int i = 0; i < patients.length; i++) {
            System.out.println("Patient: " + patients[i]);
            if (HealthMonitoringSystem.isPatientIdValid(ids[i])) {
                sys.checkHeartRate(ids[i]);
                sys.checkTemperature(ids[i]);
            } else {
                System.out.println("Invalid Patient ID.");
            }
        }
    }
}
