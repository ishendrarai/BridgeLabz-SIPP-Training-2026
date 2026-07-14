public class SmartNotificationSystem {
    static class Notification {
        String recipientName;
        String message;

        public Notification(String recipientName, String message) {
            this.recipientName = recipientName;
            this.message = message;
        }

        public void sendNotification() {
            System.out.println("Sending Generic Notification...");
        }
    }

    static class EmailNotification extends Notification {
        public EmailNotification(String recipientName, String message) {
            super(recipientName, message);
        }

        @Override
        public void sendNotification() {
            System.out.println("Sending EMAIL to " + recipientName + ": " + message);
        }
    }

    static class SMSNotification extends Notification {
        public SMSNotification(String recipientName, String message) {
            super(recipientName, message);
        }

        @Override
        public void sendNotification() {
            System.out.println("Sending SMS to " + recipientName + ": " + message);
        }
    }

    static class PushNotification extends Notification {
        public PushNotification(String recipientName, String message) {
            super(recipientName, message);
        }

        @Override
        public void sendNotification() {
            System.out.println("Sending PUSH to " + recipientName + ": " + message);
        }
    }

    public static void main(String[] args) {
        Notification[] notifications = new Notification[]{
            new EmailNotification("Alice", "Your order has shipped."),
            new SMSNotification("Bob", "OTP: 123456"),
            new PushNotification("Charlie", "New friend request.")
        };

        for (Notification n : notifications) {
            n.sendNotification(); // dynamic method dispatch
        }
    }
}
