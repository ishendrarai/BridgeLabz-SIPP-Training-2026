public class SpaceTourismReservation {
    static class SpaceTourist {
        String touristName;
        int seatNumber;
        static String missionName = "Mars Pioneer";
        static int totalReservations = 0;

        public SpaceTourist(String touristName, int seatNumber) {
            this.touristName = touristName;
            this.seatNumber = seatNumber;
            totalReservations++;
        }

        public SpaceTourist updateSeatNumber(int seatNumber) {
            this.seatNumber = seatNumber;
            return this;
        }

        public void displayDetails() {
            System.out.println("Tourist: " + touristName + " | Seat: " + seatNumber + " | Mission: " + missionName);
        }
    }

    public static void main(String[] args) {
        SpaceTourist t1 = new SpaceTourist("Alice", 5);
        t1.displayDetails();

        System.out.println("Updating seat...");
        t1.updateSeatNumber(10).updateSeatNumber(15);
        
        t1.displayDetails();
        System.out.println("Total Reservations: " + SpaceTourist.totalReservations);
    }
}
