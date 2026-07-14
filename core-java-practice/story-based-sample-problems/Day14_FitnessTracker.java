public class Day14_FitnessTracker {
    interface Trackable {
        void logActivity();
        default void resetData() {
            System.out.println("Data reset to zero.");
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
        public void logActivity() { System.out.println("Logging steps and heart rate..."); }
        @Override
        public void generateReport() { System.out.println("Generating weekly fitness report..."); }
        @Override
        public void sendAlert() { System.out.println("Alert: You've reached your daily step goal!"); }
    }
    
    public static void main(String[] args) {
        FitnessDevice fd = new FitnessDevice();
        fd.logActivity();
        fd.generateReport();
        fd.sendAlert();
        fd.resetData();
    }
}
