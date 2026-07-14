class EarthVolume {
    public static void main(String[] args) {

        double pi = 3.14;
        double radiusInKilometers = 6378;

        double volumeInCubicKilometers = (4.0 / 3.0) * pi * radiusInKilometers * radiusInKilometers * radiusInKilometers;
        double cubicKilometersPerCubicMile = 4.168;

        double volumeInCubicMiles = volumeInCubicKilometers / cubicKilometersPerCubicMile;

        System.out.println("The volume of earth in cubic kilometers is " +
                           volumeInCubicKilometers + " and cubic miles is " +
                           volumeInCubicMiles);
    }
}