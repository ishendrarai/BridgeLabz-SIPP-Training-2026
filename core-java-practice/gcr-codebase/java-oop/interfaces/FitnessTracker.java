public class FitnessTracker {
    interface Trackable {
        void logActivity();
        default void resetData() {
            System.out.println("Data reset successfully.");
        }
    }

    interface Reportable {
        void generateReport();
    }

    interface Notifiable {
        void sendAlert();
    }

    static class FitnessDevice implements Trackable, Reportable, Notifiable {
        @Override
        public void logActivity() {
            System.out.println("Logging daily activity (steps, heart rate)...");
        }

        @Override
        public void generateReport() {
            System.out.println("Generating weekly fitness report...");
        }

        @Override
        public void sendAlert() {
            System.out.println("Alert: Heart rate is too high!");
        }
    }

    public static void main(String[] args) {
        FitnessDevice device = new FitnessDevice();
        device.logActivity();
        device.generateReport();
        device.sendAlert();
        device.resetData();
    }
}
