public class DesignParkingSystem {
    int[] count;

    public DesignParkingSystem(int big, int medium, int small) {
        count = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {
        if (count[carType - 1] > 0) {
            count[carType - 1]--;
            return true;
        }
        return false;
    }
}
