public class AirportSecurity {
    interface LuggageScanner {
        boolean scanLuggage(String luggageId);
        default void displaySecurityGuidelines() {
            System.out.println("LuggageScanner: Ensure no prohibited items in luggage.");
        }
    }

    interface PassportVerifier {
        boolean verifyPassport(String passportNo);
        default void displaySecurityGuidelines() {
            System.out.println("PassportVerifier: Ensure passport is valid and not expired.");
        }

        static boolean isPassportNumberValid(String passportNo) {
            return passportNo != null && passportNo.matches("[A-Z0-9]{8}");
        }
    }

    static class AirportSecuritySystem implements LuggageScanner, PassportVerifier {
        @Override
        public boolean scanLuggage(String luggageId) {
            return !luggageId.contains("DANGER");
        }

        @Override
        public boolean verifyPassport(String passportNo) {
            return PassportVerifier.isPassportNumberValid(passportNo);
        }

        @Override
        public void displaySecurityGuidelines() {
            LuggageScanner.super.displaySecurityGuidelines();
            PassportVerifier.super.displaySecurityGuidelines();
        }
    }

    public static void main(String[] args) {
        String[] passengers = {"P1", "P2", "P3"};
        String[] passports = {"AB123456", "INVALID", "CD789012"};
        String[] luggages = {"BAG-SAFE", "BAG-SAFE", "BAG-DANGER"};

        AirportSecuritySystem system = new AirportSecuritySystem();
        system.displaySecurityGuidelines();
        System.out.println("--- Check-in ---");

        for (int i = 0; i < passengers.length; i++) {
            boolean passportOk = system.verifyPassport(passports[i]);
            boolean luggageOk = system.scanLuggage(luggages[i]);

            System.out.print("Passenger " + passengers[i] + ": ");
            if (passportOk && luggageOk) System.out.println("Boarding Allowed.");
            else System.out.println("Boarding Denied.");
        }
    }
}
