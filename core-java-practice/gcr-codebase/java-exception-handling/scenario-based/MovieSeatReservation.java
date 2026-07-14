public class MovieSeatReservation {
    private static int[] seats = {101, 102, 103, 104, 105};

    public static int getSeat(int index) {
        try {
            return seats[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid seat access.");
            return -1;
        }
    }

    public static void main(String[] args) {
        int requestedPosition = 8;
        int seatNumber = getSeat(requestedPosition);
        System.out.println("Requested seat number: " + seatNumber);
    }
}
