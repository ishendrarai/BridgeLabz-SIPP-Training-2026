class DistanceConversion {
    public static void main(String[] args) {

        double distanceInKilometers = 10.8;
        double milesPerKilometer = 1.6;

        double distanceInMiles = distanceInKilometers * milesPerKilometer;

        System.out.println("The distance " + distanceInKilometers + " km in miles is " + distanceInMiles);
    }
}